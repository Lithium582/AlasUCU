/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlasUCU;

import Clases.AlaUCU;
import UCUGrafos.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Lithium582
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlaUCU alita = AlaUCU.getInstancia();

        String direccionArchivoAeropuertosSiEsLargoAProposito = "src/Archivos/Aeropuertos.csv";
        String direccionArchivoAeroLineasNoTanLargo = "src/Archivos/Aerolineas.csv";
        String direccionArchivoVuelosCorto = "src/Archivos/vuelos_produccion.csv";

        alita.cargarGrafo(direccionArchivoAeropuertosSiEsLargoAProposito, direccionArchivoAeroLineasNoTanLargo, direccionArchivoVuelosCorto);

        /*Collection<Comparable> unaListaDePrueba = alita.bpf("LAX");

        for(Comparable comp : unaListaDePrueba){
            System.out.println(comp.toString());
        }*/
        
        TCaminos muchosCaminitos = alita.todosLosCaminos("LAX", "SLC", 4, "AA");
        /*TCaminos muchosCaminitos2 = alita.todosLosCaminos("LAX", "SLC", 4, "WN");
        TCaminos muchosCaminitos3 = alita.todosLosCaminos("LAX", "SLC", 4, "7H");
        TCaminos muchosCaminitos4 = alita.todosLosCaminos("LAX", "SLC", 4, "AS");
        TCaminos muchosCaminitos5 = alita.todosLosCaminos("LAX", "SLC", 4, "US");
        TCaminos muchosCaminitos6 = alita.todosLosCaminos("LAX", "SLC", 4, "UA");
        TCaminos muchosCaminitos7 = alita.todosLosCaminos("LAX", "SLC", 4, "KL");
        TCaminos muchosCaminitos8 = alita.todosLosCaminos("LAX", "SLC", 4, "DL");
        TCaminos muchosCaminitos9 = alita.todosLosCaminos("LAX", "SLC", 4, "AM");*/
        
        
        //TCaminos muchosCaminitos = alita.todosLosCaminos("04G", "09J", 2,"BB");

        muchosCaminitos.imprimir();
        System.out.println(muchosCaminitos.getCaminos().size());
        muchosCaminitos.getCaminoMasCorto().imprimirEtiquetas();
        /*System.out.println(muchosCaminitos2.getCaminos().size());
        System.out.println(muchosCaminitos3.getCaminos().size());
        System.out.println(muchosCaminitos4.getCaminos().size());
        System.out.println(muchosCaminitos5.getCaminos().size());
        System.out.println(muchosCaminitos6.getCaminos().size());
        System.out.println(muchosCaminitos7.getCaminos().size());
        System.out.println(muchosCaminitos8.getCaminos().size());
        System.out.println(muchosCaminitos9.getCaminos().size());*/
        /*int a = 0;

        int posicion1 = alita.obtenerPosicionEnElHashMap("04G");
        int posicion2 = alita.obtenerPosicionEnElHashMap("09J");
        //ArrayList<Double[][]> unArray = alita.obtenerMatrices("04G");
        ArrayList<Double[][]> unArray = alita.obtenerMatrices("AA");

        //La primera es Floyd
        Double[][] matrizDePinkFloyd = unArray.get(0);
        Double[][] matrizPe = unArray.get(1);
        Double costo = matrizDePinkFloyd[posicion1][posicion2];

        //UtilGrafos.imprimirMatrizCsv(matrizDePinkFloyd, alita.getGrafo().getVertices());
        //UtilGrafos.imprimirMatrizCsv(matrizPe, alita.getGrafo().getVertices());

        if (matrizDePinkFloyd[posicion1][posicion2] < Double.MAX_VALUE && matrizDePinkFloyd[posicion1][posicion2] != -1D) {
            String costoFinalDelPinkFloydDeLaVida = matrizDePinkFloyd[posicion1][posicion2].toString();

            boolean algo = true;
            int integerDeSobra = posicion2;

            Comparable aeroOrigen = alita.obtenerEtiquetaPorPosicion(posicion1);
            Comparable aeroDestino = alita.obtenerEtiquetaPorPosicion(posicion2);
            String resultado = aeroOrigen.toString();

            while (algo) {
                integerDeSobra = matrizPe[posicion1][integerDeSobra].intValue();
                if (integerDeSobra == -1) {
                    algo = false;
                } else {
                    Comparable resultadoDeSobra = alita.obtenerEtiquetaPorPosicion(integerDeSobra);
                    resultado += ",\n" + resultadoDeSobra.toString();
                }
            }

            //Holuuuuuuuu
            
            resultado += ",\n" + aeroDestino;

            System.out.println("Tenemos viaje!!! " + resultado + "\ny cuesta: " + costoFinalDelPinkFloydDeLaVida);

            int holu = 23;
        } else{
            System.out.println("Holu. No estaría habiendo ningún recorrido por esa aerolínea. SORRY, Mildis ::");
        }*/

    }

}
