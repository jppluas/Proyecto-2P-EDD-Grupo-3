
package grupo3.grupo_03.treemap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class treemapg3 {
    
    String nomFile;
    double pesoFile;
    NodoTreeMap padre;
    
    class NodoTreeMap {
        ArrayList<File> hijos;
        
        public NodoTreeMap(){
            hijos = new ArrayList<>();
        }
    }
    
    public treemapg3(File archivo){
        this.nomFile = archivo.getName();
        this.pesoFile = archivo.length();
    }
    
    public void anadirHijos(List<File> listaHijos){
        
    }
      
    
    public static void main(String args[]) throws IOException {
        String ruta = "/Users/mbravop03/Desktop/ESPOL/Segundo Semestre/Calculo Vectorial";
        getInfo(ruta);
        
        String pruebaSuma = "/Users/mbravop03/Desktop/ESPOL/Segundo Semestre/Comunicación";
        //System.out.println(sumaCarpeta(pruebaSuma));
    }
   
    public static void getInfo(String ruta){
        File directoryPath = new File (ruta);
        File filesList[] = directoryPath.listFiles();
        System.out.println("List of files and directories in directory: "+ ruta);
        
        
        for(File file : filesList) {
            if(file.isDirectory()){
                System.out.println("Tamano carpeta: " + sumaCarpeta(file.getAbsolutePath()));
                getInfo(file.getAbsolutePath());
            } else {
                System.out.println("File name: "+file.getName());
                System.out.println("File path: "+file.getAbsolutePath());
                System.out.println("Size :"+file.length());
                System.out.println("");
            }    
        }
    }
    
    public static long sumaCarpeta(String ruta){
        File directoryPath = new File(ruta);
        File filesList[] = directoryPath.listFiles();
        
        long contador = 0;
        for(File file : filesList){
            contador+= file.length();
        }
        
        return contador;
    }
}