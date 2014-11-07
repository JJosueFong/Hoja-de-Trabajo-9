/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja8;

public interface InterfazGrafo<V,E> {
    public void add(V label);
    public void addEdge(V vtx1, V vtx2, E label);
    public void show();
    public int getIndex(V label);
    public V get(int label);
    public int getEdge(V label1, V label2);
    public boolean contains(V label);
    public int size();
    
}
