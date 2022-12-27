
package grupo3.grupo_03.treemap;
import java.io.File;
import java.io.IOException;
public class treemapg3 {
   public static void main(String args[]) throws IOException {
      //Creating a File object for directory
      String ruta="E:/Descargas/Heap";
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