/**
 *
 * @author Renaldhi Fahrezi
 * Student ID  : E1900355
 * Date created: 29 October 2021
 *
 */

/**
 * This is the Administrator class.
 * It is a subclass from User abstract class.
 *
 * This class contains all the user class attributes
 * and staff ID for the staff.
 */
public class Administrator extends User {
    // declare variable
    private String staffID;

    // constructor

    /**
     * This is the constructor of the Administrator class.
     * It uses super method to access the attributes
     * from the User abstract class.
     *
     * @param inUsername
     * @param inPassword
     * @param inEmail
     * @param inFullName
     * @param inStaffID
     */
    public Administrator(String inUsername, String inPassword, String inEmail, String inFullName, String inStaffID) {
        // super method to access the parent class attributes
        super(inUsername, inPassword, inEmail, inFullName);
        this.staffID = inStaffID;
    }

    // Setters

    /**
     * This method will set the staff ID
     *
     * @param inStaffID
     */
    public void setStaffID(String inStaffID) {
        this.staffID = inStaffID;
    }

    // getters

    /**
     * This method will return the staff ID
     *
     * @return the staff ID
     */
    public String getStaffID() {
        return staffID;
    }

    /**
     * This method will print Staff ID and all the attributes.
     * It overrides from the abstract class.
     *
     * @return string of staff ID and abstract class attributes
     */
    @Override // override
    public String toString() {
        return "Administrator "
                + "with ID: "
                + staffID
                + super.toString();
    }
}
