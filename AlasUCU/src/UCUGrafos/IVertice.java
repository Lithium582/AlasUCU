package UCUGrafos;

import Clases.*;
import java.util.Collection;
import java.util.LinkedList;

/**
 * 
 * @author Lithium582
 */
public interface IVertice {

    IAdyacencia buscarAdyacencia(IVertice verticeDestino);

    IAdyacencia buscarAdyacencia(Comparable etiquetaDestino);

    boolean eliminarAdyacencia(Comparable nomVerticeDestino);

    boolean getActivo();
    
    void setActivo(boolean pActivo);
    
    LinkedList<IAdyacencia> getAdyacentes();

    Aeropuerto getDatos();

    Comparable getEtiqueta();

    boolean getVisitado();

    boolean insertarAdyacencia(IVertice pVerticeDestino, LinkedList<IVuelo> pListaRelaciones);
    
    IVertice primerAdyacente();

    void setVisitado(boolean valor);

    void bpf(Collection<Comparable> visitados);
    
    boolean tieneCiclo(TCamino camino);
    
    boolean tieneCiclo(LinkedList<Comparable> camino);
    
    TCaminos todosLosCaminos(Comparable etiquetaDestino, TCamino caminoPrevio, TCaminos losCaminos, int pCantidadEscalas, Comparable pAerolinea);
    
}
