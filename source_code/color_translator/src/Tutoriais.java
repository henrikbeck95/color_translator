public class Tutoriais {
    public static void tutorial_RGB_CMYK(){
        separadorInicio();
        tutorial_RGB();
        //valorInvalido();
        separadorFinal();
    }
    
    public static void tutorial_CMYK_RGB(){
        separadorInicio();
        System.out.println("Insira valores entre 0 e 100 para CYAN, MAGENTA, YELLOW e BLACK. Estes valores correspondem a porcentagem '%'");
        System.out.println("Observação: Esta escala de cor é ideal para impressão.");
        //valorInvalido();
        separadorFinal();
    }
    
    public static void tutorial_RGB_HEXADECIMAL(){
        separadorInicio();
        tutorial_RGB();
        //valorInvalido();
        separadorFinal();
    }
    
    public static void tutorial_HEXADECIMAL_RGB(){
        separadorInicio();
        System.out.println("Insira valores entre 0 e F. 0 significa ausencia de cor e f todas as cores (branco)."
                + "\nOs dois primeiros digitos correspondes ao RED, os dois seguintes ao GREEN e os dois últimos ao BLUE.");
        System.out.println("Observação: Esta escala de cor é ideal para codificação de softwares.");
        valorInvalido();
        separadorFinal();
    }
    
    public static void tutorial_RGB_HSL(){
        separadorInicio();
        tutorial_RGB();
        //valorInvalido();
        separadorFinal();
    }
    
    public static void tutorial_HSL_RGB(){
        separadorInicio();
        System.out.println("Insira valores entre 0 e 360 para HUE; e, entre 0 e 100 para SATURATION e LIGHTNESS.");
        System.out.println("Observação: Esta escala de cor é ideal para manipulação do contraste.");
        //valorInvalido();
        separadorFinal();
    }
    
    public static void tutorial_RGB_HSV(){
        separadorInicio();
        tutorial_RGB();
        //valorInvalido();
        separadorFinal();
    }
    
    public static void tutorial_HSV_RGB(){
        separadorInicio();
        System.out.println("Insira valores entre 0 e 360 para HUE; e, entre 0 e 100 para SATURATION e VALUE.");
        System.out.println("Observação: Esta escala de cor é ideal para manipulação da saturação, brilho e tonalidade.");
        //valorInvalido();
        separadorFinal();
    }
    
    public static void tutorial_RGB_Grey(){
        separadorInicio();
        tutorial_RGB();
        //valorInvalido();
        separadorFinal();
    }
    
    public static void separadorInicio(){
        System.out.println("\n---TUTORIAL---");
    }
    
    public static void separadorFinal(){
        System.out.println("---********---\n");
    }
    
    public static void tutorial_RGB(){
        System.out.println("Insira valores entre 0 e 255 para RED, GREEN e BLUE. Estes valores correspondem a escala.");
        System.out.println("Observação: Esta escala de cor é ideal para monitores.");
    }
    
    public static void valorInvalido(){
        System.out.println("Caso seja inserido um valor diferente do intervalo ideal, prosseguiremos com o cálculo, mas já aviso que o resultado será impreciso!");
    }
}