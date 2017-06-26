package de.konsultaner.demo;

import de.konsultaner.neopixel.Pixel;
import de.konsultaner.neopixel.PixelHandler;

public class Main {

    public static void main(String [] args){

        try {
            PixelHandler pixelHandler = PixelHandler
                .getBuilder()
                .buildChannel0()
                .setDimention(100,1)
                .setGpoiNumber(18)
                .add()
                .buildChannel1().add()
                .instance();

            pixelHandler.initalize();
            pixelHandler.getPixelChannel(0).setPixel(0,0,Pixel.fromColor(255,255,0,0));
            pixelHandler.render();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
