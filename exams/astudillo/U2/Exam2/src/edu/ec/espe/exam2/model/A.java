/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ec.espe.exam2.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LABS-ESPE
 */
public abstract class A {
    // Aggregation: 0..1 to 0..* (A has a list of A, and can be aggregated by one A)
    private A parentA;
    private List<A> childrenA;

    public A() {
        childrenA = new ArrayList<>();
    }

    public void setParentA(A parentA) {
        this.parentA = parentA;
    }

    public A getParentA() {
        return parentA;
    }

    public List<A> getChildrenA() {
        return childrenA;
    }

    public void addChildA(A child) {
        childrenA.add(child);
        child.setParentA(this);
    }

    @Override
    public String toString() {
        return "A{" +
                "parentA=" + (parentA != null ? parentA.getClass().getSimpleName() : "null") +
                ", childrenA=" + childrenA.size() +
                '}';
    }
}
