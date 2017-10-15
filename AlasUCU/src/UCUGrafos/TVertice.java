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
    
    @Override
    public boolean insertarAdyacencia(IVertice<V,A> pVerticeDestino, LinkedList<A> pListaRelaciones) {
        IAdyacencia objAdyacenciaBuscada = this.buscarAdyacencia(pVerticeDestino.getEtiqueta());
        if (objAdyacenciaBuscada == null) {
            IAdyacencia ady = new TAdyacencia(pVerticeDestino,pListaRelaciones);
            return adyacentes.add(ady);
        } else {
            return objAdyacenciaBuscada.getRelaciones().addAll(pListaRelaciones);
        }
        //return false;
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
    
    @Override
    public void bpf(Collection<Comparable> visitados) {
        visitado = true;
        visitados.add(etiqueta);
        for(IAdyacencia adyActual : adyacentes){
            if(!(adyActual.getVertice().getVisitado()))
            {
                adyActual.getVertice().bpf(visitados);
            }
        }
    }
    
    /**
     * Dado un vértice destino, una estructura del tipo TCamino "caminoPrevio" donde ir adjuntando los vértices incorporados
     * al camino y actualizando en forma acorde el costo total, y una estructura TCaminos "losCaminos" en la que agregar
     * un camino cada vez que se llega al destino
     * @param etiquetaDestino
     * @param caminoPrevio
     * @param losCaminos 
     */
    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaDestino, TCamino caminoPrevio, TCaminos losCaminos){
        //Seteamos con TRÚE
        this.setVisitado(true);
        
        for(IAdyacencia adyacencia : this.getAdyacentes()){
            IVertice destino = adyacencia.getVertice();
            
            boolean visit = destino.getVisitado();
            if(!destino.getVisitado()){
                
                System.out.println("Puto el que lee");
                if(destino.getEtiqueta().equals("06A")){
                    String aaa = "a";
                }
                
                if(destino.getEtiqueta().compareTo(etiquetaDestino) == 0){
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    losCaminos.getCaminos().add(copia);
                } else{
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    //caminoPrevio.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etiquetaDestino, copia, losCaminos);
                }
            }
        }
        
        this.setVisitado(false);
        return losCaminos;
        
    }

    @Override
    public boolean tieneCiclo(TCamino camino) {
       setVisitado(true);
       boolean tieneCiclo = false;
       camino.getOtrosVertices().add(this.etiqueta);
       
       for (IAdyacencia adyacente : adyacentes) {
            IVertice vertAdy = adyacente.getVertice();
            
            if (!vertAdy.getVisitado()) {
                tieneCiclo = vertAdy.tieneCiclo(camino);
                
                if(tieneCiclo) {
                    return true;
                }
            }else{
                if(camino.getOtrosVertices().contains(vertAdy.getEtiqueta())){
                    return true;
                }
            }
        }
       
        camino.getOtrosVertices().remove(this.etiqueta);
        return tieneCiclo;
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
       setVisitado(true);
       boolean tieneCiclo = false;
       camino.add(etiqueta);
       
       for (IAdyacencia adyacente : adyacentes) {
            //camino.agregarAdyacencia(adyacente);
            IVertice vertAdy = adyacente.getVertice();
            if (!vertAdy.getVisitado()) {
                tieneCiclo = vertAdy.tieneCiclo(camino);
                if(tieneCiclo){
                    return true;
                }
            }else{
                if(camino.contains(vertAdy.getEtiqueta())){
                    return true;
                }
            }
        }
       
       camino.remove((etiqueta));
       
        return tieneCiclo;
    }
    
}
