package org.apache.bookkeeper.bookie;

import org.apache.bookkeeper.bookie.EntryKey;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

public class TestLogMark {
    private long testLogFileId = 123;
    private long testLogFileOffset = 456;

    @Test
    public void testDefaultConstructor() {
        LogMark lm = new LogMark();

        assertNotNull(lm);
        assertEquals(0, lm.getLogFileId());
        assertEquals(0, lm.getLogFileOffset());
    }

    @Test
    public void testConstructorWithParams() {
        LogMark lm = new LogMark(testLogFileId, testLogFileOffset);

        assertNotNull(lm);
        assertEquals(testLogFileId, lm.getLogFileId());
        assertEquals(testLogFileOffset, lm.getLogFileOffset());
    }

    @Test
    public void testConstructorWithObject() {
        long logFileId = testLogFileId + 10;
        long logFileOffset = testLogFileOffset - 10;
        LogMark lm = new LogMark(new LogMark(logFileId, logFileOffset));

        assertNotNull(lm);
        assertEquals(logFileId, lm.getLogFileId());
        assertEquals(logFileOffset, lm.getLogFileOffset());
    }

    @Test
    public void testGetLogFileId() {
        LogMark lm1 = new LogMark();
        LogMark lm2 = new LogMark(testLogFileId, testLogFileOffset);

        assertEquals(0, lm1.getLogFileId());
        assertEquals(testLogFileId, lm2.getLogFileId());
    }

    @Test
    public void testGetLogFileOffset() {
        LogMark lm1 = new LogMark();
        LogMark lm2 = new LogMark(testLogFileId, testLogFileOffset);

        assertEquals(0, lm1.getLogFileOffset());
        assertEquals(testLogFileOffset, lm2.getLogFileOffset());
    }

    @Test
    public void testReadAndWriteLogMark() {
        LogMark lm1 = new LogMark();
        LogMark lm2 = new LogMark(testLogFileId, testLogFileOffset);
        ByteBuffer bb = new ByteBuffer();

        // lm2 writes its values in the buffer
        lm2.writeLogMark(bb);

        // lm1 writes its values in the buffer
        lm1.writeLogMark(bb);

        // lm1 reads lm2's values from the buffer and sets its values
        lm1.readLogMark(bb);

        // It's expected that now, lm1's values are equals to lm2's values
        assertEquals(lm2.getLogFileId(), lm1.getLogFileId());
        assertEquals(lm2.getLogFileOffset(), lm1.getLogFileOffset());

        // lm1 reads its old values from the buffer and sets its values
        lm1.readLogMark(bb);

        // It's expected that now, lm1's values are equals to 0
        assertEquals(0, lm1.getLogFileId());
        assertEquals(0, lm1.getLogFileOffset());
    }

    @Test
    public void testSetLogMark() {
        LogMark lm = new LogMark();

        // Check if lm's values are equals to 0
        assertEquals(0, lm.getLogFileId());
        assertEquals(0, lm.getLogFileOffset());

        // Then set its values to something
        lm.setLogMark(testLogFileId, testLogFileOffset);

        // Check if now, lm's values are equals to those
        assertEquals(testLogFileId, lm.getLogFileId());
        assertEquals(testLogFileOffset, lm.getLogFileOffset());
    }

    @Test
    public void testCompare() {
        LogMark lm = new LogMark(testLogFileId, testLogFileOffset);

        assertEquals(0, lm.compare(new LogMark(lm)));
        assertEquals(-1, lm.compare(new LogMark(testLogFileId, testLogFileOffset + 1)));
        assertEquals(1, lm.compare(new LogMark(testLogFileId, testLogFileOffset - 1)));

        assertEquals(-1, lm.compare(new LogMark(testLogFileId + 1, testLogFileOffset - 10)));
        assertEquals(1, lm.compare(new LogMark(testLogFileId - 1, testLogFileOffset - 10)));
    }

    @Test
    public void testToString() {
        LogMark lm = new LogMark(testLogFileId, testLogFileOffset);
        String expectedString = "LogMark: logFileId - " + testLogFileId + " , logFileOffset - " + testLogFileOffset;

        assertEquals(expectedString, lm.toString(), lm.toString());
    }
}
