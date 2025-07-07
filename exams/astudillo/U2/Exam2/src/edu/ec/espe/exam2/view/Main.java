package edu.ec.espe.exam2.view;

import edu.ec.espe.exam2.model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        B b = new B();
        C c = new C();
        D d = new D();
        E e1 = new E();
        E e2 = new E();
        F f1 = new F();
        F f2 = new F();
        G g = new G();
        J j = new J();

        b.addH(g);

        c.addE(e1);
        c.addE(e2);

        d.addF(f1);
        d.addF(f2);

        g.setJ(j);

        b.addChildA(c);

        System.out.println("=== Object Structure Demo ===");
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e1);
        System.out.println(f1);
        System.out.println(g);
        System.out.println(j);

        System.out.print("Calling doSomething() on G: ");
        g.doSomething();

        System.out.println("Press Enter to exit...");
        scanner.nextLine();
    }
}
