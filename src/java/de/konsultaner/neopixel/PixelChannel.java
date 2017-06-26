package de.konsultaner.neopixel;

import rpi.ws281x.RpiWs281xLibrary;
import rpi.ws281x.ws2811_channel_t;

public final class PixelChannel {

    private final Pixel[][] currentState;
    private final ws2811_channel_t rawChannel;
    
    private PixelChannel(int width, int height, ws2811_channel_t rawChannel){
        this.currentState = new Pixel[width][height];
        for (int i = 0; i < this.currentState.length; i++) {
            for (int i1 = 0; i1 < this.currentState[i].length; i1++) {
                this.currentState[i][i1] = new Pixel();
            }
        }
        this.rawChannel = rawChannel;
    }
    
    public void setPixel(int x, int y, Pixel pixel){
        this.currentState[x][y] = pixel;
    }
    
    public void rightShiftPixelsRow(int row){
        for (int i = 0; i < this.currentState.length; i++) {
            if(i < this.currentState.length-1){
                this.currentState[i+1][row] = this.currentState[i][row];
            }else {
                this.currentState[0][row] = this.currentState[i][row];
            }
        }
    }
    
    void pushPixels(){
        for (int i = 0; i < this.currentState.length; i++) {
            for (int i1 = 0; i1 < this.currentState[i].length; i1++) {
                this.rawChannel.leds.setValue(this.currentState[i][i1].rawColor);
            }
        }
    }

    public int getLedCount() {
        return this.rawChannel.count;
    }
    
    public ws2811_channel_t getRawChannel() {
        return rawChannel;
    }

    public static Builder getBuilder(PixelHandler.Builder builder, int channelIndex){
        return new Builder(builder, channelIndex);
    }

    public static class Builder{
        private final PixelHandler.Builder builder;
        private final int channelIndex;
        private ws2811_channel_t rawChannel;
        private int type = RpiWs281xLibrary.SK6812_STRIP_RGBW;
        private int width = 0;
        private int height = 0;
        private int gpioNumber = 0;
        private int invert = 0;
        private byte brightness = (byte) 255;

        public Builder(PixelHandler.Builder builder, int channelIndex) {

            this.builder = builder;
            this.channelIndex = channelIndex;
        }

        public Builder setUsedInvertLevelConverter(int invert){
            this.invert = invert;
            return this;
        }
        
        public Builder setGpoiNumber(int gpioNumber){
            this.gpioNumber = gpioNumber;
            return this;
        }
        
        public Builder setGlobalBrightness(byte brightness){
            this.brightness = brightness;
            return this;
        }
        
        public Builder setLedTyp(int type){
            this.type = type;
            return this;
        }
        
        public Builder setDimention(int width,int height){
            this.width = width;
            this.height = height;
            return this;
        }

        public PixelHandler.Builder add(){
            PixelChannel pixelChannel = new PixelChannel(
                this.width,
                this.height,
                new ws2811_channel_t(this.gpioNumber,this.invert,this.width*this.height,this.brightness,this.type)
            );
            builder.setChannel(channelIndex,pixelChannel);
            return builder;
        }
    }
}
