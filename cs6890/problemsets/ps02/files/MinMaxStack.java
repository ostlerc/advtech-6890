package cs6890.problemsets.ps02.files;

import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.function.BiPredicate;

/**
 * Stack with standard push and pop operations,
 * and with an extra operation to read the minimum
 * and maximum elements in the stack.
 *
 * All three operations run in O(1) time in this
 * implementation.
 *
 * For simplicity, this stack only stores integers.
 *
 * @version Mon, Feb 02, 2015
 */
public class MinMaxStack {

    /**
     * Stack that conditionally pushes onto the stack.
     *
     * Helper class to maintain min and max stacks
     *
     * @version Mon, Feb 02, 2015
     */
    private class ConditionalStack {
        public Integer[] list;
        public int count;
        public BiPredicate<Integer, Integer> pushPred;

        public ConditionalStack(int max, BiPredicate<Integer, Integer> pred) {
            list = new Integer[max];
            pushPred = pred;
            count = 0;
        }

        /**
         * Adds an element to the top of the stack if predicate allows.
         */
        public void push(int e) throws IllegalStateException {
            if(count == list.length)
                throw new IllegalStateException();

            if(count == 0 || pushPred.test(e, peek()))
                list[count++] = e;
        }

        /**
         * Removed element from the top of the stack, and returns it.
         *
         * @throws EmptyStackException if the stack is empty.
         */
        public int pop() throws EmptyStackException {
            if(count == 0)
                throw new EmptyStackException();

            return list[--count];
        }

        /**
         * Returns, but does not remove, the top element in the stack.
         *
         * @throws EmptyStackException if the stack is empty.
         */
        public int peek() throws EmptyStackException {
            if(count == 0)
                throw new EmptyStackException();

            return list[count-1];
        }
    }

    private ConditionalStack stack;
    private ConditionalStack minStack;
    private ConditionalStack maxStack;

    public MinMaxStack(int maxSize) {
        if(maxSize < 1)
            throw new IllegalArgumentException();

        stack     = new ConditionalStack(maxSize, (Integer v, Integer top)-> true);
        minStack  = new ConditionalStack(maxSize, (Integer v, Integer top)-> top >= v);
        maxStack  = new ConditionalStack(maxSize, (Integer v, Integer top)-> top <= v);
    }

    /**
     * Adds an element to the top of the stack.
     */
    public void push(int e) throws IllegalStateException {
        stack.push(e);
        minStack.push(e);
        maxStack.push(e);
    }

    /**
     * Removed element from the top of the stack, and returns it.
     *
     * @throws EmptyStackException if the stack is empty.
     */
    public int pop() throws EmptyStackException {
        int e = stack.pop();
        if (e == minStack.peek())
            minStack.pop();
        if (e == maxStack.peek())
            maxStack.pop();
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

    /**
     * Returns, but does not remove, the maximum element in the stack.
     *
     * @throws EmptyStackException if the stack is empty.
     */
    public int getMax() throws EmptyStackException {
        return maxStack.peek();
    }
}
