import java.util.Scanner;

public class RGB_Grey {
    private static final Scanner ENTRADA = new Scanner(System.in);
    private static final Cores CORES = new Cores();
    private static final EscreverHistorico txtw = new EscreverHistorico();
    private static final short VALOR_MAXIMO = 255;
    private static final short VALOR_MINIMO = 0;

    public static void anotarValoresRGB() {
        System.out.println("Informe o valor de red: ");
        double RED = ENTRADA.nextDouble();
        if (RED < VALOR_MINIMO) {
            RED = VALOR_MINIMO;
        } else if (RED > VALOR_MAXIMO) {
            RED = VALOR_MAXIMO;
        }
        CORES.setRed(RED);

        System.out.println("Informe o valor de green: ");
        double GREEN = ENTRADA.nextDouble();
        if (GREEN < VALOR_MINIMO) {
            GREEN = VALOR_MINIMO;
        } else if (GREEN > VALOR_MAXIMO) {
            GREEN = VALOR_MAXIMO;
        }
        CORES.setGreen(GREEN);

        System.out.println("Informe o valor de blue: ");
        double BLUE = ENTRADA.nextDouble();
        if (BLUE < VALOR_MINIMO) {
            BLUE = VALOR_MINIMO;
        } else if (BLUE > VALOR_MAXIMO) {
            BLUE = VALOR_MAXIMO;
        }
        CORES.setBlue(BLUE);
    }

    public static void principal() {
        anotarValoresRGB();

        System.out.println("\nValores informados:");
        double red = CORES.getRed();
        double green = CORES.getGreen();
        double blue = CORES.getBlue();
        printRGB(red, green, blue);
        
        if(red == green && green == blue){
            System.out.println("Esta conversão não faz sentido.");
            System.out.println("Como piada interna o resultado é rosa.");
        }

        System.out.println("\nRGB em escala de cinza:");
        
        double cinza = (red + green + blue) / 3;
        
        red = cinza;
        green = cinza;
        blue = cinza;
        
        printRGB(red, green, blue);
        
        String dataAtual = Principal.getDateTime();
        
        String cor = "Conversão de RGB para escala de cinza" + " (" + dataAtual + ")"
            + "\nInformado:\t" + "Red: " + CORES.getRed() + "\tGreen: " + CORES.getGreen() + "\tBlue: " + CORES.getBlue()
            + "\nResultado:\t" + "Red: " + red + "\tGreen: " + green + "\tBlue: " + blue + "\n";
        
        System.out.println("\nCOR: " + cor);
        txtw.writeTestTrue(cor);
    }
    
    public static void printRGB(double R, double G, double B){
        System.out.println("Red: " + R
            + "\tGreen: " + G
            + "\tBlue: " + B);
    }
}