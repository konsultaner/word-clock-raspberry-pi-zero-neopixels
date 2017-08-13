package de.konsultaner.wordClock;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class WordClockTest {
    @Test
    public void testConcatMatrix() throws Exception {
        int[][] matrixA = new int[][]{
            {1,0,1},{0,1,0},{1,0,0}
        };
        int[][] matrixB = new int[][]{
            {1,1,0,0},{0,1,0,0},{1,1,1,1}
        };
        
        int[][]result = WordClock.concatMatrix(matrixA,matrixB);
        assertThat("Should have concatenated correctly",result.length,CoreMatchers.equalTo(3));
        assertThat("Should have concatenated correctly",result[0].length,CoreMatchers.equalTo(4));
        
        assertThat("Should have concatenated correctly",result[0][0],CoreMatchers.equalTo(1));
        assertThat("Should have concatenated correctly",result[0][1],CoreMatchers.equalTo(1));
        assertThat("Should have concatenated correctly",result[0][2],CoreMatchers.equalTo(1));
        assertThat("Should have concatenated correctly",result[0][3],CoreMatchers.equalTo(0));
        
        assertThat("Should have concatenated correctly",result[1][0],CoreMatchers.equalTo(0));
        assertThat("Should have concatenated correctly",result[1][1],CoreMatchers.equalTo(1));
        assertThat("Should have concatenated correctly",result[1][2],CoreMatchers.equalTo(0));
        assertThat("Should have concatenated correctly",result[1][3],CoreMatchers.equalTo(0));
        
        assertThat("Should have concatenated correctly",result[2][0],CoreMatchers.equalTo(1));
        assertThat("Should have concatenated correctly",result[2][1],CoreMatchers.equalTo(1));
        assertThat("Should have concatenated correctly",result[2][2],CoreMatchers.equalTo(1));
        assertThat("Should have concatenated correctly",result[2][3],CoreMatchers.equalTo(1));
    }

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

    @Test
    public void testGetFilteredClockMatrix() throws Exception {
        String[] clockMatrix = new String[]{
            "ESKISTLRMITTAGSIABENDS",
            "FRÜHAMLFÜNFZEHNZWANZIG",
            "DREIVIERTELTGNACHVORJM",
            "HALBQZWÖLFPZWEINSIEBEN",
            "KDREIRHFÜNFELFNEUNVIER",
            "WACHTZEHNRSBSECHSFMUHR",
            "AFMOLDIWMIRDOPFRLSAKSO"
        };
        WordClockMatrix wordClockMatrix = new WordClockMatrix(clockMatrix);
        WordClock wordClock = wordClockMatrix.getWorclockDecorator()
            .addSentence(13,13,0,4,"ES IST MITTAGS EIN UHR")
            .addSentence(13,13,5,9,"ES IST MITTAGS FÜNF NACH EIN UHR")
            .addSentence(13,13,10,14,"ES IST MITTAGS ZEHN NACH EIN UHR")
            .getWordClock();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,13);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        
        String[] filteredMatrix = wordClock.getFilteredClockMatrix(clockMatrix,calendar.getTime());
        for (String row:filteredMatrix) {
            System.out.println(row);
        }
        assertThat(filteredMatrix[0],CoreMatchers.equalTo("ES IST  MITTAGS       "));
        assertThat(filteredMatrix[1],CoreMatchers.equalTo("                      "));
        assertThat(filteredMatrix[2],CoreMatchers.equalTo("                      "));
        assertThat(filteredMatrix[3],CoreMatchers.equalTo("             EIN      "));
        assertThat(filteredMatrix[4],CoreMatchers.equalTo("                      "));
        assertThat(filteredMatrix[5],CoreMatchers.equalTo("                   UHR"));
        assertThat(filteredMatrix[6],CoreMatchers.equalTo("                      "));

        calendar.set(Calendar.MINUTE,7);
        filteredMatrix = wordClock.getFilteredClockMatrix(clockMatrix,calendar.getTime());
        for (String row:filteredMatrix) {
            System.out.println(row);
        }

        assertThat(filteredMatrix[0],CoreMatchers.equalTo("ES IST  MITTAGS       "));
        assertThat(filteredMatrix[1],CoreMatchers.equalTo("       FÜNF           "));
        assertThat(filteredMatrix[2],CoreMatchers.equalTo("             NACH     "));
        assertThat(filteredMatrix[3],CoreMatchers.equalTo("             EIN      "));
        assertThat(filteredMatrix[4],CoreMatchers.equalTo("                      "));
        assertThat(filteredMatrix[5],CoreMatchers.equalTo("                   UHR"));
        assertThat(filteredMatrix[6],CoreMatchers.equalTo("                      "));
        
        calendar.set(Calendar.MINUTE,10);
        filteredMatrix = wordClock.getFilteredClockMatrix(clockMatrix,calendar.getTime());
        for (String row:filteredMatrix) {
            System.out.println(row);
        }

        assertThat(filteredMatrix[0],CoreMatchers.equalTo("ES IST  MITTAGS       "));
        assertThat(filteredMatrix[1],CoreMatchers.equalTo("           ZEHN       "));
        assertThat(filteredMatrix[2],CoreMatchers.equalTo("             NACH     "));
        assertThat(filteredMatrix[3],CoreMatchers.equalTo("             EIN      "));
        assertThat(filteredMatrix[4],CoreMatchers.equalTo("                      "));
        assertThat(filteredMatrix[5],CoreMatchers.equalTo("                   UHR"));
        assertThat(filteredMatrix[6],CoreMatchers.equalTo("                      "));
    }
}