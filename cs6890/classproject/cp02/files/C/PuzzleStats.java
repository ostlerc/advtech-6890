package cs6890.classproject.cp02.files.C;

import cs6890.classproject.cp02.files.A.PuzzleSolver;
import cs6890.classproject.cp02.files.B.PuzzleGenerator;
import java.util.*;

/**
 * CS 6890 Spring 2015, Class Project 2.
 * 
 * @version Fri, Mar 6, 2015
 */
public class PuzzleStats {
	
	/**
	 * Count the number of puzzles for each possible value of the
	 * minimum number of moves required to solve them.
	 * 
	 * Returns a map where the key is the minimum number of moves
	 * and the value is the number of configurations that require
	 * that number of moves.
	 * 
	 * Puzzles that have no solution have a key of -1.
	 */
	public static Map<Integer, Integer> computeStats(int numRows, int numCols) {
	    Map<Integer, Integer> res = new HashMap<Integer, Integer>();

        List<Character[][]> configs = PuzzleGenerator.genAllConfigs(numRows, numCols);

        for(Character[][] config : configs) {
            int key = PuzzleSolver.solvePuzzle(config);
            if(res.containsKey(key))
                res.put(key, res.get(key)+1);
            else
                res.put(key, 1);
        }

		return res;
	}
}
