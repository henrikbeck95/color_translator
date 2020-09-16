import java.util.Scanner;

public class RGB_HSL {
    private static final Scanner ENTRADA = new Scanner(System.in);
    private static final Cores CORES = new Cores();
    private static final EscreverHistorico txtw = new EscreverHistorico();
    private static final short VALOR_MAXIMO = 255;
    private static final short VALOR_MINIMO = 0;
    
    public static void anotarValoresRGB() {
        System.out.println("Informe o valor de red: ");
        double RED = ENTRADA.nextDouble();
        if(RED < VALOR_MINIMO) RED = VALOR_MINIMO;
        else if(RED > VALOR_MAXIMO) RED = VALOR_MAXIMO;
        CORES.setRed(RED);
        
        System.out.println("Informe o valor de green: ");
        double GREEN = ENTRADA.nextDouble();
        if(GREEN < VALOR_MINIMO) GREEN = VALOR_MINIMO;
        else if(GREEN > VALOR_MAXIMO) GREEN = VALOR_MAXIMO;
        CORES.setGreen(GREEN);
        
        System.out.println("Informe o valor de blue: ");
        double BLUE = ENTRADA.nextDouble();
        if(BLUE < VALOR_MINIMO) BLUE = VALOR_MINIMO;
        else if(BLUE > VALOR_MAXIMO) BLUE = VALOR_MAXIMO;
        CORES.setBlue(BLUE);
    }
    
    public static void principal() {
        anotarValoresRGB();
        
        System.out.println("\nValores informados:");
        double red = CORES.getRed();
        double green = CORES.getGreen();
        double blue = CORES.getBlue();
        printRGB(red, green, blue);
        
        System.out.println("\nValores normalizados:");
        red /= VALOR_MAXIMO;
        green /= VALOR_MAXIMO;
        blue /= VALOR_MAXIMO;
        printRGB(red, green, blue);
        
        double maior = encontrarMaior(red, green, blue);
        double menor = encontrarMenor(red, green, blue);
        System.out.println("\nMaior: " + maior + "\tMenor: " + menor);
        
        double delta = maior - menor;
        System.out.println("Delta: " + delta);
        
        double hue = calcularHue(delta, maior, red, green, blue);
        double lightness = (maior + menor) / 2;
        double saturation = calcularSaturacao(delta, lightness);
        
        System.out.println("\nHSL:");
        printHSL(hue, saturation, lightness);
        
        String dataAtual = Principal.getDateTime();
        
        String cor = "Conversão de RGB para HSL" + " (" + dataAtual + ")"
            + "\nInformado:\t" + "Red: " + CORES.getRed() + "\tGreen: " + CORES.getGreen() + "\tBlue: " + CORES.getBlue()
            + "\nResultado:\t" + "Hue: " + hue + "\tSaturation: " + saturation + "\tLightness: " + lightness + "\n";
        
        System.out.println("\nCOR: " + cor);
        txtw.writeTestTrue(cor);
    }
    
    public static double encontrarMaior(double R, double G, double B) {
        double maior = 0;
        
        if(R > G || R == G) maior = R;
        else if(G > R) maior = G;
        
        if(maior < B) maior = B;
        
        return maior;
    }    
    
    public static double encontrarMenor(double R, double G, double B) {
        double menor = 0;
        
        if(R < G || R == G) menor = R;
        else if(G < R) menor = G;
        
        if(menor > B) menor = B;
        
        return menor;
    }
    
    public static double calcularHue(double delta, double maior, double red, double green, double blue){
        /*
        double hue = 0;
        
        if(delta == 0) hue = 0;
        if(maior == red) hue = 60 * (((green - blue) / delta) % 6);
        if(maior == green) hue = 60 * (((blue - red) / delta) + 2);
        if(maior == blue) hue = 60 * (((red - green) / delta) + 4);
        */
        
        double hue = 0;
        
        if(maior == red) hue = (60 * ((green - blue) / delta) + 360) % 360;
        if(maior == green) hue = (60 * ((blue - red) / delta) + 120) % 360;
        if(maior == blue) hue = (60 * ((red - green) / delta) + 240) % 360;
        
        return hue;
    }
    
    public static double calcularSaturacao(double delta, double lightness){
        double saturacao = 0;
        
        if(delta == 0){
            saturacao = 0;
        }else{
            double modulo = (2 * lightness - 1);
            
            if(modulo < 0) modulo *= -1;
            
            saturacao = delta / (1 - modulo);
        }
        
        return saturacao;
    }
    
    public static void printRGB(double R, double G, double B){
        System.out.println("Red: " + R
            + "\tGreen: " + G
            + "\tBlue: " + B);
    }
    
    public static void printHSL(double H, double S, double L){
        System.out.println("Hue: " + H + "º"
            + "\tSaturation: " + S*100 + "%"
            + "\tLightness: " + L*100 + "%");
    }
}