package cs6890.classproject.cp02.files.A;
import java.util.*;
import java.lang.*;

/**
 * CS 6890 Spring 2015, Class Project 2.
 * 
 * @version Fri, Mar 6, 2015
 */
public class PuzzleSolver {

    /**
     * A class to store metadata about a specific board configuration
     */
    private static class BoardMove {
        public BoardMove(Character[][] board, int moves) {
            this.board = board;
            this.moves = moves;
        }

        public Character[][] board;
        public int moves;
    }

    private static Map<Long, Boolean> memos;
    private static Queue<BoardMove> queue;
    private static boolean solution_found;

     /**
      * Determine the minimum number of moves required to solve a puzzle.
      * 
      * Returns -1 if the puzzle is not solvable.
      */
    public static int solvePuzzle(Character[][] orig_board) {

        int cols = orig_board[0].length;
        for(int i = 0; i < orig_board.length; i++) {
            if(orig_board[i][cols-1] == 'T')
                return 0;
        }

        memos = new HashMap<Long, Boolean>();
        queue = new LinkedList<BoardMove>();
        solution_found = false;

        BoardMove m = new BoardMove(copyBoard(orig_board), 0);
        queue.add(m);
        memos.put(hash(orig_board), true);

        while(!queue.isEmpty()) {
            BoardMove move = queue.remove();

            for(int i = 0; i < move.board.length; i++) {
                for(int j = 0; j < move.board[i].length; j++) {
                    Character at = move.board[i][j];
                    move.board[i][j] = '.';
                    switch(at) {
                        case 'H':
                        case 'h':
                        case 'T':
                        case 't':
                            for(int x = j+1; x < move.board[i].length; x++) { //check right
                                if(!queueBoard(i, x, move, at))
                                    break;
                            }
                            for(int x = j-1; x >= 0; x--) { //check left
                                if(!queueBoard(i, x, move, at))
                                    break;
                            }
                            if(solution_found)
                                return move.moves+1;
                            break;
                        case 'V':
                        case 'v':
                            for(int y = i+1; y < move.board.length; y++) { //check down
                                if(!queueBoard(y, j, move, at))
                                    break;
                            }
                            for(int y = i-1; y >= 0; y--) { //check up
                                if(!queueBoard(y, j, move, at))
                                    break;
                            }
                            break;
                    }
                    move.board[i][j] = at;
                }
            }
        }

        //Solution not found
        return -1;
    }

    /**
     * Queue board with position i,j as the tile 'at'
     * If moving causes winning condition, then set the global solution_found boolean to true
     */
    private static boolean queueBoard(int i, int j, BoardMove move, Character at) {
        if(move.board[i][j] != '.')
            return false;
        move.board[i][j] = at;
        Long hash = hash(move.board);
        if(!memos.containsKey(hash)) {
            if(at == 'T' && j == move.board[i].length-1)
                solution_found = true;
            Character[][] newBoard = copyBoard(move.board);
            memos.put(hash, true);
            queue.add(new BoardMove(newBoard, move.moves + 1));
        }
        move.board[i][j] = '.';
        return true;
    }

    private static Character[][] copyBoard(Character[][] board) {
        Character[][] copy = new Character[board.length][];
        for(int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }
        return copy;
    }

    public static long hash(Character[][] board) {
        long h = 1125899906842597L; // prime

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++)
            h = 31*h + board[i][j];
        }
        return h;
    }
	
}
