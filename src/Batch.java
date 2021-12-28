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
 * This is the Batch class.
 * It contains batch number, batch expiry date,
 * quantity available and quantity administered
 * and also aggregation attributes from Vaccination class.
 */
public class Batch {
    private String batchNo, expiryDate;

    private int quantityAvailable, quantityAdministered;
    // aggregation from vaccination
    private ArrayList<Vaccination> vaccinationAgr;

    /**
     * This is the constructor of Batch class
     *
     * @param inBatchNo
     * @param inExp
     * @param inQtyAvail
     * @param inQtyAdm
     */
    public Batch(String inBatchNo, String inExp,
                 int inQtyAvail, int inQtyAdm){
        this.batchNo = inBatchNo;
        this.expiryDate = inExp;
        this.quantityAvailable = inQtyAvail;
        this.quantityAdministered = inQtyAdm;
        // aggregation from vaccination
        this.vaccinationAgr = new ArrayList<>();
    }

    // setters

    /**
     * This method will set the batch number
     *
     * @param inBatchNo
     */
    public void setBatchNo(String inBatchNo) {
        this.batchNo = inBatchNo;
    }

    /**
     * This method will set the expiry date
     *
     * @param inExp
     */
    public void setExpiryDate(String inExp) {
        this.expiryDate = inExp;
    }

    /**
     * This method will set the quantity available
     * @param inQtyAvail
     */
    public void setQuantityAvailable(int inQtyAvail) {
        this.quantityAvailable = inQtyAvail;
    }

    /**
     * This method will set the quantity administered
     *
     * @param inQtyAdm
     */
    public void setQuantityAdministered(int inQtyAdm) {
        this.quantityAdministered = inQtyAdm;
    }

    // aggregation from vaccination

    /**
     * This method will add vaccination object to
     * the arraylist of vaccination
     *
     * @param inVaccinationAgr
     */
    public void setVaccinationAgr(Vaccination inVaccinationAgr){
        this.vaccinationAgr.add(inVaccinationAgr);
    }

    // getters

    /**
     * This method will return the vaccine batch number
     *
     * @return the batch number
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * This method will return the batch expiry date
     *
     * @return batch expiry date
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * This method will return the batch quantity available
     *
     * @return batch quantity available
     */
    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    /**
     * This method will return the batch quantity administered
     *
     * @return quantity administered
     */
    public int getQuantityAdministered() {
        return quantityAdministered;
    }

    /**
     * This method will return the vaccination array list
     *
     * @return vaccination array list
     */
    public ArrayList<Vaccination> getVaccinationAgr() {
        return vaccinationAgr;
    }

    // to string

    /**
     * This method will print the batch attributes
     *
     * @return string of batch attributes
     */
    public String toString() {
        return "Batch No: " + batchNo +
                ", Expired at: " + expiryDate +
                ", Quantity available: " + quantityAvailable;
    }
}
