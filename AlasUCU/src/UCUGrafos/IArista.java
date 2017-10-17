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

    LinkedList<IVuelo> getRelaciones();

    Comparable getEtiquetaDestino();

    Comparable getEtiquetaOrigen();
    
    void setEtiquetaDestino(Comparable etiquetaDestino);

    void setEtiquetaOrigen(Comparable etiquetaOrigen);

    void setRelaciones(LinkedList<IVuelo> pRelaciones);
}
