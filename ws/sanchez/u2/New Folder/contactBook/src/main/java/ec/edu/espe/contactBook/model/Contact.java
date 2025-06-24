
package ec.edu.espe.contactBook.model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author LABS-ESPE
 */
public class Contact {
    
    private int id;
    private String firstName;
    private String lastName;
    private String cellphonNumber;
    private String email;
    private boolean frequentFriend;
    private String type;
    private Calendar bornOnType;
    private String comments;
    private ArrayList<Sport> sports;

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", cellphonNumber=" + cellphonNumber + ", email=" + email + ", frequentFriend=" + frequentFriend + ", type=" + type + ", bornOnType=" + bornOnType + ", comments=" + comments + ", sports=" + sports + '}';
    }
    
    
    
    /**
     * 
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
     * @return the cellphonNumber
     */
    public String getCellphonNumber() {
        return cellphonNumber;
    }

    /**
     * @param cellphonNumber the cellphonNumber to set
     */
    public void setCellphonNumber(String cellphonNumber) {
        this.cellphonNumber = cellphonNumber;
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

}
