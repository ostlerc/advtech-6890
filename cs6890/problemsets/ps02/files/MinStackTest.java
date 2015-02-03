package cs6890.problemsets.ps02.files;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

/**
 * JUnit tests for MinStack.
 * 
 * These simple tests found one bug, which was fixed.
 * Can you confirm that the implementation is 100% correct?
 * 
 * @version Thu, Jan 29, 2015
 */
public class MinStackTest {

	@Test
	public void testConstructor() {
		// nothing special here since the constructor does not do much...
		MinStack stack = new MinStack();
		assertNotNull(stack);
	}

	@Test
	public void testPushAndPop() {
		// add some numbers and pop them; they should come out in reverse order
		MinStack stack = new MinStack();
		stack.push(0);
		stack.push(0);
		stack.push(7);
		stack.push(5);
		assertEquals(5, stack.pop());
		assertEquals(7, stack.pop());
		assertEquals(0, stack.pop());
		assertEquals(0, stack.pop());
	}
	
	@Test
	public void testPopFromEmptyStack() {
		// expecting exception when popping from empty stack
		MinStack stack = new MinStack();
		try {
			stack.pop();
			fail("Expected EmptyStackException.");
		} catch (EmptyStackException e) {
			assertTrue("EmptyStackException", true);
		}
	}
	
	@Test
	public void testGetMin() {
		// make sure the minimum is correct...
		MinStack stack = new MinStack();

		stack.push(7);
		assertEquals(7, stack.getMin());
		stack.push(2);
		assertEquals(2, stack.getMin());
		stack.push(17);
		assertEquals(2, stack.getMin());
		stack.push(2);
		assertEquals(2, stack.getMin());

		int e = stack.pop();
		assertEquals(2, e);
		assertEquals(2, stack.getMin());
		e = stack.pop();
		assertEquals(17, e);
		assertEquals(2, stack.getMin());
		e = stack.pop();
		assertEquals(2, e);
		assertEquals(7, stack.getMin());
 	}

	@Test
	public void testGetMinFromEmptyStack() {
		// expecting exception when getting minimum from empty stack
		MinStack stack = new MinStack();
		try {
			stack.getMin();
			fail("Expected EmptyStackException.");
		} catch (EmptyStackException e) {
			assertTrue("EmptyStackException", true);
		}
	}
	
}
