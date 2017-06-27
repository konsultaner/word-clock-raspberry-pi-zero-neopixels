package de.konsultaner.neopixel;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class PixelTest {
    @Test
    public void setColor() throws Exception {
        Pixel pixel = Pixel.fromColor(255, 100, 100, 100);
        assertThat("Should return 0xff646464",pixel.rawColor, CoreMatchers.equalTo(0xff646464));
    }
}