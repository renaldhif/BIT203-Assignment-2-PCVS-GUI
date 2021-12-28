/**
 *
 *     @author     : Renaldhi Fahrezi
 *     Student ID  : E1900355
 *     Date created: 29 October 2021
 *
 */

// import array list
import java.util.ArrayList;

/**
 * This is the Patient class.
 * It is a subclass from User abstract class.
 *
 * This class contains all the user class attributes
 * and ICPassport for the Patient.
 */
public class Patient extends User{
    // declare variable
    private String ICPassport;
    // aggregation from vaccination
    private ArrayList<Vaccination> vaccinationAgr;


    // constructor

    /**
     * This is the constructor class of patient.
     *
     * It uses super method to access the attributes
     * from the User abstract class.
     *
     * @param inUsername
     * @param inPassword
     * @param inEmail
     * @param inFullName
     * @param inICPassport
     */
    public Patient(String inUsername, String inPassword, String inEmail,
                   String inFullName, String inICPassport) {
        // super method to access the parent class attributes
        super(inUsername, inPassword, inEmail, inFullName);
        this.ICPassport = inICPassport;
        // aggregation from vaccination
        this.vaccinationAgr = new ArrayList<>();
    }

    // setters

    /**
     * This method will set the ICPassport of the patient
     *
     * @param inICPassport
     */
    public void setICPassport(String inICPassport) {
        this.ICPassport = inICPassport;
    }

    // aggregation from vaccination

    /**
     * This method will add the vaccination into the arraylist
     *
     * @param inVaccinationAgr
     */
    public void setVaccinationAgr(Vaccination inVaccinationAgr){
        this.vaccinationAgr.add(inVaccinationAgr);
    }

    /**
     * This method will return the vaccination arraylist of patient
     *
     * @return vaccination arraylist
     */
    public ArrayList<Vaccination> getVaccinationAgr() {
        return vaccinationAgr;
    }

    /**
     * This method will return the patient ICPassport
     *
     * @return patient ICPassport
     */
    public String getICPassport() {
        return ICPassport;
    }

    /**
     * This method will print patient ICPassport and all the attributes.
     * It overrides from the abstract class.
     *
     * @return string of staff ID and abstract class attributes
     */
    @Override // override
    public String toString() {
        return "ICPassport: " + ICPassport
                + super.toString();
    }
}
