package ec.edu.espe.contactbook.model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Sanchez Julio
 */
public class Contact {

    private int id;
    private String firstName;
    private String lastName;
    private String cellphoneNumber;
    private String email;
    private boolean frequentFriend;
    private String type; //familt, friend, job, university
    private Calendar bornOnType;
    private String comments;
    private ArrayList<Sport> sports;

    public void chat(Contact contact) {
        System.out.println("chating ith contact -> " + contact.getFirstName());
    }

    public Contact(int id, String firstname, String lastName, String cellphoneNumber, String email, boolean frequentFriend, String type, Calendar bornOnType, String comments, ArrayList<Sport> sports) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastName;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
        this.frequentFriend = frequentFriend;
        this.type = type;
        this.bornOnType = bornOnType;
        this.comments = comments;
        this.sports = sports;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contact{");
        sb.append("\n id=").append(getId());
        sb.append("\n firstname=").append(getFirstName());
        sb.append("\n lastName=").append(getLastName());
        sb.append("\n cellphoneNumber=").append(getCellphoneNumber());
        sb.append("\n email=").append(getEmail());
        sb.append("\n frequentFriend=").append(isFrequentFriend());
        sb.append("\n type=").append(getType());
        sb.append("\n bornOnType=").append(getBornOnType());
        sb.append("\n comments=").append(getComments());
        sb.append("\n sports=").append(getSports());
        sb.append('}');
        return sb.toString();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the cellphoneNumber
     */
    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    /**
     * @param cellphoneNumber the cellphoneNumber to set
     */
    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the frequentFriend
     */
    public boolean isFrequentFriend() {
        return frequentFriend;
    }

    /**
     * @param frequentFriend the frequentFriend to set
     */
    public void setFrequentFriend(boolean frequentFriend) {
        this.frequentFriend = frequentFriend;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the bornOnType
     */
    public Calendar getBornOnType() {
        return bornOnType;
    }

    /**
     * @param bornOnType the bornOnType to set
     */
    public void setBornOnType(Calendar bornOnType) {
        this.bornOnType = bornOnType;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the sports
     */
    public ArrayList<Sport> getSports() {
        return sports;
    }

    /**
     * @param sports the sports to set
     */
    public void setSports(ArrayList<Sport> sports) {
        this.sports = sports;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
