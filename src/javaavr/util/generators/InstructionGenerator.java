package javaavr.util.generators;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javaavr.core.Instruction;
import javaavr.core.Instruction.Opcode;

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
		Instruction.Argument[] args = opcode.getArguments();
		for(int i=0;i!=args.length;++i) {
			if(i != 0) {
				out.print(", ");
			}
			out.print("int " + args[i].id);
		}
		out.println(") {");
		out.print("        super(Opcode." + opcode);
		for (Instruction.Argument arg : opcode.getArguments()) {
			out.print(", " + arg.id);
		}
		out.println(");");
		for (Instruction.Argument arg : opcode.getArguments()) {
			generateInvariantTest(arg);
		}
		out.println("    }");
		out.println();
	}

	private void generateInvariantTest(Instruction.Argument arg) {
		Instruction.Invariant inv = arg.invariant;
		out.print("        if(");
		if (inv instanceof Instruction.Range) {
			Instruction.Range range = (Instruction.Range) inv;
			out.print(arg.id + " < " + range.start + " || " + arg.id + " > " + range.end);
		} else {
			Instruction.Union union = (Instruction.Union) inv;
			for (int i = 0; i != union.values.length; ++i) {
				if (i != 0) {
					out.print(" && ");
				}
				out.print(arg.id + " != " + union.values[i]);
			}
		}
		out.println(") {");
		out.println("            throw new IllegalArgumentException(\"invalid argument " + arg.id + "\");");
		out.println("        }");

	}

	private void generateEncoder(Opcode opcode) {
		out.println("    public byte[] getBytes() {");
		out.println("        int opcode = 0b" + Integer.toBinaryString(opcode.getBinaryBase()) + ";");
		for (Instruction.Argument arg : opcode.getArguments()) {
			Instruction.Bits[] bits = arg.getBitRanges(opcode);
			int width = 0;
			for (int i = 0; i != bits.length; ++i) {
				Instruction.Bits b = bits[i];
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
		Instruction.Argument[] args = opcode.getArguments();
		if (args.length == 0) {
			return "Instruction";
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
