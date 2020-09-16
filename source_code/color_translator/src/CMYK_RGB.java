import java.util.Scanner;

public class CMYK_RGB {
    private static final Scanner ENTRADA = new Scanner(System.in);
    private static final Cores CORES = new Cores();
    private static final EscreverHistorico txtw = new EscreverHistorico();
    private static final short VALOR_MAXIMO = 100;
    private static final short VALOR_MINIMO = 0;
    private static final short VALOR_MAXIMO_RGB = 255;
    
    public static void anotarValoresCMYK() {
        System.out.println("Informe a porcentagem de cyan: ");
        double CYAN = (ENTRADA.nextDouble()) / 100;
        if(CYAN < VALOR_MINIMO) CYAN = VALOR_MINIMO;
        else if(CYAN > VALOR_MAXIMO) CYAN = VALOR_MAXIMO;
        CORES.setCyan(CYAN);

        System.out.println("Informe a porcentagem de magenta: ");
        double MAGENTA = (ENTRADA.nextDouble()) / 100;
        if(MAGENTA < VALOR_MINIMO) MAGENTA = VALOR_MINIMO;
        else if(MAGENTA > VALOR_MAXIMO) MAGENTA = VALOR_MAXIMO;
        CORES.setMagenta(MAGENTA);

        System.out.println("Informe a porcentagem de yellow: ");
        double YELLOW = (ENTRADA.nextDouble()) / 100;
        if(YELLOW < VALOR_MINIMO) YELLOW = VALOR_MINIMO;
        else if(YELLOW > VALOR_MAXIMO) YELLOW = VALOR_MAXIMO;
        CORES.setYellow(YELLOW);
        
        System.out.println("Informe a porcentagem de black: ");
        double BLACK = (ENTRADA.nextDouble()) / 100;
        if(BLACK < VALOR_MINIMO) BLACK = VALOR_MINIMO;
        else if(BLACK > VALOR_MAXIMO) BLACK = VALOR_MAXIMO;
        CORES.setBlack(BLACK);
    }

    public static void principal() {
        anotarValoresCMYK();
        
        System.out.println("\nValores informados:");
        double cyan = CORES.getCyan();
        double magenta = CORES.getMagenta();
        double yellow = CORES.getYellow();
        double black = CORES.getBlack();
        printCMYK(cyan, magenta, yellow, black);
        
        System.out.println("\nRGB:");
        double red = VALOR_MAXIMO_RGB * (1 - cyan) * (1 - black);
        double green = VALOR_MAXIMO_RGB * (1 - magenta) * (1 - black);
        double blue = VALOR_MAXIMO_RGB * (1 - yellow) * (1 - black);
        printRGB(red, green, blue);
        
        String dataAtual = Principal.getDateTime();
        
        String cor = "Conversão de CMYK para RGB" + " (" + dataAtual + ")"
            + "\nInformado:\t" + "Cyan: " + CORES.getCyan() + "\tMagenta: " + CORES.getMagenta() + "\tYellow: " + CORES.getYellow() + "\tBlack: " + CORES.getBlack()
            + "\nResultado:\t" + "Red: " + red + "\tGreen: " + green + "\tBlue: " + blue + "\n";
        
        System.out.println("\nCOR: " + cor);
        txtw.writeTestTrue(cor);
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
}