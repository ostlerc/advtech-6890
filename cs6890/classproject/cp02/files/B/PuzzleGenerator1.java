package cs6890.classproject.cp02.files.B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generate all possible configurations for a given board size.
 * This includes both solvable and unsolvable configurations,
 * but only includes configurations that have one target block.
 * 
 * This implementation uses recursion.
 * 
 * Can you think of advantages and disadvantages of this implementation?
 * 
 * @version Wed, Feb 28, 2015
 */
public class PuzzleGenerator1 {

	private static final char TARGET_BLOCK = 'T';
	private static final char EMPTY_SPACE = '.';
	private static final char[] NON_TARGET_BLOCKS = {EMPTY_SPACE, 'H', 'V'};

	private static Character[][] board;
	private static List<Character[][]> allConfigs;

	/**
	 * Generate all configurations for a given size.
	 */
	public static List<Character[][]> genAllConfigs(int numRows, int numCols) {
		allConfigs = new ArrayList<Character[][]>();
		 
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				board = new Character[numRows][numCols];
				for (int i = 0; i < numRows; i++)
					Arrays.fill(board[i], '.');
				board[row][col] = TARGET_BLOCK;
				genAllConfigsForTarget(0, 0);
			}
		}
		return allConfigs;
	}

	/**
	 * Generate configurations for a given location of the target block.
	 * 
	 * @param row row where the next block should be placed. 
	 * @param col column where the next block should be placed. 
	 */
	public static void genAllConfigsForTarget(int row, int col) {
		
		// all locations considered -> add to list
		if (row == board.length) {
			allConfigs.add( copy(board) );
			return;
		}
		
		// skip target block location
		if (board[row][col] == TARGET_BLOCK) {
			genAllConfigsForTarget(nextRow(row, col), nextCol(row, col));
			return;
		}
		
		// try all possible blocks at the current location
		for (int i = 0; i < NON_TARGET_BLOCKS.length; i++) {
			board[row][col] = NON_TARGET_BLOCKS[i];
			genAllConfigsForTarget(nextRow(row, col), nextCol(row, col));
		}
	}
	
	private static int nextRow(int row, int col) {
		int numCols = board[0].length;
		return col < numCols - 1 ? row : row + 1;
	}
	
	private static int nextCol(int row, int col) {
		int numCols = board[0].length;
		return col < numCols - 1 ? col + 1 : 0;
	}
	
	private static Character[][] copy(Character[][] board) {
		int numRows = board.length;
		Character[][] boardCopy = new Character[numRows][];
		for (int row = 0; row < numRows; row++)
			boardCopy[row] = board[row].clone();
		return boardCopy;
	}

	public static void main(String[] args) {
		List<Character[][]> allConfigs = genAllConfigs(2, 2);
		System.out.println("Total configurations of size 2 x 2 = " + allConfigs.size());

		allConfigs = genAllConfigs(3, 3);
		System.out.println("Total configurations of size 3 x 3 = " + allConfigs.size());
	}
}
