/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grupo3.grupo_03.treemap;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author mbravop
 */
public class treemapg3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta="rutaxd";
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
                    System.out.println("Size :"+file2.length());
                    System.out.println("");
                }
            }else{
            System.out.println("File name: "+file.getName());
            System.out.println("File path: "+file.getAbsolutePath());
            System.out.println("Size :"+file.length());
            System.out.println("");
            }
        }
    }
}
