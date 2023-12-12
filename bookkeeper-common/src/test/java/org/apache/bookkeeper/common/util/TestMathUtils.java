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
    private expected = 2024;
    private initialValue = 14;

    @Test
    public void test_findNextPositivePowerOfTwo() {
        assertEquals(expected, MathUtils.findNextPositivePowerOfTwo(initialValue), 5e-7);
    }

}
