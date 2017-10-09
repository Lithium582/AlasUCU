package UCUGrafos;

import java.util.LinkedList;

/**
 * 
 * @author Lithium582
 * @param <V> Tipo de dato del Vértice
 * @param <A> Tipo de dato de la Adyacencia (De las relaciones entre los vértices)
 */

public class TAdyacencia<V,A> implements IAdyacencia<V,A> {

    private final IVertice vertice;
    private LinkedList<A> relaciones;
    
    @Override
    public Comparable getEtiqueta() {
        return vertice.getEtiqueta();
    }
    
    @Override
    public LinkedList<A> getRelaciones(){
        return this.relaciones;
    }

    @Override
    public IVertice<V,A> getVertice() {
        return vertice;
    }
    
    @Override
    public boolean agregarRelacion(A pRelacion){
        boolean b = this.relaciones.contains(pRelacion);
        
        if(b){ //Si lo contiene, retorno false
           return !b; 
        }else{
            b = this.relaciones.add(pRelacion);
        }
        
        return b; //Retorno true si la adición funcionó
    }

    public TAdyacencia(IVertice<V,A> pVertice, LinkedList<A> pRelaciones) {
        this.vertice = pVertice;
        this.relaciones = pRelaciones;
    }
}
