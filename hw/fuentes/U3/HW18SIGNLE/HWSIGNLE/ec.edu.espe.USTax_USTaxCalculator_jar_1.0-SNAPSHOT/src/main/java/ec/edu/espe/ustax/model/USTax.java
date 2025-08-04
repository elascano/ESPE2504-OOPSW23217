/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.ustax.model;

<<<<<<< HEAD
=======
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

>>>>>>> 1e4c7996c2a22e02abbfff4a34b99d02ef14e579
/**
 *
 * @author jorge
 */
public class USTax {
    private static USTax instance;
<<<<<<< HEAD
    private USTax(USTax instance){
        this.instance = instance;
=======
    private float taxRate;
    
    private USTax(){
        this.taxRate=loadTaxFromConfigFile();
>>>>>>> 1e4c7996c2a22e02abbfff4a34b99d02ef14e579
        
    }
    public static USTax getInstance(){
        if(instance==null)
            instance = new USTax();
        return instance;
    }
    
<<<<<<< HEAD
    public float CalculatesalesTotal(){
        return 0.0F;
    }
    
=======
    private float loadTaxFromConfigFile(){
        float defaultRate = 0.15F;
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("taxRate.json")) {
            if (input != null) {
                String jsonText = new String(input.readAllBytes(), StandardCharsets.UTF_8);
                JSONObject jsonObject = new JSONObject(jsonText);
                return jsonObject.getFloat("taxRate");
            } else {
                System.out.println("Config.json not found. Using default rate..");
            }
        } catch (Exception e) {
            System.out.println("Error reading JSON: " + e.getMessage());
        }
        return defaultRate;
    }
    
    public float calculateSalesTotal(float baseAmount) {
        return baseAmount + (baseAmount * taxRate);
    }

    public float getTaxRate() {
        return taxRate;
    }
>>>>>>> 1e4c7996c2a22e02abbfff4a34b99d02ef14e579
}
