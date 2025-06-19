
package ec.edu.espe.filessaving.model;

/**
 *
 * @author Yesteb JSnow
 */
public class Student {

    private String id;
    private String name;
    private String lastName;
    private String major;
    private String email;
    private String typeStudent;
    private int phoneNumber;
    
        @Override
    public String toString() {
        return (id + "," + name + "," + lastName + "," + major + "," + email + "," + typeStudent + "," + phoneNumber);
    }


    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastname() {
        return lastName;
    }

    /**
     * @param lastName to set
     */
    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
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
     * @return the typeStudent
     */
    public String getTypeStudent() {
        return typeStudent;
    }

    /**
     * @param typeStudent the typeStudent to set
     */
    public void setTypeStudent(String typeStudent) {
        this.typeStudent = typeStudent;
    }

    /**
     * @return the phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}
