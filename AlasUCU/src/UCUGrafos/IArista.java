package UCUGrafos;

import Clases.*;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Lithium582
 */
public interface IArista {

    /**
     *
     * @return
     */
    LinkedList<IVuelo> getRelaciones();

    /**
     *
     * @return
     */
    Comparable getEtiquetaDestino();

    /**
     *
     * @return
     */
    Comparable getEtiquetaOrigen();
    
    /**
     *
     * @param etiquetaDestino
     */
    void setEtiquetaDestino(Comparable etiquetaDestino);

    /**
     *
     * @param etiquetaOrigen
     */
    void setEtiquetaOrigen(Comparable etiquetaOrigen);

    /**
     *
     * @param pRelaciones
     */
    void setRelaciones(LinkedList<IVuelo> pRelaciones);
}
