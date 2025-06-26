package ec.edu.espe.soundmixer.util;

public class CurrencyConverter {

    public static void updatePriceField(javax.swing.JTextField txtPrice, javax.swing.JComboBox<String> comboCurrency, float precioUSD) {
        String monedaSeleccionada = (String) comboCurrency.getSelectedItem();
        float precioConvertido = convert(precioUSD, monedaSeleccionada);
        txtPrice.setText(String.format("%.2f", precioConvertido));
    }
    public static float convert(float amountUSD, String currency) {
        float rate;
        switch (currency) {
            case "EUR":
                rate = 0.92f;
                break;
            case "JPY":
                rate = 145.0f;
                break;
            case "MXN":
                rate = 18.94f;
                break;
            default: // USD
                rate = 1.0f;
        }
        return amountUSD * rate;
    }
}