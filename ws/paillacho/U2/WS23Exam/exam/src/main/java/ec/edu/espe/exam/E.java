package ec.edu.espe.exam;


public class E implements IE {

    private D d;

    public E(D d) {
        this.d = d;
    }

    @Override
    public void useH(H h) {
        System.out.println("Usando H con valor a = " + h.getA());
    }

    @Override
    public void configureWithD(D d) {
        this.d = d;
        System.out.println("Configurado con D de valor a = " + d.getA());
    }

    public D getD() {
        return d;
    }
}
