package ec.edu.espe.examen.model;

/**
 *
 * @author LABS-ESPE
 */
public class Client {
    
    private  int id;
    private  String fullName;
    private  String phone;
    private  String email;
    private  String address;
    private  boolean vip;

    public Client(int id, String fullName, String phone, String email, String address, boolean vip) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.vip = vip;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public boolean isVip() { return vip; }

    @Override
    public String toString() {
        return String.format("ID: %d\nNombre: %s\nCelular: %s\nEmail: %s\nDirección: %s\nVIP: %s",
                id, fullName, phone, email, address, vip ? "Sí" : "No");
    }
}


