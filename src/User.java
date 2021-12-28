/**
 *
 *     @author     : Renaldhi Fahrezi
 *     Student ID  : E1900355
 *     Date created: 29 October 2021
 *
 */

// User class is an abstract class and superclass

/**
 * This is the class user. Class user is an abstract class and super class.
 * It will inherit all the attributes into the subclass.
 *
 * This contains basic information of user
 * such as username, password, email, and full name
 * that will be inherited to Admin and Patient.
 */
public abstract class User {
    // declare  variables
    private String username,
            password, email,
            fullName;

    // constructor

    /**
     * This is the constructor of class User.
     * It will inherit all the attributes into the subclass
     * @param inUsername
     * @param inPassword
     * @param inEmail
     * @param inFullName
     */
    public User(String inUsername, String inPassword, String inEmail, String inFullName){
        this.username = inUsername;
        this.password = inPassword;
        this.email = inEmail;
        this.fullName = inFullName;
    }

    // Setters

    /**
     * This method will set the username
     *
     * @param inUsername
     */
    public void setUsername(String inUsername){
        this.username = inUsername;
    }

    /**
     * This method will set the password
     *
     * @param inPassword
     */
    public void setPassword(String inPassword){
        this.password = inPassword;
    }

    /**
     * This method will set the email
     *
     * @param inEmail
     */
    public void setEmail(String inEmail){
        this.email = inEmail;
    }

    /**
     * This method will set the full name
     * @param inFullName
     */
    public void setFullName(String inFullName){
        this.fullName = inFullName;
    }

    // Getters

    /**
     * This method will get the username
     *
     * @return username
     */
    public String getUsername(){
        return username;
    }

    /**
     * This method will get the password
     * @return password
     */
    public String getPassword(){
        return password;
    }

    /**
     * This method will get the email
     * @return email
     */
    public String getEmail(){
        return email;
    }

    /**
     * This method will return the full name
     *
     * @return full name
     */
    public String getFullName(){
        return fullName;
    }

    /**
     * This method will print all the attributes
     *
     * @return all the attributes.
     */
    public String toString() {
        return ", username: " + username +
                ", password: " + password +
                ", email: " + email +
                ", fullName: " + fullName;
    }
}
