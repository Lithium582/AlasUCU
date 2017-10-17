package UCUGrafos;

import Clases.*;
import java.util.LinkedList;

/**
 * 
 * @author Lithium582
 * @param <V> Tipo de dato del Vértice
 * @param <A> Tipo de dato de la Adyacencia (De las relaciones entre los vértices)
 */

public class TAdyacencia implements IAdyacencia {

    private final IVertice vertice;
    private LinkedList<IVuelo> relaciones;
    
    @Override
    public Comparable getEtiqueta() {
        return vertice.getEtiqueta();
    }
    
    @Override
    public LinkedList<IVuelo> getRelaciones(){
        return this.relaciones;
    }

    @Override
    public IVertice getVertice() {
        return vertice;
    }
    
    @Override
    public boolean agregarRelacion(IVuelo pRelacion){
        boolean b = this.relaciones.contains(pRelacion);
        
        if(b){ //Si lo contiene, retorno false
           return !b; 
        }else{
            b = this.relaciones.add(pRelacion);
        }
        
        return b; //Retorno true si la adición funcionó
    }

    public TAdyacencia(IVertice pVertice, LinkedList<IVuelo> pRelaciones) {
        this.vertice = pVertice;
        this.relaciones = pRelaciones;
    }
}
