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
        assertEquals(testLedgerId, entryKeyWithParams.getLedgerId());
        assertEquals(testEntryId, entryKeyWithParams.getEntryId());
    }

    @Test
    public void TestGetLedgerId() {
        assertEquals(0, entryKeyWithoutParams.getLedgerId());
        assertEquals(testLedgerId, entryKeyWithParams.getLedgerId());
    }

    @Test
    public void TestGetEntryId() {
        assertEquals(0, entryKeyWithoutParams.getEntryId());
        assertEquals(testEntryId, entryKeyWithParams.getEntryId());
    }

    @Test
    public void TestEquals() {
        Integer a = Integer.valueOf(130197);
        assertFalse(entryKeyWithParams.equals(a));
        
        assertTrue(entryKeyWithParams.equals(new EntryKey(testLedgerId, testEntryId)));
        assertFalse(entryKeyWithParams.equals(new EntryKey(testLedgerId, testEntryId+1)));
        assertFalse(entryKeyWithParams.equals(new EntryKey(testLedgerId+1, testEntryId)));
        assertFalse(entryKeyWithParams.equals(entryKeyWithoutParams));
    }

    @Test
    public void TestHashCode() {
        assertEquals(0, entryKeyWithoutParams.hashCode());
        assertEquals((int)((13 * testLedgerId) ^ (17 * testEntryId)), entryKeyWithParams.hashCode());
    }

    @Test
    public void TestKeyComparatorCompare() {
        KeyComparator comparator = new KeyComparator();

        assertEquals(0, comparator.compare(entryKeyWithParams, entryKeyWithParams));
        assertEquals(-1, comparator.compare(entryKeyWithoutParams, entryKeyWithParams));
        assertEquals(1, comparator.compare(entryKeyWithParams, entryKeyWithoutParams));
        assertEquals(-1, comparator.copare(entryKeyWithParams, new EntryKey(testLedgerId, testEntryId + 1)));
        assertEquals(1, comparator.copare(entryKeyWithParams, new EntryKey(testLedgerId, testEntryId - 1)));
    }

}
