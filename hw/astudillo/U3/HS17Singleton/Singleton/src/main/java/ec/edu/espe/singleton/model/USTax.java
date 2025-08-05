package ec.edu.espe.singleton.model;

import java.io.InputStream;
import java.util.Properties;

/**
 * USTax class implementing Singleton pattern
 * @author Astudillo
 */
public class USTax {
    private static USTax instance;
    private float taxRate;
    
    private USTax() {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            props.load(input);
            this.taxRate = Float.parseFloat(props.getProperty("tax.rate"));
        } catch (Exception e) {
            this.taxRate = 0.15f; // default value
        }
    }
    
    public static USTax getInstance() {
        if (instance == null) {
            instance = new USTax();
        }
        return instance;
    }
    
    public float salesTotal() {
        return 1000 + (1000 * taxRate);
    }
}
