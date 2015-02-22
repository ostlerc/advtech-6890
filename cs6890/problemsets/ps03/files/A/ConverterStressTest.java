package cs6890.problemsets.ps03.files.A;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CS 6890 Spring 2015, Problem Set 3.
 * 
 * JUnit stress tests for Converter.
 * 
 * @version Sat, Feb 21, 2015
 */
public class ConverterStressTest {

	@Test
	public void stressTest() {
		for (long i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i += 7 * (Math.abs(i) % 10 + 1))
			assertEquals(i, Converter.toInt(String.valueOf(i)));
	}
}
