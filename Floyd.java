/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.



/**
 *
 * @author Mario Barrinetos
 */
package hoja8;
import java.io.IOException;

public class Floyd {
    
    Archivo a= new Archivo();
    InterfazGrafo D;
    int[][] P;
    int[] max;
    int centro;
    int minimo=10000;
    
    public Floyd(){
        
        try {
            a.obtenerArchivo("C:\\Users\\Colegio\\Desktop\\UVG\\Segundo Año\\Ciclo 2\\Algoritmos y Estructuras de Datos\\hoja8\\src\\hoja8\\ConexionesGuatemala.txt");
            a.arregloNombres(); // Nombre de los nodos
            D = a.matrizCostos(); // Peso de los arcos entre nodos
            P = new int[25][25]; // Matriz de nodos intermedios
            max = new int[25];
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(int n=0;n<a.grafo.size();n++){
            for(int m=0;m<a.grafo.size();m++){
                P[n][m]=10000;
            }
        }
    }
    
    public void shortPath(){
        for(int k=0;k<D.size();k++){
            for(int i=0;i<D.size();i++){
                for(int j=0;j<D.size();j++){
                    if(D.getEdge(D.get(i),D.get(j))>(D.getEdge(D.get(i), D.get(k))+D.getEdge(D.get(k), D.get(j)))){
                        D.addEdge(D.get(i), D.get(j), (D.getEdge(D.get(i), D.get(k))+D.getEdge(D.get(k), D.get(j))));
                        P[i][j]=k;
                    }
                }
            }
        }
        
    }
    
   public void center(){
        shortPath();
        int n=0;       
        for(int i=0;i<D.size();i++){
            for(int j=0;j<D.size()-1;j++){
                int num1=D.getEdge(D.get(j), D.get(i));
                n=j;
                n++;
                int num2=D.getEdge(D.get(n), D.get(i));
                if(num1>num2){
                    max[i]=num1;
                }
                else{
                    max[i]=num2;
                }
            }
            n++;
        }
        for(int i=0;i<D.size();i++){
            int num1=max[i];
            if(num1<minimo){
                centro=i;
                minimo=num1;
            }
        }
        System.out.println("\nCentro: "+D.get(centro)+"\n");
        
    }
    
    public void mostrarIntermedias(int num1, int num2){
        if(P[num1][num2]!=10000){
            mostrarIntermedias(num1,P[num1][num2]);
            System.out.print(", "+D.get(P[num1][num2]));
            mostrarIntermedias(P[num1][num2],num2);
        }
    }
}
