package cs6890.problemsets.ps02.files;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Stack with standard push and pop operations,
 * and with an extra operation to read the minimum
 * element in the stack.
 * 
 * All three operations run in O(1) time in this
 * implementation.
 * 
 * For simplicity, this stack only stores integers.
 * 
 * @version Thu, Jan 29, 2015
 */
public class MinStack {

	private Stack<Integer> stack;		// actual values
	private Stack<Integer> minStack;	// min values
	
	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	/**
	 * Adds an element to the top of the stack.
	 */
	public void push(int e) {
		if (stack.isEmpty())
			minStack.add(e);
		else if (e <= getMin())
			minStack.push(e);
		stack.add(e);
	}
	
	/**
	 * Removed element from the top of the stack, and returns it.
	 * 
	 * @throws EmptyStackException if the stack is empty.
	 */
	public int pop() throws EmptyStackException {
		int e = stack.pop();
		if (e == getMin())
			minStack.pop();
		return e;
	}
	
	/**
	 * Returns, but does not remove, the minimum element in the stack.
	 * 
	 * @throws EmptyStackException if the stack is empty.
	 */
	public int getMin() throws EmptyStackException {
		return minStack.peek();
	}
}
