package cs6890.problemsets.ps03.files.C;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CS 6890 Spring 2015, Problem Set 3.
 * 
 * JUnit tests for Blocks.
 * 
 * @version Sat, Feb 21, 2015
 */
public class BlocksTest {

	@Test
	public void testEmptyBoard() {
		Character[][] board = {{'.', '.', '.'},
							   {'.', '.', '.'},
							   {'.', '.', '.'}};
		assertEquals(1, Blocks.countConfigs(board));
	}

	@Test(timeout=100)
	public void test1Row1H() {
		Character[][] board = {{'.', '.', '.', '.', 'H', '.', '.', '.', '.', '.'}};
		assertEquals(10, Blocks.countConfigs(board));
	}

	@Test(timeout=100)
	public void test1Row2H() {
		Character[][] board = {{'H', '.', '.', '.', '.', 'H', '.', '.', '.', 'H'}};
		assertEquals(120, Blocks.countConfigs(board));
	}

	@Test(timeout=100)
	public void test1RowHV() {
		Character[][] board = {{'H', '.', '.', '.', 'V', 'H', '.', '.', '.', 'H'}};
		assertEquals(40, Blocks.countConfigs(board));
	}

	@Test(timeout=100)
	public void test1Col1V() {
		Character[][] board = {{'.'},
				   			   {'.'},
				   			   {'V'},
				   			   {'.'},
				   			   {'.'}};
		assertEquals(5, Blocks.countConfigs(board));
	}

	@Test(timeout=100)
	public void test1Col2V() {
		Character[][] board = {{'.'},
				   			   {'V'},
				   			   {'.'},
				   			   {'V'},
				   			   {'.'}};
		assertEquals(10, Blocks.countConfigs(board));
	}

	@Test(timeout=100)
	public void test1ColVH() {
		Character[][] board = {{'.'},
				   			   {'V'},
				   			   {'V'},
				   			   {'.'},
				   			   {'H'},
				   			   {'.'},
				   			   {'V'},
				   			   {'.'},
				   			   {'V'},
				   			   {'.'}};
		assertEquals(60, Blocks.countConfigs(board));
	}

	@Test(timeout=1000)
	public void test2Row3H2H() {
		Character[][] board = {{'.', '.', '.', '.', 'H', '.', 'H', '.', 'H', '.'},
							   {'.', 'H', '.', '.', 'H', '.', '.', '.', '.', '.'}};
		assertEquals(5400, Blocks.countConfigs(board));
	}

	@Test(timeout=1000)
	public void test2Row3H2H1V() {
		Character[][] board = {{'.', '.', '.', '.', 'H', 'V', 'H', '.', 'H', '.'},
							   {'.', 'H', '.', '.', 'H', '.', '.', '.', '.', '.'}};
		assertEquals(8100, Blocks.countConfigs(board));
	}

	@Test(timeout=1000)
	public void test3x3_1() {
		Character[][] board = {{'.', 'H', 'V'},
							   {'H', 'V', 'H'},
							   {'V', 'H', 'V'}};
		assertEquals(10, Blocks.countConfigs(board));
	}

	@Test(timeout=1000)
	public void test3x3_2() {
		Character[][] board = {{'V', '.', 'H'},
							   {'H', 'V', '.'},
							   {'.', 'H', 'V'}};
		assertEquals(156, Blocks.countConfigs(board));
	}

	@Test(timeout=5000)
	public void test4x4_1() {
		Character[][] board = {{'H', 'V', 'V', 'H'},
							   {'H', '.', '.', 'H'},
							   {'H', '.', '.', 'H'},
							   {'H', '.', '.', 'H'}};
		assertEquals(4752, Blocks.countConfigs(board));
	}

	@Test(timeout=5000)
	public void test4x4_2() {
		Character[][] board = {{'H', 'V', 'V', 'H'},
							   {'H', '.', '.', 'H'},
							   {'H', '.', '.', 'H'},
							   {'H', '.', '.', 'H'}};
		assertEquals(4752, Blocks.countConfigs(board));
	}

	@Test(timeout=20000)
	public void test5x5_1() {
		Character[][] board = {{'H', 'V', 'H', 'V', 'H'},
							   {'H', '.', 'H', '.', 'H'},
							   {'H', '.', 'H', '.', 'H'},
							   {'H', '.', 'H', '.', 'H'},
							   {'H', '.', 'H', '.', 'H'}};
		assertEquals(370000, Blocks.countConfigs(board));
	}

	@Test(timeout=20000)
	public void test5x5_2() {
		Character[][] board = {{'H', 'V', 'H', 'V', 'H'},
							   {'H', '.', 'H', '.', 'H'},
							   {'V', '.', 'V', '.', 'V'},
							   {'H', '.', 'H', '.', 'H'},
							   {'H', 'V', 'H', 'V', 'H'}};
		assertEquals(478528, Blocks.countConfigs(board));
	}

	@Test(timeout=20000)
	public void test5x5_3() {
		Character[][] board = {{'.', 'V', 'H', 'V', 'H'},
							   {'H', 'V', 'H', '.', 'V'},
							   {'V', 'H', 'V', 'H', 'V'},
							   {'H', '.', 'V', 'H', 'H'},
							   {'V', 'V', 'H', 'V', 'H'}};
		assertEquals(669516, Blocks.countConfigs(board));
	}

	@Test(timeout=100000)
	public void test4x6_1() {
		Character[][] board = {{'V', 'V', 'H', 'V', 'H', 'V'},
							   {'.', 'V', '.', 'V', '.', 'H'},
							   {'H', '.', 'V', 'H', 'V', '.'},
							   {'V', 'H', 'V', 'H', 'V', 'V'}};
		assertEquals(1861380, Blocks.countConfigs(board));
	}
}
