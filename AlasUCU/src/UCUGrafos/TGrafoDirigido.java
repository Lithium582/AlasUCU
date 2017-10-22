package UCUGrafos;

import Clases.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Lithium582
 */
public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, IVertice> vertices; //Vértices del grafo, con el tipo del Vértice y de sus Adyacencias
    Double[][] pinkFloyd; //No sé si esto tiene sentido

    /**
     *
     */
    public TGrafoDirigido() {
        this.vertices = new HashMap<>();
        this.pinkFloyd = null;
    }

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoDirigido(Collection<IVertice> vertices, Collection<IArista> aristas) {
        this.vertices = new HashMap<>();
        this.pinkFloyd = null;
        String a = "";

        this.cargarGrafo(vertices, aristas);
    }

    /**
     *
     * @param pComp
     * @return
     */
    @Override
    public int obtenerPosicionEnElHashMap(Comparable pComp) {
        int i = 0;
        for (Comparable comp : this.getVertices().keySet()) {
            if (comp.equals(pComp)) {
                return i;
            }

            i++;
        }

        return -1;
    }

    /**
     *
     * @param pPosicion
     * @return
     */
    @Override
    public Comparable obtenerEtiquetaPorPosicion(int pPosicion) {
        int i = 0;
        for (Comparable comp : this.getVertices().keySet()) {
            if (i == pPosicion) {
                return this.getVertices().get(comp).getDatos().toString();
                //return comp;
            }

            i++;
        }

        return null;
    }

    /**
     *
     * @param vertices
     * @param aristas
     */
    @Override
    public void cargarGrafo(Collection<IVertice> vertices, Collection<IArista> aristas) {
        for (IVertice vertice : vertices) {
            insertarVertice(vertice);
        }

        for (IArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean inv�lidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return
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
     * @param nombreVertice
     * @return
     */
    public boolean eliminarVertice(Comparable nombreVertice) {
        IVertice verticeBuscado = this.getVertices().get(nombreVertice);

        if (verticeBuscado != null) {
            verticeBuscado.setActivo(false);
            return true;
        }

        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
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
    @Override
    public IVertice buscarVertice(Comparable unaEtiqueta) {
        IVertice verticeBuscado = getVertices().get(unaEtiqueta);

        if (verticeBuscado != null) {
            if (verticeBuscado.getActivo()) {
                return verticeBuscado;
            }
        }

        return null;
    }

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(IArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            IVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            IVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());

            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(vertDestino, arista.getRelaciones());
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
     * @param pObjeto
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta, Aeropuerto pObjeto) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            IVertice vert = new TVertice(pObjeto, unaEtiqueta);
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

    /**
     *
     * @return
     */
    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, IVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, IVertice> getVertices() {
        return vertices;
    }

    /**
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @param costo
     * @return
     */
    @Override
    public boolean insertarArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, Comparable costo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Be pe efe sin par·metros
    /**
     *
     * @return
     */
    @Override
    public Collection<Comparable> bpf() {
        Set<Comparable> clavesVertices = this.vertices.keySet();
        IVertice verticeActual = null;
        //Diamante ?
        Collection<Comparable> verticesVisitados = new LinkedList<>();

        for (Comparable c : clavesVertices) {
            verticeActual = this.vertices.get(c);
            if (!(verticeActual.getVisitado())) {
                verticeActual.bpf(verticesVisitados);
            }

        }

        return verticesVisitados;
    }

    /**
     *
     * @param etiquetaOrigen
     * @return
     */
    @Override
    public Collection<Comparable> bpf(Comparable etiquetaOrigen) {
        IVertice verticeActual = null;
        Collection<Comparable> verticesVisitados = new LinkedList<Comparable>();

        verticeActual = this.vertices.get(etiquetaOrigen);
        if (verticeActual == null) {
            return null;
        }

        verticeActual.bpf(verticesVisitados);

        return verticesVisitados;
    }

    /**
     *
     * @param verticeOrigen
     * @return
     */
    @Override
    public Collection<Comparable> bpf(TVertice verticeOrigen) {
        Collection<Comparable> verticesVisitados = new LinkedList<Comparable>();
        verticeOrigen.bpf(verticesVisitados);

        return verticesVisitados;
    }

    /**
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @param pCantidadEscalas
     * @param pAerolinea
     * @return
     */
    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino, int pCantidadEscalas, Comparable pAerolinea) {
        IVertice verticeOrigen = this.buscarVertice(etiquetaOrigen);
        IVertice verticeDestino = buscarVertice(etiquetaOrigen);

        TCaminos caminos = null;
        TCamino caminoPrevio = new TCamino(verticeOrigen);
        if (verticeOrigen != null && verticeDestino != null) {
            caminos = new TCaminos();
            caminos = verticeOrigen.todosLosCaminos(etiquetaDestino, caminoPrevio, caminos, pCantidadEscalas, pAerolinea);
        }

        return caminos;
    }

    /**
     *
     * @param camino
     * @return
     */
    @Override
    public boolean tieneCiclo(TCamino camino) {
        return false;
    }

    /**
     *
     */
    @Override
    public void desvisitarVertices() {
        for (IVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public boolean tieneCiclo() {
        TCamino camino = null;
        boolean esCiclo = false;

        for (IVertice vertice : this.vertices.values()) {
            if (!vertice.getVisitado()) {
                camino = new TCamino(vertice);
                esCiclo = vertice.tieneCiclo(camino);
            }

            if (esCiclo) {
                return esCiclo;
            }
        }

        return esCiclo;
    }

    /**
     * -----------------------------------------------------
     *
     * @param etiquetaOrigen
     * @return  *
     */
    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
