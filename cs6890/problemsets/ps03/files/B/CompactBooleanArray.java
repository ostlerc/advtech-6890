package cs6890.problemsets.ps03.files.B;

/**
 * CS 6890 Spring 2015, Problem Set 3.
 *
 * Usually boolean values use one byte, even if they can be stored
 * using a single bit. Because bytes can be addressed, unlike bits,
 * this is faster than using a single bit for storing a boolean.
 * However, when need a very large number of boolean values,
 * we need to find a way to store them more efficiently.
 *
 * Storing boolean values efficiently can be done using bit arrays:
 * http://en.wikipedia.org/wiki/Bit_array
 *
 * Java provides an implementation in the BitSet class:
 * http://docs.oracle.com/javase/7/docs/api/java/util/BitSet.html
 *
 * For this problem, you should implement a bit array which stores
 * bits using an array of integers.
 *
 * You should implement all the methods in this class, and your
 * implementation should follow the following rules (if you break
 * any of them you get a zero score on this problem):
 *
 * - You are not allowed to add any extra member variables other
 *   than the already existing size and int array
 * - You are not allowed to change the signature of the methods.
 * - You are not allowed to use BitSet or any other class in your
 *   implementation.
 *
 * Your implementation should store n boolean values using
 * n + O(1) bits stored using the int array.
 *
 * Each the method can be implemented using only a few lines.
 * But you have to know how to manipulate bits. If you are not
 * familiar with bitwise operators, you can read about them here:
 * http://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
 *
 * Remember that a int is stored in binary, so you can use each
 * bit on its binary representation to store a boolean value.
 *
 * Since an int uses 32 bits, the first 32 booleans in the array
 * should be stored on the first int of the array, the next 32 bits
 * should be stored on the second int of the array, and so on.
 * Moreover, booleans stored on an int should be indexed starting
 * from the least significant digit.
 *
 * For example, if the value of booleans at index 0 and 4 are set
 * to true (indices are zero based), the binary representation of
 * the first int would be 0...010001, which would correspond to a
 * decimal value of 17.
 *
 * @version Sat, Feb 21, 2015
 */
public class CompactBooleanArray {

    final int INTSIZE = 32;
	private int size;		// number of values that can be stored
	private int[] array;	// array for storing values

	/**
	 * Create a new array.
	 *
	 * Allocates enough memory to store <code>size</code> boolean values.
	 */
	public CompactBooleanArray(int size) throws IllegalArgumentException {
	    if(size < 0)
	        throw new IllegalArgumentException();

	    this.size = size;
	    array = new int[getArraySize()];
	}

	/**
	 * Returns the number of values that can be stored in this array.
	 * That is, the number of bools it can store.
	 */
	public int getSize() {
        return size;
	}

	/**
	 * Returns the size of the underlying integer array.
	 * That is, the number of integers it can store.
	 */
	public int getArraySize() {
	    if(size == 0)
	        return 0;
	    if(size % INTSIZE != 0)
	        return size/INTSIZE + 1;
        return size/INTSIZE;
	}

	/**
	 * Returns the value of the boolean at a specified index.
	 */
	public boolean get(int idx) throws IndexOutOfBoundsException {
        int array_idx = getArrayIndex(idx);
	    int mask = 1 << (idx % INTSIZE);
		return (array[array_idx]&mask) != 0;
	}

	/**
	 * Sets the value of the boolean at a specified index.
	 */
	public void set(int idx, boolean value) throws IndexOutOfBoundsException {
        int array_idx = getArrayIndex(idx);
        int mask = 1 << (idx % INTSIZE);
        if(value) {
            array[array_idx] |= mask;
        } else {
            mask = ~mask;
            array[array_idx] &= mask;
        }
	}

	/**
	 * Negates the value of the boolean at a specified index.
	 */
	public void negate(int idx) throws IndexOutOfBoundsException {
        int array_idx = getArrayIndex(idx);
        int mask = 1 << (idx % INTSIZE);
        array[array_idx] ^= mask;
	}

	/**
	 * Returns the underlying integer array.
	 */
	public int[] getArray() {
		return array;
	}

	/**
	 * Returns the index for the bit at index idx
	 */
	private int getArrayIndex(int idx) throws IndexOutOfBoundsException {
        int array_idx = idx / INTSIZE;
        if(idx < 0 || idx >= size || array_idx < 0 || array_idx >= getArraySize())
            throw new IndexOutOfBoundsException();
        return array_idx;
    }
}
