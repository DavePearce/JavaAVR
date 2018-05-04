package javaavr.util.generators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javaavr.core.Instruction;

public class OldDecoderGenerator {
	public static boolean match(Instruction.Opcode opcode, int bits) {
		String fmt = opcode.getOpcodeFormat().replaceAll("_", "");
		if(fmt == "") {
			return false;
		} else {
			for (int i = 15; i >= 0; --i) {
				boolean bit = (bits & 1) == 1;
				if (fmt.charAt(i) == '0' && bit) {
					return false;
				} else if (fmt.charAt(i) == '1' && !bit) {
					return false;
				}
				// matched bit
				bits = bits >> 1;
			}
			return true;
		}
	}
	public static char[] extractVariables(String format) {
		ArrayList<Character> vars = new ArrayList<>();
		boolean[] seen = new boolean[256];
		for(int i=0;i!=format.length();++i) {
			char c = format.charAt(i);
			if(Character.isAlphabetic(c)) {
				if(!seen[c]) {
					vars.add(c);
					seen[c] = true;
				}
			}
		}
		char[] chars = new char[vars.size()];
		for(int i=0;i!=chars.length;++i) {
			chars[i] = vars.get(i);
		}
		return chars;
	}

	public static int lookup(char var, char[] vars) {
		for(int i=0;i!=vars.length;++i) {
			if(vars[i] == var) {
				return i;
			}
		}
		throw new IllegalArgumentException("impossible!");
	}

	public static int[] extract(Instruction.Opcode opcode, int bits) {
		String fmt = opcode.getOpcodeFormat().replaceAll("_", "");
		char[] vars = extractVariables(opcode.getOpcodeFormat());
		int[] operands = new int[vars.length];
		for (int i = 15; i >= 0; i--) {
			char c = fmt.charAt(15-i);
			if (c != '0' && c != '1') {
				int bit = (bits >> i) & 1;
				int index = lookup(c,vars);
				operands[index] = (operands[index] << 1) | bit;
			}
		}
		return operands;
	}

	public static Set<Instruction.Opcode> generateOpcodeSet() {
		HashSet<Instruction.Opcode> opcodes = new HashSet<>();
		for (Instruction.Opcode opcode : Instruction.Opcode.values()) {
			opcodes.add(opcode);
		}
		return opcodes;
	}

	private static int generateOpcodeMask(int width) {
		int shift = (16-width);
		int mask = (65535 >> shift) << shift;
		return mask;
	}

	public static Map<Integer, Set<Instruction.Opcode>> split(Set<Instruction.Opcode> opcodes, int width) {
		int mask = generateOpcodeMask(width);
		HashMap<Integer, Set<Instruction.Opcode>> groups = new HashMap<>();
		for (int i = 0; i != 65536; ++i) {
			int bucket = i & mask;
			Set<Instruction.Opcode> group = groups.get(bucket);
			if (group == null) {
				group = new HashSet<>();
				groups.put(bucket, group);
			}
			for (Instruction.Opcode o : opcodes) {
				if (match(o, i)) {
					group.add(o);
				}
			}
		}
		return groups;
	}

	public static String toBinaryString(int j) {
		String bs = Integer.toBinaryString(j);
		int padding = 16 - bs.length();
		for(int i=0;i!=padding;++i) {
			bs = "0" + bs;
		}
		return "0b" + bs;
	}

	private static int GLOBAL_INDEX = 0;

	private static void generateDecoder(Set<Instruction.Opcode> opcodes, int id, int width) {
		if (width > 16) {
			System.out.println("OPCODES: " + opcodes);
			throw new IllegalArgumentException("Overlapping opcodes!");
		} else {
			int mask = generateOpcodeMask(width);
			Map<Integer, Set<Instruction.Opcode>> buckets = split(opcodes, width);
			System.out.println("public Instruction decode_" + id + "(int opcode) {");
			System.out.println("    switch(opcode) {");
			int index = 0;
			for (Map.Entry<Integer, Set<Instruction.Opcode>> e : buckets.entrySet()) {
				int opcode = e.getKey() & mask;
				Set<Instruction.Opcode> values = e.getValue();
				if (values.size() == 1) {
					// In this case, we have uniquely identified the opcode
					Instruction.Opcode o = values.iterator().next();
					System.out.println("\tcase " + toBinaryString(opcode) + ":");
					System.out.println("\t\treturn new Instruction(" + o.toString() + ");");
				} else if (values.size() > 1) {
					int myid = GLOBAL_INDEX + index++;
					System.out.println("\tcase " + toBinaryString(opcode) + ":");
					System.out.println("\t\treturn decode_" + myid + "(opcode);");
				}
			}
			System.out.println("\tdefault:");
			System.out.println("\t\treturn null;");
			System.out.println("    }");
			System.out.println(" }");

			// Now, print out any invoked methods
			int tmp = GLOBAL_INDEX;
			GLOBAL_INDEX += index;
			for (Map.Entry<Integer, Set<Instruction.Opcode>> e : buckets.entrySet()) {
				Set<Instruction.Opcode> values = e.getValue();
				if (values.size() > 1) {
					generateDecoder(values, tmp++, width + 4);
				}
			}
		}
	}

	public static void main(String[] args) {
		Set<Instruction.Opcode> opcodes = generateOpcodeSet();
		generateDecoder(opcodes,0,4);
	}
}
