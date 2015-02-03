package cs6890.problemsets.ps02.files;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

/**
 * JUnit tests for MineSweeper
 *
 * @version Mon, Feb 02, 2015
 */
public class MineSweeperTest {

    @Test
    public void testEmptyMap() {
        boolean[][] map = new boolean[10][10];

        int[][] res = MineSweeper.countMines(map);
        assertTrue(res.length == 10);
        assertTrue(res[0].length == 10);

        for(int i=0; i < 10; i++) {
            for(int j=0; j < 10; j++) {
                assertTrue(res[i][j] == 0);
            }
        }
    }

    @Test
    public void testFullMap() {
        int n = 10;
        boolean[][] map = new boolean[n][n];
        for(int i=0; i < n; i++) {
            Arrays.fill(map[i], true);
        }

        int[][] res = MineSweeper.countMines(map);
        assertTrue(res.length == n);
        assertTrue(res[0].length == n);

        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                assertTrue(res[i][j] == -1);
            }
        }
    }

    @Test
    public void testTopLeftCornerMine() {
        boolean[][] map = new boolean[2][2];

        map[0][0] = true;

        int[][] sol = {{-1, 1}, {1, 1}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }

    @Test
    public void testTopRightCornerMine() {
        boolean[][] map = new boolean[2][2];

        map[0][1] = true;

        int[][] sol = {{1, -1}, {1, 1}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }

    @Test
    public void testBottomLeftCornerMine() {
        boolean[][] map = new boolean[2][2];

        map[1][0] = true;

        int[][] sol = {{1, 1}, {-1, 1}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }

    @Test
    public void testBottomRightCornerMine() {
        boolean[][] map = new boolean[2][2];

        map[1][1] = true;

        int[][] sol = {{1, 1}, {1, -1}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }

    @Test
    public void testCenterMine() {
        boolean[][] map = new boolean[3][3];

        map[1][1] = true;

        int[][] sol = {{1, 1, 1}, {1, -1, 1}, {1, 1, 1}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }

    @Test
    public void testLeftSideMine() {
        boolean[][] map = new boolean[3][3];

        map[1][0] = true;

        int[][] sol = {{1, 1, 0}, {-1, 1, 0}, {1, 1, 0}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }

    @Test
    public void testRightSideMine() {
        boolean[][] map = new boolean[3][3];

        map[1][2] = true;

        int[][] sol = {{0, 1, 1}, {0, 1, -1}, {0, 1, 1}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }

    @Test
    public void testTopSideMine() {
        boolean[][] map = new boolean[3][3];

        map[0][1] = true;

        int[][] sol = {{1, -1, 1}, {1, 1, 1}, {0, 0, 0}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }

    @Test
    public void testBottomSideMine() {
        boolean[][] map = new boolean[3][3];

        map[2][1] = true;

        int[][] sol = {{0, 0, 0}, {1, 1, 1}, {1, -1, 1}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }

    @Test
    public void testSidebySideMine() {
        boolean[][] map = new boolean[4][4];

        map[2][1] = true;
        map[2][2] = true;

        int[][] sol = {{0, 0, 0, 0}, {1, 2, 2, 1}, {1, -1, -1, 1}, {1, 2, 2, 1}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }

    @Test
    public void testSurroundedArea() {
        boolean[][] map = new boolean[3][3];
        for(int i=0; i < 3; i++) {
            Arrays.fill(map[i], true);
        }

        map[1][1] = false;

        int[][] sol = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }

    @Test
    public void testFullCol() {
        boolean[][] map = new boolean[3][3];

        map[0][1] = true;
        map[1][1] = true;
        map[2][1] = true;

        int[][] sol = {{2, -1, 2}, {3, -1, 3}, {2, -1, 2}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }

    @Test
    public void testFullRow() {
        boolean[][] map = new boolean[3][3];

        map[1][0] = true;
        map[1][1] = true;
        map[1][2] = true;

        int[][] sol = {{2, 3, 2}, {-1, -1, -1}, {2, 3, 2}};
        int[][] res = MineSweeper.countMines(map);

        assertTrue(Arrays.deepEquals(sol, res));
    }
}
