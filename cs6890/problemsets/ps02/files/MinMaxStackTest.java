package cs6890.problemsets.ps02.files;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

/**
 * JUnit tests for MinMaxStack.
 * 
 * These simple tests found one bug, which was fixed.
 * Can you confirm that the implementation is 100% correct?
 * 
 * @version Thu, Jan 29, 2015
 */
public class MinMaxStackTest {

    @Test
    public void testConstructor() {
        // nothing special here since the constructor does not do much...
        MinMaxStack stack = new MinMaxStack(1);
        assertNotNull(stack);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIllegalConstructorSize() {
        MinMaxStack stack = new MinMaxStack(0);
    }

    @Test
    public void testPushAndPop() {
        // add some numbers and pop them; they should come out in reverse order
        MinMaxStack stack = new MinMaxStack(5);
        stack.push(0);
        stack.push(0);
        stack.push(7);
        stack.push(5);
        assertEquals(5, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(0, stack.pop());
        assertEquals(0, stack.pop());
    }
    
    @Test(expected=IllegalStateException.class)
    public void testPushFullStack() {
        // expecting exception when popping from empty stack
        MinMaxStack stack = new MinMaxStack(1);
        stack.push(10);
        stack.push(30);
    }

    @Test(expected=EmptyStackException .class)
    public void testPopFromEmptyStack() {
        // expecting exception when popping from empty stack
        MinMaxStack stack = new MinMaxStack(1);
        stack.push(10);
        stack.pop();
        stack.pop();
    }

    @Test
    public void testGetMin() {
        int data[] = new int[] { 7, 7, 17, 3, 5, 1, 0, 1, -1, 2 };
        int mins[] = new int[] { 7, 7, 7, 3, 3, 1, 0, 0, -1, -1 };

        // make sure the minimum is correct...
        MinMaxStack stack = new MinMaxStack(data.length);

        for(int i = 0; i < data.length; i++)
        {
            stack.push(data[i]);
            assertEquals(mins[i], stack.getMin());
        }

        for(int i = data.length-1; i >= 0; i--)
        {
            assertEquals(stack.getMin(), mins[i]);

            int e = stack.pop();
            assertEquals(e, data[i]);
        }
    }

    @Test(expected=EmptyStackException .class)
    public void testGetMinFromEmptyStack() {
        MinMaxStack stack = new MinMaxStack(10);
        stack.getMin();
    }

    @Test
    public void testGetMax() {
        int data[] = new int[] { 7, 7, 17, 3, 50, 1, 50, 250 };
        int maxs[] = new int[] { 7, 7, 17, 17, 50, 50, 50, 250 };

        // make sure the minimum is correct...
        MinMaxStack stack = new MinMaxStack(data.length);

        for(int i = 0; i < data.length; i++)
        {
            stack.push(data[i]);
            assertEquals(maxs[i], stack.getMax());
        }

        for(int i = data.length-1; i >= 0; i--)
        {
            assertEquals(stack.getMax(), maxs[i]);

            int e = stack.pop();
            assertEquals(e, data[i]);
        }
    }

    @Test(expected=EmptyStackException .class)
        public void testGetMaxFromEmptyStack() {
            MinMaxStack stack = new MinMaxStack(10);
            stack.getMax();
        }
}
