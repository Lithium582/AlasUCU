package UCUGrafos;

import java.util.LinkedList;

/**
 * 
 * @author Lithium582
 * @param <V> Tipo de dato del Vértice
 * @param <A> Tipo de dato de la Adyacencia (De las relaciones entre los vértices)
 */
public interface IAdyacencia<V,A> {
    /**
     * Retorna el vértice al que apunta la adyacencia
     * @return 
     */
    IVertice<V,A> getVertice();
    
    /**
     * Retorna las relaciones que representa la adyacencia
     * @return 
     */
    LinkedList<A> getRelaciones();
    
    /**
     * Retorna la etiqueta del vértice al que apunta la adyacencia
     * @return 
     */
    Comparable getEtiqueta();
    
    /**
     * Agrega una relación a la lista de relaciones de la adyacencia
     * @param pRelacion 
     */
    boolean agregarRelacion(A pRelacion);
    
}
