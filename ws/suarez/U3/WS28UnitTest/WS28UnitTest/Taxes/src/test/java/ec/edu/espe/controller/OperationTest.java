package ec.edu.espe.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author BERNARDO SUAREZ
 */

public class OperationTest {
    
    public OperationTest() {
    }
    /**
     * Test of add method, of class Operation.
     */
    @org.junit.jupiter.api.Test
    public void testAdd() {
        System.out.println("add");
        float addend1 = 1.2F;
        float addend2 = 2.4F;
        float expResult = 3.6F;
        float result = Operation.add(addend1, addend2);
        assertEquals(expResult, result, 0);
    }

    
}
