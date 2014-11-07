/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja8;

import java.util.Scanner;
/**
 *
 * @author Javier Fong 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        Floyd matriz = new Floyd(); // Matriz de adyacencia
        matriz.shortPath(); 
        int seleccion, opcion; 
        Scanner scan = new Scanner(System.in); //Entrada por teclado
        System.out.println("1. Ruta mas corta ");
        System.out.println("2. Centro");
        System.out.println("3. Modificar grafo");
        System.out.println("4. Fin");
        seleccion = scan.nextInt(); 
        
        // Realizar ciclo mientras la respuesta del usuario no sea 4
        while(seleccion!=4){
            
            if(seleccion==1){
                matriz.shortPath(); 
                System.out.println("Desde:");
                String ciudad1 = scan.next(); 
                System.out.println("Hacia:");
                String ciudad2 = scan.next();
                if(matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)){
                    System.out.println("\nDistancia minima: "+matriz.D.getEdge(ciudad1, ciudad2)+".");
                    if(matriz.D.getEdge(ciudad1, ciudad2)!=10000){
                        System.out.print("RUTA: "+ciudad1);
                        matriz.mostrarIntermedias(matriz.D.getIndex(ciudad1), matriz.D.getIndex(ciudad2));
                        System.out.println(", "+ciudad2);
                    }
                }
            }
            
            else if(seleccion==2){
                matriz.center();
            }
            
            else if(seleccion==3){
                System.out.println("1. Interrupcion en el trafico?");
                System.out.println("2. Nueva conexion?");
                opcion = scan.nextInt();
                if(opcion==1){
                    System.out.println("Desde:");
                    String ciudad1 = scan.next();
                    System.out.println("Hacia:");
                    String ciudad2 = scan.next();
                    if(matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)){
                        matriz.D.addEdge(ciudad1, ciudad2, 10000);
                    }
                }
                else if(opcion==2){
                    System.out.println("Desde:");
                    String ciudad1 = scan.next();
                    System.out.println("Hacia:");
                    String ciudad2 = scan.next();
                    System.out.println("Distancia:");
                    int distancia = scan.nextInt();
                    if(matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)){
                        matriz.D.addEdge(ciudad1, ciudad2, distancia);
                    }
                    else{
                        matriz.D.add(ciudad1);
                        matriz.D.add(ciudad2);
                        matriz.D.addEdge(ciudad1, ciudad2, distancia);
                    }
                }
                matriz.shortPath();
            }
       
            System.out.println("1. Ruta mas corta ");
            System.out.println("2. Centro");
            System.out.println("3. Modificar grafo");
            System.out.println("4. Fin");
            seleccion = scan.nextInt();
        }
        
    }
}
