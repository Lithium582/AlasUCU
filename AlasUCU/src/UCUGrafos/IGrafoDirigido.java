package UCUGrafos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * 
 * @author Lithium582
 * @param <V> Tipo de dato del Vértice
 * @param <A> Tipo de dato de la Adyacencia (De las relaciones entre los vértices)
 */
public interface IGrafoDirigido<V,A> {

    
    /**
     * @return Etiqueta del centro del grafo
     */
    //Comparable centroDelGrafo();

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino.
     * En caso de no existir la arista, retorna falso. En caso de que las
     * etiquetas sean invalidas (no existe el vertice origen o el destino), retorna falso.
     */
    boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino);

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el vertice, retorna falso. En caso de que la etiqueta sea
     * invalida, retorna false.
     *
     */
    boolean eliminarVertice(Comparable nombreVertice);

    /**
     * Metodo encargado de verificar la existencia de una arista. Las
     * etiquetas pasadas por parametro deben ser validas (o sea, los vértices origen y destino deben existir en el grafo).
     *
     * @return True si existe la arista, false en caso contrario
     */
    //boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino);

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    boolean existeVertice(Comparable unaEtiqueta);

    /**
     *ejecuta el algoritmo de Floyd en el grafo, para hallar los caminos mínimos entre todos los pares de vértices. 
	  * @return una matriz de n x n (n = cantidad de vértices del grafo) con los costos de los caminos mínimos. 
     */
    double [][] floyd(Double[][] pC);
    
    int obtenerPosicionEnElHashMap(Comparable pComp);
    
    Comparable obtenerEtiquetaPorPosicion(int pPosicion);
    
    ArrayList<Double[][]> floydPink(Double[][] pC);
    
    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    boolean insertarVertice(IVertice vertice);

    void cargarGrafo(Collection<IVertice<V,A>> vertices, Collection<IArista<A>> aristas);
    
    Comparable obtenerExcentricidad(Comparable etiquetaVertice, double[][] pFloyd);

    boolean contieneCiclos();
    
    boolean insertarArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, Comparable costo);
    
    Collection<Comparable> bpf();
    
    Collection<Comparable> bpf(Comparable etiquetaOrigen);
    
    Collection<Comparable> bpf(TVertice verticeOrigen);
    
    TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino);
    
    boolean tieneCiclo(TCamino camino);
    
    boolean tieneCiclo();
    
    boolean tieneCiclo(Comparable etiquetaOrigen);
    
    public Map<Comparable, IVertice<V,A>> getVertices();
    
    void desvisitarVertices();
}
