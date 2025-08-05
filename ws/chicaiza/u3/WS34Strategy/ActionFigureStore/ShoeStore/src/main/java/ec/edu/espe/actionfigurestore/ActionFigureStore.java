/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.actionfigurestore;

import ec.edu.espe.actionfigurestore.controller.PaymentController;
import ec.edu.espe.actionfigurestore.model.PaymentContext;
import ec.edu.espe.actionfigurestore.view.PaymentView;

/**
 *
 * @author LABS-ESPE
 */

public class ActionFigureStore {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        PaymentView view = new PaymentView();
        PaymentController controller = new PaymentController(context, view);

        controller.processPayment();
    }
}
