/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import UCUGrafos.IArista;
import UCUGrafos.IGrafoDirigido;
import UCUGrafos.TCaminos;
import java.util.Collection;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lithium582
 */
public class AlaUCUTest {
    
    public AlaUCUTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstancia method, of class AlaUCU.
     */
    @org.junit.Test
    public void testGetInstancia() {
        System.out.println("getInstancia");
        AlaUCU expResult = null;
        AlaUCU result = AlaUCU.getInstancia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAerolineas method, of class AlaUCU.
     */
    @org.junit.Test
    public void testGetAerolineas() {
        System.out.println("getAerolineas");
        AlaUCU instance = null;
        LinkedList<Aerolinea> expResult = null;
        LinkedList<Aerolinea> result = instance.getAerolineas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrafo method, of class AlaUCU.
     */
    @org.junit.Test
    public void testGetGrafo() {
        System.out.println("getGrafo");
        AlaUCU instance = null;
        IGrafoDirigido expResult = null;
        IGrafoDirigido result = instance.getGrafo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarAerolinea method, of class AlaUCU.
     */
    @org.junit.Test
    public void testBuscarAerolinea() {
        System.out.println("buscarAerolinea");
        Comparable<String> pCodigo = null;
        AlaUCU instance = null;
        Aerolinea expResult = null;
        Aerolinea result = instance.buscarAerolinea(pCodigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevaAerolinea method, of class AlaUCU.
     */
    @org.junit.Test
    public void testNuevaAerolinea() {
        System.out.println("nuevaAerolinea");
        Aerolinea pObjAerolinea = null;
        AlaUCU instance = null;
        boolean expResult = false;
        boolean result = instance.nuevaAerolinea(pObjAerolinea);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevoAeropuerto method, of class AlaUCU.
     */
    @org.junit.Test
    public void testNuevoAeropuerto() {
        System.out.println("nuevoAeropuerto");
        Aeropuerto pObjAeropuerto = null;
        AlaUCU instance = null;
        boolean expResult = false;
        boolean result = instance.nuevoAeropuerto(pObjAeropuerto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevaArista method, of class AlaUCU.
     */
    @org.junit.Test
    public void testNuevaArista() {
        System.out.println("nuevaArista");
        IArista pObjArista = null;
        AlaUCU instance = null;
        boolean expResult = false;
        boolean result = instance.nuevaArista(pObjArista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarVuelos method, of class AlaUCU.
     */
    @org.junit.Test
    public void testBuscarVuelos() {
        System.out.println("buscarVuelos");
        Comparable<String> pAeropuertoOrigen = null;
        Comparable<String> pAeropuertoDestino = null;
        AlaUCU instance = null;
        LinkedList<IVuelo> expResult = null;
        LinkedList<IVuelo> result = instance.buscarVuelos(pAeropuertoOrigen, pAeropuertoDestino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarAeropuerto method, of class AlaUCU.
     */
    @org.junit.Test
    public void testBuscarAeropuerto() {
        System.out.println("buscarAeropuerto");
        Comparable pCodigo = null;
        AlaUCU instance = null;
        Aeropuerto expResult = null;
        Aeropuerto result = instance.buscarAeropuerto(pCodigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAeropuerto method, of class AlaUCU.
     */
    @org.junit.Test
    public void testEliminarAeropuerto() {
        System.out.println("eliminarAeropuerto");
        Comparable pCodigo = null;
        AlaUCU instance = null;
        boolean expResult = false;
        boolean result = instance.eliminarAeropuerto(pCodigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarGrafo method, of class AlaUCU.
     */
    @org.junit.Test
    public void testCargarGrafo() {
        System.out.println("cargarGrafo");
        String pArchivoAeropuertos = "";
        String pArchivoAerolineas = "";
        String pArchivoVuelos = "";
        AlaUCU instance = null;
        instance.cargarGrafo(pArchivoAeropuertos, pArchivoAerolineas, pArchivoVuelos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bpf method, of class AlaUCU.
     */
    @org.junit.Test
    public void testBpf() {
        System.out.println("bpf");
        Comparable etiquetaOrigen = null;
        AlaUCU instance = null;
        Collection<Comparable> expResult = null;
        Collection<Comparable> result = instance.bpf(etiquetaOrigen);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of todosLosCaminos method, of class AlaUCU.
     */
    @org.junit.Test
    public void testTodosLosCaminos() {
        System.out.println("todosLosCaminos");
        Comparable pEtiquetaOrigen = null;
        Comparable pEtiquetaDestino = null;
        int pCantidadEscalas = 0;
        Comparable pAerolinea = null;
        AlaUCU instance = null;
        TCaminos expResult = null;
        TCaminos result = instance.todosLosCaminos(pEtiquetaOrigen, pEtiquetaDestino, pCantidadEscalas, pAerolinea);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodosLosCaminos method, of class AlaUCU.
     */
    @org.junit.Test
    public void testObtenerTodosLosCaminos() {
        System.out.println("obtenerTodosLosCaminos");
        Comparable pEtiquetaOrigen = null;
        Comparable pEtiquetaDestino = null;
        int pCantidadEscalas = 0;
        Comparable pAerolinea = null;
        AlaUCU instance = null;
        LinkedList<String> expResult = null;
        LinkedList<String> result = instance.obtenerTodosLosCaminos(pEtiquetaOrigen, pEtiquetaDestino, pCantidadEscalas, pAerolinea);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPosicionEnElHashMap method, of class AlaUCU.
     */
    @org.junit.Test
    public void testObtenerPosicionEnElHashMap() {
        System.out.println("obtenerPosicionEnElHashMap");
        Comparable pComp = null;
        AlaUCU instance = null;
        int expResult = 0;
        int result = instance.obtenerPosicionEnElHashMap(pComp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerEtiquetaPorPosicion method, of class AlaUCU.
     */
    @org.junit.Test
    public void testObtenerEtiquetaPorPosicion() {
        System.out.println("obtenerEtiquetaPorPosicion");
        int pPosicion = 0;
        AlaUCU instance = null;
        Comparable expResult = null;
        Comparable result = instance.obtenerEtiquetaPorPosicion(pPosicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
