/**
 *
 *     @author     : Renaldhi Fahrezi
 *     Student ID  : E1900355
 *     Date created: 29 October 2021
 *
 */

/**
 * This is the vaccination class.
 * It contains attributes such as
 * vaccination ID, appointmentDate, status, and remarks.
 */
public class Vaccination {
    private String vaccinationID,
            appointmentDate,
            status,
            remarks;

    // constructor

    /**
     * This is the constructor of Vaccination class
     *
     * @param inVaccinationID
     * @param inDate
     * @param inStatus
     * @param inRemarks
     */
    public Vaccination(String inVaccinationID, String inDate,
                       String inStatus, String inRemarks){
        this.vaccinationID = inVaccinationID;
        this.appointmentDate = inDate;
        this.status = inStatus;
        this.remarks = inRemarks;
    }

    // setters

    /**
     * This method will set the vaccination ID
     *
     * @param inVaccinationID
     */
    public void setVaccinationID(String inVaccinationID) {
        this.vaccinationID = inVaccinationID;
    }

    /**
     * This method will set the vaccination appointment date
     *
     * @param inDate
     */
    public void setAppointmentDate(String inDate) {
        this.appointmentDate = inDate;
    }

    /**
     * This method will set the status of vaccination
     *
     * @param inStatus
     */
    public void setStatus(String inStatus) {
        this.status = inStatus;
    }

    /**
     * This method will set the remarks of vaccination
     *
     * @param inRemarks
     */
    public void setRemarks(String inRemarks) {
        this.remarks = inRemarks;
    }

    // getters

    /**
     * This method will get the vaccination ID
     *
     * @return vaccination ID
     */
    public String getVaccinationID() {
        return vaccinationID;
    }

    /**
     * This method will get the appointment date
     *
     * @return vaccination application date
     */
    public String getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * This method will get the status of the vaccination
     *
     * @return status vaccination
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method will get the remarks of the vaccination
     *
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    // to strings

    /**
     * This method will print all the vaccination attributes
     *
     * @return vaccination attributes
     */
    public String toString() {
        return "vaccinationID: " + vaccinationID +
                ", Appointment Date: " + appointmentDate +
                ", status: " + status +
                ", remarks: " + remarks;
    }
}
