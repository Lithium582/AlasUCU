/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Lithium582
 */
public class Vuelo implements IVuelo {
    private static int idVuelo = 0;
    
    private final Comparable<Integer> ID;
    private final Comparable<String> origen;
    private final Comparable<String> destino;
    private Comparable<String> aerolinea;
    private double costo;

    /**
     *
     * @param pOrigen
     * @param pDestino
     * @param pCosto
     * @param pAerolinea
     */
    public Vuelo(Comparable<String> pOrigen, Comparable<String> pDestino, double pCosto, Comparable<String> pAerolinea) {
        this.ID = idVuelo++;
        
        this.origen = pOrigen;
        this.destino = pDestino;
        this.costo = pCosto;
        this.aerolinea = pAerolinea;
    }

    /**
     *
     * @return
     */
    @Override
    public Comparable<Integer> getID() {
        return this.ID;
    }

    /**
     *
     * @return
     */
    @Override
    public Comparable<String> getOrigen() {
        return this.origen;
    }
    
    /**
     *
     * @return
     */
    @Override
    public Comparable<String> getDestino() {
        return this.destino;
    }
    
    /**
     *
     * @return
     */
    @Override
    public double getCosto(){
        return this.costo;
    }
    
    /**
     *
     * @param nuevoCosto
     */
    @Override
    public void setCosto(float pNuevoCosto){
        this.costo = pNuevoCosto;
    }
    
    @Override
    public Comparable<String> getAerolinea() {
        return this.aerolinea;
    }
    
    @Override
    public void setAerolinea(Comparable<String> pNuevaAerolinea){
        this.aerolinea = pNuevaAerolinea;
    }
    
    @Override
    public boolean equals(Object anObject){
        if(anObject instanceof Vuelo){
            return this.ID == ((Vuelo)anObject).ID;
        }
        
        return false;
    }
    
}
