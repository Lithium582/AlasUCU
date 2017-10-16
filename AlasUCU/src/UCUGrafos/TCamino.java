package UCUGrafos;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Lithium582
 */
public class TCamino<V,A> {
    private IVertice<V,A> origen;
    //public LinkedList<Comparable> otrosVertices; //Lista de Etiquetas de los vértices
    private ArrayList<Comparable> otrosVertices;
    private LinkedList<IAdyacencia<V,A>> otrasAdyacencias; //Lista de la adyacencia que conecta el vértice anterior en la lista con el actual
    /*
        La primera adyacencia conecta al origen con el primer vértice, y así sucesivamente
    */
    
    public IVertice<V,A> getOrigen(){
        return this.origen;
    }
    
    public ArrayList<Comparable> getOtrosVertices(){
        return this.otrosVertices;
    }
    
    public LinkedList<IAdyacencia<V,A>> getOtrasAdyacencias(){
        return this.otrasAdyacencias;
    }
    
    public TCamino(IVertice<V,A> v){
        this.origen = v;
        this.otrosVertices = new ArrayList<Comparable>();
        this.otrasAdyacencias = new LinkedList<IAdyacencia<V,A>>();
    }
    
    public boolean agregarAdyacencia(IAdyacencia pObjAdyacencia){
        boolean resultado = false;
        if(pObjAdyacencia.getVertice() != null){
            Comparable etiquetaDestino = pObjAdyacencia.getEtiqueta();
            
            resultado = otrosVertices.add(etiquetaDestino);
            
            //Si insertó la etiqueta, insertamos la adyacencia
            if(resultado){
                resultado = resultado && otrasAdyacencias.add(pObjAdyacencia);
            }
        }
        
        return resultado;
    }
    
    //Tiene sentido esto?
    //Si se elimina cualquier adyacencia en el medio, el camino podría romperse...
    //Salvo que siempre se elmine el último
    public boolean eliminarAdyacencia(IAdyacencia pObjAdyacencia){
        Comparable etiquetaAEliminar = pObjAdyacencia.getEtiqueta();
        
        if(otrosVertices.contains(etiquetaAEliminar)){
            int indice = otrosVertices.indexOf(etiquetaAEliminar);
            otrosVertices.remove(indice);
            otrasAdyacencias.remove(indice);
        }
        
        return false;
    }
    
    public boolean eliminarUltimaAdyacencia(){
        boolean res = false;
        int cantidad = otrosVertices.size();
        res = otrosVertices.remove(cantidad) != null;
        res = res && (otrasAdyacencias.removeLast() != null);
        
        return res;
    }
    
    public void imprimirEtiquetas(){
        System.out.println( "\n" + origen.getEtiqueta());
        
        ArrayList<Double[][]> nuevo = new ArrayList();
        
        for(Comparable comp : otrosVertices){
            System.out.println(comp.toString());
        }
    }
    
    public String imprimirEtiquetasStr(){
        String resultado = "\n" + origen.getEtiqueta();
        
        for(Comparable comp : otrosVertices){
            resultado += ", " + comp.toString();
        }
        
        return resultado;
    }
    
    public TCamino copiar(){
        IVertice<V,A> origenCopia = new TVertice(this.origen.getDatos(), this.origen.getEtiqueta());
        TCamino copia = new TCamino(origenCopia);
        origenCopia.getAdyacentes().addAll(this.origen.getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());
        copia.getOtrasAdyacencias().addAll(this.getOtrasAdyacencias());
        
        return copia;
    }
    
}
