/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.ec.espe.taxes.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author LABS-ESPE
 */
public class OperationTest {
    
    public OperationTest() {
    }

    /**
     * Test of add method, of class Operation.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        float addend1 = 1.2F;
        float addend2 = 2.4F;
        float expResult = 3.6F;
        float result = Operation.add(addend1, addend2);
        assertEquals(expResult, result, 0);
    }
    
}
