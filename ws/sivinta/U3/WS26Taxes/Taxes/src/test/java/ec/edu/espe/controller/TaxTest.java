/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author LABS-ESPE
 */
public class TaxTest {
    
    public TaxTest() {
    }

    /**
     * Test of compuTax method, of class Tax.
     */
    @Test
    public void testCompuTax() {
        System.out.println("compuTax");
        float basePrice = 100.0F;
        float percentage = 15.0F;
        boolean charged = false;
        Tax instance = new Tax();
        float expResult = 0.0F;
        float result = instance.compuTax(basePrice, percentage, charged);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testCompuZeroTax() {
        System.out.println("compuTax");
        float basePrice = 100.0F;
        float percentage = 15.0F;
        boolean charged = false;
        Tax instance = new Tax();
        float expResult = 0.0F;
        float result = instance.compuTax(basePrice, percentage, charged);
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
    
}
