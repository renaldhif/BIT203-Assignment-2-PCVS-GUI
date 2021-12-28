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
 * This is Healthcare center class.
 * It contains center name and the address of the healthcare center.
 *
 * Also, it contains aggregation attributes from Batch and Administrator.
 */
public class HealthcareCenter {
    private String centreName,
                address;

    // aggregation from Administrator class
    private ArrayList<Administrator> adminAgr;
    // aggregation from Batch class
    private ArrayList<Batch> batchAgr;

    //constructor

    /**
     * This is the constructor of Healthcare center class.
     *
     * @param inCentreName
     * @param inAddress
     */
    public HealthcareCenter(String inCentreName, String inAddress){
        this.centreName = inCentreName;
        this.address = inAddress;
        // aggregation
        this.adminAgr = new ArrayList<>();
        this.batchAgr = new ArrayList<>();
    }

    //setters

    /**
     * This method will set the healthcare center name
     *
     * @param inCentreName
     */
    public void setCentreName(String inCentreName) {
        this.centreName = inCentreName;
    }

    /**
     * This method will set the address of the healthcare center
     *
     * @param inAddress
     */
    public void setAddress(String inAddress) {
        this.address = inAddress;
    }

    // aggregation from Administrator class
    /**
     * This method will assign the administrator
     * who works in the healthcare center
     *
     * @param inAdminAgr
     */
    public void setAdminAgr(Administrator inAdminAgr){
        this.adminAgr.add(inAdminAgr);
    }

    // aggregation from Batch class

    /**
     * This method will assign the vaccine batch
     * registered into the healthcare center
     *
     * @param inBatchObj
     */
    public void setBatchAgr(Batch inBatchObj) {
        this.batchAgr.add(inBatchObj);
    }

    // getters

    /**
     * This method will get the center name of the healthcare center
     *
     * @return healthcare center name
     */
    public String getCentreName() {
        return centreName;
    }

    /**
     * This method will get the address of the healthcare center
     *
     * @return healthcare center address
     */
    public String getAddress() {
        return address;
    }

    // aggregation from Administrator class

    /**
     * This method will get the arraylist of assigned administrator
     * who works in the healthcare center
     *
     * @return arraylist assigned administrator
     */
    public ArrayList<Administrator> getAdminAgr(){
        return adminAgr;
    }

    // aggregation from Batch class

    /**
     * This method will get the arraylist of assigned vaccine batch
     * in the healthcare center
     *
     *
     * @return arraylist assigned batch
     */
    public ArrayList<Batch> getBatchAgr() {
        return batchAgr;
    }

    /**
     * This method will print the healthcare center attributes
     *
     * @return string of healthcare center attributes
     */
    public String toString() {
        return "Healthcare Center Name: " + centreName
                + ", address: " + address;
    }
}
