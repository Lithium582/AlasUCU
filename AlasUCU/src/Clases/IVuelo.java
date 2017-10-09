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
public interface IVuelo {
    /**
     * Nos devuelve el identificador del vuelo en cuestion.
     * @return ID de vuelo.
     */
    public Comparable<Integer> getID();

    /**
     * Nos devuelve la ciudad de origen de dicho vuelo.
     * @return Origen.
     */
    public Comparable<String> getOrigen();
    
    /**
     * Nos devuelve el destino del vuelo.
     * @return Destino.
     */
    public Comparable<String> getDestino();
    
    /**
     * Nos devuelve el costo del viaje.
     * @return Costo.
     */
    public double getCosto();
    
    /**
     * Nos permite asignarle un nuevo costo al viaje.
     * @param pCosto Nuevo costo.
     */
    public void setCosto(float pCosto);
    
    /**
     * Nos devuelve la fecha en que parte el vuelo.
     * @return Fecha de partida.
     */
    public Date getFechaPartida();
    
    /**
     * Nos permite asignarle una nueva fecha de partida al vuelo.
     * @param nuevaFecha Nueva fecha de partida.
     */
    public void setFechaPartida(Date nuevaFecha);
    
    /**
     * Retorna la fecha en que llega el vuelo a destino
     * @return Fecha de llegada
     */
    public Date getFechaLlegada();
    
    /**
     * Asigna una nueva fecha de llegada al vuelo
     * @param nuevaFecha Nueva fecha de llegada
     */
    public void setFechaLlegada(Date nuevaFecha);
}
