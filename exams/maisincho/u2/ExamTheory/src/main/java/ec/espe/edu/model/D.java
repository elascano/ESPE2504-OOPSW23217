/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author @author LABS-ESPE
 */
public class D extends A {

    private List<F> fs = new ArrayList<>();
    private List<E> es = new ArrayList<>();

    public void E(E e) {
        if (es.size() < 4) {
            es.add(e);
        }
    }

    public D() {
        super();
    }

    public List<F> getFs() {
        return fs;
    }

}
