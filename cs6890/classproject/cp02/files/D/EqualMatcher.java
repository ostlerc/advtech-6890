package cs6890.classproject.cp02.files.D;

import cs6890.classproject.cp02.files.D.PuzzleMatcher;
import cs6890.classproject.cp02.files.A.PuzzleSolver;
import java.util.*;

/**
 * CS 6890 Spring 2015, Class Project 2.
 * 
 * @version Fri, Mar 6, 2015
 */
public class EqualMatcher implements PuzzleMatcher {
    private int steps;

    EqualMatcher(int steps) {
        this.steps = steps;
    }

    public boolean puzzleMatch(Character[][] puzzle) {
        return steps == PuzzleSolver.solvePuzzle(puzzle);
    }
}
