// Copyright 2018 The JavaAVR Project Developers
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package javr.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javr.core.AVR;
import javr.core.AvrDecoder;
import javr.core.AvrInstruction;
import javr.memory.ByteMemory;

public class HexFile {
	private final Record[] records;

	public HexFile(List<Record> records) {
		this.records = new Record[records.size()];
		for(int i=0;i!=records.size();++i) {
			this.records[i] = records.get(i);
		}
	}

	public int size() {
		return records.length;
	}

	public Record get(int ith) {
		return records[ith];
	}

	/**
	 * Upload the contents of this hexfile to the given memory.
	 *
	 * @param memory
	 */
	public void uploadTo(AVR.Memory memory) {
		for(int i=0;i!=records.length;++i) {
			Record record = records[i];
			if(record instanceof Data) {
				Data data = (Data) record;
				memory.write(data.getAddress(), data.toByteArray());
			} else if(record instanceof EndOfFile) {
				// Skip
			} else {
				throw new IllegalArgumentException("invalid hexfile record");
			}
		}
	}

	/**
	 * Convert an array of bytes into a HexFile.
	 *
	 * @param bytes
	 *            The array of bytes to be converted.
	 * @param width
	 *            The preferred width of each data record in bytes (must be less
	 *            than 256).
	 * @return
	 */
	public static HexFile toHexFile(byte[] bytes, int width) {
		if(width < 0 || width > 256) {
			throw new IllegalArgumentException("invalid record width");
		} else if(bytes == null) {
			throw new IllegalArgumentException("bytes cannot be null");
		}
		ArrayList<Record> records = new ArrayList<>();
		for (int i = 0; i < bytes.length; i = i + width) {
			// Construct a chunk of the given size
			byte[] chunk = Arrays.copyOfRange(bytes, i, Math.min(i + width, bytes.length));
			records.add(new Data(i, chunk));
		}
		// Terminate record list
		records.add(new EndOfFile(0));
		// Done
		return new HexFile(records);
	}

	public static class Reader {
		private final BufferedReader reader;

		public Reader(java.io.Reader reader) {
			this.reader = new BufferedReader(reader);
		}

		public HexFile readAll() throws IOException {
			ArrayList<Record> records = new ArrayList<>();
			String line;
			int lineno = 0;
			while ((line = reader.readLine()) != null) {
				// Keep reading!
				records.add(parseHexLine(++lineno, line));
			}
			return new HexFile(records);
		}

		protected Record parseHexLine(int lineno, String line) throws InvalidHexLine {
			// Sanity check line looks OK.
			if (line.length() == 0 || line.charAt(0) != ':') {
				throw new InvalidHexLine("line " + lineno);
			}
			int length = readInt(1, 2, line, lineno);
			int address = readInt(3, 6, line, lineno);
			int kind = readInt(7, 8, line, lineno);
			byte[] data = readBytes(9, length, line, lineno);
			// FIXME: could check checksum!
			//
			switch (kind) {
			case 0:
				return new Data(address, data);
			case 1:
				return new EndOfFile(address);
			default:
				throw new InvalidHexLine("line " + lineno);
			}
		}

		protected int readInt(int start, int end, String line, int lineno) throws InvalidHexLine {
			int value = 0;
			for (int i = start; i <= end; ++i) {
				int digit = toDigit(lineno, line.charAt(i));
				value = (value << 4) | digit;
			}
			return value;
		}

		protected byte[] readBytes(int start, int count, String line, int lineno) throws InvalidHexLine {
			final byte[] bytes = new byte[count];
			//
			for (int i = 0; i < bytes.length; i = i + 1) {
				int dig1 = toDigit(lineno, line.charAt(start++));
				int dig2 = toDigit(lineno, line.charAt(start++));
				bytes[i] = (byte) ((dig1 << 4) | dig2);
			}
			return bytes;
		}

		protected int toDigit(int lineno, char c) throws InvalidHexLine {
			switch (c) {
			case '0':
				return 0;
			case '1':
				return 1;
			case '2':
				return 2;
			case '3':
				return 3;
			case '4':
				return 4;
			case '5':
				return 5;
			case '6':
				return 6;
			case '7':
				return 7;
			case '8':
				return 8;
			case '9':
				return 9;
			case 'a':
			case 'A':
				return 10;
			case 'b':
			case 'B':
				return 11;
			case 'c':
			case 'C':
				return 12;
			case 'd':
			case 'D':
				return 13;
			case 'e':
			case 'E':
				return 14;
			case 'f':
			case 'F':
				return 15;
			}
			throw new InvalidHexLine("line " + lineno);
		}
	}

