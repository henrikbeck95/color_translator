import java.util.Scanner;

public class HSL_RGB {
    private static final Scanner ENTRADA = new Scanner(System.in);
    private static final Cores CORES = new Cores();
    private static final EscreverHistorico txtw = new EscreverHistorico();
    private static final short VALOR_MAXIMO_HUE = 360;
    private static final short VALOR_MAXIMO = 100;
    private static final short VALOR_MINIMO = 0;
    private static final short VALOR_MAXIMO_RGB = 255;

    public static void anotarValoresRGB() {
        System.out.println("Informe o valor de hue: ");
        double HUE = ENTRADA.nextDouble();
        if(HUE < VALOR_MINIMO) HUE = VALOR_MINIMO;
        else if(HUE > VALOR_MAXIMO_HUE) HUE = VALOR_MAXIMO_HUE;
        CORES.setHue(HUE);

        System.out.println("Informe o valor de saturation: ");
        double SATURATION = ENTRADA.nextDouble();
        if(SATURATION < VALOR_MINIMO) SATURATION = VALOR_MINIMO;
        else if(SATURATION > VALOR_MAXIMO) SATURATION = VALOR_MAXIMO;
        CORES.setSaturation(SATURATION);

        System.out.println("Informe o valor de lightness: ");
        double LIGHTNESS = ENTRADA.nextDouble();
        if(LIGHTNESS < VALOR_MINIMO) LIGHTNESS = VALOR_MINIMO;
        else if(LIGHTNESS > VALOR_MAXIMO) LIGHTNESS = VALOR_MAXIMO;
        CORES.setLightness(LIGHTNESS);
    }

    public static void principal() {
        anotarValoresRGB();

        System.out.println("\nValores informados:");
        double hue = CORES.getHue();
        double saturation = CORES.getSaturation() / 100;
        double lightness = CORES.getLightness() / 100;
        printHSL(hue, saturation, lightness);
        
        System.out.println("\nValores interediários:");
        double c_modulo = 2 * lightness - 1; //|2 * lightness - 1|;
        System.out.println("C_modulo: " + c_modulo);
        if(c_modulo < 0) c_modulo *= -1;
        double c = (1 - c_modulo) * saturation;
        
        double x_modulo = ((hue / 60) % 2) - 1; //|(H / 60) % 2 - 1|
        if(x_modulo < 0) x_modulo *= -1;
        System.out.println("X_modulo: " + x_modulo);
        double x = c * (1 - x_modulo);
        
        double m = lightness - c / 2;
        System.out.println("M: " + m);
        
        System.out.println("\nC: " + c + "\tX: " + x + "\tM: " + m);
        
        System.out.println("\nValores normalizados':");
        double rgb[] = calcularRGB(hue, c, x, m);
        double red = rgb[0];
        double green = rgb[1];
        double blue = rgb[2];
        printRGB(red, green, blue);
        
        System.out.println("\nRGB:");
        red = (red + m) * VALOR_MAXIMO_RGB;
        green = (green + m) * VALOR_MAXIMO_RGB;
        blue = (blue + m) * VALOR_MAXIMO_RGB;
        printRGB(red, green, blue);
        
        String dataAtual = Principal.getDateTime();
        
        String cor = "Conversão de HSL para RGB" + " (" + dataAtual + ")"
            + "\nInformado:\t" + "Hue: " + CORES.getHue() + "\tSaturation: " + CORES.getSaturation() + "\tLightness: " + CORES.getLightness()
            + "\nResultado:\t" + "Red: " + red + "\tGreen: " + green + "\tBlue: " + blue + "\n";
        
        System.out.println("\nCOR: " + cor);
        txtw.writeTestTrue(cor);
    }

    public static double[] calcularRGB(double hue, double c, double x, double m) {
        double rgb[] = new double [3];

        if((0 <= hue || 360 == hue) && hue < 60){
            rgb[0] = c;
            rgb[1] = x;
            rgb[2] = 0;
        }else if(60 <= hue && hue < 120){
            rgb[0] = x;
            rgb[1] = c;
            rgb[2] = 0;
        }else if(120 <= hue && hue < 180){
            rgb[0] = 0;
            rgb[1] = c;
            rgb[2] = x;
        }else if(180 <= hue && hue < 240){
            rgb[0] = 0;
            rgb[1] = x;
            rgb[2] = c;
        }else if(240 <= hue && hue < 300){
            rgb[0] = x;
            rgb[1] = 0;
            rgb[2] = c;
        }else if(300 <= hue && hue < 360){
            rgb[0] = c;
            rgb[1] = 0;
            rgb[2] = x;
        }

        return rgb;
    }

    public static void printHSL(double H, double S, double L) {
        System.out.println("Hue: " + H + "º"
                + "\tSaturation: " + S*100 + "%"
                + "\tLightness: " + L*100 + "%");
    }

    public static void printRGB(double R, double G, double B) {
        System.out.println("Red: " + R
                + "\tGreen: " + G
                + "\tBlue: " + B);
    }
}