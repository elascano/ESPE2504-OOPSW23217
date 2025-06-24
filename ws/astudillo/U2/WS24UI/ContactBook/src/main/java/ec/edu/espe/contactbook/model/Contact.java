/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.contactbook.model;

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
    private String cellphoneNumber;
    private String email;
    private boolean frecuentFriend;
    private String type; //family, friend, job, university
    private Calendar bornOnType;
    private String comments;
    private ArrayList<Sport> sports;

    public Contact(int id, String firstMame, String lastName, String cellphoneNumber, String email, boolean frecuentFriend, String type, Calendar bornOnType, String comments, ArrayList<Sport> sports) {
        this.id = id;
        this.firstName = firstMame;
        this.lastName = lastName;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
        this.frecuentFriend = frecuentFriend;
        this.type = type;
        this.bornOnType = bornOnType;
        this.comments = comments;
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", cellphoneNumber=" + cellphoneNumber + ", email=" + email + ", frecuentFriend=" + frecuentFriend + ", type=" + type + ", bornOnType=" + bornOnType + ", comments=" + comments + ", sports=" + sports + '}';
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
     * @return the firstMame
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstMame to set
     */
    public void setFirstMame(String firstName) {
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
     * @return the frecuentFriend
     */
    public boolean isFrecuentFriend() {
        return frecuentFriend;
    }

    /**
     * @param frecuentFriend the frecuentFriend to set
     */
    public void setFrecuentFriend(boolean frecuentFriend) {
        this.frecuentFriend = frecuentFriend;
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
