package ec.edu.espe.contactbook.model;

/**
 *
 * @author Carlos Paillacho
 */
public class Contact {
    int id;
    String firstName;
    String lastName;
    String cellPhoneNumber;
    String email;
    boolean frecuentFriend;
    String type; //family, friend, job, university
    Calendar bornOnType;
    String comments;
    ArrayList<Sport> sports;
    
    
    public void chat(Contact contact) {
        System.out.println("Chating with contact -> " + contact.getFirstName());
          
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", cellPhoneNumber=" + cellPhoneNumber + ", email=" + email + ", frecuentFriend=" + frecuentFriend + ", type=" + type + ", bornOnType=" + bornOnType + ", comments=" + comments + ", sports=" + sports + '}';
    }

    public Contact(int id, String firstName, String lastName, String cellPhoneNumber, String email, boolean frecuentFriend, String type, Calendar bornOnType, String comments, <any> sports) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellPhoneNumber = cellPhoneNumber;
        this.email = email;
        this.frecuentFriend = frecuentFriend;
        this.type = type;
        this.bornOnType = bornOnType;
        this.comments = comments;
        this.sports = sports;
    }
}
