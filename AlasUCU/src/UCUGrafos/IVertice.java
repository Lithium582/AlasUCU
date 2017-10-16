package UCUGrafos;


import java.util.Collection;
import java.util.LinkedList;

/**
 * 
 * @author Lithium582
 * @param <V> Tipo de dato del Vértice
 * @param <A> Tipo de dato de la Adyacencia (De las relaciones entre los vértices)
 */
public interface IVertice<V,A> {

    IAdyacencia<V,A> buscarAdyacencia(IVertice<V,A> verticeDestino);

    IAdyacencia<V,A> buscarAdyacencia(Comparable etiquetaDestino);

    boolean eliminarAdyacencia(Comparable nomVerticeDestino);

    boolean getActivo();
    
    void setActivo(boolean pActivo);
    
    LinkedList<IAdyacencia<V,A>> getAdyacentes();

    V getDatos();

    Comparable getEtiqueta();

    boolean getVisitado();

    boolean insertarAdyacencia(IVertice<V,A> pVerticeDestino, LinkedList<A> pListaRelaciones);
    
    IVertice<V,A> primerAdyacente();

    void setVisitado(boolean valor);

    void bpf(Collection<Comparable> visitados);
    
    boolean tieneCiclo(TCamino camino);
    
    boolean tieneCiclo(LinkedList<Comparable> camino);
    
    TCaminos todosLosCaminos(Comparable etiquetaDestino, TCamino caminoPrevio, TCaminos losCaminos);
    
}
