package UCUGrafos;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Lithium582
 */
public class TCamino {
    private IVertice origen;
    //public LinkedList<Comparable> otrosVertices; //Lista de Etiquetas de los vértices
    private ArrayList<Comparable> otrosVertices;
    private LinkedList<IAdyacencia> otrasAdyacencias; //Lista de la adyacencia que conecta el vértice anterior en la lista con el actual
    private Double costoTotal;
    /*
        La primera adyacencia conecta al origen con el primer vértice, y así sucesivamente
    */
    
    /**
     *
     * @return
     */
    public IVertice getOrigen(){
        return this.origen;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Comparable> getOtrosVertices(){
        return this.otrosVertices;
    }
    
    /**
     *
     * @return
     */
    public LinkedList<IAdyacencia> getOtrasAdyacencias(){
        return this.otrasAdyacencias;
    }
    
    /**
     *
     * @param v
     */
    public TCamino(IVertice v){
        this.origen = v;
        this.otrosVertices = new ArrayList<Comparable>();
        this.otrasAdyacencias = new LinkedList<IAdyacencia>();
        this.costoTotal = 0D;
    }
    
    /**
     *
     * @param pObjAdyacencia
     * @param pCosto
     * @return
     */
    public boolean agregarAdyacencia(IAdyacencia pObjAdyacencia, Double pCosto){
        boolean resultado = false;
        if(pObjAdyacencia.getVertice() != null){
            Comparable etiquetaDestino = pObjAdyacencia.getEtiqueta();
            String unStringAAgregar = pObjAdyacencia.getVertice().getDatos().getNombre();
            resultado = otrosVertices.add(etiquetaDestino + "(" + unStringAAgregar + ")");
            
            //Si insertó la etiqueta, insertamos la adyacencia
            if(resultado){
                resultado = resultado && otrasAdyacencias.add(pObjAdyacencia);
            }
            
            this.costoTotal += pCosto;
        }
        
        return resultado;
    }
    
    //Tiene sentido esto?
    //Si se elimina cualquier adyacencia en el medio, el camino podría romperse...
    //Salvo que siempre se elmine el último

    /**
     *
     * @param pObjAdyacencia
     * @return
     */
    public boolean eliminarAdyacencia(IAdyacencia pObjAdyacencia){
        Comparable etiquetaAEliminar = pObjAdyacencia.getEtiqueta();
        
        if(otrosVertices.contains(etiquetaAEliminar)){
            int indice = otrosVertices.indexOf(etiquetaAEliminar);
            otrosVertices.remove(indice);
            otrasAdyacencias.remove(indice);
        }
        
        return false;
    }
    
    /**
     *
     * @return
     */
    public boolean eliminarUltimaAdyacencia(){
        boolean res = false;
        int cantidad = otrosVertices.size();
        res = otrosVertices.remove(cantidad) != null;
        res = res && (otrasAdyacencias.removeLast() != null);
        
        return res;
    }
    
    /**
     *
     * @return
     */
    public Double getCosto(){
        return this.costoTotal;
    }
    
    /**
     *
     * @return
     */
    public String imprimirEtiquetasStr(){
        String resultado = origen.getEtiqueta().toString() + "(" + this.origen.getDatos().getNombre() + ")";
        
        for(Comparable comp : otrosVertices) {
            resultado += " - " + comp.toString();
        }
        
        resultado += " --> $" + String.valueOf(this.costoTotal);
        return resultado;
    }
    
    /**
     *
     */
    public void imprimirEtiquetas(){
        String resultado = origen.getEtiqueta().toString() + "(" + this.origen.getDatos().getNombre() + ")";
        
        for(Comparable comp : otrosVertices) {
            resultado += " - " + comp.toString();
        }
        
        resultado += " --> $" + String.valueOf(this.costoTotal);
        System.out.println(resultado);
    }
    
    /**
     *
     * @return
     */
    public TCamino copiar(){
        IVertice origenCopia = new TVertice(this.origen.getDatos(), this.origen.getEtiqueta());
        TCamino copia = new TCamino(origenCopia);
        origenCopia.getAdyacentes().addAll(this.origen.getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());
        copia.getOtrasAdyacencias().addAll(this.getOtrasAdyacencias());
        copia.costoTotal = this.costoTotal;
        
        return copia;
    }
    
}
