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
    private int expected = 2024;
    private int initialValue = 1997;

    @Test
    public void testFindNextPositivePowerOfTwo() {
        assertEquals(expected, MathUtils.findNextPositivePowerOfTwo(initialValue));
    }

}