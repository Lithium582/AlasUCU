/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCUGrafos;

import Clases.*;
import java.util.LinkedList;

/**
 *
 * @author Lithium582
 */
public class TCaminos {
    private final LinkedList<TCamino> caminos;
    private TCamino caminoMasCorto;
    
    public LinkedList<TCamino> getCaminos(){
        return this.caminos;
    }
    
    public TCaminos(){
        this.caminos = new LinkedList<TCamino>();
        this.caminoMasCorto = null;
    }
    
    public void agregarCamino(TCamino pCamino) {
        this.caminos.add(pCamino);
        if(this.caminoMasCorto == null) {
            this.caminoMasCorto = pCamino;
        } else {
            if(pCamino.getCosto() < this.caminoMasCorto.getCosto()) {
                this.caminoMasCorto = pCamino;
            }
        }
    }
    
    public TCamino getCaminoMasCorto(){
        return this.caminoMasCorto;
    }
    
    public void imprimir(){
        this.caminos.forEach((camino) -> {
            camino.imprimirEtiquetas();
        });
    }
}
