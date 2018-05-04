package javaavr.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javaavr.core.Instruction;
import javaavr.core.Memory;
import javaavr.util.ByteMemory;
import javaavr.util.TinyDecoder;

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
	public void uploadTo(Memory memory) {
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

		public int size() {
			return data.length;
		}

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
		public String toString() {
			return "eof";
		}
	}

	public static void main(String[] args) throws IOException {
		String input = ":10010000214601360121470136007EFE09D2190140\n" + ":100110002146017E17C20001FF5F16002148011928\n"
				+ ":10012000194E79234623965778239EDA3F01B2CAA7\n" + ":100130003F0156702B5E712B722B732146013421C7\n"
				+ ":00000001FF\n";
		// HexFile.Reader reader = new HexFile.Reader(new StringReader(input));

		HexFile.Reader reader = new HexFile.Reader(new FileReader("main.hex"));
		HexFile hf = reader.readAll();
		for (int i = 0; i != hf.size(); ++i) {
			System.out.println("READ: " + hf.get(i));
		}
		// Now, upload and try to decode
		ByteMemory mem = new ByteMemory(100);
		hf.uploadTo(mem);
		TinyDecoder decoder = new TinyDecoder();
		for(int i=0;i!=mem.size();) {
			Instruction insn = decoder.decode(mem,i);
			System.out.println(String.format("%04X", i/2) + ": " + insn);
			i = i + insn.getWidth();
		}
	}
}
