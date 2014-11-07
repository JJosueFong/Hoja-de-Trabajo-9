/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja8;
import java.io.*;

/**
 *
 * @author Mario Barrientos
 */
public class Archivo{
    
    File archivo;
    FileReader fr;
    BufferedReader br;
    InterfazGrafo grafo = new GraphMatrix();

    
    
    public void obtenerArchivo(String direccion) throws FileNotFoundException{
       archivo=new File(direccion); 
    }  
    
    public InterfazGrafo arregloNombres() throws IOException{
         fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.add(tmp[0]);
            grafo.add(tmp[1]);
        }
        return grafo;
    }
    
   public InterfazGrafo matrizCostos() throws IOException{
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        String linea;

        while((linea=br.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.addEdge(tmp[0], tmp[1], tmp[2]);
        }
        return grafo;
    }
    

}
