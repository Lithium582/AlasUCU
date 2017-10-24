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
    
    /**
     *
     * @return
     */
    public LinkedList<TCamino> getCaminos(){
        return this.caminos;
    }
    
    /**
     *
     * @return
     */
    public TCamino getCaminoMasCorto(){
        return this.caminoMasCorto;
    }
    
    /**
     *
     */
    public TCaminos(){
        this.caminos = new LinkedList<TCamino>();
        this.caminoMasCorto = null;
    }
    
    /**
     *
     * @param pCamino
     */
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
    
    /**
     *
     * @return 
     */
    public String imprimiMasCortoSTR(){
        if(this.caminoMasCorto != null){
            String strRetorno = this.caminoMasCorto.imprimirEtiquetasStr();
            return strRetorno;
        }
        
        return "";
    }
    
    /**
     * 
     */
    public void imprimirCaminoMasCorto(){
        if(this.caminoMasCorto != null){
            this.caminoMasCorto.imprimirEtiquetas();
        } else {
            System.out.println("");
        }
    }
    
    /**
     *
     */
    public void imprimir(){
        this.caminos.forEach((camino) -> {
            camino.imprimirEtiquetas();
        });
    }
    
    /**
     *
     * @return 
     */
    public String imprimirTodosSTR(){
        String strRetorno = "";
        for(TCamino caminoLambda : this.caminos){
            strRetorno += caminoLambda.imprimirEtiquetasStr() + "\n";
        }
        
        return strRetorno;
    }
}
