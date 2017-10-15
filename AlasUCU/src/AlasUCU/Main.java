/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlasUCU;
import Clases.AlaUCU;
import UCUGrafos.*;
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
        String direccionArchivoAeroLineasNoTanLargp = "src/Archivos/Aerolineas.csv";
        String direccionArchivoVuelosCorto = "src/Archivos/vuelos_test.csv";
        
        alita.cargarGrafo(direccionArchivoAeropuertosSiEsLargoAProposito, direccionArchivoAeroLineasNoTanLargp, direccionArchivoVuelosCorto);
        
        Collection<Comparable> unaListaDePrueba = alita.bpf("LAX");
        
        /*for(Comparable comp : unaListaDePrueba){
            System.out.println(comp.toString());
        }*/
        
        TCaminos muchosCaminitos = alita.todosLosCaminos("04G", "09J");
        
        muchosCaminitos.imprimir();
        int a = 0;
        
        System.out.println("Borrar al PUTO QUE LEE");
    }
    
}
