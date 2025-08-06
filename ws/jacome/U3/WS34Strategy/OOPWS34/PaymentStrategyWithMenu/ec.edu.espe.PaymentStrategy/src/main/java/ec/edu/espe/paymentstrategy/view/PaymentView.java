package ec.edu.espe.paymentstrategy.view;

/**
 *
 * @author LABS-ESPE
 */
public class PaymentView {
    public void showPaymentResult(String message) {
        System.out.println("[View] " + message);
    }

    public void showError(String error) {
        System.err.println("[Error] " + error);
    }
}
