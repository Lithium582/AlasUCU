/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Lithium582
 */
public class Aeropuerto {
    private final int ID;
    private String nombre;
    private final String ciudad;
    private final String pais;
    private final float latitud;
    private final float longitud;
    private final float altitud;
    private final float zonaHoraria;
    private final Comparable<String> codIATA;
    private final Comparable<String> codICAO;
    //private "ALGO" DST;

    /**
     * Nos devuelve el identificador del aeropuerto.
     * @return ID del aeropuerto.
     */
    public int getID(){
        return this.ID;
    }
    
    /**
     * Nos devuelve el nombre del aeropuerto.
     * @return Nombre
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Nos devuelve el nombre del aeropuerto.
     * @param pNombre Nombre nuevo del Aeropuerto
     */
    public void getNombre(String pNombre) {
        this.nombre = pNombre;
    }

    /**
     * Nos devuelve la ciudad del aeropuerto.
     * @return Ciudad
     */
    public String getCiudad() {
        return this.ciudad;
    }
    
    /**
     * Nos devuelve el pais donde se encuentra el aeropuerto
     * @return Pais
     */
    public String getPais() {
        return this.pais;
    }
    
    /**
     * Nos devuelve la latitud a la que encuentra el aeropuerto
     * @return Latitud
     */
    public float getLatitud() {
        return this.latitud;
    }
    
    /**
     * Nos devuelve la longitud a la que encuentra el aeropuerto
     * @return Longitud
     */
    public float getLongitud() {
        return this.longitud;
    }

    /**
     * Nos devuelve la altitud a la que se encuentra el aeropuerto.
     * @return Altitud
     */
    public float getAltitud() {
        return this.altitud;
    }
    
    /**
     * Nos devuelve la zona horaria a la que pertenece el aeropuerto.
     * @return Zona horaria.
     */
    public float getZonaHoraria() {
        return this.zonaHoraria;
    }

    /**
     * Nos devuelve el código IATA del Aeropuerto
     * @return Código IATA
     */
    public Comparable<String> getCodIATA() {
        return this.codIATA;
    }
    
    /**
     * Nos devuelve el código ICAO del Aeropuerto
     * @return Código ICAO
     */
    public Comparable<String> getCodICAO() {
        return this.codICAO;
    }

    /**
     * Constructor del aeropuerto.
     * @param pID Identificador del aeopuerto
     * @param pNombre Nombre
     * @param pCiudad Ciudad
     * @param pPais Pais
     * @param pLatitud Latitud
     * @param pLongitud Longitud
     * @param pAltitud Altitud
     * @param pCodIATA Código IATA
     * @param pCodICAO Código ICAO
     * @param pZonaHoraria Zona horaria, indicada por un valor de punto flotante.
     */
    public Aeropuerto(int pID, String pNombre, String pCiudad, String pPais, float pLatitud, float pLongitud, float pAltitud, Comparable<String> pCodIATA, Comparable<String> pCodICAO, float pZonaHoraria) {
        this.ID = pID;
        this.nombre = pNombre;
        this.ciudad = pCiudad;
        this.pais = pPais;
        this.latitud = pLatitud;
        this.longitud = pLongitud;
        this.altitud = pAltitud;
        this.zonaHoraria = pZonaHoraria;
        this.codIATA = pCodIATA;
        this.codICAO = pCodICAO;
    }
    
    
    
    
    
    //
    
}