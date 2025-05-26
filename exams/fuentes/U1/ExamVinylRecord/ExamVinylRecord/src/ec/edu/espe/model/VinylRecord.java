package ec.edu.espe.model;

import java.util.Scanner;

/**
 *
 * @author Jorge Fuentes
 */
public class VinylRecord {
    private int id;
    private String color;
    private int size;
    private String type;
    private int price;

    public VinylRecord(int id, String color, int size, String type, int price) {
        this.id = id;
        this.color = color;
        this.size = size;
        this.type = type;
        this.price = price;
    }
    public static void insertColor(){
        Scanner scanner = new Scanner(System.in);
        String choice=null;
        System.out.println("Escriba el color que desea:");
        System.out.println("Rojo");
        System.out.println("Negro");
        System.out.println("Verde");
        System.out.println("Blanco");
        System.out.println("Escriba su opcion:");
         choice = scanner.nextString();
        
        
        
    }
    public void insertSize(){
        
    }
    public void insertType(){
        
    }
    public void insertPrice(){
        
    }
    
    
}
