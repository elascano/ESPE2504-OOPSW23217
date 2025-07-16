/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.taxes.controller;

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
    
    
        @Test
    public void testComputeZeroTax() {
        System.out.println("computeTax");
        float basePrice = 100.0F;
        float percentage = 15.0F;
        boolean charged = false;
        Tax instance = new Tax();
        float expResult = 0.0F;
        float result = instance.computeTax(basePrice, percentage, charged);
        assertEquals(expResult, result, 0);

    }

    /**
     * Test of testComputeIce method, of class Tax.
     */
    @Test
    public void testTestComputeIce() {
        System.out.println("testComputeIce");
        float basePrice = 0.0F;
        Tax instance = new Tax();
        float expResult = 0.0F;
        float result = instance.testComputeIce(basePrice);
        assertEquals(expResult, result, 0);

    }
    
}
