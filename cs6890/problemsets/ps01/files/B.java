package cs6890.problemsets.ps01.files;
import java.util.Arrays;

/**
 * CS 6890 Spring 2015, Problem Set 1.
 * 
 * The method getValue is not clear.
 * Refactor it so that its purpose is obvious and the code is clean.
 * 
 * You may change the name of the method and the parameters, but not
 * the return type what the method returns. You may change the main method.
 */
public class B {

	public static double median(double[] list) {
        Arrays.sort(list);

        int mid_idx = list.length / 2;
        double median = list[mid_idx];

        // median of even # of items is the avg of two center items
        if (list.length % 2 == 0)
        {
            median += list[mid_idx - 1];
            median /= 2;
        }
        return median;
	}
	
	public static void main(String[] args) {
		double[] even_values = { 3.4, 5.32, 99, 12.1, 0.23, 68.90 };
        double[] odd_values = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		System.out.println("The even median is: " + median(even_values));
        System.out.println("The odd median is: " + median(odd_values));
	}
}
