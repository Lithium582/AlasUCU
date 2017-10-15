package Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import UCUGrafos.*;
import java.util.Collection;
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
    private IGrafoDirigido<Aeropuerto,IVuelo> _grafo;
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
    
    public double[][] obtenerFloyd(Comparable<String> pAerolinea){
        double[][] matrizCostos = this.obtenerMatrizCostos(pAerolinea);
        double[][] matrizFloyd = this._grafo.floyd(matrizCostos);
        
        return matrizFloyd;
    }
    
    public Comparable obtenerExcentricidad(Comparable<String> pAerolinea, Comparable pEtiqueta){
        double[][] matrizCostos = this.obtenerMatrizCostos(pAerolinea);
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
    
    private double[][] obtenerMatrizCostos(Comparable<String> pAerolinea) {
        Map<Comparable, IVertice<Aeropuerto,IVuelo>> vertices = this._grafo.getVertices();
        int cantidadVertices = vertices.size();
        double[][] matrizCostos = new double[cantidadVertices][cantidadVertices];

        for (int i = 0; i < matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos.length; j++) {
                if (i == j) {
                    matrizCostos[i][j] = -1;
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
                    IAdyacencia<Aeropuerto,Vuelo> objAdyacencia = VerticeI.buscarAdyacencia(VerticeJ);
                    
                    LinkedList<Vuelo> vuelos = objAdyacencia.getRelaciones();
                    double costoMinimo = Double.MAX_VALUE;
                    
                    for(Vuelo objVueloActual : vuelos){
                        if(objVueloActual.getAerolinea().compareTo(pAerolinea.toString()) > 0){
                            if(objVueloActual.getCosto() < costoMinimo){
                                costoMinimo = objVueloActual.getCosto();
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

        Collection<IVertice<Aeropuerto, IVuelo>> losVertices = new LinkedList<IVertice<Aeropuerto, IVuelo>>();
        Collection<IArista<IVuelo>> lasAristas = new LinkedList<IArista<IVuelo>>();

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
                losVertices.add(new TVertice<>(nuevoAeropuerto, ID));
            }
        }

        //Cargamos las aristas en el grafo
        //origen,destino,costo,FECHA HORA salida,Fecha hora llegada
        for (String actual : arrayVuelos) {
            String[] line = actual.split(",");
            if ((line[0].trim().length() == 2) && (line[1].trim().length() == 3)
                    && (line[2].trim().length() == 3)) {
                String aerolinea = line[0].trim();
                String origen = line[1].trim();
                
                System.out.println("PUTO EL QUE LEE");
                if(origen.equals("04G")){
                    String aaaaaa = "BBBB";
                }
                
                String destino = line[2].trim();
                double costo = Double.parseDouble(line[3].trim());
                //Creamos un vuelo a partir de la informacion
                IVuelo nuevoVuelo = new Vuelo(origen, destino,costo, aerolinea);
                //TArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, LinkedList<E> pRelaciones)
                TArista<IVuelo> nuevaArista = new TArista(origen, destino, nuevoVuelo);
                lasAristas.add(nuevaArista);
                String aaaaaaa = "BBBB";
            }
        }
        
        this._grafo.cargarGrafo(losVertices, lasAristas);
    }
    
    public Collection<Comparable> bpf(Comparable etiquetaOrigen){
        return this._grafo.bpf(etiquetaOrigen);
    }
    
    public TCaminos todosLosCaminos(Comparable pEtiquetaOrigen, Comparable pEtiquetaDestino){
        return this._grafo.todosLosCaminos(pEtiquetaOrigen, pEtiquetaDestino);
    }
}
