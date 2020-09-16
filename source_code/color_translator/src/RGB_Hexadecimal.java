import java.util.Scanner;

public class RGB_Hexadecimal {
    private static final Scanner ENTRADA = new Scanner (System.in);
    private static final Cores CORES = new Cores();
    private static final EscreverHistorico txtw = new EscreverHistorico();
    private static final short VALOR_MAXIMO = 255;
    private static final short VALOR_MINIMO = 0;
    
    /*
    hex = r*65536+g*256+b;
    hex = hex.toString(16,6);
    len = hex.length;
    if( len<6 )
            for(i=0; i<6-len; i++)
                    hex = '0'+hex;
    */
    
    public static void anotarValoresRGB() {
        System.out.println("Informe o valor de red: ");
        double RED = ENTRADA.nextDouble();
        if(RED < VALOR_MINIMO) RED = 0;
        else if(RED > VALOR_MAXIMO) RED = 255;
        CORES.setRed(RED);
        
        System.out.println("Informe o valor de green: ");
        double GREEN = ENTRADA.nextDouble();
        if(GREEN < VALOR_MINIMO) GREEN = 0;
        else if(GREEN > VALOR_MAXIMO) GREEN = 255;
        CORES.setGreen(GREEN);
        
        System.out.println("Informe o valor de blue: ");
        double BLUE = ENTRADA.nextDouble();
        if(BLUE < VALOR_MINIMO) BLUE = 0;
        else if(BLUE > VALOR_MAXIMO) BLUE = 255;
        CORES.setBlue(BLUE);
    }
    
    public static void principal() {
        anotarValoresRGB();
        System.out.println("\nValores informados:");
        printRGB();
        
        String HEXADECIMAL = String.format("#%02x%02x%02x", (int) CORES.getRed(), (int) CORES.getGreen(), (int) CORES.getBlue());
        System.out.println("HEXADECIMAL: " + HEXADECIMAL);
        
        String dataAtual = Principal.getDateTime();
        
        String cor = "Conversão de RGB para Hexadecimal" + " (" + dataAtual + ")"
            + "\nInformado:\t" + "Red: " + CORES.getRed() + "\tGreen: " + CORES.getGreen() + "\tBlue: " + CORES.getBlue()
            + "\nResultado:\t" + HEXADECIMAL + "\n";
        
        System.out.println("\nCOR: " + cor);
        txtw.writeTestTrue(cor);
    }
    
    public static void printRGB(){
        System.out.println("Red: " + CORES.getRed()
            + "\tGreen: " + CORES.getGreen()
            + "\tBlue: " + CORES.getBlue());
    }
}