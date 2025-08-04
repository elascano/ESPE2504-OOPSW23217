import controller.PaymentController;
import model.*;
import util.InputUtil;
import view.PaymentView;

public class Main {
    public static void main(String[] args) {
        PaymentController controller = new PaymentController();
        PaymentView view = new PaymentView();

        view.showPaymentOptions();
        int choice = InputUtil.getIntInput();

        switch (choice) {
            case 1: controller.setPaymentStrategy(new PaypalPayment()); break;
            case 2: controller.setPaymentStrategy(new CreditCardPayment()); break;
            case 3: controller.setPaymentStrategy(new DebitCardPayment()); break;
            case 4: controller.setPaymentStrategy(new DigitalWalletPayment()); break;
            case 5: controller.setPaymentStrategy(new DeUnaPayment()); break;
            default: System.out.println("Invalid option."); return;
        }

        System.out.print("Enter amount to pay: ");
        double amount = InputUtil.getDoubleInput();
        controller.processPayment(amount);
    }
}
