package de.konsultaner.neopixel;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Richard Burkhardt on 27.06.2017.
 */
public class PixelChannelTest {
    @Test
    public void setPixel() throws Exception {
        PixelHandler pixelHandler = PixelHandler.getBuilder()
            .buildChannel0().setDimention(10,10).add()
            .buildChannel1().add()
            .instance();
        
        PixelChannel pixelChannel = pixelHandler.getPixelChannel(0);
        
        assertThat("Should have 100 pixels",pixelChannel.getLedCount(), CoreMatchers.equalTo(100));

        for (float i = 0; i < 10; i++) {
            int value = (int)(255 - (i*25.5F));
            pixelChannel.setPixel((int)i,0,Pixel.fromColor(value,value,value,value));
        }
        
        assertThat("Should have 255 at pixels 0",pixelChannel.getPixel(0,0).rawColor, CoreMatchers.equalTo(0xFFFFFFFF));
        assertThat("Should have 255 at pixels 0",pixelChannel.getPixel(9,0).rawColor, CoreMatchers.equalTo(0x19191919));

        pixelChannel.rightShiftPixelsRow(0);
        for (int i = 0; i < 10; i++) {
            System.out.println(Integer.toHexString(pixelChannel.getPixel(i,0).rawColor));
        }
        assertThat("Should have 255 at pixels 0",pixelChannel.getPixel(0,0).rawColor, CoreMatchers.equalTo(0x19191919));
        assertThat("Should have 255 at pixels 0",pixelChannel.getPixel(9,0).rawColor, CoreMatchers.equalTo(0x33333333));
    }

}