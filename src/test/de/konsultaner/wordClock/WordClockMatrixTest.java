package de.konsultaner.wordClock;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordClockMatrixTest {

    @Test
    public void testMatrix() throws Exception {
        WordClockMatrix matrix = new WordClockMatrix(
            new String[]{
                "ESKISTLRMITTAGSIABENDS",
                "FRÜHAMLFÜNFZEHNZWANZIG",
                "DREIVIERTELTGNACHVORJM",
                "HALBQZWÖLFPZWEINSIEBEN",
                "KDREIRHFÜNFELFNEUNVIER",
                "WACHTZEHNRSBSECHSFMUHR",
                "AFMOLDIWMIRDOPFRLSAKSO"
            }
        );

        int[][] result1 = matrix.getMatrixBySentence("ES IST ABENDS FÜNFZEHN VOR ZWÖLF");
        assertThat("Should return a fitting matrix",result1[0][0],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[0][1],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[0][2],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[0][3],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[0][4],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[0][5],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[0][6],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[0][7],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[0][8],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[0][9],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[0][10],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[0][11],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[0][12],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[0][13],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[0][14],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[0][15],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[0][16],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[0][17],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[0][18],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[0][19],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[0][20],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[0][21],CoreMatchers.equalTo(1));
    
        assertThat("Should return a fitting matrix",result1[1][0],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][1],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][2],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][3],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][4],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][5],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][6],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][7],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[1][8],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[1][9],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[1][10],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[1][11],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[1][12],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[1][13],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[1][14],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[1][15],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][16],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][17],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][18],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][19],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][20],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[1][21],CoreMatchers.equalTo(0));
    }
}