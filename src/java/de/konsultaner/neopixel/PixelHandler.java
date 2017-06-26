package de.konsultaner.neopixel;

import rpi.ws281x.RpiWs281xLibrary;
import rpi.ws281x.ws2811_channel_t;
import rpi.ws281x.ws2811_t;

import java.security.interfaces.RSAPrivateCrtKey;

public final class PixelHandler {
    
    private static final int PIXEL_CHANNEL_COUNT = 2;
    
    private final ws2811_t matrix;
    private final ws2811_channel_t[] rawChannels = new ws2811_channel_t[PIXEL_CHANNEL_COUNT];
    private final PixelChannel[] pixelChannels = new PixelChannel[PIXEL_CHANNEL_COUNT];
    
    private PixelHandler(int frequency, int dma, ws2811_channel_t[] rawChannels, PixelChannel[] pixelChannels){
        this.rawChannels[0] = rawChannels[0];
        this.rawChannels[1] = rawChannels[1];
        this.pixelChannels[0] = pixelChannels[0];
        this.pixelChannels[1] = pixelChannels[1];
        
        this.matrix = new ws2811_t(frequency,dma, this.rawChannels);
    }

    public int initalize() throws Exception {
        int result = RpiWs281xLibrary.INSTANCE.ws2811_init(matrix);
        if(result != RpiWs281xLibrary.ws2811_return_t.WS2811_SUCCESS){
            throw new Exception(RpiWs281xLibrary.INSTANCE.ws2811_get_return_t_str(result).toString());
        }
        return result;
    }
    
    public PixelChannel getPixelChannel(int channelIndex){
        return this.pixelChannels[channelIndex];
    }
    
    public int render() throws Exception {
        this.pixelChannels[0].pushPixels();
        this.pixelChannels[1].pushPixels();
        
        int result = RpiWs281xLibrary.INSTANCE.ws2811_render(matrix);
        if(result != RpiWs281xLibrary.ws2811_return_t.WS2811_SUCCESS){
            throw new Exception(RpiWs281xLibrary.INSTANCE.ws2811_get_return_t_str(result).toString());
        }
        return result;
    }
    
    public void cleanup(){
        RpiWs281xLibrary.INSTANCE.ws2811_fini(this.matrix);
    }
    
    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private int frequency = RpiWs281xLibrary.WS2811_TARGET_FREQ;
        private int dma = 5;
        private final ws2811_channel_t[] channels = new ws2811_channel_t[PIXEL_CHANNEL_COUNT];
        private final PixelChannel[] pixelChannels = new PixelChannel[PIXEL_CHANNEL_COUNT];

        private Builder(){
            // build default rawChannels
            channels[0] = new ws2811_channel_t();
        }
        
        public PixelHandler.Builder setFrequency(int frequency){
            this.frequency = frequency;
            return this;
        }

        /**
         * direct memory access channel to use; default is 5
         * @param dma the channel number
         * @return the builder instance
         */
        public PixelHandler.Builder setDMA(int dma){
            this.dma = dma;
            return this;
        }
        
        public PixelChannel.Builder buildChannel0(){
            return PixelChannel.getBuilder(this,0);
        }
        
        public PixelChannel.Builder buildChannel1(){
            return PixelChannel.getBuilder(this,1);
        }

        void setChannel(int channelIndex, PixelChannel pixelChannel) {
            pixelChannels[channelIndex] = pixelChannel;
            channels[channelIndex] = pixelChannel.getRawChannel();
        }
        
        public PixelHandler instance() throws Exception {
            if(channels[0] != null && channels[1] != null){
                return new PixelHandler(this.frequency,this.dma,this.channels, this.pixelChannels);
            }else{
                throw new Exception("Please add call buildChannel0() and buildChannel1() before calling instance()!");
            }
        }
    }

}
