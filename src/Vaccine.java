/**
 *
 *     @author     : Renaldhi Fahrezi
 *     Student ID  : E1900355
 *     Date created: 29 October 2021
 *
 */

// import java arraylist
import java.util.ArrayList;

/**
 * This is the Vaccine class.
 * It contains vaccine name, ID, and the manufacturer.
 *
 * Also, it contains aggregation attribute from batch
 */
public class Vaccine {
    private String vaccineID,
                manufacturer,
                vaccineName;

    // aggregation from Batch class
    private ArrayList<Batch> batchAgr;

    // constructor

    /**
     * This is the constructor class of Vaccine
     *
     * @param inVaccineID
     * @param inManufacturer
     * @param inVaccineName
     */
    public Vaccine(String inVaccineID,
                   String inManufacturer, String inVaccineName){
        this.vaccineID = inVaccineID;
        this.manufacturer = inManufacturer;
        this.vaccineName = inVaccineName;
        // aggregation from Batch
        this.batchAgr = new ArrayList<>();
    }

    // setters

    /**
     * This method will set the vaccine ID
     *
     * @param inVaccineID
     */
    public void setVaccineID(String inVaccineID) {
        this.vaccineID = inVaccineID;
    }

    /**
     * This method will set the vaccine manufacturer
     *
     * @param inManufacturer
     */
    public void setManufacturer(String inManufacturer) {
        this.manufacturer = inManufacturer;
    }

    /**
     * This method will set the vaccine name
     *
     * @param inVaccineName
     */
    public void setVaccineName(String inVaccineName) {
        this.vaccineName = inVaccineName;
    }

    // aggregation from Batch class

    /**
     * This method will set the assigned batch into the vaccine
     *
     * @param inBatchAgr
     */
    public void setBatchAgr(Batch inBatchAgr) {
        this.batchAgr.add(inBatchAgr);
    }

    // getters

    /**
     * This method will return the vaccine ID
     *
     * @return vaccine ID
     */
    public String getVaccineID() {
        return vaccineID;
    }

    /**
     * This method will return manufacturer vaccine
     *
     * @return vaccine manufacturer name
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * This method will return the vaccine name
     *
     * @return vaccine name
     */
    public String getVaccineName() {
        return vaccineName;
    }

    // aggregation from Batch class

    /**
     * This method will return the batch arraylist
     * assigned to the batch
     *
     * @return batch arraylist assigned
     */
    public ArrayList<Batch> getBatchAgr() {
        return batchAgr;
    }

    // to String

    /**
     * This method will return the vaccine attributes
     *
     * @return string of vaccine attributes
     */
    public String toString() {
        return "Vaccine " + vaccineName
                + ", with Vaccine ID: " + vaccineID
                + ", manufactured by: " + manufacturer;
    }
}
