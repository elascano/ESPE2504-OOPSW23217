/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.taxes.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author LABS-ESPE
 */
public class TaxTest {
    
    public TaxTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of computeTax method, of class Tax.
     */
    @Test
    public void testComputeTax() {
        System.out.println("computeTax");
        float basePrice = 100.0F;
        float percentage = 15.0F;
        boolean charged = true;
        Tax instance = new Tax();
        float expResult = 15.0F;
        float result = instance.computeTax(basePrice, percentage, charged);
        assertEquals(expResult, result, 0);
   
    }

    /**
     * Test of computeIce method, of class Tax.
     */
    @Test
    public void testComputeIce() {
        System.out.println("computeIce");
        float basePrice = 0.0F;
        Tax instance = new Tax();
        float expResult = 1.0F;
        float result = instance.computeIce(basePrice);
        assertEquals(expResult, result, 0);
   
    }
        public void testComputeZero() {
        System.out.println("computeZero");
        float basePrice = 0.0F;
        Tax instance = new Tax();
        float expResult = 1.0F;
        float result = instance.computeIce(basePrice);
        assertEquals(expResult, result, 0);
    
}
}