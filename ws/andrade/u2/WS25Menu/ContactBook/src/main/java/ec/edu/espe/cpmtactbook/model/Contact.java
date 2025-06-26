/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cpmtactbook.model;

import java.util.ArrayList;

/**
 *
 * @author LABS-ESPE
 */
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String cellphoneNumer;
    private String email;
    private boolean frequentFriend;
    private String type;//family, friend, job, university
    private String bornOnType;
    private String comments;
    private ArrayList<Sport>sports;

    public Contact(int id, String firsName, String lastName, String cellphoneNumer, String email, boolean frequentFriend, String type, String bornOnType, String comments, ArrayList<Sport> sports) {
        this.id = id;
        this.firstName = firsName;
        this.lastName = lastName;
        this.cellphoneNumer = cellphoneNumer;
        this.email = email;
        this.frequentFriend = frequentFriend;
        this.type = type;
        this.bornOnType = bornOnType;
        this.comments = comments;
        this.sports = sports;
    }
    
    public void chat(Contact contact){
        System.out.println("chating with contact --> " + contact.firstName);
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", firstName=" + firstName + "\n, lastName=" + lastName + "\n, cellphoneNumer=" + cellphoneNumer + "\n, email=" + email + "\n, frequentFriend=" + frequentFriend + "\n, type=" + type + "\n, bornOnType=" + bornOnType + "\n, comments=" + comments + "\n, sports=" + sports + '}';
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
     * @return the firsName
     */
    public String getFirsName() {
        return firstName;
    }

    /**
     * @param firsName the firsName to set
     */
    public void setFirsName(String firsName) {
        this.firstName = firsName;
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
     * @return the cellphoneNumer
     */
    public String getCellphoneNumer() {
        return cellphoneNumer;
    }

    /**
     * @param cellphoneNumer the cellphoneNumer to set
     */
    public void setCellphoneNumer(String cellphoneNumer) {
        this.cellphoneNumer = cellphoneNumer;
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
    public String getBornOnType() {
        return bornOnType;
    }

    /**
     * @param bornOnType the bornOnType to set
     */
    public void setBornOnType(String bornOnType) {
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
