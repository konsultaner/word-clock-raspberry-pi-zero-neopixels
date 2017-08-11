package de.konsultaner.wordClock;

public class WordClockMatrix {
    
    public final String[] matrix;
    
    public WordClockMatrix(String[] matrix) {
        this.matrix = matrix;
    }

    /**
     * finds the sentence in the matrix and returns a matrix with marked entries where to find the words
     * it does not support linebreaks within a word. Use a whitespace where a linebreak is needed
     * @param sentence "i.e. 'It is ten past five'" 
     * @return a NxM Matrix of 0,1 values
     */
    public int[][] getMatrixBySentence(String sentence){
        int[][] result = new int[this.matrix.length][this.matrix.length>0?this.matrix[0].length():0]; 
        String words[] = sentence.split(" ");
        int rowIndex = 0;
        int wordIndex = 0;
        for (String word: words) {
            int currentWordIndex;
            for (int j = rowIndex; j < this.matrix.length; j++) {
                // breaking words are not allowed
                currentWordIndex = this.matrix[rowIndex].indexOf(word);
                if(currentWordIndex >= wordIndex){
                    for (int i = 0; i < word.length(); i++) {
                        result[rowIndex][currentWordIndex+i] = 1;
                    }
                    wordIndex = currentWordIndex + word.length();
                    break;
                }else{
                    rowIndex++;
                    wordIndex = 0;
                }
            }
        }
        return result;
    }
    
    public WordclockDecorator getWorclockDecorator(){
        return new WordclockDecorator(this);
    }
    
    public static final class WordclockDecorator{
        private final WordClockMatrix matrix;
        private WordClock wordClock = new WordClock();
        private WordclockDecorator(WordClockMatrix matrix){
            this.matrix = matrix;
        }
        public WordclockDecorator addSentence(int fromHour, int toHour, int fromMinute, int toMinute, String sentence){
            wordClock.addInterval(new WordClock.Interval(fromHour, toHour, fromMinute, toMinute, matrix.getMatrixBySentence(sentence)));
            return this;
        }
        public WordClock getWordClock() {
            WordClock returnWordClock = wordClock;
            wordClock = new WordClock();
            return returnWordClock;
        }
    }
}
