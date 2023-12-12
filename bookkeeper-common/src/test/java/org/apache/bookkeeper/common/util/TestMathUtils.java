package org.apache.bookkeeper.common.util;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

public class TestMathUtils {
    private long startNanoTime = System.nanoTime();
    
    @Test
    public void testSignSafeMod() {
        final int testsNum = 8;
        int dividend[] = new int[] {45, -45, 43, -43, 7, -7, 4, -4};
        int divisor[] = new int[] {13, 13, -13, -13, 13, 13, -13, -13};
        int expected[] = new int[] {6, 7, 4, 9, 7, 6, 4, 9};

        assertTrue(dividend.length == testsNum);
        assertTrue(divisor.length == testsNum);
        assertTrue(expected.length == testsNum);

        for(int i = 0; i < testsNum; i++){
            assertEquals(expected[i], MathUtils.signSafeMod(dividend[i], divisor[i]));
        }
    }

    @Test
    public void testFindNextPositivePowerOfTwo() {
        int initialValue = 1997;
        int expected = 2048;
        
        assertEquals(expected, MathUtils.findNextPositivePowerOfTwo(initialValue));
    }

    @Test
    public void testNowInNano() {
        assertTrue(MathUtils.nowInNano() >= startNanoTime);
    }

    @Test
    public void testElapsedNanos() {
        long elapsedNanoTime = System.nanoTime() - startNanoTime;

        assertTrue(MathUtils.elapsedNanos(startNanoTime) >= elapsedNanoTime);
    }

    @Test
    public void testElapsedMicroSec() {
        long elapsedNanoTime = System.nanoTime() - startNanoTime;

        assertTrue(MathUtils.elapsedMicroSec(startNanoTime) >= TimeUnit.NANOSECONDS.toMicros(elapsedNanoTime));
    }

    @Test
    public void testElapsedMSec() {
        long elapsedNanoTime = System.nanoTime() - startNanoTime;
 
        assertTrue(MathUtils.elapsedMSec(startNanoTime) >= TimeUnit.NANOSECONDS.toMillis(elapsedNanoTime));
    }

}