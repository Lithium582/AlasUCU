package UCUGrafos;

import Clases.*;
import java.util.Collection;
import java.util.LinkedList;

/**
 * 
 * @author Lithium582
 */
public interface IVertice {

    /**
     *
     * @param verticeDestino
     * @return
     */
    IAdyacencia buscarAdyacencia(IVertice verticeDestino);

    /**
     *
     * @param etiquetaDestino
     * @return
     */
    IAdyacencia buscarAdyacencia(Comparable etiquetaDestino);

    /**
     *
     * @param nomVerticeDestino
     * @return
     */
    boolean eliminarAdyacencia(Comparable nomVerticeDestino);

    /**
     *
     * @return
     */
    boolean getActivo();
    
    /**
     *
     * @param pActivo
     */
    void setActivo(boolean pActivo);
    
    /**
     *
     * @return
     */
    LinkedList<IAdyacencia> getAdyacentes();

    /**
     *
     * @return
     */
    Aeropuerto getDatos();

    /**
     *
     * @return
     */
    Comparable getEtiqueta();

    /**
     *
     * @return
     */
    boolean getVisitado();

    /**
     *
     * @param pVerticeDestino
     * @param pListaRelaciones
     * @return
     */
    boolean insertarAdyacencia(IVertice pVerticeDestino, LinkedList<IVuelo> pListaRelaciones);
    
    /**
     *
     * @return
     */
    IVertice primerAdyacente();

    /**
     *
     * @param valor
     */
    void setVisitado(boolean valor);

    /**
     *
     * @param visitados
     */
    void bpf(Collection<Comparable> visitados);
    
    /**
     *
     * @param camino
     * @return
     */
    boolean tieneCiclo(TCamino camino);
    
    /**
     *
     * @param camino
     * @return
     */
    boolean tieneCiclo(LinkedList<Comparable> camino);
    
    /**
     *
     * @param etiquetaDestino
     * @param caminoPrevio
     * @param losCaminos
     * @param pCantidadEscalas
     * @param pAerolinea
     * @return
     */
    TCaminos todosLosCaminos(Comparable etiquetaDestino, TCamino caminoPrevio, TCaminos losCaminos, int pCantidadEscalas, Comparable pAerolinea);
    
}
