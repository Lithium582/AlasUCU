package UCUGrafos;

import Clases.*;
import java.util.LinkedList;

/**
 *
 * @author Lithium582
 */
public class TArista implements IArista {

    /**
     *
     */
    protected Comparable etiquetaOrigen;

    /**
     *
     */
    protected Comparable etiquetaDestino;

    /**
     *
     */
    protected LinkedList<IVuelo> relaciones;

    /**
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @param pRelaciones
     */
    public TArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, LinkedList<IVuelo> pRelaciones) {
        this.etiquetaOrigen = etiquetaOrigen;
        this.etiquetaDestino = etiquetaDestino;
        this.relaciones = pRelaciones;
    }
    
    /**
     * Constructor de la clase Arista
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @param pRelacion
     */
    public TArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, IVuelo pRelacion) {
        this.etiquetaOrigen = etiquetaOrigen;
        this.etiquetaDestino = etiquetaDestino;
        /*LinkedList<E> listaRelaciones = new LinkedList<>();
        listaRelaciones.add(pRelacion);*/
        
        relaciones = new LinkedList<IVuelo>();
        relaciones.add(pRelacion);
    }
    
    /**
     *
     * @return
     */
    @Override
    public Comparable getEtiquetaOrigen() {
        return etiquetaOrigen;
    }

    /**
     *
     * @param etiquetaOrigen
     */
    @Override
    public void setEtiquetaOrigen(Comparable etiquetaOrigen) {
        this.etiquetaOrigen = etiquetaOrigen;
    }

    /**
     *
     * @return
     */
    @Override
    public Comparable getEtiquetaDestino() {
        return etiquetaDestino;
    }

    /**
     *
     * @param etiquetaDestino
     */
    @Override
    public void setEtiquetaDestino(Comparable etiquetaDestino) {
        this.etiquetaDestino = etiquetaDestino;
    }

    /**
     *
     * @return
     */
    @Override
    public LinkedList<IVuelo> getRelaciones() {
        return relaciones;
    }

    /**
     *
     * @param pRelaciones
     */
    @Override
    public void setRelaciones(LinkedList<IVuelo> pRelaciones) {
        this.relaciones = pRelaciones;
    }

    
}
