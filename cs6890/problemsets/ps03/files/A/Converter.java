package cs6890.problemsets.ps03.files.A;

import java.lang.Math;

/**
 * CS 6890 Spring 2015, Problem Set 3.
 * 
 * Converting a String into an int.
 * 
 * Fix the integer overflow/underflow bug, and any other bugs.
 *
 * @version Sat, Feb 21, 2015
 */
public class Converter {

    static final int base = 10;
    static final int MaxTest = Integer.MAX_VALUE / base;
    static final int MaxDigit = Integer.MAX_VALUE % base;
    static final int MaxLength = (int)Math.log10(Integer.MAX_VALUE) + 1;

	/**
	 * Converts a String into an int.
	 * A valid integer may start with - or +.
	 * 
	 * @throws NumberFormatException if <code>s</code> is not a valid
	 * 	       integer, or if it is outside of the valid int range staring 
	 *         at Integer.MIN_VALUE and ending at Integer.MAX_VALUE. 
	 */
	public static int toInt(String s) throws NumberFormatException {

		if (s == null || s.length() == 0)
			throw new NumberFormatException();
		
		int sum = 0;
		int i = 0;
		int last_digit = MaxDigit;
		int max_length = MaxLength;

		if (s.charAt(0) == '-') {
            last_digit++;
            max_length++;
			i = 1;
		}
		else if (s.charAt(0) == '+')
			i = 1;

		if (s.length() == i || s.length() > max_length)
			throw new NumberFormatException();
			
		for (; i < s.length(); i++) {
			
			char ch = s.charAt(i);
            int digit = ch - '0';

			if (ch < '0' || ch > '9' || (sum == MaxTest && digit > last_digit)) {
				throw new NumberFormatException();
            }

            sum *= base;
			sum += digit;
		}

		return s.charAt(0) == '-' ? -sum : sum;
	}
}
