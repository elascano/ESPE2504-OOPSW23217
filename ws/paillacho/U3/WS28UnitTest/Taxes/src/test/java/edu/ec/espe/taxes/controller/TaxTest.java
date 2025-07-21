package edu.ec.espe.taxes.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Carlos Paillacho
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
    /**
     * Test of computeIce method, of class Tax.
     */
      @Test
    public void testCompute0Tax() {
        System.out.println("computeTax");
        float basePrice = 100.0F;
        float percentage = 0.0F;
        boolean charged = false;
        Tax instance = new Tax();
        float expResult = 0.0F;
        float result = instance.computeTax(basePrice, percentage, charged);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testComputeIce() {
        System.out.println("computeIce");
        float basePrice = 0.0F;
        Tax instance = new Tax();
        float expResult = 0.0F;
        float result = instance.computeIce(basePrice);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
