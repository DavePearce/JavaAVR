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
package javr.util.generators;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javr.core.AvrInstruction;
import javr.core.AvrInstruction.Opcode;

public class InstructionGenerator {
	private final Opcode[] values;
	private final PrintWriter out;

	public InstructionGenerator(OutputStream out,Opcode... values) {
		this.values = values;
		this.out = new PrintWriter(new OutputStreamWriter(out));
	}

	public void generate() {
		for(int i=0;i!=values.length;++i) {
			generate(values[i]);
		}
		out.flush();
	}

	private void generate(Opcode opcode) {
		String baseClass = determineBaseClass(opcode);
		out.println("/**");
		out.println(" * " + opcode.getDescription() + ".");
		out.println(" * ");
		out.println(" * " + opcode.getOpcodeFormat());
		if(opcode.getOperandFormat() != null) {
			out.println(" * " + opcode.getOperandFormat());
		}
		out.println(" */");
		out.println("public static final class " + opcode + " extends " + baseClass + " {");
		generateConstructor(opcode);
		generateDescriptor(opcode);
		generateWidth(opcode);
		generateEncoder(opcode);
		out.println("}");
	}

	private void generateDescriptor(Opcode opcode) {
		out.println("    public String getDescription() { return \"" + opcode.getDescription() + "\"; }");
		out.println();
	}

	private void generateWidth(Opcode opcode) {
		if(opcode.getOperandFormat() != null) {
			out.println("    public int getWidth() { return 2; }");
			out.println();
		}
	}

	private void generateConstructor(Opcode opcode) {
		out.print("    public " + opcode + "(");
		AvrInstruction.Argument[] args = opcode.getArguments();
		for(int i=0;i!=args.length;++i) {
			if(i != 0) {
				out.print(", ");
			}
			out.print("int " + args[i].id);
		}
		out.println(") {");
		out.print("        super(Opcode." + opcode);
		for (AvrInstruction.Argument arg : opcode.getArguments()) {
			out.print(", " + arg.id);
		}
		out.println(");");
		for (AvrInstruction.Argument arg : opcode.getArguments()) {
			generateInvariantTest(arg);
		}
		out.println("    }");
		out.println();
	}

	private void generateInvariantTest(AvrInstruction.Argument arg) {
		int min = getMinInteger(arg.signed,arg.width);
		int max = getMaxInteger(arg.signed,arg.width);
		boolean shifted = false;
		for(AvrInstruction.Transform t : arg.transforms) {
			if(t instanceof AvrInstruction.ShiftLeft) {
				shifted = true;
				min = min << 1;
				max = max << 1;
			} else {
				AvrInstruction.Offset o = (AvrInstruction.Offset) t;
				min += o.offset;
				max += o.offset;
			}
		}
		out.print("        if(");
		out.print(arg.id + " < " + min + " || " + arg.id + " > " + max);
		if(shifted) {
			out.print(" || (" + arg.id  + " % 2) != 0");
		}
		out.println(") {");
		out.println("            throw new IllegalArgumentException(\"invalid argument " + arg.id + "\");");
		out.println("        }");
	}

	private int getMinInteger(boolean signed, int width) {
		if(signed) {
			return -1 << (width-1);
		} else {
			return 0;
		}
	}

	private int getMaxInteger(boolean signed, int width) {
		if(signed) {
			return (1 << (width-1))-1;
		} else {
			return (1 << width) - 1;
		}
	}

	private void generateEncoder(Opcode opcode) {
		out.println("    public byte[] getBytes() {");
		out.println("        int opcode = 0b" + Integer.toBinaryString(opcode.getBinaryBase()) + ";");
		for (AvrInstruction.Argument arg : opcode.getArguments()) {
			AvrInstruction.Bits[] bits = arg.getBitRanges(opcode);
			int width = 0;
			// FIXME: we need to undo transforms here.
			for (int i = 0; i != bits.length; ++i) {
				AvrInstruction.Bits b = bits[i];
				int shift = b.getStart() - width;
				out.println("        opcode |= (this." + arg.name + " << " + shift + ") & 0b"
						+ Integer.toBinaryString(b.toMask()) + ";");
				width = width + b.getWidth();
			}
		}
		if(opcode.getOperandFormat() == null) {
			out.println("        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };");
		} else {
			out.println("        return new byte[]{ (byte) opcode, (byte) (opcode >> 8), (byte) (opcode >> 16), (byte) (opcode >> 24) };");
		}
		out.println("    }");
	}

	private String determineBaseClass(Opcode opcode) {
		AvrInstruction.Argument[] args = opcode.getArguments();
		if (args.length == 0) {
			return "AvrInstruction";
		} else {
			String r = "";
			for (int i = 0; i != args.length; ++i) {
				r = r + args[i].kind;
			}
			return r;
		}
	}

	public static void main(String[] args) {
		new InstructionGenerator(System.out, Opcode.values()).generate();
	}
}
