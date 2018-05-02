package javaavr.util.generators;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javaavr.core.Instruction;
import javaavr.core.Instruction.Opcode;

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
			int fmt = toMask(o.getFormat());
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
		for(Opcode o : opcodes) {
			if(covered(o,mask, value)) {
				covered.add(o);
			}
		}
		return covered;
	}

	public static boolean covered(Opcode o, int mask, int value) {
		int ovalue = toValue(o.getFormat());
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
			System.out.println("MASK: " + toBinaryString(mask));
			Group group = new Group(mask,opcodes);
			for(int i=0;i!=65536;++i) {
				if((i & mask) == i) {
					Set<Opcode> covered = determineCoveredOpcodes(mask,i,opcodes);
					if(covered.size() == opcodes.size()) {
						throw new RuntimeException("Unable to distinguish " + opcodes);
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
		System.out.println("\tInstruction decode_" + id + "(int opcode) {");
		if(g.isTerminal()) {
			Opcode o = g.getTerminal();
			System.out.println("\t\t\treturn new Instruction(" + o + ");");
		} else {
			String mask = toBinaryString(g.getMask());
			System.out.println("\t\tswitch(opcode & " + mask + ") {");
			for(Map.Entry<Integer, Group> e : g.getBuckets().entrySet()) {
				System.out.println("\t\tcase " + toBinaryString(e.getKey()) + ":");
				int n = numbering.get(e.getValue());
				System.out.println("\t\t\treturn decode_" + n + "(opcode);");
			}
			System.out.println("\t\tdefault:");
			System.out.println("\t\t\treturn null;");
			System.out.println("\t\t}");
		}
		System.out.println("\t}");
	}
}
