package UCUGrafos;

import Clases.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * 
 * @author Lithium582
 */
public interface IGrafoDirigido {

    
    /**
     * @return Etiqueta del centro del grafo
     */
    //Comparable centroDelGrafo();

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino.
     * En caso de no existir la arista, retorna falso. En caso de que las
     * etiquetas sean invalidas (no existe el vertice origen o el destino), retorna falso.
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return 
     */
    boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino);

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el vertice, retorna falso. En caso de que la etiqueta sea
     * invalida, retorna false.
     *
     * @param nombreVertice
     * @return 
     */
    boolean eliminarVertice(Comparable nombreVertice);

    IVertice buscarVertice(Comparable unaEtiqueta);
    
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
     *
     * @param pComp
     * @return
     */
    int obtenerPosicionEnElHashMap(Comparable pComp);
    
    /**
     *
     * @param pPosicion
     * @return
     */
    Comparable obtenerEtiquetaPorPosicion(int pPosicion);
    
    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como parametro debe ser valida.
     *
     * @param vertice
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    boolean insertarVertice(IVertice vertice);

    /**
     *
     * @param vertices
     * @param aristas
     */
    void cargarGrafo(Collection<IVertice> vertices, Collection<IArista> aristas);
    
    /**
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @param costo
     * @return
     */
    boolean insertarArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, Comparable costo);
    
    /**
     * 
     */
    boolean insertarArista(IArista arista);
    
    /**
     *
     * @return
     */
    Collection<Comparable> bpf();
    
    /**
     *
     * @param etiquetaOrigen
     * @return
     */
    Collection<Comparable> bpf(Comparable etiquetaOrigen);
    
    /**
     *
     * @param verticeOrigen
     * @return
     */
    Collection<Comparable> bpf(TVertice verticeOrigen);
    
    /**
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @param pCantidadEscalas
     * @param pAerolinea
     * @return
     */
    TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino, int pCantidadEscalas, Comparable pAerolinea);
    
    /**
     *
     * @param camino
     * @return
     */
    boolean tieneCiclo(TCamino camino);
    
    /**
     *
     * @return
     */
    boolean tieneCiclo();
    
    /**
     *
     * @param etiquetaOrigen
     * @return
     */
    boolean tieneCiclo(Comparable etiquetaOrigen);
    
    /**
     *
     * @return
     */
    public Map<Comparable, IVertice> getVertices();
    
    /**
     *
     */
    void desvisitarVertices();
}
