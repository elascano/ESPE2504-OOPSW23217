package view;

public class PaymentView {
    public void showPaymentOptions() {
        System.out.println("Select payment method:");
        System.out.println("1. PayPal");
        System.out.println("2. Credit Card");
        System.out.println("3. Debit Card");
        System.out.println("4. Digital Wallet");
        System.out.println("5. DeUna");
    }

    public void showPaymentResult(String result) {
        System.out.println(result);
    }
}
