import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MinHeapTest {
    @Test
    public void testGetMin() {
        MinHeap<Integer> heap = new MinHeap<>();
        assertNull("Min should be null for an empty heap", heap.getMin());

        heap.insert(5);
        assertEquals("Min should be the inserted element", (Integer) 5, heap.getMin());

        heap.insert(3);
        assertEquals("Min should update to the smallest element", (Integer) 3, heap.getMin());

        heap.insert(7);
        assertEquals("Min should still be the smallest element", (Integer) 3, heap.getMin());
    }

    @Test
    public void testInsert() {
        MinHeap<Integer> heap = new MinHeap<>();
        heap.insert(10);
        assertEquals("Heap size should be 1 after insertion", 1, heap.size());
        assertEquals("Min should be the only element inserted", (Integer) 10, heap.getMin());

        heap.insert(5);
        assertEquals("Heap size should be 2 after second insertion", 2, heap.size());
        assertEquals("Min should update to the smallest element", (Integer) 5, heap.getMin());

        heap.insert(15);
        assertEquals("Heap size should be 3 after third insertion", 3, heap.size());
        assertEquals("Min should still be the smallest element", (Integer) 5, heap.getMin());
    }

    @Test
    public void testRemoveMin() {
        MinHeap<Integer> heap = new MinHeap<>();
        assertNull("Removing min from an empty heap should return null", heap.removeMin());

        heap.insert(5);
        heap.insert(3);
        heap.insert(7);

        assertEquals("Min should be 3 initially", (Integer) 3, heap.removeMin());
        assertEquals("Min should update after removal", (Integer) 5, heap.getMin());
        assertEquals("Heap size should decrease after removal", 2, heap.size());

        assertEquals("Min should be 5 now", (Integer) 5, heap.removeMin());
        assertEquals("Heap size should decrease again", 1, heap.size());

        assertEquals("Min should be 7 now", (Integer) 7, heap.removeMin());
        assertEquals("Heap should be empty after removing last element", 0, heap.size());
        assertNull("Removing from an empty heap should return null", heap.removeMin());
    }

    @Test
    public void testSize() {
        MinHeap<Integer> heap = new MinHeap<>();
        assertEquals("Initial heap size should be 0", 0, heap.size());

        heap.insert(10);
        assertEquals("Heap size should be 1 after one insertion", 1, heap.size());

        heap.insert(20);
        assertEquals("Heap size should be 2 after second insertion", 2, heap.size());

        heap.removeMin();
        assertEquals("Heap size should decrease to 1 after one removal", 1, heap.size());

        heap.removeMin();
        assertEquals("Heap size should be 0 after removing all elements", 0, heap.size());
    }
}
