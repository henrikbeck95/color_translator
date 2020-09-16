import java.util.Scanner;

public class RGB_CMYK {
    private static final Scanner ENTRADA = new Scanner(System.in);
    private static final EscreverHistorico txtw = new EscreverHistorico();
    private static final Cores CORES = new Cores();
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
        double cyan, magenta, yellow, black;
        
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
        if(maior < 0 || maior > 1) System.out.println("Você inseriou valores errados, o resultado do cálculo será impreciso");
        System.out.println("\nMaior: " + maior);
        
        if(maior == 0){
            cyan = 0.0;
            magenta = 0.0;
            yellow = 0.0;
            black = 1;
        }else{
            black = 1 - maior;
            cyan = (1 - red - black) / (1 - black); 
            magenta = (1 - green - black) / (1 - black);
            yellow = (1 - blue - black) / (1 - black);
        }
        
        System.out.println("\nCMYK:");
        printCMYK(cyan, magenta, yellow, black);
        printPorcentagemCMYK(cyan, magenta, yellow, black);
        
        
        String dataAtual = Principal.getDateTime();
        
        String cor = "Conversão de RGB para CMYK: " + " (" + dataAtual + ")"
            + "\nInformado:\t" + "Red: " + CORES.getRed() + "\tGreen: " + CORES.getGreen() + "\tBlue: " + CORES.getBlue()
            + "\nResultado:\t" + "Cyan: " + cyan + "\tMagenta: " + magenta + "\tYellow: " + yellow + "\tBlack: " + black + "\n";
        
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
    
    public static void printRGB(double R, double G, double B){
        System.out.println("Red: " + R
            + "\tGreen: " + G
            + "\tBlue: " + B);
    }
    
    public static void printCMYK(double C, double M, double Y, double K){
        System.out.println("Cyan: " + C
            + "\tMagenta: " + M
            + "\tYellow: " + Y
            + "\tBlack: " + K);
    }
    
    public static void printPorcentagemCMYK(double C, double M, double Y, double K){
        System.out.println("Cyan: " + Math.round(C * 100) + "%"
            + "\tMagenta: " + Math.round(M * 100) + "%"
            + "\tYellow: " + Math.round(Y * 100) + "%"
            + "\tBlack: " + Math.round(K * 100) + "%");
    }
}