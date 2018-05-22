// Copyright 2011 The Whiley Project Developers
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
package javr.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import javr.core.AvrDecoder;
import javr.core.AvrInstruction;
import javr.io.HexFile;
import javr.memory.ByteMemory;
import javr.memory.ElasticByteMemory;

@RunWith(Parameterized.class)
public class AvrEncodingTests {

	/**
	 * The directory containing the source files for each test case. Every test
	 * corresponds to a file in this directory.
	 */
	public final static String TESTS_DIR = "tests".replace('/', File.separatorChar);

	/**
	 * Ignored tests and a reason why we ignore them.
	 */
	public final static Map<String, String> IGNORED = new HashMap<>();

	static {
		IGNORED.put("SOMETHING TO IGNORE", "#696");
	}

	// ======================================================================
	// Test Harness
	// ======================================================================

	/**
	 * Compile a syntactically invalid test case with verification enabled. The
	 * expectation is that compilation should fail with an error and, hence, the
	 * test fails if compilation does not.
	 *
	 * @param name
	 *            Name of the test to run. This must correspond to a whiley
	 *            source file in the <code>WHILEY_SRC_DIR</code> directory.
	 */
	protected void runTest(String testName) throws IOException {
		// Construct hex filename from test name
		String hexFileName = TESTS_DIR + File.separatorChar + testName + ".hex";
		// Read in the hex file
		HexFile.Reader hfr = new HexFile.Reader(new FileReader(hexFileName));
		HexFile hf = hfr.readAll();
		// Read all bytes of the file. We will use these to compare against with the
		// generated encoding.
		byte[] originalBytes = readFileAsBytes(hf);
		// Construct the hex file reader.
		AvrInstruction[] insns = readFileAsInstructions(hf);
		// Perform the encoding
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		for (int i = 0; i != insns.length; ++i) {
			bout.write(insns[i].getBytes());
		}
		byte[] encodedBytes = bout.toByteArray();
		// Finally, check the encoding matched the original.
		if(!Arrays.equals(originalBytes,encodedBytes)) {
			int pc = 0;
			for(int i=0;i!=insns.length;++i) {
				AvrInstruction insn = insns[i];
				byte[] bytes = insns[i].getBytes();
				printBytes(Arrays.copyOfRange(originalBytes,pc,pc+bytes.length));
				System.out.print(" : ");
				printBytes(bytes);
				System.out.println(" : " + insn);
				pc = pc + bytes.length;
			}
		}
		assertTrue(Arrays.equals(originalBytes, encodedBytes));
	}

	private void printBytes(byte[] bytes) {
		for (int j = 0; j != bytes.length; ++j) {
			if (j != 0) {
				System.out.print(" ");
			}
			System.out.print(Integer.toHexString(bytes[j]));
		}
	}

	private byte[] readFileAsBytes(HexFile hf) throws FileNotFoundException {
		// Read hex file into elastic memory
		ElasticByteMemory mem = new ElasticByteMemory();
		hf.uploadTo(mem);
		// return the bytes;
		return mem.toByteArray();
	}

	/**
	 * Read a given hex file as a sequence of instructions. We can then encode these
	 * back into binary data in order to check that the encoder works.
	 *
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	private AvrInstruction[] readFileAsInstructions(HexFile hf) throws IOException {
		// Read hex file into elastic memory
		ElasticByteMemory mem = new ElasticByteMemory();
		hf.uploadTo(mem);
		// Now decode it
		AvrDecoder decoder = new AvrDecoder();
		ArrayList<AvrInstruction> instructions = new ArrayList<>();
		for (int pc = 0; pc < mem.size();) {
			AvrInstruction instruction = decoder.decode(mem, pc / 2);
			instructions.add(instruction);
			pc = pc + (instruction.getWidth() * 2);
		}
		// Create final array
		return instructions.toArray(new AvrInstruction[instructions.size()]);
	}

	// ======================================================================
	// Tests
	// ======================================================================

	// Parameter to test case is the name of the current test.
	// It will be passed to the constructor by JUnit.
	private final String testName;

	public AvrEncodingTests(String testName) {
		this.testName = testName;
	}

	// Here we enumerate all available test cases.
	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return findTestNames(TESTS_DIR);
	}

	// Skip ignored tests
	@Before
	public void beforeMethod() {
		String ignored = IGNORED.get(this.testName);
		Assume.assumeTrue("Test " + this.testName + " skipped: " + ignored, ignored == null);
	}

	@Test
	public void valid() throws IOException {
		if (new File("../../running_on_travis").exists()) {
			System.out.println(".");
		}
		runTest(this.testName);
	}

	/**
	 * Scan a directory to get the names of all the hex files in that directory. The
	 * list of file names can be used as input parameters to a JUnit test.
	 *
	 * @param srcDir
	 *            The path of the directory to scan.
	 */
	public static Collection<Object[]> findTestNames(String srcDir) {
		final String suffix = ".hex";

		ArrayList<Object[]> testcases = new ArrayList<>();
		File[] files = new File(srcDir).listFiles();
		if(files == null) {
			throw new IllegalArgumentException("invalid directory: " + srcDir);
		} else {
			for (File f : files) {
				// Check it's a file
				if (!f.isFile()) {
					continue;
				}
				String name = f.getName();
				// Check it's a whiley source file
				if (!name.endsWith(suffix)) {
					continue;
				}
				// Get rid of extension
				String testName = name.substring(0, name.length() - suffix.length());
				testcases.add(new Object[] { testName });
			}
		}
		// Sort the result by filename
		Collections.sort(testcases, new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				return ((String) o1[0]).compareTo((String) o2[0]);
			}
		});
		return testcases;
	}
}
