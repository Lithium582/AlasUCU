/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCUGrafos;

import java.util.LinkedList;

/**
 *
 * @author Lithium582
 */
public class TCaminos<V,A> {
    private final LinkedList<TCamino<V,A>> caminos;
    
    public LinkedList<TCamino<V,A>> getCaminos(){
        return this.caminos;
    }
    
    public TCaminos(){
        this.caminos = new LinkedList<TCamino<V,A>>();
    }
    
    public void imprimir(){
        this.caminos.forEach((camino) -> {
            camino.imprimirEtiquetas();
        });
    }
}
