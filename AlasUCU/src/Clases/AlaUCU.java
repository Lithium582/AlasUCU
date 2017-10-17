package Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import UCUGrafos.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * No, no me equivoqué. Es Ala porque es una sola ?)
 * @author Lithium582
 */
public class AlaUCU {
    
    // <editor-fold defaultstate="extended" desc="Atributos">
    private static AlaUCU _instancia;
    private IGrafoDirigido _grafo;
    private LinkedList<Aerolinea> _aerolineas;
    // </editor-fold>
    
    private AlaUCU(){
        this._grafo = new TGrafoDirigido();
        this._aerolineas = new LinkedList<Aerolinea>();
    }
    
    public static AlaUCU getInstancia(){
        if(_instancia == null){
            _instancia = new AlaUCU();
        }
        
        return _instancia;
    }
    
    public LinkedList<Aerolinea> getAerolineas(){
        return _aerolineas;
    }
    
    public IGrafoDirigido getGrafo(){
        return this._grafo;
    }
    
    public double[][] obtenerFloyd(Comparable<String> pAerolinea){
        Double[][] matrizCostos = this.obtenerMatrizCostos(pAerolinea);
        double[][] matrizFloyd = this._grafo.floyd(matrizCostos);
        
        return matrizFloyd;
    }
    
    public Comparable obtenerExcentricidad(Comparable<String> pAerolinea, Comparable pEtiqueta){
        Double[][] matrizCostos = this.obtenerMatrizCostos(pAerolinea);
        double[][] matrizFloyd = this._grafo.floyd(matrizCostos);
        Comparable excentricidad = this._grafo.obtenerExcentricidad(pEtiqueta,matrizFloyd);
        return excentricidad;
    }
    
    /**
     * Método auxiliar que, dada una string con formato de fecha, la convierte
     * en un dato de tipo Date.
     *
     * @param pFecha Fecha a castear.
     * @return Fecha en formato Date.
    *
     */
    private Date FormatoFecha(String pFecha) throws ParseException {
        try {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = dt.parse(pFecha);
            return date;
        } catch (ParseException e) {
            throw e;
            //System.err.println("Error de parsing: " + e.getMessage());
        }
    }

    /**
     * Método auxiliar que, dada una string con formato de fecha, la convierte
     * en un dato de tipo Date.
     *
     * @param pFecha Fecha a castear.
     * @return Fecha en formato Date.
    *
     */
    private String RemoverCaracteres(String pCadena) {
        String caracteresRaros = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        String caracteresOriginales = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";

        String strRetorno = pCadena;
        for (int i = 0; i < caracteresRaros.length(); i++) {
            // Reemplazamos los caracteres especiales.
            strRetorno = strRetorno.replace(caracteresRaros.charAt(i), caracteresOriginales.charAt(i));
        }
        return strRetorno;
    }
    
    private Double[][] obtenerMatrizCostos(Comparable<String> pAerolinea) {
        Map<Comparable, IVertice> vertices = this._grafo.getVertices();
        int cantidadVertices = vertices.size();
        Double[][] matrizCostos = new Double[cantidadVertices][cantidadVertices];

        for (int i = 0; i < matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos.length; j++) {
                if (i == j) {
                    matrizCostos[i][j] = -1D;
                } else {
                    matrizCostos[i][j] = Double.MAX_VALUE;
                }
            }
        }

        Set<Comparable> etiquetasVertices = vertices.keySet();
        Comparable[] VerticesIArr = etiquetasVertices.toArray(new Comparable[cantidadVertices]);
        Comparable[] VerticesJArr = etiquetasVertices.toArray(new Comparable[cantidadVertices]);

