/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ec.espe.exam2.model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author LABS-ESPE
 */
public class C extends A {
    // Composition: 0..3 E
    private List<E> eList;

    public C() {
        eList = new ArrayList<>();
    }

    public void addE(E e) {
        if (eList.size() < 3) {
            eList.add(e);
        }
    }

    public List<E> getEList() {
        return eList;
    }

    @Override
    public String toString() {
        return "C{" +
                "eList=" + eList.size() +
                "} " + super.toString();
    }
}
