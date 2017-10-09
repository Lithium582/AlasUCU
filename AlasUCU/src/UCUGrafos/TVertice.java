package UCUGrafos;


import java.util.Collection;
import java.util.LinkedList;

/**
 * 
 * @author Lithium582
 * @param <V> Tipo de dato del Vértice
 * @param <A> Tipo de dato de la Adyacencia (De las relaciones entre los vértices)
 */
public class TVertice<V,A> implements IVertice<V,A>{

    private Comparable etiqueta;
    private LinkedList<IAdyacencia<V,A>> adyacentes;
    private boolean visitado;
    private V datos;

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public LinkedList<IAdyacencia<V,A>> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(V pDato, Comparable pEtiqueta) {
        this.etiqueta = pEtiqueta;
        this.datos = pDato;
        adyacentes = new LinkedList();
        visitado = false;
    }

    @Override
    public boolean getVisitado() {
        return this.visitado;
    }
    
    @Override
    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    @Override
    public IAdyacencia buscarAdyacencia(IVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

/*
    public Double obtenerCostoAdyacencia(IVertice verticeDestino) {
        IAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        
        return Double.MAX_VALUE;
    }
*/

    @Override
    public boolean insertarAdyacencia(IVertice<V,A> pVerticeDestino, LinkedList<A> pListaRelaciones) {
        if (buscarAdyacencia(pVerticeDestino.getEtiqueta()) == null) {
            IAdyacencia ady = new TAdyacencia(pVerticeDestino,pListaRelaciones);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        IAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public IVertice<V,A> primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getVertice();
        }
        return null;
    }

    

    @Override
    public IAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (IAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getVertice().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    @Override
    public V getDatos() {
        return datos;
    }
}
