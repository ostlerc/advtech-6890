package cs6890.classproject.cp02.files.B;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CS 6890 Spring 2015, Class Project 2.
 * 
 * JUnit tests for PuzzleGenerator.
 * 
 * @version Fri, Mar 6, 2015
 */
public class PuzzleGeneratorTest {

	@Test(timeout=100)
	public void test2x2() {
		assertEquals(48, PuzzleGenerator.genAllConfigs(2, 2).size());
	}

	@Test(timeout=100)
	public void test2x3() {
		assertEquals(480, PuzzleGenerator.genAllConfigs(2, 3).size());
	}

	@Test(timeout=100)
	public void test3x3() {
		assertEquals(9216, PuzzleGenerator.genAllConfigs(3, 3).size());
	}

	@Test(timeout=100)
	public void test3x4() {
		assertEquals(135168, PuzzleGenerator.genAllConfigs(3, 4).size());
	}

	@Test(timeout=15000)
	public void test4x4() {
		assertEquals(3932160, PuzzleGenerator.genAllConfigs(4, 4).size());
	}
}
