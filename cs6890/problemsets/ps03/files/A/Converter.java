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
		boolean neg = false;
        final int base = 10;
        int MaxTest =  Integer.MAX_VALUE / base;
        int MaxDigit = Integer.MAX_VALUE % base;

		int start = 0;
		if (s.charAt(0) == '-') {
			neg = true;
			start = 1;
		}
		else if (s.charAt(0) == '+')
			start = 1;

        if(neg) { // two's complement : negative numbers hold 1 more than positive
            MaxDigit++;
        }
			
		if (s.length() == start)
			throw new NumberFormatException();
			
		for (int i = start; i < s.length(); i++) {
			
			char ch = s.charAt(i);
			if (!Character.isDigit(ch))
				throw new NumberFormatException();
			
            int digit = ch - '0';
			if(sum > MaxTest || (sum == MaxTest && digit > MaxDigit)) {
                throw new NumberFormatException();
            }

            sum *= base;
			sum += digit;
		}
		
		return neg ? -sum : sum;
	}
	
}
