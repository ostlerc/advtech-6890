package cs6890.classproject.cp02.files.D;

import cs6890.classproject.cp02.files.D.PuzzleMatcher;
import cs6890.classproject.cp02.files.A.PuzzleSolver;
import java.util.*;

/**
 * CS 6890 Spring 2015, Class Project 2.
 * 
 * @version Fri, Mar 6, 2015
 */
public class GreaterMatcher implements PuzzleMatcher {
    private int steps;

    GreaterMatcher(int steps) {
        this.steps = steps;
    }

    public boolean puzzleMatch(Character[][] puzzle) {
        return PuzzleSolver.solvePuzzle(puzzle) >= steps;
    }
}

