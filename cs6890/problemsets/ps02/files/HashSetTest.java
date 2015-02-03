package cs6890.problemsets.ps02.files;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

/**
 * JUnit tests for Hash and Set.
 *
 * @version Mon, Feb 02, 2015
 */
public class HashSetTest {
    public final int n = 20;

    @Test(expected=NullPointerException.class)
    public void testHashSetNull() {
        HashSet<Integer> h = new HashSet<Integer>(null);
    }

    @Test
    public void testHashSetConstruct() {
        HashSet<Integer> h = new HashSet<Integer>();
    }

    @Test
    public void testAdd() {
        HashSet<Integer> h = new HashSet<Integer>();
        for(int i=0; i < n; i++) {
            assertTrue(h.add(i));
        }
        for(int i=0; i < n; i++) {
            assertFalse(h.add(i));
        }
    }

    @Test
    public void testContains() {
        HashSet<Integer> h = new HashSet<Integer>();
        for(int i=0; i < n; i++) {
            assertFalse(h.contains(i));
            assertTrue(h.add(i));
            assertTrue(h.contains(i));
        }

        for(int i=0; i < n; i++) {
            assertTrue(h.contains(i));
            assertFalse(h.add(i));
            assertTrue(h.contains(i));
        }

        for(int i=0; i < n; i++) {
            assertFalse(h.add(i));
            assertTrue(h.contains(i));
        }
    }

    @Test
    public void testEquals() {
        HashSet<Integer> h  = new HashSet<Integer>();
        HashSet<Integer> h2 = new HashSet<Integer>();

        assertTrue(h.equals(h2));
        assertTrue(h2.equals(h));

        for(int i=0; i < n-1; i++) {
            h.add(i);
            assertFalse(h.equals(h2));
            assertFalse(h2.equals(h));

            h2.add(n-i-1);
            assertFalse(h.equals(h2));
            assertFalse(h2.equals(h));
        }

        h.add(n-1);
        h2.add(0);
        assertTrue(h.equals(h2));
        assertTrue(h2.equals(h));

        h.clear();

        assertFalse(h.equals(h2));
        assertFalse(h2.equals(h));
    }

    @Test
    public void testIsEmpty() {
        HashSet<Integer> h  = new HashSet<Integer>();

        assertTrue(h.isEmpty());

        for(int i=0; i < n; i++) {
            h.add(i);
            assertFalse(h.isEmpty());
        }

        h.remove(0);
        assertFalse(h.isEmpty());

        h.clear();
        assertTrue(h.isEmpty());

        for(int i=0; i < n; i++) {
            h.add(i);
            assertFalse(h.isEmpty());
            h.remove(i);
            assertTrue(h.isEmpty());
        }
    }

    @Test
    public void testRemove() {
        HashSet<Integer> h  = new HashSet<Integer>();

        for(int i=0; i < n; i++) {
            h.add(i);
            assertTrue(h.remove(i));
            assertFalse(h.remove(i));
        }

        for(int i=0; i < n; i++) {
            h.add(i);
        }

        for(int i=0; i < n; i++) {
            assertTrue(h.remove(i));
        }

        for(int i=0; i < n; i++) {
            assertFalse(h.remove(i));
        }
    }

    @Test(expected=NullPointerException.class)
    public void testRemoveAllThrows() {
        HashSet<Integer> h  = new HashSet<Integer>();
        h.removeAll(null);
    }

    @Test
    public void testRemoveAll() {
        List<Integer> data = new ArrayList<Integer>();
        data.add(2);
        data.add(4);
        data.add(6);
        data.add(7);
        data.add(10);
        data.add(14);

        HashSet<Integer> h  = new HashSet<Integer>();

        for(int i=0; i < n; i++) {
            h.add(i);
        }

        assertTrue(h.removeAll(data));

        for(int i=0; i < n; i++) {
            assertTrue(h.contains(i) != data.contains(i));
        }

    }

    @Test(expected=NullPointerException.class)
    public void testRetainAllThrows() {
        HashSet<Integer> h  = new HashSet<Integer>();
        h.retainAll(null);
    }

    @Test
    public void testRetainAll() {
        List<Integer> data = new ArrayList<Integer>();
        data.add(2);
        data.add(4);
        data.add(6);
        data.add(7);
        data.add(10);
        data.add(14);

        HashSet<Integer> h  = new HashSet<Integer>();

        for(int i=0; i < n; i++) {
            h.add(i);
        }

        assertTrue(h.retainAll(data));

        for(int i=0; i < n; i++) {
            assertTrue(h.contains(i) == data.contains(i));
        }
    }

    @Test
    public void testSize() {
        HashSet<Integer> h  = new HashSet<Integer>();
        for(int i=0; i < n; i++) {
            assertTrue(h.size() == i);
            h.add(i);
        }

        assertTrue(h.size() == n);
        for(int i=0; i < n; i++) {
            assertTrue(h.size() == n-i);
            h.remove(i);
        }
        assertTrue(h.size() == 0);
    }

    @Test(expected=NullPointerException.class)
    public void testToArrayThrows() {
        HashSet<Integer> h  = new HashSet<Integer>();
        h.toArray(null);
    }

    @Test
    public void testToArray() {
        HashSet<Integer> h  = new HashSet<Integer>();

        for(int i=0; i < n; i++) {
            h.add(i);
        }

        for(int i=0; i < n; i++) {
            Object data[] = h.toArray();
            assertTrue(data.length == n-i);
            List<Object> l = Arrays.asList(data);
            for(int j=0; j < i; j++) {
                assertFalse(l.contains(j));
            }
            for(int j=i; j < n; j++) {
                assertTrue(l.contains(j));
            }
            h.remove(i);
        }
    }
}
