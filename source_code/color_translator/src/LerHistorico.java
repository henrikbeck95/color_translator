import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JTextArea;

public class LerHistorico {
    private File fileTXT;
    
    //public LerHistorico(JTextArea leitura){
    public void lerHistorico(){
        fileTXT = new File ("src/Historico.txt");
        
        System.out.println("\n---Início da leitura---");
        
        try{
            FileReader read = new FileReader(fileTXT);
            BufferedReader br = new BufferedReader(read);
            
            String line, temp = "";
            
            for (int i = 0; (line = br.readLine()) != null; i++){
                System.out.println(line);
                //leitura.setText(line + "\n");
                temp += (line + "\n");
            }
            
            System.out.println(temp);
            //leitura.setText(temp);
            
            /*
            while( (line = br.readLine()) != null){
                System.out.println(line);
                //JOptionPane.showMessageDialog(null, line);
                leitura.setText(line);
            }
            */
            
            System.out.println("---Fim da leitura---");
            
            read.close();
            br.close();
        }catch(Exception e){
            System.out.println("Erro de leitura!");
        }
    }
}