package cs6890.classproject.cp02.files.D;

import cs6890.classproject.cp02.files.D.PuzzleMatcher;
import cs6890.classproject.cp02.files.A.PuzzleSolver;
import java.util.*;

/**
 * CS 6890 Spring 2015, Class Project 2.
 * 
 * @version Fri, Mar 6, 2015
 */
public class RangeMatcher implements PuzzleMatcher {
    private int low;
    private int high;

    RangeMatcher(int low, int high) {
        this.low  = low;
        this.high = high;
    }

    public boolean puzzleMatch(Character[][] puzzle) {
        int moves = PuzzleSolver.solvePuzzle(puzzle);
        return moves >= low && moves < high;
    }
}
