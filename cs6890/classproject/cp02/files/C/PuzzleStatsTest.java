package cs6890.classproject.cp02.files.C;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * CS 6890 Spring 2015, Class Project 2.
 * 
 * JUnit tests for PuzzleStats.
 * 
 * @version Fri, Mar 6, 2015
 */
public class PuzzleStatsTest {

	@Test(timeout=100)
	public void test2x2() {
		Map<Integer, Integer> stats = new HashMap<Integer, Integer>();
		stats.put(-1, 10);
		stats.put(0, 24);
		stats.put(1, 8);
		stats.put(2, 4);
		stats.put(3, 2);
		assertEquals(stats, PuzzleStats.computeStats(2, 2));
	}

	@Test(timeout=100)
	public void test2x3() {
		Map<Integer, Integer> stats = new HashMap<Integer, Integer>();
		stats.put(-1, 256);
		stats.put(0, 160);
		stats.put(1, 32);
		stats.put(2, 16);
		stats.put(3, 8);
		stats.put(4, 4);
		stats.put(5, 2);
		stats.put(6, 2);
		assertEquals(stats, PuzzleStats.computeStats(2, 3));
	}

	@Test(timeout=2000)
	public void test3x3() {
		Map<Integer, Integer> stats = new HashMap<Integer, Integer>();
		stats.put(-1, 4928);
		stats.put(0, 3072);
		stats.put(1, 384);
		stats.put(2, 256);
		stats.put(3, 192);
		stats.put(4, 128);
		stats.put(5, 111);
		stats.put(6, 69);
		stats.put(7, 34);
		stats.put(8, 20);
		stats.put(9, 10);
		stats.put(10, 4);
		stats.put(11, 6);
		stats.put(12, 2);
		assertEquals(stats, PuzzleStats.computeStats(3, 3));
	}

	@Test(timeout=10000)
	public void test3x4() {
		Map<Integer, Integer> stats = new HashMap<Integer, Integer>();
		stats.put(-1, 89519);
		stats.put(0, 33792);
		stats.put(1, 3072);
		stats.put(2, 2048);
		stats.put(3, 1536);
		stats.put(4, 1024);
		stats.put(5, 1144);
		stats.put(6, 1054);
		stats.put(7, 685);
		stats.put(8, 523);
		stats.put(9, 252);
		stats.put(10, 146);
		stats.put(11, 114);
		stats.put(12, 68);
		stats.put(13, 62);
		stats.put(14, 44);
		stats.put(15, 25);
		stats.put(16, 8);
		stats.put(17, 14);
		stats.put(18, 16);
		stats.put(19, 10);
		stats.put(20, 8);
		stats.put(21, 4);
		assertEquals(stats, PuzzleStats.computeStats(3, 4));
	}

}
