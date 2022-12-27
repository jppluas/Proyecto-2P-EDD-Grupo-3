
import java.io.File;
import java.io.IOException;
public class Grupo_03 {
   public static void main(String args[]) throws IOException {
      //Creating a File object for directory
      String ruta="E:/Descargas/Iterador";
      File directoryPath = new File (ruta);
      //List of all files and directories
      File filesList[] = directoryPath.listFiles();
      System.out.println("List of files and directories in directory:"+ ruta);
      for(File file : filesList) {
        if(file.isDirectory()){
            File directory= file;
            File filesList2[] = directory.listFiles();
            System.out.println("List of files and directories in directory:"+file.getName());
            for(File file2 : filesList2){
                System.out.println("File name: "+file2.getName());
                System.out.println("File path: "+file2.getAbsolutePath());
                System.out.println("Size :"+file2.getTotalSpace());
                System.out.println("");
            }
        } else{
        System.out.println("File name: "+file.getName());
        System.out.println("File path: "+file.getAbsolutePath());
        System.out.println("Size :"+file.getTotalSpace());
        System.out.println("");
        }
      }
   }
}
