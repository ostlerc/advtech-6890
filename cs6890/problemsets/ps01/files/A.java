package cs6890.problemsets.ps01.files;
import java.util.Arrays;

/**
 * CS 6890 Spring 2015, Problem Set 1.
 * 
 * The method checkNumbr is not clear.
 * Refactor it so that its purpose is obvious and the code is clean.
 * 
 * You may change the name of the method and the parameters, but not
 * the return type what the method returns. You may change the main method.
 */
public class A {

    public static boolean isPrime(int n) {
        if (n<2) return false;
        if (n==2) return true; // special case 2 is a prime
        if (n%2 == 0) return false;

        for(int i=3; i*i <= n; i+=2) { // only check odds
            if(n%i==0)
                return false;
        }
        return true;
    }

	public static void main(String[] args) {
	    for(int i = 0; i < 100; i++)
	        System.out.format("%d is %sprime\n", i, isPrime(i) ? "" : "not ");
	}
}
