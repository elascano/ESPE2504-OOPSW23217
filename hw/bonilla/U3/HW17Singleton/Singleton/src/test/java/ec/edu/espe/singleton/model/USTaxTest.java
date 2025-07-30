package ec.edu.espe.singleton.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class USTaxTest {
    
    @Test
    public void testSingletonInstance() {
        USTax tax1 = USTax.getInstance();
        USTax tax2 = USTax.getInstance();
        
        assertSame(tax1, tax2, "getInstance() should return the same instance");
        assertEquals(tax1.hashCode(), tax2.hashCode(), "Hash codes should be equal");
    }
    
    @Test
    public void testSalesTotalCalculation() {
        USTax tax = USTax.getInstance();
        
        double saleAmount = 100.0;
        double expectedTotal = 108.5;
        double actualTotal = tax.getSalesTotal(saleAmount);
        
        assertEquals(expectedTotal, actualTotal, 0.01, "Sales total calculation should be correct");
    }
    
    @Test
    public void testTaxAmountCalculation() {
        USTax tax = USTax.getInstance();
        
        double saleAmount = 200.0;
        double expectedTax = 17.0;
        double actualTax = tax.getTaxAmount(saleAmount);
        
        assertEquals(expectedTax, actualTax, 0.01, "Tax amount calculation should be correct");
    }
    
    @Test
    public void testNegativeAmountException() {
        USTax tax = USTax.getInstance();
        
        double result1 = tax.getSalesTotal(-10.0);
        double result2 = tax.getTaxAmount(-5.0);
        
        assertTrue(result1 < 0, "Should handle negative amounts");
        assertTrue(result2 < 0, "Should handle negative amounts");
    }
    
    @Test
    public void testTaxRate() {
        USTax tax = USTax.getInstance();
        
        double expectedRate = 0.085;
        double actualRate = tax.getTaxRate();
        
        assertEquals(expectedRate, actualRate, 0.001, "Tax rate should be 8.5%");
    }
}