        //Recorre
        for (int i = 0; i < cantidadVertices; i++){
            IVertice VerticeI = vertices.get(VerticesIArr[i]);
            
            for (int j = 0; j < cantidadVertices; j++){
                IVertice VerticeJ = vertices.get(VerticesJArr[j]);

                if (!VerticeI.getEtiqueta().equals(VerticeJ.getEtiqueta())) {
                    IAdyacencia objAdyacencia = VerticeI.buscarAdyacencia(VerticeJ);
                    double costoMinimo = Double.MAX_VALUE;
                    
                    if(objAdyacencia != null){
                        LinkedList<IVuelo> vuelos = objAdyacencia.getRelaciones();
                        
                        for(IVuelo objVueloActual : vuelos){
                            //if(objVueloActual.getAerolinea().compareTo(pAerolinea.toString()) > 0){
                            if(objVueloActual.getAerolinea().equals(pAerolinea.toString())){
                                if(objVueloActual.getCosto() < costoMinimo){
                                    costoMinimo = objVueloActual.getCosto();
                                }
                            }
                        }
                    }
                    
                    matrizCostos[i][j] = costoMinimo;
                }
            }
        }
        return matrizCostos;
    }
    
    /**
     * Metodo que nos permite cargar el grafo a partir de tres archivos: Uno
     * conteniendo los aeropuertos en formato "ID,Nombre". Otro con los vuelos
     * en formato "Aerolinea,Origen,Destino,Costo". Y finalmente, uno con las
     * aerolineas con formato "ID,Nombre".
     *
     * @param pArchivoAeropuertos Nombre del archivo de aeropuertos
     * @param pArchivoVuelos Nombre del archivo de vuelos
     * @param pArchivoAerolineas Nombre del archivo de aerolíneas
     */
    public void cargarGrafo(String pArchivoAeropuertos, String pArchivoAerolineas, String pArchivoVuelos) {
        //Leemos los archivos, obteniendo así todos los vértices y aristas.
        String[] arrayAeropuertos = ManejadorArchivosGenerico.leerArchivo(pArchivoAeropuertos, false);
        String[] arrayVuelos = ManejadorArchivosGenerico.leerArchivo(pArchivoVuelos, false);
        String[] aeroArray = ManejadorArchivosGenerico.leerArchivo(pArchivoAerolineas, false);

        Collection<IVertice> losVertices = new LinkedList<IVertice>();
        Collection<IArista> lasAristas = new LinkedList<IArista>();

        for (String actual : aeroArray) {
            String[] lineaArchivo = actual.split(",");
            if (lineaArchivo[0].trim().length() == 2) {
                Aerolinea aeroLinea = new Aerolinea(lineaArchivo[0].trim(), lineaArchivo[1].trim());
                this._aerolineas.add(aeroLinea);
            }
        }

        //Cargamos los vertices en el grafo
        for (String actual : arrayAeropuertos) {
            String[] lineaArchivo = actual.split(",");
            if ((lineaArchivo[0].trim().length() == 3)) {
                String ID = (lineaArchivo[0].trim());
                String name = lineaArchivo[1].trim();
                //Creamos el aeropuerto a partir de la info obtenida
                Aeropuerto nuevoAeropuerto = new Aeropuerto(ID, name);
                //Lo insertamos en la coleccion
                losVertices.add(new TVertice(nuevoAeropuerto, ID));
            }
        }

        //Cargamos las aristas en el grafo
        //origen,destino,costo,FECHA HORA salida,Fecha hora llegada
        for (String actual : arrayVuelos) {
            String[] line = actual.split(",");
            if ((line[0].trim().length() == 2) && (line[1].trim().length() == 3)
                    && (line[2].trim().length() == 3)) {
                Comparable<String> aerolinea = line[0].trim();
                Comparable<String> origen = line[1].trim();
                
                String destino = line[2].trim();
                double costo = Double.parseDouble(line[3].trim());
                //Creamos un vuelo a partir de la informacion
                IVuelo nuevoVuelo = new Vuelo(origen, destino,costo, aerolinea);
                //TArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, LinkedList<E> pRelaciones)
                TArista nuevaArista = new TArista(origen, destino, nuevoVuelo);
                lasAristas.add(nuevaArista);
            }
        }
        
        this._grafo.cargarGrafo(losVertices, lasAristas);
    }
    
    public Collection<Comparable> bpf(Comparable etiquetaOrigen){
        return this._grafo.bpf(etiquetaOrigen);
    }
    
    public TCaminos todosLosCaminos(Comparable pEtiquetaOrigen, Comparable pEtiquetaDestino, int pCantidadEscalas, Comparable pAerolinea){
        return this._grafo.todosLosCaminos(pEtiquetaOrigen, pEtiquetaDestino,pCantidadEscalas,pAerolinea);
    }
    
    public LinkedList<String> obtenerTodosLosCaminos(Comparable pEtiquetaOrigen, Comparable pEtiquetaDestino, int pCantidadEscalas, Comparable pAerolinea){
        TCaminos todosLosCaminos = this._grafo.todosLosCaminos(pEtiquetaOrigen, pEtiquetaDestino,pCantidadEscalas,pAerolinea);
        LinkedList<String> caminosResultado = new LinkedList<String>();
        int i = 0;
        
        for(TCamino camino : todosLosCaminos.getCaminos()){
            String caminoSTR = camino.getOrigen().getEtiqueta().toString();
            Map<Comparable,String> vuelosPorAerolinea = null;
            //Interno
            Map<Comparable,Double> vuelosPorAerolinea2 = null;
            
            for(IAdyacencia adyacencia : camino.getOtrasAdyacencias()){
                caminoSTR += " - " + adyacencia.getEtiqueta();
                vuelosPorAerolinea2 = new HashMap<>();
                
                for(IVuelo objVuelo : adyacencia.getRelaciones()){
                    Double costo = vuelosPorAerolinea2.get(objVuelo.getAerolinea());
                    
                    //No se habían registrado vuelos de la aerolínea hasta el momento
                    if(costo == null){
                        vuelosPorAerolinea2.put(objVuelo.getAerolinea(),objVuelo.getCosto());
                    } else{
                        if(costo.compareTo(objVuelo.getCosto()) > 0){
                            vuelosPorAerolinea2.replace(pEtiquetaOrigen, costo);
                        }
                    }
                }
                
                if(vuelosPorAerolinea.size() == 0){
                    for(Comparable c : vuelosPorAerolinea2.keySet()){
                        caminoSTR += "(" +  vuelosPorAerolinea2.get(c).toString() + ")";
                        vuelosPorAerolinea.put(c, caminoSTR);
                    }
                    //vuelosPorAerolinea = vuelosPorAerolinea2;
                } else{
                    //Si no hay vuelos registrados entre dos ciudades, el camino no es viable
                    //Retorno null
                    if(vuelosPorAerolinea2.size() > 0){
                        for(Comparable c : vuelosPorAerolinea.keySet()){
                            //String
                        }
                    } else {
                        return null;
                    }

                }
                
            }
            
            //Jugar con el map al final
            caminosResultado.add(caminoSTR);
            i++;
        }
        
        return caminosResultado;
    }
    
    public ArrayList<Double[][]> obtenerMatrices(String pEtiqueta){
        Double[][] matrizCostos = this.obtenerMatrizCostos(pEtiqueta);
        
        //UtilGrafos.imprimirMatrizCsv(matrizCostos, this._grafo.getVertices());
        
        ArrayList<Double[][]> arrayRetorno = this._grafo.floydPink(matrizCostos);
        
        return arrayRetorno;
    }
    
    public int obtenerPosicionEnElHashMap(Comparable pComp){
        return this._grafo.obtenerPosicionEnElHashMap(pComp);
    }
    
    public Comparable obtenerEtiquetaPorPosicion(int pPosicion){
        return this._grafo.obtenerEtiquetaPorPosicion(pPosicion);
    }
}
