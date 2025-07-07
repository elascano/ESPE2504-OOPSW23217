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
public class B extends A {
    // Association: 0..* to H (interface)
    private List<H> hList;
    private int r;

    public B() {
        hList = new ArrayList<>();
        r = 0;
    }

    public void addH(H h) {
        hList.add(h);
    }

    public List<H> getHList() {
        return hList;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "B{" +
                "hList=" + hList.size() +
                ", r=" + r +
                "} " + super.toString();
    }
}
