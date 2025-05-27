package unda_scissors;

public class Unda_Scissors {
    private int id;
    private String brand;
    private int bladeLength;
    private boolean isLeftHanded;

    public Unda_Scissors(int id, String brand, int bladeLength, boolean isLeftHanded) {
        this.id = id;
        this.brand = brand;
        this.bladeLength = bladeLength;
        this.isLeftHanded = isLeftHanded;
    }

    public int getId() { return id; }
    public String getBrand() { return brand; }
    public int getBladeLength() { return bladeLength; }
    public boolean isLeftHanded() { return isLeftHanded; }

    public String toCSV() {
        return id + "," + brand + "," + bladeLength + "," + isLeftHanded;
    }

    public static Unda_Scissors fromCSV(String line) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0]);
        String brand = parts[1];
        int bladeLength = Integer.parseInt(parts[2]);
        boolean isLeftHanded = Boolean.parseBoolean(parts[3]);
        return new Unda_Scissors(id, brand, bladeLength, isLeftHanded);
    }

    @Override
    public String toString() {
        return "Scissors [id=" + id + ", brand=" + brand + ", bladeLength=" + bladeLength + ", leftHanded=" + isLeftHanded + "]";
    }
}
