package cs6890.classproject.cp02.files.D;

import cs6890.classproject.cp02.files.C.PuzzleStats;

import cs6890.classproject.cp02.files.D.EqualMatcher;
import cs6890.classproject.cp02.files.D.RangeMatcher;
import java.util.*;

/**
 * CS 6890 Spring 2015, Class Project 2.
 * 
 * @version Fri, Mar 6, 2015
 */
public class PuzzleFinder {

    private static final int EMPTY_RAND_RATIO = 40;
    private static final int H_RAND_RATIO = 2;

    /**
     * Keep track of global board information here
     * Passing this information around is pointless as everyone needs it
     */
    private static int rows;
    private static int cols;

    private static PuzzleMatcher matcher;
    private static Random rand = new Random();

    public static void main(String[] args) {
        //PuzzleMatcher matcher = new RangeMatcher(20, 30);
        //PuzzleMatcher matcher = new RangeMatcher(30, 39);
        //PuzzleMatcher matcher = new EqualMatcher(40);
        PuzzleMatcher matcher = new EqualMatcher(87);
        //PuzzleMatcher matcher = new GreaterMatcher(100);
        PuzzleStats.printBoard(findPuzzle(4, 5, matcher));
    }

    public static Character[][] findPuzzle(int numRows, int numCols, PuzzleMatcher matcher) {
        rows = numRows;
        cols = numCols;
        PuzzleFinder.matcher = matcher;

        Character[][] board = new Character[rows][cols];
        for(int i = 0; i < rows; i++) {
            Arrays.fill(board[i], ' ');
        }

        do {
            randomizePuzzle(board);
        } while(!matcher.puzzleMatch(board));

        return board;
    }

    private static void randomizePuzzle(Character[][] board) {
        int target_row = rand.nextInt(board.length);
        int target_col = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = randomTile();
            }
        }

        for(int j = target_col+1; j < board[0].length; j++)
            if(board[target_row][j] == 'H')
                board[target_row][j] = 'V';

        board[target_row][target_col] = 'T';
    }

    private static Character randomTile() {
        if(rand.nextInt(H_RAND_RATIO) == 0) {
            return 'H';
        }
        if(rand.nextInt(EMPTY_RAND_RATIO) == 0) {
            return '.';
        }
        return 'V';
    }
}
