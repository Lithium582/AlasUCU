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
    private double costo;
    private Date fechaPartida;
    private Date fechaLlegada;

    /**
     *
     * @param pOrigen
     * @param pDestino
     * @param pCosto
     * @param pFechaPartida
     * @param pFechaLlegada
     */
    public Vuelo(Comparable<String> pOrigen, Comparable<String> pDestino, double pCosto, Date pFechaPartida, Date pFechaLlegada) {
        this.ID = idVuelo++;
        
        this.origen = pOrigen;
        this.destino = pDestino;
        this.costo = pCosto;
        this.fechaPartida = pFechaPartida;
        this.fechaLlegada = pFechaLlegada;
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
     * @return
     */
    @Override
    public Date getFechaPartida(){
        return this.fechaPartida;
    }
    
    /**
     *
     * @param nuevaFecha
     */
    @Override
    public void setFechaPartida(Date nuevaFecha){
        this.fechaPartida = nuevaFecha;
    }
    
    /**
     *
     * @return
     */
    @Override
    public Date getFechaLlegada(){
        return this.fechaLlegada;
    }
    
    /**
     *
     * @param nuevaFecha
     */
    @Override
    public void setFechaLlegada(Date nuevaFecha){
        this.fechaLlegada = nuevaFecha;
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
    public boolean equals(Object anObject){
        if(anObject instanceof Vuelo){
            return this.ID == ((Vuelo)anObject).ID;
        }
        
        return false;
    }
}
