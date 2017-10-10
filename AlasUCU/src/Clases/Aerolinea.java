/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import UCUGrafos.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Lithium582
 */
public class Aerolinea {
    
    // <editor-fold defaultstate="extended" desc="Atributos">
    public static Aerolinea instancia;
    private TGrafoDirigido<Aeropuerto,Vuelo> _grafo;
    // </editor-fold>
    
    private Aerolinea(){
        this._grafo = new TGrafoDirigido();
    }
    
    public Aerolinea getAerolinea(){
        if(instancia == null){
            instancia = new Aerolinea();
        }
        
        return instancia;
    }
    
    public double[][] obtenerFloyd(Date pFechaDesde){
        double[][] matrizCostos = this.obtenerMatrizCostos(pFechaDesde);
        double[][] matrizFloyd = this._grafo.floyd(matrizCostos);
        
        return matrizFloyd;
    }
    
    public double[][] obtenerExcentricidad(Date pFechaDesde, Comparable pEtiqueta){
        double[][] matrizCostos = this.obtenerMatrizCostos(pFechaDesde);
        double[][] matrizFloyd = this._grafo.floyd(matrizCostos);
        Comparable excentricidad = this._grafo.obtenerExcentricidad(pEtiqueta,matrizFloyd);
        return matrizFloyd;
    }
    
    /**
     * Método auxiliar que, dada una string con formato de fecha, la convierte
     * en un dato de tipo Date.
     *
     * @param pFecha Fecha a castear.
     * @return Fecha en formato Date.
    *
     */
    private Date FormatoFecha(String pFecha) throws ParseException {
        try {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = dt.parse(pFecha);
            return date;
        } catch (ParseException e) {
            throw e;
            //System.err.println("Error de parsing: " + e.getMessage());
        }
    }

    /**
     * Método auxiliar que, dada una string con formato de fecha, la convierte
     * en un dato de tipo Date.
     *
     * @param pFecha Fecha a castear.
     * @return Fecha en formato Date.
    *
     */
    private String RemoverCaracteres(String pCadena) {
        String caracteresRaros = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        String caracteresOriginales = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";

        String strRetorno = pCadena;
        for (int i = 0; i < caracteresRaros.length(); i++) {
            // Reemplazamos los caracteres especiales.
            strRetorno = strRetorno.replace(caracteresRaros.charAt(i), caracteresOriginales.charAt(i));
        }
        return strRetorno;
    }
    
    private double[][] obtenerMatrizCostos(Date pFechaOrigen) {
        Map<Comparable, TVertice<Aeropuerto,Vuelo>> vertices = this._grafo.getVertices();
        int cantidadVertices = vertices.size();
        double[][] matrizCostos = new double[cantidadVertices][cantidadVertices];

        for (int i = 0; i < matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos.length; j++) {
                if (i == j) {
                    matrizCostos[i][j] = -1d;
                } else {
                    matrizCostos[i][j] = Double.MAX_VALUE;
                }
            }
        }

        int i = 0;

        Set<Comparable> etiquetasVertices = vertices.keySet();
        Object[] VerticesIArr = etiquetasVertices.toArray();
        Object[] VerticesJArr = etiquetasVertices.toArray();

        while (i < cantidadVertices) {
            int j = 0;
            while (j < cantidadVertices) {
                TVertice elemVerticeI = vertices.get(VerticesIArr[i]);
                TVertice elemVerticeJ = vertices.get(VerticesJArr[j]);

                if (!elemVerticeI.getEtiqueta().equals(elemVerticeJ.getEtiqueta())) {
                    TVertice verticeI = (TVertice) elemVerticeI;
                    TVertice verticeJ = (TVertice) elemVerticeJ;
                    //Double costoAdyacencia = verticeI.obtenerCostoAdyacencia(verticeJ);
                    
                    IAdyacencia abcccc = verticeI.buscarAdyacencia(verticeJ);
                    Object lista = abcccc.getRelaciones();
                    LinkedList<Vuelo> lista2 = (LinkedList<Vuelo>)lista;
                    double costoMinimo = Double.MAX_VALUE;
                    
                    for(Vuelo objVueloActual : lista2){
                        if(objVueloActual.getFechaPartida().compareTo(pFechaOrigen) < 0){
                            if(objVueloActual.getCosto() < costoMinimo){
                                costoMinimo = objVueloActual.getCosto();
                            }
                        }
                    }
                    
                    //matrizCostos[i][j] = costoAdyacencia;
                    matrizCostos[i][j] = costoMinimo;
                }
                j++;
            }
            i++;
        }
        return matrizCostos;
    }
    
    
}
