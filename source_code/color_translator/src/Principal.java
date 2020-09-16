import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
    private static final Scanner ENTRADA = new Scanner(System.in);
    private static final LerHistorico txtr = new LerHistorico();
    
    private static final String RGB_TO_CMYK = "Converter RGB para CMYK";
    private static final String CMYK_TO_RGB = "Converter CMYK para RGB";
    private static final String RGB_TO_HEXADECIMAL = "Converter RGB para Hexadecimal";
    private static final String HEXADECIMAL_TO_RGB = "Converter Hexadecimal para RGB";
    private static final String RGB_TO_HSL = "Converter RGB para HSL";
    private static final String HSL_TO_RGB = "Converter HSL para RGB";
    private static final String RGB_TO_HSV = "Converter RGB para HSV";
    private static final String HSV_TO_RGB = "Converter HSV para RGB";
    private static final String RGB_TO_GREY = "Converter RGB para Escala de cinza";
    private static final String HISTORICO = "Histórico da conversões realizadas";
    private static final String CREDITOS = "Creditos";
    private static final String SAIR = "Finalizar software";
    private static final String DEBUG = " (funcionando em modo debug)";
    
    public static void main(String[] args) {
        byte indice = escolherOpcao();
        menu(indice);
        //main(null);
        //debugMenu();
    }
    
    public static void debugMenu(){
        System.out.println(HSV_TO_RGB + DEBUG);
        HSV_RGB.principal();
    }

    public static byte escolherOpcao(){
        System.out.println("---Color translator---");
        System.out.println("\nInforme a funcao desejada: "
                + "\n1 - " + RGB_TO_CMYK
                + "\n2 - " + CMYK_TO_RGB
                + "\n3 - " + RGB_TO_HEXADECIMAL
                + "\n4 - " + HEXADECIMAL_TO_RGB
                + "\n5 - " + RGB_TO_HSL
                + "\n6 - " + HSL_TO_RGB
                + "\n7 - " + RGB_TO_HSV
                + "\n8 - " + HSV_TO_RGB
                + "\n9 - " + RGB_TO_GREY
                + "\n10 - " + HISTORICO
                + "\n11 - " + CREDITOS
                + "\n0 - " + SAIR);
        byte indice = ENTRADA.nextByte();
        
        return indice;
    }
    
    public static void menu(byte indice){
        switch (indice) {
            case 0:
                System.out.println(SAIR);
                aguardando();
                System.exit(indice);
                Runtime.getRuntime().exit(indice); //Caso o comando seja execudo no prompt de comando ou terminal.
            case 1:
                System.out.println(RGB_TO_CMYK);
                Tutoriais.tutorial_RGB_CMYK();
                aguardando();
                RGB_CMYK.principal();
                break;
            case 2:
                System.out.println(CMYK_TO_RGB);
                Tutoriais.tutorial_CMYK_RGB();
                aguardando();
                CMYK_RGB.principal();
                break;
            case 3:
                System.out.println(RGB_TO_HEXADECIMAL);
                Tutoriais.tutorial_RGB_HEXADECIMAL();
                aguardando();
                RGB_Hexadecimal.principal();
                break;
            case 4:
                System.out.println(HEXADECIMAL_TO_RGB);
                Tutoriais.tutorial_HEXADECIMAL_RGB();
                aguardando();
                Hexadecimal_RGB.principal();
                break;
            case 5:
                System.out.println(RGB_TO_HSL);
                Tutoriais.tutorial_RGB_HSL();
                aguardando();
                RGB_HSL.principal();
                break;
            case 6:
                System.out.println(HSL_TO_RGB);
                Tutoriais.tutorial_HSL_RGB();
                aguardando();
                HSL_RGB.principal();
                break;
            case 7:
                System.out.println(RGB_TO_HSV);
                Tutoriais.tutorial_RGB_HSV();
                aguardando();
                RGB_HSV.principal();
                break;
            case 8:
                System.out.println(HSV_TO_RGB);
                Tutoriais.tutorial_HSV_RGB();
                aguardando();
                HSV_RGB.principal();
                break;
            case 9:
                System.out.println(RGB_TO_GREY);
                Tutoriais.tutorial_RGB_Grey();
                aguardando();
                RGB_Grey.principal();
                break;
            case 10:
                System.out.println(HISTORICO);
                aguardando();
                txtr.lerHistorico();
                break;
            case 11:
                System.out.println(CREDITOS);
                aguardando();
                System.out.print("\nColor translator " + Calendar.getInstance().get(Calendar.YEAR));
                System.out.print(" é um software desenvolvido por Henrik Beck www.github.com/henrikbeck95\n");
                break;
            default:
                break;
        }
    }
    
    public static void aguardando() {
        try {
            //Thread.sleep(1500);
            Thread.sleep(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getDateTime() { 
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	Date date = new Date(); 
	return dateFormat.format(date); 
    }
}