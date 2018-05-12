package javaavr.util.generators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javaavr.core.AvrInstruction;
import javaavr.core.AvrInstruction.Argument;
import javaavr.core.AvrInstruction.Opcode;

public class DecoderGenerator {

	private static class Group {
		private int mask;
		private Set<Opcode> items;
		private Map<Integer,Group> buckets;

		public Group(int mask, Set<Opcode> matched) {
			this.mask = mask;
			this.items = new HashSet<>(matched);
			this.buckets = new HashMap<>();
		}

		public int getMask() {
			return mask;
		}

		public Set<Opcode> getAll() {
			return items;
		}

		public Map<Integer,Group> getBuckets() {
			return buckets;
		}

		public boolean isTerminal() {
			return DecoderGenerator.isTerminal(items);
		}

		public Opcode getTerminal() {
			return DecoderGenerator.findWinner(items);
		}
	}

	private static class Range {
		private int start;
		private int end;

		public Range(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getWidth() {
			return (end-start)+1;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public int toMask() {
			int mask = 0;
			for(int i=start;i<=end;++i) {
				mask |= (1 << i);
			}
			return mask;
		}

		@Override
		public String toString() {
			return start + "-" + end;
		}
	}

	public static class Variable {
		private String name;
		private Range[] ranges;

		public Variable(String name, int mask) {
			this.name = name;
			this.ranges = toRanges(mask);
		}

		private Range[] toRanges(int mask) {
			int start = Integer.MIN_VALUE;
			ArrayList<Range> ranges = new ArrayList<>();
			//
			int unit = 1;
			for(int i=0;i!=32;++i) {
				if((mask & unit) == unit) {
					if(start < 0) {
						start = i;
					}
				} else if(start >= 0) {
					ranges.add(new Range(start,i-1));
					start = Integer.MIN_VALUE;
				}
				unit = unit << 1;
			}
			// Check if open range
			if(start >= 0) {
				ranges.add(new Range(start,31));
			}
			//
			return ranges.toArray(new Range[ranges.size()]);
		}

		@Override
		public String toString() {
			return name + Arrays.toString(ranges);
		}
	}

	/**
	 * For a given set of instructions, this determines the largest possible 16-bit
	 * mask.
	 *
	 * @param group
	 * @return
	 */
	private static int determineMaximumMask(Set<Opcode> group) {
		int mask = 0xFFFF;
		for(Opcode o : group) {
			int fmt = toMask(o.getOpcodeFormat());
			mask = mask & fmt;
		}
		return mask;
	}

	/**
	 * Turn a given format string into a 16-bit mask which identifies all fixed
	 * bits.
	 *
	 * @param format
	 * @return
	 */
	public static int toMask(String format) {
		// Remove all underscores.
		format = format.replaceAll("_", "");
		//
		int mask = 0;
		for(int i=0;i!=format.length();++i) {
			mask = mask << 1;
			char c = format.charAt(i);
			if(c == '0' || c == '1') {
				mask = mask | 1;
			}
		}
		//
		return mask;
	}

	/**
	 * Determine which opcodes are "covered" by this mask. That is, which ones have
	 * all their fixed bits in the mask.
	 *
	 * @param mask
	 * @param opcodes
	 * @return
	 */
	public static Set<Opcode> determineCoveredOpcodes(int mask, int value, Set<Opcode> opcodes) {
		HashSet<Opcode> covered = new HashSet<>();
		for (Opcode o : opcodes) {
			if (covered(o, mask, value)) {
				covered.add(o);
			}
		}
		return covered;
	}

	public static boolean covered(Opcode o, int mask, int value) {
		int ovalue = toValue(o.getOpcodeFormat());
		return (ovalue & mask) == value;
	}

	/**
	 * Turn a given format string into a 16-bit mask which identifies all fixed
	 * bits.
	 *
	 * @param format
	 * @return
	 */
	public static int toValue(String format) {
		// Remove all underscores.
		format = format.replaceAll("_", "");
		//
		int mask = 0;
		for(int i=0;i!=format.length();++i) {
			mask = mask << 1;
			char c = format.charAt(i);
			if(c == '1') {
				mask = mask | 1;
			}
		}
		//
		return mask;
	}

	/**
	 * Recursively split a given set of opcodes into a tree of groups.
	 *
	 * @param opcodes
	 * @param mask
	 * @return
	 */
	public static Group split(Set<Opcode> opcodes) {
		if(isTerminal(opcodes)) {
			return new Group(0,opcodes);
		} else {
			int mask = determineMaximumMask(opcodes);
			Group group = new Group(mask,opcodes);
			for(int i=0;i!=65536;++i) {
				if((i & mask) == i) {
					Set<Opcode> covered = determineCoveredOpcodes(mask,i,opcodes);
					if(covered.size() == opcodes.size()) {
						for(Opcode o : covered) {
							System.out.println(o + "\t: " + o.getOpcodeFormat());
						}
						throw new RuntimeException("Unable to distinguish " + opcodes + " (mask: " + Integer.toBinaryString(mask) + ")");
					} else if(covered.size() > 0) {
						Group bucket = split(covered);
						group.getBuckets().put(i,bucket);
					}
				}
			}
			return group;
		}
	}

	public static Opcode findWinner(Set<Opcode> opcodes) {
		Opcode matched = null;
		// First, find a winner.
		for(Opcode o : opcodes) {
			if(matched == null || o.subsumes(matched)) {
				matched = o;
			}
		}
		return matched;
	}

	/**
	 * Check whether a set of opcodes represents a terminating state. Obviously, if
	 * the set contains only one opcode then it is by definition terminating.
	 * However, in other cases, it may also be terminating. For example, if one
	 * opcode subsumes all the others as this indicates we have a single opcode with
	 * one or more (overlapping) specialisations.
	 *
	 * @param opcodes
	 * @return
	 */
	public static boolean isTerminal(Set<Opcode> opcodes) {
		// Find a winner
		Opcode matched = findWinner(opcodes);
		// Check it's the only winner.
		for(Opcode o : opcodes) {
			if(o != matched && !matched.subsumes(o)) {
				return false;
			}
		}
		return true;
	}

	public static char[] extractVariables(String opcodeFormat, String operandFormat) {
		ArrayList<Character> vars = new ArrayList<>();
		boolean[] seen = new boolean[256];
		if(operandFormat != null) {
			opcodeFormat += operandFormat;
		}
		for(int i=0;i!=opcodeFormat.length();++i) {
			char c = opcodeFormat.charAt(i);
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

	public static Variable extractVariable(char v, String opcodeFormat, String operandFormat) {
		String name = "";
		int mask = 0;
		int unit = 1;
		for(int i=15;i>=0;--i) {
			if(opcodeFormat.charAt(i) == v) {
				name += v;
				mask |= unit;
			}
			unit = unit << 1;
		}
		if(operandFormat != null) {
			for(int i=15;i>=0;--i) {
				if(operandFormat.charAt(i) == v) {
					name += v;
					mask |= unit;
				}
				unit = unit << 1;
			}
		}
		return new Variable(name,mask);
	}



	public static Map<Group,Integer> number(Group g) {
		HashMap<Group,Integer> numbering = new HashMap<>();
		number(g,0,numbering);
		return numbering;
	}

	public static int number(Group g, int id, Map<Group,Integer> numbering) {
		numbering.put(g, id++);
		for(Map.Entry<Integer, Group> e : g.getBuckets().entrySet()) {
			id = number(e.getValue(),id,numbering);
		}
		return id;
	}

	public static void main(String[] args) {
		//Group g = split(new HashSet<>(Arrays.asList(Opcode.values())));
		HashSet<Opcode> tmp = new HashSet<>();
		tmp.addAll(Arrays.asList(Opcode.values()));
		Group g = split(tmp);
		Map<Group,Integer> numbering = number(g);
		print(g,numbering);
		printDecoders(g,numbering);
		printExtractors(g);
	}

	public static String toBinaryString(int value) {
		String r = Integer.toBinaryString(value);
		while(r.length() < 16) {
			r = "0" + r;
		}
		return "0b" + r;
	}

	public static void print(Group g, Map<Group,Integer> numbering) {
		System.out.println("==================================");
		System.out.println("ID: " + numbering.get(g));
		System.out.println("MASK: " + Integer.toBinaryString(g.getMask()));
		System.out.println("OPCODES: " + g.getAll());
		for(Map.Entry<Integer,Group> e : g.getBuckets().entrySet()) {
			System.out.println(toBinaryString(e.getKey()) + " ==> " + numbering.get(e.getValue()));
		}
		for(Map.Entry<Integer,Group> e : g.getBuckets().entrySet()) {
			print(e.getValue(),numbering);
		}
	}

	public static void printDecoders(Group g, Map<Group,Integer> numbering) {
		printDecoder(g,numbering);
		for(Map.Entry<Integer, Group> e : g.getBuckets().entrySet()) {
			printDecoders(e.getValue(),numbering);
		}
	}

	public static void printDecoder(Group g, Map<Group,Integer> numbering) {
		int id = numbering.get(g);
		System.out.println("\tprivate static AvrInstruction decode_" + id + "(int opcode, Memory mem, int pc) {");
		if(g.isTerminal()) {
			Opcode o = g.getTerminal();
			AvrInstruction.Argument[] args = o.getArguments();
			if(o.getOperandFormat() != null) {
				System.out.println("\t\t\tint lsb = mem.read(pc+2) & 0xFF;");
				System.out.println("\t\t\tint msb = mem.read(pc+3) & 0xFF;");
				System.out.println("\t\t\topcode = (msb << 24) | (lsb << 16) | opcode;");
			}
			String argstr = "";
			for(int i=0;i!=args.length;++i) {
				AvrInstruction.Argument arg = args[i];
				if(arg.signed) {
					System.out.println("\t\t\tint " + arg.name + " = extract_s" + Integer.toBinaryString(arg.toMask(o)) + "(opcode);");
				} else {
					System.out.println("\t\t\tint " + arg.name + " = extract_u" + Integer.toBinaryString(arg.toMask(o)) + "(opcode);");
				}
				if(i != 0) {
					argstr += ", ";
				}
				printTransforms(arg);
				argstr = argstr + arg.name;
			}
			System.out.println("\t\t\treturn new " + o + "(" + argstr + ");");
		} else {
			String mask = toBinaryString(g.getMask());
			System.out.println("\t\tswitch(opcode & " + mask + ") {");
			for(Map.Entry<Integer, Group> e : g.getBuckets().entrySet()) {
				System.out.println("\t\tcase " + toBinaryString(e.getKey()) + ":");
				int n = numbering.get(e.getValue());
				System.out.println("\t\t\treturn decode_" + n + "(opcode,mem,pc);");
			}
			System.out.println("\t\tdefault:");
			System.out.println("\t\t\treturn new AvrInstruction.UNKNOWN();");
			System.out.println("\t\t}");
		}
		System.out.println("\t}");
	}

	public static void printTransforms(Argument arg) {
		for(int i=0;i!=arg.transforms.length;++i) {
			AvrInstruction.Transform t = arg.transforms[i];
			if(t instanceof AvrInstruction.ShiftLeft) {
				System.out.println("\t\t\t" + arg.name + " = " + arg.name + " << 1;");
			} else {
				AvrInstruction.Offset offset = (AvrInstruction.Offset) t;
				System.out.println("\t\t\t" + arg.name + " = " + arg.name + " + " + offset.offset + ";");
			}
		}
	}

	public static int getMinInt(boolean signed, int width) {
		if(signed) {
			return -1 << (width-1);
		} else {
			return 0;
		}
	}

	public static int getMaxInt(boolean signed, int width) {
		if(signed) {
			return (1 << (width-1)) - 1;
		} else {
			return 0;
		}
	}

	public static void printExtractors(Group g) {
		HashSet<String> visited = new HashSet<>();
		for(Opcode o : g.getAll()) {
			Argument[] args = o.getArguments();
			for(int i=0;i!=args.length;++i) {
				Argument arg = args[i];
				int mask = arg.toMask(o);
				String s = arg.signed ? "s" : "u";
				s = s + Integer.toBinaryString(mask);
				if(!visited.contains(s)) {
					visited.add(s);
					printExtractor(s,o,arg);
				}
			}
		}
	}

	public static void printExtractor(String name, Opcode opcode, Argument arg) {
		AvrInstruction.Bits[] ranges = arg.getBitRanges(opcode);
		int mask = arg.toMask(opcode);
		System.out.println("\tprivate static int extract_" + name + "(int opcode) {");
		int width = 0;
		for(int i=0;i!=ranges.length;++i) {
			AvrInstruction.Bits r = ranges[i];
			int offset = r.getStart() - width;
			System.out.print("\t\t");
			if(i == 0) {
				System.out.print("int " + arg.name + " = ");
			} else {
				System.out.print(arg.name + " |= ");
			}
			System.out.println("(opcode & " + toBinaryString(r.toMask()) + ") >> " + offset + ";");
			width += r.getWidth();
		}
		if(arg.signed) {
			int shift = 32 - width;
			System.out.println("\t\t" + arg.name + " = (" + arg.name + " << " + shift + ") >> " + shift + ";");
		}
		System.out.println("\t\treturn " + arg.name + ";");
		System.out.println("\t}");
	}

	private static void printVariable(Variable v) {

	}

//	private static void printInstructions() {
//		for(Opcode o : Opcode.values()) {
//			char[] vars = extractVariables(o.getOpcodeFormat());
//			Arrays.sort(vars);
//			String baseClass = o.getKind();
//			System.out.println("\tpublic static final class " + o + " extends " + baseClass + " {");
//			System.out.print("\t\tpublic " + o + "(");
//			for(int i=0;i!=vars.length;++i) {
//				if(i != 0) {
//					System.out.print(", ");
//				}
//				System.out.print("int " + vars[i]);
//			}
//			System.out.print(") { super(Opcode." + o);
//			for(int i=0;i!=vars.length;++i) {
//				System.out.print(", ");
//				System.out.print(vars[i]);
//			}
//			System.out.println("); }");
//			System.out.print("\t\tpublic " + o + "(int[] operands");
//			System.out.print(") { super(Opcode." + o);
//			for(int i=0;i!=vars.length;++i) {
//				System.out.print(", ");
//				System.out.print("operands[" + i + "]");
//			}
//			System.out.println("); }");
//			System.out.println("\t}");
//		}
//	}
}
