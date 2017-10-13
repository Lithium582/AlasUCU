package UCUGrafos;

import java.util.LinkedList;

public class TArista<E> implements IArista<E> {

    protected Comparable etiquetaOrigen;
    protected Comparable etiquetaDestino;
    protected LinkedList<E> relaciones;

    public TArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, LinkedList<E> pRelaciones) {
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
    public TArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, E pRelacion) {
        this.etiquetaOrigen = etiquetaOrigen;
        this.etiquetaDestino = etiquetaDestino;
        LinkedList<E> listaRelaciones = new LinkedList<>();
        listaRelaciones.add(pRelacion);
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
    public LinkedList<E> getRelaciones() {
        return relaciones;
    }

    @Override
    public void setRelaciones(LinkedList<E> pRelaciones) {
        this.relaciones = pRelaciones;
    }

    
}
