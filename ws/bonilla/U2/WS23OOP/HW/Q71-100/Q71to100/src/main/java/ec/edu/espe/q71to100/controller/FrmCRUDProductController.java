package ec.edu.espe.q71to100.controller;

import ec.edu.espe.q71to100.util.FileManagerProduct;
import ec.edu.espe.q71to100.view.FrmCRUDProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class FrmCRUDProductController implements ActionListener, ItemListener {

    private static FrmCRUDProductController instance;

    private FrmCRUDProduct frmCRUDProduct;

    private FrmCRUDProductController() {
        this.frmCRUDProduct = FrmCRUDProduct.getInstance();

        //frmLogin.getBtmLogin().addActionListener(this);
        // frmLogin.getBtmLogin().setActionCommand("Login");
    }

    public static FrmCRUDProductController getInstance() {
        if (instance == null) {
            instance = new FrmCRUDProductController();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();

        switch (button) {
            case "Login" -> {
                //String username = frmLogin.getTxtUser().getText();
                //String password = frmLogin.getPwdPassword().getText();
                //FileManagerUser.getInstance().loginUser(username, password);
            }

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            //String rol = FrmRegister.getInstance().getCmbRol().getSelectedItem().toString();
            //String idGenerado = generarIdUnico(rol);
            //FrmRegister.getInstance().getShowID().setText(idGenerado);
        }
    }

    public static void setInstance(FrmCRUDProductController aInstance) {
        instance = aInstance;
    }

    public FrmCRUDProduct getFrmCRUDProduct() {
        return frmCRUDProduct;
    }

    public void setFrmCRUDProduct(FrmCRUDProduct frmCRUDProduct) {
        this.frmCRUDProduct = frmCRUDProduct;
    }

}
