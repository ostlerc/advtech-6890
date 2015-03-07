package cs6890.classproject.cp02.files.B;

import java.util.*;

/**
 * CS 6890 Spring 2015, Class Project 2.
 * 
 * @version Fri, Mar 6, 2015
 */
public class PuzzleGenerator {

    /**
     * Keep track of global board information here
     * Passing this information around is pointless as everyone needs it
     */
    private static int rows;
    private static int cols;

	/**
	 * Generate all configurations that have a target block,
	 * a single empty space, and all other locations have
	 * horizontal or vertical blocks.
	 */
	public static List<Character[][]> genAllConfigs(int numRows, int numCols) {
        ArrayList<Character[][]> allConfigs = new ArrayList<Character[][]>();
        rows = numRows;
        cols = numCols;

        Character[][] board = new Character[rows][cols];
	    for(int i = 0; i < rows; i++) {
            Arrays.fill(board[i], ' ');
        }

        for(int i = 0; i < rows; i++) {
	        for( int j =0; j < cols; j++) {
	            board[i][j] = '.';
	            genConfigs(0, 0, false, board, allConfigs);
                board[i][j] = ' ';
            }
        }

		return allConfigs;
	}

    /**
     * Generate all configs from row i column j and downward
     * If a block has not been assigned yet it is ' '
     * has_t describes if the board has a target block installed already or not
     * all other spaces must be permutated as either 'H', 'V' or 'T' (if it hasn't already been placed)
     */
	private static void genConfigs(int i, int j, boolean has_t, Character[][] board, List<Character[][]> configs) {
	    //base case
        if(j == cols - 1 && i == rows - 1) {
            if(board[i][j] == ' ') {
                if(has_t) {
                    board[i][j] = 'H';
                    configs.add(copyBoard(board));
                    board[i][j] = 'V';
                    configs.add(copyBoard(board));
                } else {
                    board[i][j] = 'T';
                    configs.add(copyBoard(board));
                }
                board[i][j] = ' ';
            } else if(has_t) {
                configs.add(copyBoard(board));
            }
            return;
        }

        int next_i = i;
        int next_j = j;

        if(j != cols - 1)
            next_j++;
        else
        {
            next_i++;
            next_j = 0;
        }

        if(board[i][j] == ' ') {
            if(!has_t) {
                board[i][j] = 'T';
                genConfigs(next_i, next_j, true, board, configs);
            }

            board[i][j] = 'H';
            genConfigs(next_i, next_j, has_t, board, configs);
            board[i][j] = 'V';
            genConfigs(next_i, next_j, has_t, board, configs);
            board[i][j] = ' ';
        } else {
            genConfigs(next_i, next_j, has_t, board, configs);
        }
    }

    private static Character[][] copyBoard(Character[][] board) {
        Character[][] copy = new Character[board.length][];
        for(int x = 0; x < board.length; x++) {
            copy[x] = board[x].clone();
        }
        return copy;
    }
}
