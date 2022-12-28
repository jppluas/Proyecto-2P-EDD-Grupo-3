
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
        String ruta = "/Users/mbravop03/Desktop/ESPOL/Primer Semestre/Fundamentos de Programación/Segundo Parcial";
        getInfo(ruta);
    }
   
    public static void getInfo(String ruta){
        File directoryPath = new File (ruta);
        File filesList[] = directoryPath.listFiles();
        System.out.println("List of files and directories in directory: "+ ruta);
        for(File file : filesList) {
            if(file.isDirectory()){
                getInfo(file.getAbsolutePath());
            } else {
                System.out.println("File name: "+file.getName());
                System.out.println("File path: "+file.getAbsolutePath());
                System.out.println("Size :"+file.length());
                System.out.println("");
            }    
        }
    }
}