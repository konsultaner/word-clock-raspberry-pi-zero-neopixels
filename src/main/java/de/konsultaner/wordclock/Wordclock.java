package de.konsultaner.wordclock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Wordclock {
    private final List<Interval> intervals = new ArrayList<>();
    public boolean addInterval(Interval interval){
        return this.intervals.add(interval);
    }

    public List<Interval> getByDate(Date date){
        List<Interval> resultIntervals = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if(interval.type == Interval.HOUR){
                if(interval.from >= hour && hour <= interval.to){
                    resultIntervals.add(interval);
                }
            }
            if(interval.type == Interval.MINUTE){
                if(interval.from >= minute && minute <= interval.to){
                    resultIntervals.add(interval);
                }
            }
        }
        return resultIntervals;
    }
    
    public int[][] getMatrixByDate(Date date){
        int[][] resultMatrix = new int[0][0];
        List<Interval> intervals = getByDate(date);
        for (int i = 0; i < intervals.size(); i++) {
            int[][] currentMatrix = intervals.get(i).matrix;
            if(resultMatrix.length < currentMatrix.length){
                int[][] enlargedResult = new int[currentMatrix.length][resultMatrix.length>0?resultMatrix[0].length:0];
                java.lang.System.arraycopy(resultMatrix,0,enlargedResult,0,enlargedResult.length);
                resultMatrix = enlargedResult;
            }
            for (int j = 0; j < currentMatrix.length; j++) {
                if(resultMatrix[j].length < currentMatrix[j].length){
                    int[] enlargedResult = new int[currentMatrix[j].length];
                    java.lang.System.arraycopy(resultMatrix[j],0,enlargedResult,0,enlargedResult.length);
                }
                for (int k = 0; k < currentMatrix[j].length; k++) {
                    resultMatrix[j][k] |=  currentMatrix[j][k];
                }
            }
        }
        return resultMatrix;
    }
    
    public static class Interval{
        public static final int HOUR = Calendar.HOUR_OF_DAY;
        public static final int MINUTE = Calendar.MINUTE;
        
        final int type;
        final int from;
        final int to;
        final int[][] matrix;

        public Interval(int type, int from, int to, int[][] matrix) {
            this.type = type;
            this.from = from;
            this.to = to;
            this.matrix = matrix;
        }      
    }
    
}