	public static class Writer {
		private final PrintWriter writer;

		public Writer(java.io.Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		public void flush() throws IOException {
			writer.flush();
		}

		public void write(HexFile hf) throws IOException {
			Record[] records = hf.records;
			for(int i=0;i!=hf.size();++i) {
				write(records[i]);
			}
		}

		private void write(Record r) throws IOException {
			writer.write(":");
			// Write byte count
			write_u1(r.size());
			// Write address
			write_u2(r.getAddress());
			// Write data bytes
			for(int i=0;i!=r.size();++i) {
				write_u1(r.get(i) & 0xFF);
			}
			// Write checksum
			// End line
			writer.println();
		}

		private void write_u1(int value) throws IOException {
			if(value < 0 || value > 255) {
				throw new IllegalArgumentException("invalid unsigned byte value: " + value);
			}
//			char d1 = (char) ('0' + (value & 0xF));
//			writer.print(d1);
//			value = value >> 4;
//			char d2 = (char) ('0' + (value & 0xF));
//			writer.print(d2);
			String d = String.format("%02x", value);
			if(d.length() != 2) {
				throw new IllegalArgumentException("internal failure");
			}
			writer.print(d);
		}

		private void write_u2(int value) throws IOException {
			if(value < 0 || value > 65535) {
				throw new IllegalArgumentException("invalid unsigned word value: " + value);
			}
			write_u1((value >> 8) & 0xFF);
			write_u1(value & 0xFF);
		}
	}

	public static class InvalidHexLine extends IOException {
		public InvalidHexLine(String message) {
			super(message);
		}
	}

	/**
	 * A Hex file is a linear sequence of records of different kinds.
	 *
	 * @author David J. Pearce
	 *
	 */
	public static abstract class Record {
		protected final int address;

		public Record(int address) {
			this.address = address;
		}

		/**
		 * Get the 16-bit address representing where the data should be placed. This is
		 * an offset from the current "base address".
		 *
		 * @return
		 */
		public int getAddress() {
			return address;
		}

		/**
		 * Get the number of bytes in the data field. This is an 8 bit field, hence can
		 * return at most 256 bytes.
		 *
		 * @return
		 */
		public abstract int size() ;

		/**
		 * Get a given byte in the data field.
		 *
		 * @param i
		 * @return
		 */
		public abstract byte get(int i);
	}

	/**
	 * A data record is the most common kind of record.
	 *
	 * @author David J. Pearce
	 *
	 */
	public static class Data extends Record {
		private final byte[] data;

		public Data(int address, byte[] data) {
			super(address);
			this.data = data;
		}

		@Override
		public int size() {
			return data.length;
		}

		@Override
		public byte get(int i) {
			return data[i];
		}

		public byte[] toByteArray() {
			return Arrays.copyOf(data, data.length);
		}

		@Override
		public String toString() {
			String r = "data:" + String.format("%04X", address);
			for (int i = 0; i != data.length; ++i) {
				r += ":" + String.format("%02X", data[i]);
			}
			return r;
		}
	}

	public static class EndOfFile extends Record {
		public EndOfFile(int address) {
			super(address);
		}

		@Override
		public int size() {
			return 0;
		}

		@Override
		public byte get(int i) {
			throw new UnsupportedOperationException();
		}

		@Override
		public String toString() {
			return "eof";
		}
	}

	public static void main(String[] args) throws IOException {
		String input = ":10010000214601360121470136007EFE09D2190140\n"
				+ ":100110002146017E17C20001FF5F16002148011928\n"
				+ ":10012000194E79234623965778239EDA3F01B2CAA7\n"
				+ ":100130003F0156702B5E712B722B732146013421C7\n"
				+ ":00000001FF\n";
		// HexFile.Reader reader = new HexFile.Reader(new StringReader(input));

		HexFile.Reader reader = new HexFile.Reader(new StringReader(input));
		HexFile hf = reader.readAll();
		for (int i = 0; i != hf.size(); ++i) {
			System.out.println("READ: " + hf.get(i));
		}
		// Now, upload and try to decode
		ByteMemory mem = new ByteMemory(512);
		hf.uploadTo(mem);
//		AvrDecoder decoder = new AvrDecoder();
//		for(int i=0;i!=mem.size();) {
//			AvrInstruction insn = decoder.decode(mem,i);
//			System.out.println(String.format("%04X", i/2) + ": " + insn);
//			i = i + insn.getWidth();
//		}
		// Generate output file
		StringWriter strbuf = new StringWriter();
		HexFile.Writer writer = new HexFile.Writer(strbuf);
		writer.write(hf);
		writer.flush();
		System.out.println(strbuf);
	}
}
