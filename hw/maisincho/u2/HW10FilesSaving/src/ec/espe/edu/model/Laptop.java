package ec.espe.edu.model;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class Laptop implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int id;
    private String color;
    private float size;
    private int ram;
    private int rom;
    private String processor;

    public Laptop(String name, int id, String color, float size, int ram, int rom, String processor) {
        this.name = name;
        this.id = id;
        this.color = color;
        this.size = size;
        this.ram = ram;
        this.rom = rom;
        this.processor = processor;

    }

    public Laptop() {
        this.name = "";
        this.id = 0;
        this.color = "";
        this.size = 0.0f;
        this.ram = 0;
        this.rom = 0;
        this.processor = "";
    }

    @Override
    public String toString() {
        return "Laptop{" + "name=" + name + ", processor=" + processor + ", id=" + id + ", color=" + color + ", size=" + size + ", ram=" + ram + ", rom=" + rom + '}';
    }

    public void inputLaptopDetails(Scanner scanner) {
        System.out.print("Name Laptop: ");
        this.name = scanner.nextLine();
        
        System.out.println("Processor");
        this.processor=scanner.nextLine();
        

        System.out.print("Enter the laptop's ID: ");
        this.id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter the ram");
        this.ram = scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter the rom");
        this.rom = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the laptop's color: ");
        this.color = scanner.nextLine();

        System.out.print("Enter the laptop's size (in inches): ");
        this.size = scanner.nextFloat();
    }

    public void updateLaptopDetails(Scanner scanner) {
        System.out.println("Updating Laptop details");
        System.out.print("Enter the new Laptop name: ");
        this.name = scanner.nextLine();

        System.out.print("Enter the new Laptop color: ");
        this.color = scanner.nextLine();

        System.out.print("Enter the new Laptop size (in inches): ");
        this.size = scanner.nextFloat();
    }
}
