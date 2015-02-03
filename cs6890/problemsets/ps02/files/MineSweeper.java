package cs6890.problemsets.ps02.files;

import java.lang.*;
import java.util.*;

/**
 * MineSweeper class to count mines
 *
 * @version Mon, Feb 02, 2015
 */
public class MineSweeper {

    /**
     * Return an array of integers where each cell with a mine has a -1, and every
     * other cell has the total number of mines in all adjacent cells
     *
     * @param mineField an m x n boolean array where a true value indicates the
     * presence of a mine
     */
    public static int[][] countMines(boolean[][] mineField) {
        int[][] mineCounts = new int[mineField.length][];

        // Allocate and initialize count map
        for(int m=0; m < mineField.length; m++) {
            mineCounts[m] = new int[mineField[m].length];
            for(int n=0; n < mineField[m].length; n++) {
                mineCounts[m][n] = 0;
            }
        }

        // For each mine, mark all surrounding areas as +1
        int md = mineField.length;
        for(int m=0; m < md; m++) {
            int nd = mineField[m].length;
            for(int n=0; n < nd; n++) {

                if(!mineField[m][n])
                    continue;

                if(m > 0) //up
                {
                    mineCounts[m-1][n]++;
                    if(n > 0)
                        mineCounts[m-1][n-1]++; //left
                    if(n < md-1)
                        mineCounts[m-1][n+1]++; //right
                }
                if(m < md-1)
                {
                    mineCounts[m+1][n]++; //down
                    if(n > 0)
                        mineCounts[m+1][n-1]++; //left
                    if(n < md-1)
                        mineCounts[m+1][n+1]++; //right
                }

                if(n > 0)
                    mineCounts[m][n-1]++; //left
                if(n < md-1)
                    mineCounts[m][n+1]++; //right
            }
        }

        // mark all mines as -1
        for(int m=0; m < mineField.length; m++) {
            for(int n=0; n < mineField[m].length; n++) {
                if(mineField[m][n])
                    mineCounts[m][n] = -1;
            }
        }

        return mineCounts;
    }
}
