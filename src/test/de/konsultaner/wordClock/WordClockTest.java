package de.konsultaner.wordClock;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class WordClockTest {

    @Test
    public void testGetIntervalsByDate() throws Exception {
        WordClock wordClock = new WordClock();
        int[][] matrix1 = new int[10][10];
        matrix1[0][0] = 1;
        matrix1[1][0] = 1;
        matrix1[2][0] = 1;
        matrix1[3][0] = 1;
        wordClock.addInterval(new WordClock.Interval(1,1, 0, 59, matrix1));
        
        int[][] matrix2 = new int[10][10];
        matrix2[0][0] = 1;
        matrix2[1][3] = 1;
        matrix2[2][3] = 1;
        matrix2[3][3] = 1;
        wordClock.addInterval(new WordClock.Interval(9,18, 0, 59, matrix2));
        
        int[][] matrix3 = new int[10][10];
        matrix3[0][9] = 1;
        matrix3[9][1] = 1;
        matrix3[8][1] = 1;
        matrix3[7][1] = 1;
        wordClock.addInterval(new WordClock.Interval(1,1, 0, 15, matrix3));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,1);
        calendar.set(Calendar.MINUTE,0);
        List<WordClock.Interval> intervals = wordClock.getIntervalsByDate(calendar.getTime());
        
        assertThat("Should find 1 and 3",intervals.size(), CoreMatchers.equalTo(2));
        assertThat("Should find 1 and 3",intervals.get(0).matrix, CoreMatchers.equalTo(matrix1));
        assertThat("Should find 1 and 3",intervals.get(1).matrix, CoreMatchers.equalTo(matrix3));

        calendar.set(Calendar.MINUTE,15);
        intervals = wordClock.getIntervalsByDate(calendar.getTime());

        assertThat("Should find 1 and 3",intervals.size(), CoreMatchers.equalTo(2));
        assertThat("Should find 1 and 3",intervals.get(0).matrix, CoreMatchers.equalTo(matrix1));
        assertThat("Should find 1 and 3",intervals.get(1).matrix, CoreMatchers.equalTo(matrix3));
        
        calendar.set(Calendar.MINUTE,16);
        intervals = wordClock.getIntervalsByDate(calendar.getTime());

        assertThat("Should find 1",intervals.size(), CoreMatchers.equalTo(1));
        assertThat("Should find 1",intervals.get(0).matrix, CoreMatchers.equalTo(matrix1));
        
        calendar.set(Calendar.HOUR_OF_DAY,8);
        intervals = wordClock.getIntervalsByDate(calendar.getTime());

        assertThat("Should find nothing",intervals.size(), CoreMatchers.equalTo(0));
        
        calendar.set(Calendar.HOUR_OF_DAY,9);
        intervals = wordClock.getIntervalsByDate(calendar.getTime());

        assertThat("Should find 2",intervals.size(), CoreMatchers.equalTo(1));
        assertThat("Should find 2",intervals.get(0).matrix, CoreMatchers.equalTo(matrix2));

        calendar.set(Calendar.HOUR_OF_DAY,18);
        calendar.set(Calendar.MINUTE,59);
        intervals = wordClock.getIntervalsByDate(calendar.getTime());

        assertThat("Should find 2",intervals.size(), CoreMatchers.equalTo(1));
        assertThat("Should find 2",intervals.get(0).matrix, CoreMatchers.equalTo(matrix2));

        calendar.set(Calendar.HOUR_OF_DAY,19);
        calendar.set(Calendar.MINUTE,0);
        intervals = wordClock.getIntervalsByDate(calendar.getTime());

        assertThat("Should find nothing",intervals.size(), CoreMatchers.equalTo(0));
    }

    @Test
    public void testGetMatrixByDate() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,1);
        calendar.set(Calendar.MINUTE,0);
        
        WordClock wordClock = new WordClock();
        int[][] matrix1 = new int[4][1];
        matrix1[0][0] = 1;
        matrix1[1][0] = 1;
        matrix1[2][0] = 1;
        matrix1[3][0] = 1;
        wordClock.addInterval(new WordClock.Interval(1,1, 0, 59, matrix1));
        
        int[][] matrix = wordClock.getMatrixByDate(calendar.getTime());
        
        assertThat("Should have a 4x1 matrix equal to matrix 1",matrix.length,CoreMatchers.equalTo(4));
        assertThat("Should have a 4x1 matrix equal to matrix 1",matrix[0].length,CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[0][0],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[1][0],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[2][0],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[3][0],CoreMatchers.equalTo(1));

        int[][] matrix2 = new int[4][4];
        matrix2[0][0] = 0;
        matrix2[1][3] = 1;
        matrix2[2][3] = 1;
        matrix2[3][3] = 1;
        wordClock.addInterval(new WordClock.Interval(1,1, 0, 59, matrix2));

        matrix = wordClock.getMatrixByDate(calendar.getTime());

        assertThat("Should have a 4x4 matrix equal to matrix 2",matrix.length,CoreMatchers.equalTo(4));
        assertThat("Should have a 4x4 matrix equal to matrix 2",matrix[0].length,CoreMatchers.equalTo(4));
        assertThat("Should have the correct copied values",matrix[0][0],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[1][0],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[2][0],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[3][0],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[1][3],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[2][3],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[3][3],CoreMatchers.equalTo(1));


        int[][] matrix3 = new int[5][4];
        matrix3[4][0] = 1;
        wordClock.addInterval(new WordClock.Interval(1,1, 0, 59, matrix3));

        matrix = wordClock.getMatrixByDate(calendar.getTime());

        assertThat("Should have a 4x4 matrix equal to matrix 2",matrix.length,CoreMatchers.equalTo(5));
        assertThat("Should have a 4x4 matrix equal to matrix 2",matrix[0].length,CoreMatchers.equalTo(4));
        assertThat("Should have the correct copied values",matrix[0][0],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[1][0],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[2][0],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[3][0],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[1][3],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[2][3],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[3][3],CoreMatchers.equalTo(1));
        assertThat("Should have the correct copied values",matrix[4][0],CoreMatchers.equalTo(1));
    }
}