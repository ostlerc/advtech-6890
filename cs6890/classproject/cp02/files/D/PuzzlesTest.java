package cs6890.classproject.cp02.files.D;

import static org.junit.Assert.*;

import org.junit.Test;

import cs6890.classproject.cp02.files.A.PuzzleSolver;

/**
 * CS 6890 Spring 2015, Class Project 2.
 * 
 * JUnit tests for student puzzles.
 * 
 * Update the board for each test case with puzzles that require
 * a the specified number of moves.
 * 
 * @version Fri, Mar 6, 2015
 */
public class PuzzlesTest {

	@Test
	public void test4x4_20_29() {
		Character[][] board = {{'.', '.', '.', '.'},
		                       {'.', '.', '.', '.'},
		                       {'.', '.', '.', '.'},
		                       {'.', '.', '.', '.'}};
		int moves = PuzzleSolver.solvePuzzle(board);
		assertTrue(moves >= 20 && moves < 30);
	}

	@Test
	public void test4x4_30_39() {
		Character[][] board = {{'.', '.', '.', '.'},
		                       {'.', '.', '.', '.'},
		                       {'.', '.', '.', '.'},
		                       {'.', '.', '.', '.'}};
		int moves = PuzzleSolver.solvePuzzle(board);
		assertTrue(moves >= 30 && moves < 39);
	}

	@Test
	public void test4x4_40() {
		Character[][] board = {{'.', '.', '.', '.'},
		                       {'.', '.', '.', '.'},
		                       {'.', '.', '.', '.'},
		                       {'.', '.', '.', '.'}};
		int moves = PuzzleSolver.solvePuzzle(board);
		assertEquals(40, moves);
	}

	@Test
	public void test5x5_100() {
		Character[][] board = {{'.', '.', '.', '.', '.'},
		                       {'.', '.', '.', '.', '.'},
		                       {'.', '.', '.', '.', '.'},
		                       {'.', '.', '.', '.', '.'},
		                       {'.', '.', '.', '.', '.'}};
		int moves = PuzzleSolver.solvePuzzle(board);
		assertTrue(moves >= 100);
	}

	@Test
	public void test4x5_87() {
		Character[][] board = {{'.', '.', '.', '.', '.'},
		                       {'.', '.', '.', '.', '.'},
		                       {'.', '.', '.', '.', '.'},
		                       {'.', '.', '.', '.', '.'}};
		int moves = PuzzleSolver.solvePuzzle(board);
		assertEquals(87, moves);
	}

}
