package edu.cmu.cs.cs214.rec02;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Unit tests for IntQueue implementations.
 * 
 * This test class checks both LinkedIntQueue and ArrayIntQueue implementations.
 * It aims to achieve high coverage using different testing techniques.
 */
public class IntQueueTest {

    private IntQueue mQueue;
    private List<Integer> testList;

    /**
     * Called before each test.
     */
    @Before
    public void setUp() {
        mQueue = new ArrayIntQueue(); 

        testList = new ArrayList<>(List.of(1, 2, 3));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testNotEmpty() {
        mQueue.enqueue(1);
        assertFalse(mQueue.isEmpty());
    }

    @Test
    public void testPeekEmptyQueue() {
        assertNull(mQueue.peek());
    }

    @Test
    public void testPeekNoEmptyQueue() {
        mQueue.enqueue(5);
        assertEquals((Integer) 5, mQueue.peek());
    }

    @Test
    public void testEnqueue() {
        for (int i = 0; i < testList.size(); i++) {
            mQueue.enqueue(testList.get(i));
            assertEquals(testList.get(0), mQueue.peek());
            assertEquals(i + 1, mQueue.size());
        }
    }

    @Test
    public void testDequeue() {
        mQueue.enqueue(10);
        mQueue.enqueue(20);
        assertEquals((Integer) 10, mQueue.dequeue());
        assertEquals((Integer) 20, mQueue.dequeue());
        assertTrue(mQueue.isEmpty());

        assertNull(mQueue.dequeue());
    }

    @Test
    public void testEnsureCapacity() {
        for (int i = 0; i < 20; i++) {
            mQueue.enqueue(i);
        }
        assertEquals(20, mQueue.size());
    }

    @Test
    public void testClear() {
        mQueue.enqueue(1);
        mQueue.enqueue(2);
        mQueue.clear();
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testContent() {
    List<Integer> correctResult = List.of(10, 20, 30, 40, 50);

    for (int num : correctResult) {
        mQueue.enqueue(num);
    }

    for (int expected : correctResult) {
        assertEquals(expected, (int) mQueue.dequeue());
    }
}

}
