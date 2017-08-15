package de.konsultaner.tetris;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class BrickTest {
    @Test
    public void rotateCW() throws Exception {
    }

    @Test
    public void rotateCCW() throws Exception {
    }

    @Test
    public void clearRows() throws Exception {
        Tetris.Brick brick = new Tetris.Brick(new int[][]{
            {0,0,0,1},
            {1,1,1,1}
        });
        brick.y = 10;
        
        brick.clearRows(new int[]{1,0,0,1,0,0,0,0,0,0,0,0}, Tetris.GRAVITY.BOTTOM);
        assertArrayEquals(brick.getMatrix(), new int[][]{
            {0,0,0,1},
            {1,1,1,1}
        });
        
        brick.clearRows(new int[]{1,0,0,1,0,0,0}, Tetris.GRAVITY.BOTTOM);
        assertArrayEquals(brick.getMatrix(), new int[][]{
            {0,0,0,1},
            {1,1,1,1}
        });

        brick.clearRows(new int[]{1,0,0,1,0,0,0,0,0,0,1,0}, Tetris.GRAVITY.BOTTOM);
        assertArrayEquals(brick.getMatrix(), new int[][]{
            {1,1,1,1}
        });

        brick = new Tetris.Brick(new int[][]{
            {0,0,0,1},
            {1,1,1,1}
        });
        brick.y = 10;
        brick.clearRows(new int[]{1,0,0,1,0,0,0,0,0,0,0,1}, Tetris.GRAVITY.BOTTOM);
        assertArrayEquals(brick.getMatrix(), new int[][]{
            {0,0,0,1}
        });
        assertThat(brick.y, CoreMatchers.equalTo(11));
        
        brick = new Tetris.Brick(new int[][]{
            {0,0,0,1},
            {1,1,1,1}
        });
        brick.y = 10;
        brick.clearRows(new int[]{1,0,0,1,0,0,0,0,0,0,0,1}, Tetris.GRAVITY.BOTTOM);
        assertArrayEquals(brick.getMatrix(), new int[][]{
            {0,0,0,1}
        });
        assertThat(brick.y, CoreMatchers.equalTo(11));

        brick = new Tetris.Brick(new int[][]{
            {0,0,0,1},
            {1,1,1,1}
        });
        brick.y = 10;
        brick.clearRows(new int[]{1,0,0,1,0,0,0,0,0,0,0,1}, Tetris.GRAVITY.TOP);
        assertArrayEquals(brick.getMatrix(), new int[][]{
            {0,0,0,1}
        });
        assertThat(brick.y, CoreMatchers.equalTo(7));
    }

    @Test
    public void clearColumns() throws Exception {
    }

}