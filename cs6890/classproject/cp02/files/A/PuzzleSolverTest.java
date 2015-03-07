package cs6890.classproject.cp02.files.A;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CS 6890 Spring 2015, Class Project 2.
 * 
 * JUnit tests for PuzzleSolver.
 * 
 * @version Fri, Mar 6, 2015
 */
public class PuzzleSolverTest {

	@Test
	public void testEmptyBoard() {
		Character[][] board = {{'.', '.', '.'},
							   {'.', '.', '.'},
							   {'.', '.', '.'}};
		assertEquals(-1, PuzzleSolver.solvePuzzle(board));
	}

	@Test(timeout=100)
	public void test1Row_1() {
		Character[][] board = {{'.', '.', '.', '.', 'T', '.', '.', '.', '.', '.'}};
		assertEquals(1, PuzzleSolver.solvePuzzle(board));
	}

	@Test(timeout=100)
	public void test1Row_2() {
		Character[][] board = {{'H', '.', '.', '.', '.', 'T', '.', '.', '.', 'H'}};
		assertEquals(-1, PuzzleSolver.solvePuzzle(board));
	}

	@Test(timeout=100)
	public void test1Col_1() {
		Character[][] board = {{'.'},
				   			   {'V'},
				   			   {'V'},
				   			   {'.'},
				   			   {'H'},
				   			   {'.'},
				   			   {'V'},
				   			   {'T'},
				   			   {'V'},
				   			   {'.'}};
		assertEquals(0, PuzzleSolver.solvePuzzle(board));
	}

	@Test(timeout=1000)
	public void test2RowHH() {
		Character[][] board = {{'.', '.', '.', '.', 'T', '.', 'H', '.', 'H', '.'},
							   {'.', 'H', '.', '.', 'H', '.', '.', '.', '.', '.'}};
		assertEquals(-1, PuzzleSolver.solvePuzzle(board));
	}

	@Test(timeout=1000)
	public void test2RowHV() {
		Character[][] board = {{'.', 'H', '.', '.', 'H', '.', '.', '.', 'H', '.'},
							   {'T', 'V', 'V', '.', 'V', 'V', '.', '.', 'v', '.'}};
		assertEquals(9, PuzzleSolver.solvePuzzle(board));
	}

	@Test(timeout=1000)
	public void test3x3_1() {
		Character[][] board = {{'.', 'H', 'V'},
							   {'T', 'V', 'V'},
							   {'V', 'H', 'H'}};
		assertEquals(8, PuzzleSolver.solvePuzzle(board));
	}

	@Test(timeout=5000)
	public void test4x4_1() {
		Character[][] board = {{'T', 'V', 'V', 'V'},
							   {'H', 'H', 'V', 'H'},
							   {'H', '.', '.', 'H'},
							   {'H', 'V', 'H', '.'}};
		assertEquals(9, PuzzleSolver.solvePuzzle(board));
	}

	@Test(timeout=20000)
	public void test5x5_1() {
		Character[][] board = {{'.', 'V', 'H', 'V', 'H'},
							   {'H', 'V', 'H', '.', 'V'},
							   {'V', 'T', 'V', '.', 'V'},
							   {'H', '.', 'V', 'H', 'H'},
							   {'V', 'V', 'H', 'V', 'H'}};
		assertEquals(8, PuzzleSolver.solvePuzzle(board));
	}

	@Test(timeout=100000)
	public void test4x6_1() {
		Character[][] board = {{'V', 'V', 'H', 'V', 'H', 'V'},
							   {'.', 'V', 'T', 'V', '.', 'V'},
							   {'H', '.', 'V', 'H', 'V', '.'},
							   {'V', 'H', 'V', 'H', 'V', 'V'}};
		assertEquals(11, PuzzleSolver.solvePuzzle(board));
	}
}
