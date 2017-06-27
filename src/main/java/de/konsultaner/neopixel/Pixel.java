package de.konsultaner.neopixel;

public class Pixel {

    int rawColor = 0x00000000;
    
    public void setColor(int white, int red, int green, int blue){
        this.rawColor = (white << 24) | (red << 16)| (green << 8) | blue;
    }

    public int getRawColor() {
        return rawColor;
    }

    public void setWhite(int value){
        this.rawColor = (this.rawColor & 0x00FFFFFF) | (value << 24);
    }
    
    public void setRed(int value){
        this.rawColor = (this.rawColor & 0xFF00FFFF) | (value << 16);
    }
    
    public void setGreen(int value){
        this.rawColor = (this.rawColor & 0xFFFF00FF) | (value << 8);
    }
    
    public void setBlue(int value){
        this.rawColor = (this.rawColor & 0xFFFFFF00) | value;
    }

    public static Pixel fromColor(int white, int red, int green, int blue) {
        Pixel pixel = new Pixel();
        pixel.setColor(white,red,green,blue);
        return pixel;
    }
}
