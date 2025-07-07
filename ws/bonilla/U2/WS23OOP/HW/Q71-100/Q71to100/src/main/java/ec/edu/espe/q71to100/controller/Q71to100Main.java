package ec.edu.espe.q71to100.controller;

import ec.edu.espe.q71to100.view.FrmCRUDProduct;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class Q71to100Main {

    public static void main(String[] args) {
        FrmCRUDProductController.getInstance();
        FrmCRUDProduct.getInstance().setVisible(true);
    }
}
