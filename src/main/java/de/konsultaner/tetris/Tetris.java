package de.konsultaner.tetris;

import java.util.Arrays;
import java.util.Random;

public class Tetris {
    private int matrixWidth;
    private int matrixHeight;
    private Brick[] bricks;
    private Brick[] field;
    private Brick currentBrick;
    private Brick nextBrick;
    private GRAVITY gravity = GRAVITY.BOTTOM;

    public enum GRAVITY {
        LEFT,RIGHT,TOP,BOTTOM
    }
    
    public Tetris(int matrixWidth, int matrixHeight) {
        this.matrixWidth = matrixWidth;
        this.matrixHeight = matrixHeight;
    }
    
    public void setGravity(GRAVITY gravity) {
        this.gravity = gravity;
    }

    public void addBrick(Brick brick){
        Brick[] enlargedBricks = new Brick[field.length+1];
        java.lang.System.arraycopy(field,0,enlargedBricks,0,enlargedBricks.length);
        enlargedBricks[enlargedBricks.length-1] = brick;
        bricks = enlargedBricks;
    }
    
    public void renderNextTick(){
        if(!fall()){
            Random random = new Random();
            Brick[] enlargedField = new Brick[field.length+1];
            java.lang.System.arraycopy(field,0,enlargedField,0,enlargedField.length);
            enlargedField[enlargedField.length-1] = currentBrick.copy();
            field = enlargedField;
            currentBrick = nextBrick;
            nextBrick = bricks[random.nextInt(bricks.length)];
        }
    }

    /**
     * Clears rows that are full and to be cleared, gravity is taken in consideration
     * @return An array of rows that have been cleared out, rows are marked with 1
     */
    int[][] clearFullRows(){
        int[][] field = getCurrentFieldMatrix();
        int[] clearRows = new int[field.length];
        int[] clearColumns = new int[field.length>0?field[0].length:0];
        int[][] resultMatrix = new int[clearRows.length][clearColumns.length];
        Arrays.fill(clearRows, 1);
        Arrays.fill(clearColumns, 1);
        
        for (int rowIndex = 0; rowIndex < field.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < field[rowIndex].length; columnIndex++) {
                if(gravity == GRAVITY.BOTTOM || gravity == GRAVITY.TOP) {
                    clearRows[rowIndex] |= field[rowIndex][columnIndex];
                    clearColumns[columnIndex] = 0;
                }else{
                    clearRows[rowIndex] = 0;
                    clearColumns[columnIndex] |= field[rowIndex][columnIndex];
                }
            }
        }
        
        // clear out brick
        for (Brick brick: bricks ) {
            brick.clearRows(clearRows);
            brick.clearColumns(clearColumns);
        }
        
        // generate result matrix        
        for (int rowIndex = 0; rowIndex < resultMatrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < resultMatrix[rowIndex].length; columnIndex++) {
                resultMatrix[rowIndex][columnIndex] = clearRows[rowIndex] | clearColumns[columnIndex];
            }
        }
                
        return resultMatrix;
    }

    public int[][] getCurrentFieldMatrix(){
        int[][] resultMatrix = new int[matrixHeight][matrixWidth];
        for (int i = 0; i < field.length; i++) {
            for (int brickRowIndex = 0; brickRowIndex < field[i].matrix.length; brickRowIndex++) {
                for (int brickColumnIndex = 0; brickColumnIndex < field[i].matrix[brickRowIndex].length; brickColumnIndex++) {
                    if(field[i].matrix[brickRowIndex][brickColumnIndex] == 1){
                        resultMatrix[field[i].y+brickRowIndex][field[i].x+brickColumnIndex] = i;
                    }
                }
            }
        }
        return resultMatrix;
    }
    
    private boolean fall(){
        return moveBrick(currentBrick,gravity);
    }
    
    public boolean moveLeft(){
        switch (gravity){
            case TOP: return moveBrick(currentBrick,GRAVITY.RIGHT);
            case RIGHT: return moveBrick(currentBrick,GRAVITY.BOTTOM);
            case BOTTOM: return moveBrick(currentBrick,GRAVITY.LEFT);
            case LEFT: return moveBrick(currentBrick,GRAVITY.TOP);
        }
        return false;
    }
    
    public boolean moveRight(){
        switch (gravity){
            case TOP: return moveBrick(currentBrick,GRAVITY.LEFT);
            case RIGHT: return moveBrick(currentBrick,GRAVITY.TOP);
            case BOTTOM: return moveBrick(currentBrick,GRAVITY.RIGHT);
            case LEFT: return moveBrick(currentBrick,GRAVITY.BOTTOM);
        }
        return false;
    }
    
    boolean moveBrick(Brick brick, GRAVITY direction){
        int[][] fieldMatrix = getCurrentFieldMatrix();
        for (int rowIndex = 0; rowIndex < fieldMatrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < fieldMatrix[rowIndex].length; columnIndex++) {
                int nextCurrentBrickX = brick.x + (direction == GRAVITY.RIGHT?1:0)  - (direction == GRAVITY.LEFT?1:0);
                int nextCurrentBrickY = brick.y + (direction == GRAVITY.BOTTOM?1:0) - (direction == GRAVITY.TOP?1:0);
                for (int brickRowIndex = 0; brickRowIndex < brick.matrix.length; brickRowIndex++) {
                    for (int brickColumnIndex = 0; brickColumnIndex < brick.matrix[brickRowIndex].length; brickColumnIndex++) {
                        if(brick.matrix[brickRowIndex][brickColumnIndex] == 1){
                           if(
                               rowIndex+nextCurrentBrickY+brickRowIndex >= fieldMatrix.length ||
                               columnIndex+nextCurrentBrickX+brickColumnIndex >= fieldMatrix[rowIndex+nextCurrentBrickY+brickRowIndex].length ||
                               fieldMatrix[rowIndex+nextCurrentBrickY+brickRowIndex][columnIndex+nextCurrentBrickX+brickColumnIndex] >= 0
                           ) {
                               return false;
                           }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public class Brick implements Cloneable{
        int x,y;
        int red,green,blue,white;
        private int[][] matrix;

        public Brick(int[][] matrix) {
            this.matrix = matrix;
        }

        protected Brick copy(){
            try{
                return this.clone();
            } catch (CloneNotSupportedException ignore) { }
            return null;
        }
        
        @Override
        protected Brick clone() throws CloneNotSupportedException {
            Brick clone;
            try {
                clone = (Brick) super.clone();
            }
            catch (CloneNotSupportedException ex) {
                throw new CloneNotSupportedException();
            }
            return clone;
        }

        void rotateCW(){
                
        }
        
        void rotateCCW(){
            
        }

        public void clearRows(int[] clearRows) {
            int[][] newMatrix = new int[0][0];
            int clearedRows = 0;
            for (int i = 0; i < clearRows.length; i++) {
                if(clearRows[i] == 0){
                    int rowIndex = i - y;
                    if(rowIndex > 0 && rowIndex < matrix.length){
                        if(newMatrix.length > 0){
                            newMatrix = Arrays.copyOf(newMatrix,newMatrix.length+1);
                        }else{
                            newMatrix = new int[1][matrix[rowIndex].length];
                        }
                        newMatrix[newMatrix.length-1] = Arrays.copyOf(matrix[rowIndex],matrix[rowIndex].length);
                    }
                }else clearedRows++;
            }
            matrix = newMatrix;
            if(gravity == GRAVITY.BOTTOM){
                y+=clearedRows;
            }
            if(gravity == GRAVITY.TOP){
                y-=clearedRows;
            }
        }

        public void clearColumns(int[] clearColumns) {
            
        }
    }
}
