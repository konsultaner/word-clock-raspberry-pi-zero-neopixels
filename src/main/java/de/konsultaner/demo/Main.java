package de.konsultaner.demo;

import de.konsultaner.neopixel.Pixel;
import de.konsultaner.neopixel.PixelHandler;
import rpi.ws281x.RpiWs281xLibrary;

public class Main {

    public static void main(String [] args){
        PixelHandler pixelHandler = null;
        try {
            pixelHandler = PixelHandler
                .getBuilder()
                .buildChannel0()
                .setLedTyp(RpiWs281xLibrary.SK6812_STRIP_RGBW)
                .setDimention(100,1)
                .setGpoiNumber(18)
                .add()
                .buildChannel1()
                .add()
                .instance();

            pixelHandler.initalize();
            int ledSize = pixelHandler.getPixelChannel(0).getLedCount();
            int whiteBlockLength = 10;
            int rampLength = (ledSize / 3);
            for (int i = 0; i < ledSize; i++) {
                int white = i >= 0 && i < whiteBlockLength?255:0;

                int red = calculateColorValue(i,rampLength);
                int green = calculateColorValue(((((i-rampLength)%ledSize)+ledSize)%ledSize),rampLength);
                int blue = calculateColorValue(((((i-rampLength*2)%ledSize)+ledSize)%ledSize),rampLength);
                pixelHandler.getPixelChannel(0).setPixel(i, 0, Pixel.fromColor(white,red,green,blue));
            }
            pixelHandler.render();
            for (int i = 0; i < ledSize; i++) {
                pixelHandler.getPixelChannel(0).rightShiftPixelsRow(0);
                pixelHandler.render();
                Thread.sleep(1000/15);
            }
            pixelHandler.getPixelChannel(0).clearChannel();
            pixelHandler.render();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(pixelHandler != null){
                pixelHandler.cleanup();
            }
        }
    }

    private static int calculateColorValue(float ledIndex, int rampLength){
        float colorValue = ledIndex/rampLength * 255;
        if(colorValue > 255*2) return 0;
        if(colorValue > 255){
            colorValue = (255*2) - colorValue;
        }
        return (int)colorValue;
    }
}
