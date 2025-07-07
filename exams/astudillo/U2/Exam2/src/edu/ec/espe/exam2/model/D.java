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
public class D extends A {
    // Aggregation: 0..4 F (each F can be aggregated by 1 D)
    private List<F> fList;

    public D() {
        fList = new ArrayList<>();
    }

    public void addF(F f) {
        if (fList.size() < 4) {
            fList.add(f);
            f.setD(this);
        }
    }

    public List<F> getFList() {
        return fList;
    }

    @Override
    public String toString() {
        return "D{" +
                "fList=" + fList.size() +
                "} " + super.toString();
    }
}
