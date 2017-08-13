package de.konsultaner.wordClock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class WordClock {
    private final List<Interval> intervals = new ArrayList<>();
    public boolean addInterval(Interval interval){
        return this.intervals.add(interval);
    }

    public List<Interval> getIntervalsByDate(Date date){
        List<Interval> resultIntervals = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if(interval.fromHour <= hour && hour <= interval.toHour && interval.fromMinute <= minute && minute <= interval.toMinute){
                resultIntervals.add(interval);
            }
        }
        return resultIntervals;
    }
    
    public int[][] getMatrixByDate(Date date){
        int[][] resultMatrix = new int[0][0];
        List<Interval> intervals = getIntervalsByDate(date);
        for (int i = 0; i < intervals.size(); i++) {
            int[][] currentMatrix = intervals.get(i).matrix;
            if(resultMatrix.length < currentMatrix.length){
                int[][] enlargedResult = new int[currentMatrix.length][resultMatrix.length>0?resultMatrix[0].length:0];
                java.lang.System.arraycopy(resultMatrix,0,enlargedResult,0,resultMatrix.length);
                resultMatrix = enlargedResult;
            }
            for (int j = 0; j < currentMatrix.length; j++) {
                if(resultMatrix[j].length < currentMatrix[j].length){
                    int[] enlargedResult = new int[currentMatrix[j].length];
                    java.lang.System.arraycopy(resultMatrix[j],0,enlargedResult,0,resultMatrix[j].length);
                    resultMatrix[j] = enlargedResult;
                }
                for (int k = 0; k < currentMatrix[j].length; k++) {
                    resultMatrix[j][k] |=  currentMatrix[j][k];
                }
            }
        }
        return resultMatrix;
    }
    
    public static int[][] concatMatrix(int[][] matrixA, int[][] matrixB){
        int[][] resultMatrix = new int[Math.max(matrixA.length,matrixB.length)][Math.max(matrixA.length>0?matrixA[0].length:0,matrixB.length>0?matrixB[0].length:0)];
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                resultMatrix[i][j] = (matrixA.length > i&&matrixA[i].length>j?matrixA[i][j]:0) | (matrixB.length > i&&matrixB[i].length>j?matrixB[i][j]:0);
            }
        }
        return resultMatrix;
    }
    
    public String[] getFilteredClockMatrix(String[] clockMatrix, Date date){
        String[] filteredClockMatrix = new String[clockMatrix.length];
        int[][] binaryMatrix = this.getMatrixByDate(date);
        for (int i = 0; i < binaryMatrix.length; i++) {
            for (int j = 0; j < binaryMatrix[i].length && i < clockMatrix[i].length(); j++) {
                if(filteredClockMatrix[i] == null) filteredClockMatrix[i] = "";
                filteredClockMatrix[i] += binaryMatrix[i][j] == 0?" ":clockMatrix[i].charAt(j);
            }
        }
        return filteredClockMatrix;
    }
    
    public static class Interval{
        public static final int HOUR = Calendar.HOUR_OF_DAY;
        public static final int MINUTE = Calendar.MINUTE;
        
        final int fromHour;
        final int toHour;
        final int fromMinute;
        final int toMinute;
        final int[][] matrix;

        public Interval(int fromHour, int toHour, int fromMinute, int toMinute, int[][] matrix) {
            this.fromHour = fromHour;
            this.toHour = toHour;
            this.fromMinute = fromMinute;
            this.toMinute = toMinute;
            this.matrix = matrix;
        }      
    }
    
}
