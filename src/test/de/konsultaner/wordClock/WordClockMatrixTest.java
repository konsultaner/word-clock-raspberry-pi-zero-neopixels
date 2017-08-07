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
        
        assertThat("Should return a fitting matrix",result1[2][0],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][1],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][2],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][3],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][4],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][5],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][6],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][7],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][8],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][9],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][10],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][11],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][12],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][13],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][14],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][15],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][16],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][17],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[2][18],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[2][19],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[2][20],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[2][21],CoreMatchers.equalTo(0));
        
        assertThat("Should return a fitting matrix",result1[3][0],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][1],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][2],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][3],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][4],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][5],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[3][6],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[3][7],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[3][8],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[3][9],CoreMatchers.equalTo(1));
        assertThat("Should return a fitting matrix",result1[3][10],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][11],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][12],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][13],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][14],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][15],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][16],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][17],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][18],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][19],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][20],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[3][21],CoreMatchers.equalTo(0));
        
        assertThat("Should return a fitting matrix",result1[4][0],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][1],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][2],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][3],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][4],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][5],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][6],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][7],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][8],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][9],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][10],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][11],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][12],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][13],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][14],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][15],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][16],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][17],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][18],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][19],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][20],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[4][21],CoreMatchers.equalTo(0));
        
        assertThat("Should return a fitting matrix",result1[5][0],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][1],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][2],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][3],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][4],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][5],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][6],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][7],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][8],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][9],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][10],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][11],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][12],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][13],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][14],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][15],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][16],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][17],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][18],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][19],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][20],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[5][21],CoreMatchers.equalTo(0));
        
        assertThat("Should return a fitting matrix",result1[6][0],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][1],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][2],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][3],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][4],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][5],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][6],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][7],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][8],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][9],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][10],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][11],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][12],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][13],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][14],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][15],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][16],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][17],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][18],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][19],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][20],CoreMatchers.equalTo(0));
        assertThat("Should return a fitting matrix",result1[6][21],CoreMatchers.equalTo(0));
    }
}