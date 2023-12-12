package org.apache.bookkeeper.common.util;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

public class TestMathUtils {
    private long startNanoTime = System.nanoTime();
    
    @Test
    public void testSignSafeMod() {
        final int length = 8;
        int dividend[] = new int[] {45, -45, 43, -43, 7, -7, 4, -4};
        int divisor[] = new int[] {13, 13, -13, -13, 13, 13, -13, -13};
        int expected[] = new int[] {6, 7, 4, 9, 7, 6, 4, 9};

        assertTrue(dividend.length = length);
        assertTrue(divisor.length = length);
        assertTrue(expected.length = length);

        for(int i = 0; i < length; i++){
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
        assertTrue(nowInNano() >= startNanoTime);
    }

    @Test
    public void testElapsedNanos() {
        int elapsedNanoTime = System.nanoTime() - startNanoTime;

        assertTrue(MathUtils.elapsedNanos(startNanoTime) >= elapsedNanoTime);
    }

    @Test
    public void testElapsedMicroSec() {
        int elapsedNanoTime = System.nanoTime() - startNanoTime;

        assertTrue(MathUtils.elapsedMicroSec(startNanoTime) >= TimeUnit.NANOSECONDS.toMicros(elapsedNanoTime));
    }

    @Test
    public void testElapsedMSec() {
        int elapsedNanoTime = System.nanoTime() - startNanoTime;

        assertTrue(MathUtils.elapsedMsec(startNanoTime) >= TimeUnit.NANOSECONDS.toMillis(elapsedNanoTime));
    }

}