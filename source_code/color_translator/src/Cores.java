public class Cores {
    //RGB:
    private double red;
    private double green;
    private double blue;
    
    //CMYK:
    private double cyan;
    private double magenta;
    private double yellow;
    private double black;
    
    //Hexadecimal
    private String hexadecimal;
    
    //HSL && HSV:
    private double hue;
    private double saturation;
    private double lightness;
    private double value;

    //RGB:
    public double getRed() {
        return red;
    }

    public void setRed(double red) {
        this.red = red;
    }

    public double getGreen() {
        return green;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    public double getBlue() {
        return blue;
    }

    public void setBlue(double blue) {
        this.blue = blue;
    }

    //CMYK:
    public double getCyan() {
        return cyan;
    }

    public void setCyan(double cyan) {
        this.cyan = cyan;
    }

    public double getMagenta() {
        return magenta;
    }

    public void setMagenta(double magenta) {
        this.magenta = magenta;
    }

    public double getYellow() {
        return yellow;
    }

    public void setYellow(double yellow) {
        this.yellow = yellow;
    }

    public double getBlack() {
        return black;
    }
    
    public void setBlack(double black) {
        this.black = black;
    }
    
    //Hexadecimal:
    public String getHexadecimal() {
        return hexadecimal;
    }

    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }
    
    //HSL && HSV:
    public double getHue() {
        return hue;
    }

    public void setHue(double hue) {
        this.hue = hue;
    }

    public double getSaturation() {
        return saturation;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    public double getLightness() {
        return lightness;
    }

    public void setLightness(double lightness) {
        this.lightness = lightness;
    }
    
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}