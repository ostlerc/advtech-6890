package cs6890.problemsets.ps03.files.A;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CS 6890 Spring 2015, Problem Set 3.
 * 
 * JUnit tests for Converter.
 * 
 * @version Sat, Feb 21, 2015
 */
public class ConverterTest {

	@Test(expected=NumberFormatException.class)
	public void testNull() {
		Converter.toInt(null);
	}

	@Test(expected=NumberFormatException.class)
	public void testEmptyString() {
		Converter.toInt("");
	}

	@Test
	public void testZero() {
		int res = Converter.toInt("0");
		assertEquals(0, res);
		res = Converter.toInt("0123");
		assertEquals(123, res);
	}

	@Test
	public void testPositiveNumber() {
		int res = Converter.toInt("123");
		assertEquals(123, res);
	}

	@Test
	public void testNegativeNumber() {
		int res = Converter.toInt("-123");
		assertEquals(-123, res);
	}
	
	@Test(expected=NumberFormatException.class)
	public void testDecimal() {
		Converter.toInt("123.456");
	}
	
	@Test(expected=NumberFormatException.class)
	public void testJustMinusSign() {
		Converter.toInt("-");
	}

	@Test(expected=NumberFormatException.class)
	public void testMinusSignInTheMiddle() {
		Converter.toInt("12-3");
	}

	@Test(expected=NumberFormatException.class)
	public void testMinusSignAtTheEnd() {
		Converter.toInt("123-");
	}

	@Test(expected=NumberFormatException.class)
	public void testNonDigit() {
		Converter.toInt("123x0");
	}
	
	@Test
	public void testPlusSignInFront() {
		int res = Converter.toInt("+123");
		assertEquals(123, res);
	}
	
	@Test
	public void testMaxValue() {
		int res = Converter.toInt(String.valueOf(Integer.MAX_VALUE));
		assertEquals(Integer.MAX_VALUE, res);
	}
	
	@Test(expected=NumberFormatException.class)
	public void testIntOverflow() {
		long num = ((long) Integer.MAX_VALUE) + 1;
		Converter.toInt(String.valueOf(num));
	}
	
	@Test
	public void testMinValue() {
		int res = Converter.toInt(String.valueOf(Integer.MIN_VALUE));
		assertEquals(Integer.MIN_VALUE, res);
	}

	@Test(expected=NumberFormatException.class)
	public void testIntUnderflow() {
		long num = ((long) Integer.MIN_VALUE) - 1;
		Converter.toInt(String.valueOf(num));
	}
}
