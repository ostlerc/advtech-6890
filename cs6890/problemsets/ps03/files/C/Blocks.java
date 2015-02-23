package cs6890.problemsets.ps03.files.C;
import java.util.*;
import java.lang.*;

/**
 * CS 6890 Spring 2015, Problem Set 3.
 *
 * Suppose you have a rectangular board with blocks that can
 * only move horizontally and blocks that can only move
 * vertically. This board is represented by a 2D array of
 * characters where 'H' and 'V' represent horizontal and
 * vertical blocks, respectively, and where '.' represents
 * an empty space (there is no 'T' block and you can assume
 * the board is correctly setup).
 *
 * Implement the countConfigs method below to count the number
 * of configurations reachable on a board with horizontal blocks
 * and vertical blocks, using any number of moves.
 *
 * Breath first search (BFS) or depth first search (DFS) are
 * both possible algorithms for solving this problem.
 *
 * @version Sat, Feb 21, 2015
 */
public class Blocks {

    private static HashSet<String> memos;
    private static Queue<Character[][]> queue;

	/**
	 * Count the number of configurations reachable on a board.
	 */
	public static int countConfigs(Character[][] orig_board) {
	    memos = new HashSet<String>();
        queue = new LinkedList<Character[][]>();

        queue.add(copyBoard(orig_board));
        memos.add(boardStr(orig_board));

        int ret = 0;
        while(!queue.isEmpty()) {
            Character[][] board = queue.remove();

            ret++;

            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    Character at = board[i][j];
                    board[i][j] = '.';
                    switch(at) {
                        case 'H':
                            for(int x = j+1; x < board[i].length; x++) { //check right
                                if(!queueBoard(i, x, board, at))
                                    break;
                            }
                            for(int x = j-1; x >= 0; x--) { //check left
                                if(!queueBoard(i, x, board, at))
                                    break;
                            }
                            break;
                        case 'V':
                            for(int y = i+1; y < board.length; y++) { //check down
                                if(!queueBoard(y, j, board, at))
                                    break;
                            }
                            for(int y = i-1; y >= 0; y--) { //check up
                                if(!queueBoard(y, j, board, at))
                                    break;
                            }
                            break;
                    }
                    board[i][j] = at;
                }
            }
        }
        return ret;
	}

    private static boolean queueBoard(int i, int j, Character[][] board, Character at) {
        if(board[i][j] != '.')
            return false;
        board[i][j] = at;
        String board_str = boardStr(board);
        if(!memos.contains(board_str)) {
            Character[][] newBoard = copyBoard(board);
            memos.add(board_str);
            queue.add(newBoard);
        }
        board[i][j] = '.';
        return true;
    }

    private static String boardStr(Character[][] board) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++)
                s.append(board[i][j]);
        }
        return s.toString();
    }

    private static Character[][] copyBoard(Character[][] board) {
        Character[][] copy = new Character[board.length][];
        for(int i = 0; i < board.length; i++) {
            copy[i] = new Character[board[i].length];
            for(int j = 0; j < board[i].length; j++)
                copy[i][j] = board[i][j];
        }
        return copy;
    }
}
