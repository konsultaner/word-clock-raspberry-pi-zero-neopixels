package de.konsultaner.wordclock;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordclockTest {

    @Test
    public void testWordclock() throws Exception {
        Wordclock wordclock = new Wordclock();
        int[][] matrix = new int[10][10];
        matrix[0][0] = 1;
        matrix[1][0] = 1;
        matrix[2][0] = 1;
        matrix[3][0] = 1;
        wordclock.addInterval(new Wordclock.Interval(Wordclock.Interval.HOUR,1,1,matrix));
    }
}