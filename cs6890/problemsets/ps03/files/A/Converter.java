package cs6890.problemsets.ps03.files.A;

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
		int sign = 1;

		// TODO: don't use substring (it's not efficient)
		if (s.charAt(0) == '-') {
			sign = -1;
			s = s.substring(1);
		}
		else if (s.charAt(0) == '+') {
			s = s.substring(1);
		} 
			
		if (s.length() == 0)
			throw new NumberFormatException();
			
		// TODO: read digits from left to right...?
		for (int i = s.length() - 1; i >= 0; i--) {
			
			char ch = s.charAt(i);
			if (!Character.isDigit(ch))
				throw new NumberFormatException();
			
			int digit = ch - '0';
			sum += digit * Math.pow(10, s.length() - 1 - i);
		}
		
		return sum * sign;
	}
	
}
