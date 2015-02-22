package cs6890.problemsets.ps03.files.B;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CS 6890 Spring 2015, Problem Set 3.
 * 
 * JUnit tests for CompactBooleanArray.
 * 
 * @version Sat, Feb 21, 2015
 */
public class CompactBooleanArrayTest {

	@Test(expected=IllegalArgumentException.class)
	public void testConstructorWithNegativeSize() {
		new CompactBooleanArray(-1);
	}

	@Test
	public void testConstructorWithZeroSize() {
		CompactBooleanArray ba = new CompactBooleanArray(0);
		assertEquals(0, ba.getSize());
		assertEquals(0, ba.getArraySize());
	}
	
	@Test
	public void testConstructorWithPositiveSize() {
		int size = 10;
		CompactBooleanArray ba = new CompactBooleanArray(size);
		assertEquals(size, ba.getSize());
		assertEquals(1, ba.getArraySize());
		for (int i = 0; i < size; i++)
			assertFalse(ba.get(i));
	}
	
	@Test
	public void testSize() {
		CompactBooleanArray ba = new CompactBooleanArray(0);
		assertEquals(0, ba.getSize());
		assertEquals(0, ba.getArraySize());
		for (int size = 1; size <= Integer.SIZE; size++) {
			ba = new CompactBooleanArray(size);
			assertEquals(size, ba.getSize());
			assertEquals(1, ba.getArraySize());
		}
		for (int size = Integer.SIZE + 1; size <= 2 * Integer.SIZE; size++) {
			ba = new CompactBooleanArray(size);
			assertEquals(size, ba.getSize());
			assertEquals(2, ba.getArraySize());
		}
	}
	
	@Test
	public void testOutOfBoundsLow() {
		int size = 6890;
		CompactBooleanArray ba = new CompactBooleanArray(size);
		
		// get
		try {
			ba.get(-1);
			fail("Expected: IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
			assertTrue("IndexOutOfBoundsException", true);
		}
		
		// set
		try {
			ba.set(-1, true);
			fail("Expected: IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
			assertTrue("IndexOutOfBoundsException", true);
		}

		// negate
		try {
			ba.negate(-1);
			fail("Expected: IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
			assertTrue("IndexOutOfBoundsException", true);
		}
	}

	@Test
	public void testOutOfBoundsHigh() {
		int size = 6890;
		CompactBooleanArray ba = new CompactBooleanArray(size);
		
		// get
		try {
			ba.get(size);
			fail("Expected: IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
			assertTrue("IndexOutOfBoundsException", true);
		}
		
		// set
		try {
			ba.set(size, true);
			fail("Expected: IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
			assertTrue("IndexOutOfBoundsException", true);
		}

		// negate
		try {
			ba.negate(size);
			fail("Expected: IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
			assertTrue("IndexOutOfBoundsException", true);
		}
	}

	@Test
	public void testSetTrue() {
		int size = 6890;
		CompactBooleanArray ba = new CompactBooleanArray(size);
		for (int i = 0; i < size; i++)
			ba.set(i, i % 2 == 0);
		for (int i = 0; i < size; i++)
			ba.set(i, true);
		for (int i = 0; i < size; i++)
			assertTrue(ba.get(i));
	}
	
	@Test
	public void testSetFalse() {
		int size = 6890;
		CompactBooleanArray ba = new CompactBooleanArray(size);
		for (int i = 0; i < size; i++)
			ba.set(i, i % 2 == 0);
		for (int i = 0; i < size; i++)
			ba.set(i, false);
		for (int i = 0; i < size; i++)
			assertFalse(ba.get(i));
	}
	
	@Test
	public void testSetAndGet() {
		int size = 6890;
		CompactBooleanArray ba = new CompactBooleanArray(size);
		for (int i = 0; i < size; i++)
			ba.set(i, i % 2 == 0);
		for (int i = 0; i < size; i++)
			assertEquals(i % 2 == 0, ba.get(i));
	}
	
	@Test
	public void testNegate() {
		int size = 6890;
		CompactBooleanArray ba = new CompactBooleanArray(size);
		for (int i = 0; i < size; i++)
			if (i % 3 == 0)
				ba.set(i, true);
		for (int i = 0; i < size; i++)
			ba.negate(i);
		for (int i = 0; i < size; i++)
			assertEquals(i % 3 != 0, ba.get(i));
	}
	
	@Test
	public void testGetArray_1() {
		for (int i = 0; i < Integer.SIZE - 1; i++) {
			CompactBooleanArray ba = new CompactBooleanArray(2 * Integer.SIZE);
			ba.set(i, true);
			int[] array = ba.getArray();
			int[] expected = { (int) Math.pow(2, i), 0 };
			assertArrayEquals(expected, array);
		}
	}

	@Test
	public void testGetArray_2() {
		for (int i = 0; i < Integer.SIZE - 1; i++) {
			CompactBooleanArray ba = new CompactBooleanArray(2 * Integer.SIZE);
			ba.set(Integer.SIZE + i, true);
			int[] array = ba.getArray();
			int[] expected = { 0, (int) Math.pow(2, i) };
			assertArrayEquals(expected, array);
		}
	}

	@Test
	public void testGetArray_3() {
		int size = 11 * Integer.SIZE;
		CompactBooleanArray ba = new CompactBooleanArray(size);
		for (int i = 0; i < 11; i++)
			ba.set(i * Integer.SIZE + i, true);
		int[] array = ba.getArray();
		int[] expected = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 };
		assertArrayEquals(expected, array);
	}
	
	@Test()
	public void testMemoryUsage() throws Exception {

		// Technically, this is not a unit test,
		// but we will used it for this problem.
		
		// Integer.MAX_VALUE = 2147483647
		// 2147483647 bits ~= 270 MB
		int size = Integer.MAX_VALUE;
		CompactBooleanArray ba = new CompactBooleanArray(size);

		// 512 MB is more than enough space for the array
		// and any extra memory used by the virtual machine
		long memoryTotal = Runtime.getRuntime().totalMemory();
		long memory512MB = 512 * 1024 * 1024; 
		assertTrue(memoryTotal <= memory512MB);
	}
}
