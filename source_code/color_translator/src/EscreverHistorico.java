import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscreverHistorico {
    private File fileTXT;
    
    public EscreverHistorico(){
        fileTXT = new File("src/Historico.txt");
    }
    
    public void writeTestTrue(String text){
        try{
            FileWriter fw = null;
            fw = new FileWriter(fileTXT, true); //True adiciona uma linha. False sobrescreve o que já tinha.
            fw.write(text + "\n");
            fw.close();
        }catch (IOException ex){
            Logger.getLogger(EscreverHistorico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeTestFalse(String text){
        try{
            FileWriter fw = null;
            fw = new FileWriter(fileTXT, false); //True adiciona uma linha. False sobrescreve o que já tinha.
            fw.write(text + "\n");
            fw.close();
        }catch (IOException ex){
            Logger.getLogger(EscreverHistorico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}