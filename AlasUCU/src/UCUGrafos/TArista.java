package UCUGrafos;

import Clases.*;
import java.util.LinkedList;

public class TArista implements IArista {

    protected Comparable etiquetaOrigen;
    protected Comparable etiquetaDestino;
    protected LinkedList<IVuelo> relaciones;

    public TArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, LinkedList<IVuelo> pRelaciones) {
        this.etiquetaOrigen = etiquetaOrigen;
        this.etiquetaDestino = etiquetaDestino;
        this.relaciones = pRelaciones;
    }
    
    /**
     * Constructor de la clase Arista
     * @param anOriginTag Etiqueta de origen
     * @param aDestinationTag
     * @param aRelationship
     */
    public TArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, IVuelo pRelacion) {
        this.etiquetaOrigen = etiquetaOrigen;
        this.etiquetaDestino = etiquetaDestino;
        /*LinkedList<E> listaRelaciones = new LinkedList<>();
        listaRelaciones.add(pRelacion);*/
        
        relaciones = new LinkedList<IVuelo>();
        relaciones.add(pRelacion);
    }
    
    @Override
    public Comparable getEtiquetaOrigen() {
        return etiquetaOrigen;
    }

    @Override
    public void setEtiquetaOrigen(Comparable etiquetaOrigen) {
        this.etiquetaOrigen = etiquetaOrigen;
    }

    @Override
    public Comparable getEtiquetaDestino() {
        return etiquetaDestino;
    }

    @Override
    public void setEtiquetaDestino(Comparable etiquetaDestino) {
        this.etiquetaDestino = etiquetaDestino;
    }

    @Override
    public LinkedList<IVuelo> getRelaciones() {
        return relaciones;
    }

    @Override
    public void setRelaciones(LinkedList<IVuelo> pRelaciones) {
        this.relaciones = pRelaciones;
    }

    
}
