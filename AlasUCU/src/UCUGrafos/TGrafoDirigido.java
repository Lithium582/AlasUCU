package UCUGrafos;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * @author Lithium582
 * @param <V> Tipo de dato del Vértice
 * @param <A> Tipo de dato de la Adyacencia (De las relaciones entre los vértices)
 */
public class TGrafoDirigido<V,A> implements IGrafoDirigido<V,A> {

    private Map<Comparable, IVertice<V,A>> vertices; //Vértices del grafo, con el tipo del Vértice y de sus Adyacencias
    Double[][] pinkFloyd; //No sé si esto tiene sentido
    
    public TGrafoDirigido(){
        this.vertices = new HashMap<>();
        this.pinkFloyd = null;
    }
    
    public TGrafoDirigido(Collection<IVertice<V,A>> vertices, Collection<IArista<A>> aristas) {
        this.vertices = new HashMap<>();
        this.pinkFloyd = null;
        String a = "";
        
        this.cargarGrafo(vertices,aristas);
    }
    
    @Override
    public void cargarGrafo(Collection<IVertice<V,A>> vertices, Collection<IArista<A>> aristas){
        for (IVertice<V,A> vertice : vertices) {
            insertarVertice(vertice);
        }
        
        for (IArista<A> arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino.
     * En caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean inv�lidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            IVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     */
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las
     * etiquetas pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        IVertice vertOrigen = buscarVertice(etiquetaOrigen);
        IVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private IVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea
     * valida, se deben cumplir los siguientes casos: 1) Las etiquetas pasadas
     * por parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(IArista arista) {
        if ((arista.getEtiquetaOrigen()!= null) && (arista.getEtiquetaDestino() != null)) {
            IVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            IVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            
            System.out.println("PUTO EL QUE LEE");
            if(arista.getEtiquetaOrigen().equals("04G")){
                String aaa = "AAA";
            }
            
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(vertDestino,arista.getRelaciones());
            }
        }
        return false;
    }
 
    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta, V pObjeto) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice<V,A> vert = new TVertice<V,A>(pObjeto, unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }
    
    @Override
    public boolean insertarVertice(IVertice vertice) {
     Comparable unaEtiqueta = vertice.getEtiqueta();
     if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }
    
    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, IVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, IVertice<V,A>> getVertices() {
        return vertices;
    }

    /**
     * Método Pink Floyd
     * @return una matriz
     */
    @Override
    public double[][] floyd(double[][] pC) {
        //Matriz de Costos (por eso se llama C)
        //Double[][] C = UtilGrafos.obtenerMatrizCostos(this.vertices);
        
        int cantVertices = pC.length;
        //Matriz de Floyd (por eso se llama A)
        double[][] A = new double[cantVertices][cantVertices];
        
        //Matriz de vértices anteriores
        double[][] P = new double[cantVertices][cantVertices];
        
        for (int i = 0; i < cantVertices; i++){
            for (int j = 0; j < cantVertices; j++){
                A[i][j] = pC[i][j];
                P[i][j] = 0D;
            }
        }
        
        for(int i = 0; i < cantVertices; i++){
            A[i][i] = 0D;
        }
        
        for(int k = 0; k < cantVertices; k++){
            for(int i = 0; i < cantVertices; i++){
                for(int j = 0; j < cantVertices; j++){
                    if((A[i][k] + A[k][j]) < A[i][j]){
                        A[i][j] = (A[i][k] + A[k][j]);
                        P[i][j] = Double.parseDouble(String.valueOf(k));
                    }
                }
            }
        }
        //No podemos retornar P (llora)
        return A;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice, double[][] pFloyd) {
        //Double[][] matrizA = this.floyd();
        //if(this.pinkFloyd == null){
            //this.pinkFloyd = this.floyd();
        //}
        
        Set<Comparable> etiquetasVertices = vertices.keySet();
        Object[] VerticesIArr = etiquetasVertices.toArray();
        Double maxValue = -1D;
        
        int indice = -1;
        for(int i = 0; i < VerticesIArr.length; i++){
            if(etiquetaVertice.compareTo(VerticesIArr[i]) == 0){
                indice = i;
                break;
            }
        }
        
        if(indice > -1){
            for (int i = 0; i < VerticesIArr.length; i++){
                Double currentValue = this.pinkFloyd[i][indice];
                
                if(currentValue > maxValue){
                    maxValue = currentValue;
                }
            }
        }
        
        return maxValue;
    }

    @Override
    public boolean contieneCiclos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean insertarArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, Comparable costo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  //Be pe efe sin par·metros
    @Override
    public Collection<Comparable> bpf() {
        Set<Comparable> clavesVertices = this.vertices.keySet();
        IVertice verticeActual = null;
        //Diamante ?
        Collection<Comparable> verticesVisitados = new LinkedList<>();
      
        for(Comparable c : clavesVertices){
            verticeActual = this.vertices.get(c);
            if(!(verticeActual.getVisitado())){
                verticeActual.bpf(verticesVisitados);
            }
            
        }
        
        return verticesVisitados;
    }

    @Override
    public Collection<Comparable> bpf(Comparable etiquetaOrigen) {
        IVertice verticeActual = null;
        Collection<Comparable> verticesVisitados = new LinkedList<Comparable>();
        
        verticeActual = this.vertices.get(etiquetaOrigen);
        verticeActual.bpf(verticesVisitados);
        
        return verticesVisitados;
    }
    
    @Override
    public Collection<Comparable> bpf(TVertice verticeOrigen) {
        Collection<Comparable> verticesVisitados = new LinkedList<Comparable>();
        verticeOrigen.bpf(verticesVisitados);
        
        return verticesVisitados;
    }
    
    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino){
        IVertice verticeOrigen = this.buscarVertice(etiquetaOrigen);
        TCaminos caminos = null;
        TCamino caminoPrevio = new TCamino(verticeOrigen);
        
        if(verticeOrigen != null){
            caminos = new TCaminos();
            caminos = verticeOrigen.todosLosCaminos(etiquetaDestino, caminoPrevio, caminos);
        }
        
        return caminos;
    }
    
    @Override
    public boolean tieneCiclo(TCamino camino) {
        return false;
    }
    
    @Override
    public boolean tieneCiclo() {
        TCamino camino = null;
        boolean esCiclo = false;
        
        for(IVertice vertice : this.vertices.values()){
            if(!vertice.getVisitado()){
                camino = new TCamino(vertice);
                esCiclo = vertice.tieneCiclo(camino);
            }
            
            if(esCiclo){
                return esCiclo;
            }
        }
        
        return esCiclo;
    }

    /** ----------------------------------------------------- **/
    
    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
