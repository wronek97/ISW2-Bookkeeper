package org.apache.bookkeeper.bookie;

import org.apache.bookkeeper.bookie.EntryKey;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

public class TestEntryKey {
    private long testLedgerId = 123;
    private long testEntryId = 456;
    private EntryKey entryKeyWithoutParams = new EntryKey();
    private EntryKey entryKeyWithParams = new EntryKey(testLedgerId, testEntryId);

    @Test
    public void testConstructorWithoutParams() {
        assertNotNull(entryKeyWithoutParams);
        assertEquals(0, entryKeyWithoutParams.getLedgerId());
        assertEquals(0, entryKeyWithoutParams.getEntryId());
    }

    @Test
    public void testConstructorWithParams() {
        assertNotNull(entryKeyWithParams);
        assertEquals(123, entryKeyWithParams.getLedgerId());
        assertEquals(456, entryKeyWithParams.getEntryId());
    }

    @Test
    public void TestGetLedgerId() {
        assertEquals(0, entryKeyWithoutParams.getLedgerId());
        assertEquals(123, entryKeyWithParams.getLedgerId());
    }

    @Test
    public void TestGetEntryId() {
        assertEquals(0, entryKeyWithoutParams.getEntryId());
        assertEquals(456, entryKeyWithParams.getEntryId());
    }

    @Test
    public void TestEquals() {
        Integer a = Integer.valueOf(66);
        assertFalse(entryKeyWithParams.equals(a));
        assertFalse(entryKeyWithParams.equals(entryKeyWithoutParams));
        assertTrue(entryKeyWithParams.equals(new EntryKey(testLedgerId, testEntryId)));
    }

    @Test
    public void TestHashCode() {
        //(ledgerId * 13) ^ (entryId * 17)
        assertEquals(6263, entryKeyWithoutParams.hashCode());
    }

}
