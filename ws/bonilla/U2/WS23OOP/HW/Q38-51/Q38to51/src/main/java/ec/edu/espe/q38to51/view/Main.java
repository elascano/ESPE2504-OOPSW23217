package ec.edu.espe.q38to51.view;

import ec.edu.espe.q38to51.model.E;
import ec.edu.espe.q38to51.model.B;
import ec.edu.espe.q38to51.model.F;
import ec.edu.espe.q38to51.model.A;
import ec.edu.espe.q38to51.model.D;
import ec.edu.espe.q38to51.model.H;
import ec.edu.espe.q38to51.model.C;
import ec.edu.espe.q38to51.model.G;
import ec.edu.espe.q38to51.model.J;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        
        // Inicializar todas las clases del modelo
        ArrayList<A> As = new ArrayList<>();
        ArrayList<E> Es = new ArrayList<>();
        ArrayList<F> Fs = new ArrayList<>();
        ArrayList<B> Bs = new ArrayList<>();
        E e1 = new E();
        E e2 = new E();
        E e3 = new E();
        E e4 = new E();
        E e5 = new E();
        C c = new C(Es, As);
        
        c.addElement(e1);
        c.addElement(e2);
        c.addElement(e3);
        F f = new F();
        Fs.add(f);

        E[] Es2 = new E[5];
        Es2[0] = e1;
        Es2[1] = e2;
        Es2[2] = e3;
        Es2[3] = e4;
        Es2[4] = e5;
        
        D d = new D(Es2, Fs, As);
        B b = new B(As);
        Bs.add(b);
        J j = new J();
        G g = new G(Bs, j);
        ArrayList<H> Hs = new ArrayList<>();
        Hs.add(g);
        b.setH(Hs);

        //Mostrar
        b.show();
        c.show();
        d.show();
        g.show();
        
    }
}
