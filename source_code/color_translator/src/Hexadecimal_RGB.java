import java.awt.Color;
import java.util.Scanner;

public class Hexadecimal_RGB {
    private static final Scanner ENTRADA = new Scanner(System.in);
    private static final Cores CORES = new Cores();
    private static final EscreverHistorico txtw = new EscreverHistorico();
    
    public static void anotarValoresRGB() {
        System.out.println("Informe o valor do hexadecimal: #");
        String HEXADECIMAL = ENTRADA.next();
        CORES.setHexadecimal(HEXADECIMAL);
    }

    public static void principal() {
        anotarValoresRGB();
        
        Color rgb = Color.decode("#" + CORES.getHexadecimal());
        double red = rgb.getRed();
        double green = rgb.getGreen();
        double blue = rgb.getBlue();
        
        System.out.println("\nRGB:");
        printRGB(red, green, blue);
        
        String dataAtual = Principal.getDateTime();   
                
        String cor = "Conversão de Hexadecimal para RGB" + " (" + dataAtual + ")"
            + "\nInformado:\t" + "#" + CORES.getHexadecimal()
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