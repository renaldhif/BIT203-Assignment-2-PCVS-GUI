 /**
  *
  *     @author     : Renaldhi Fahrezi
  *     Student ID  : E1900355
  *     Date created: 29 October 2021
  *
  */


// Import java utility
// and time library that needed in this class
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

 /**
  * PCVS is a class to handle objects
  * from other classes and some methods
  * that will be used for the console application.
  */
 public class PCVS {

        // arraylist of Patient
        private ArrayList<Patient> patientList = new ArrayList<>();
        // arraylist of Administrator
        private ArrayList<Administrator> adminList = new ArrayList<>();
        // arraylist of Healthcare Center
        private ArrayList<HealthcareCenter> centreList = new ArrayList<>();
        // arraylist of healthcare center that contains assigned vaccine
        private ArrayList<HealthcareCenter> listHCVacAdded
                                            = new ArrayList<>();
        // arraylist of Vaccine
        private ArrayList<Vaccine> vaccineList = new ArrayList<>();

         /**
          * declares a vaccine object with initial value
          * for accessing the attributes.
          *
          * initialize the object of Patient, Administrator,
          * Vaccine for using the variable
          */
        private Patient dataPatient = new Patient(
                 "no username",
                 "no password",
                    "no email",
                 "no full name",
                "no IC Passport");

        private Administrator dataAdmin = new Administrator(
                 "no username",
                 "no password",
                    "no email",
                 "no full name",
                   "defaultForAdmin");

        private Vaccine vaccineObj = new Vaccine(
                "V00","No Name",
                "No Name");


     /**
      * This is the constructor method.
      *
      * These lines will add HealthcareCenter to the array list
      * of HealthcareCenter Class and add Vaccine to the array list
      * of Vaccine Class
      */
        public PCVS(){
                // Healthcare centre lists
                centreList.add(new HealthcareCenter(
                        "Siloam Hospital",
                        "Denpasar"));

                centreList.add(new HealthcareCenter(
                        "Bali " +
                        "International Medical Centre(BIMC)",
                        "Badung"));

                centreList.add(new HealthcareCenter(
                        "Sanjiwani " +
                        "Hospital","Gianyar"));

                centreList.add(new HealthcareCenter(
                        "Karangasem " +
                        "Public Hospital",
                        "Karangasem"));

                centreList.add(new HealthcareCenter(
                        "Bangli " +
                        "Public Hospital", "Bangli"));

                // vaccine lists
                vaccineList.add(new Vaccine("V01",
                        "Sinovac Research " +
                                "and Development Co.,Ltd",
                        "Sinovac"));

                vaccineList.add(new Vaccine("V02",
                        "Oxford/AstraZeneca",
                        "AstraZeneca"));

                vaccineList.add(new Vaccine("V03",
                        "Pfizer Inc.",
                        "Pfizer"));

                vaccineList.add(new Vaccine("V04",
                        "CBPGC Co.,Ltd.(Sinopharm)",
                        "Sinopharm"));

                vaccineList.add(new Vaccine("V05",
                        "Moderna, Inc.",
                        "Moderna"));
        }

     /**
      * This method is used to add new object
      * to the admin arraylist by argument
      *
      * @param newAdmin
      */
    public void setAdminList(Administrator newAdmin) {
            this.adminList.add(newAdmin);
    }

     /**
      * This method is used to add new object
      * to the patient arraylist by argument
      *
      * @param newPatient
      */
    public void setPatientList(Patient newPatient) {
            this.patientList.add(newPatient);
    }


     /**
      * This method is used to add new object
      * to the arraylist by argument
      *
      * @param newCentre
      */
    public void setCentreList(HealthcareCenter newCentre) {
            this.centreList.add(newCentre);
    }

     /**
      * This method will set a batch
      * to the Healthcare Center by Vaccine ID and batch object
      *
      * @param inHC
      * @param inBatch
      */
    public void setBatchToHC(HealthcareCenter inHC,
                             Batch inBatch){
         inHC.setBatchAgr(inBatch);
     }

     /**
      *  This method is used to add new object
      *  to the vaccine arraylist by argument
      *
      * @param newVaccine
      */
    public void setVaccineList(Vaccine newVaccine){
            this.vaccineList.add(newVaccine);
    }

     /**
      * This method will set a batch
      * to the selected vaccine by Vaccine ID and batch object
      *
      * @param IDVac
      * @param inBatchAgr
      */
    public void setBatchToVaccine(int IDVac, Batch inBatchAgr){
            getVaccineByIndex(IDVac).setBatchAgr(inBatchAgr);
    }

     /**
      * This method will set an appointment
      * of vaccination for the patient by argument
      *
      * @param inVaccination
      * @param inBatch
      * @param inPatient
      */
    public void setVaccination(Vaccination inVaccination,
                               Batch inBatch, Patient inPatient){
            inPatient.getVaccinationAgr().add(inVaccination);
            inBatch.getVaccinationAgr().add(inVaccination);
            // decrement the quantity of vaccine based
            // on the pending status
            inBatch.setQuantityAvailable(inBatch.
                                getQuantityAvailable()-1);
    }
    
     /**
      * This method used to get an arraylist of Healthcare Center
      * by return the centreList
      *
      * @return centreList
      */
    public ArrayList<HealthcareCenter> getCentreList() {
         return centreList;
    }

     /**
      * This method will return
      * the arraylist of administrator.
      *
      * @return arraylist administrator
      */
    public ArrayList<Administrator> getAdminList() {
         return adminList;
    }

     /**
      * This method will return the arraylist of patient.
      *
      * @return arraylist patient
      */
    public ArrayList<Patient> getPatientList() {
         return patientList;
    }

     /**
      * This method will return arraylist of vaccine
      *
      * @return arraylist of vaccine
      */
    public ArrayList<Vaccine> getVaccineList() {
         return vaccineList;
    }

     /**
      * This method will return all the Vaccines
      * added to the Vaccines Array List
      * by using an index number
      *
      * @param idxNUm
      * @return arraylist of vaccine by index
      */
    public Vaccine getVaccineByIndex(int idxNUm){
         return vaccineList.get(idxNUm);
    }

     /**
      * This method will return all the Healthcare centers
      * added to the HealthcareCenter Arraylist
      * by using an index number
      *
      * @param idxNum
      * @return arraylist of healthcare center by index
      */
    public HealthcareCenter getCentreListByIndex(int idxNum){
         return centreList.get(idxNum);
    }

     /**
      * This method will return all the healthcare centers
      * that contains vaccine added to the healthcare.
      *
      * @param idxNum
      * @return the arraylist of healthcare t
      * hat contains assigned vaccine
      */
    public HealthcareCenter getCentreListVacAddedIdx (int idxNum){
         return listHCVacAdded.get(idxNum);
    }

     /**
      * This method will return all arraylist patient object.
      *
      * @return arraylist patient
      */
    public Patient getDataPatient(){
         for (int i = 0; i < getPatientList().size(); i++){
             dataPatient = getPatientList().get(i);
         }
         return dataPatient;
    }

     /**
      * This method will return patient object
      * stored in patient arraylist
      * by using patient's username and password.
      *
      * It uses equals method to validate username and password
      * inputted are equal to the username and password
      * added to the arraylist
      *
      * @param inUsername
      * @param inPassword
      * @return patient object by using patient's username and password.
      */
     public Patient getPatient(String inUsername, String inPassword){
         for (int i = 0; i < getPatientList().size(); i++){
             Patient dataPatient = getPatientList().get(i);
             // validates login by comparing
             // the username and password inputted
             // with patient's username and password
             if(dataPatient.getUsername().equals(inUsername)
                     &&
                 dataPatient.getPassword().equals(inPassword)){
                 return dataPatient;
             }
         }
         return null;
     }

     /**
      * This method will return all arraylist patient object.
      *
      * @return arraylist administrator
      *
      */
     public Administrator getDataAdministrator(){
         for (int j = 0; j < getAdminList().size(); j++){
             dataAdmin = getAdminList().get(j);
         }
         return dataAdmin;
     }

     /**
      * This method will return all the patients full name
      *
      * @return patients full name
      */
     public String showAllPatientFullName(){
         String showPatientFN = "";

         for(int i = 0; i < getPatientList().size(); i++){
             showPatientFN += "[" + (i+1) + "]. "
                            + getPatientList().get(i).getFullName()
                            + "\n";
         }

         return showPatientFN;
     }

     /**
      * This method will return all the admins full name
      *
      * @return admins full name
      */
     public String showAllAdminFullName(){
         String showAdminFN = "";

         for(int i = 0; i < getAdminList().size(); i++){
             showAdminFN += "[" + (i+1) + "]. "
                          + getAdminList().get(i).getFullName()
                          + "\n";
         }

         return showAdminFN;
     }

     /**
      * This method will return
      * the healthcare center admin who works here
      *
      * @param inUsername
      * @return the admin's healthcare center
      */
     public HealthcareCenter getAdminInHC(String inUsername){
         // healthcare center loop to get the healthcare center
         for (int i = 0; i < getCentreList().size(); i++){
             HealthcareCenter dataHC = getCentreListByIndex(i);
             // then loop for the admin
             // assigned to the healthcare center
             for (int j = 0; j < dataHC.getAdminAgr().size(); j++){
                 // conditional statement to prevent
                 // looping all the admin objects
                 // by validating the username inputted
                 // is equal to the admin's username
                 if (dataHC.getAdminAgr().get(j).getUsername()
                         .equals(inUsername)){
                     return dataHC;
                 }
             }
         }
         return null;
     }

     /**
      * This method will print the vaccine name selected by user
      * by using index number
      *
      * @param idxNum
      * @return vaccine name selected by user
      */
     public String getVaccineName(int idxNum){
         return "Vaccine "
                 + vaccineList.get(idxNum).getVaccineName();
     }

     /**
      * This method will print the vaccine manufacturer name
      * selected by user by using index number
      *
      * @param idxNum
      * @return vaccine manufacturer name selected by user
      */
     public String getVaccineManufact(int idxNum){
         return ", Manufactured by "
                 + vaccineList.get(idxNum).getManufacturer();
     }

     /**
      * This method will print all the vaccines name
      * and the vaccine ID
      *
      * @return vaccine name and vaccine ID
      */
     public String getAllVaccinesID(){
         String getVaccines = "";

         for (int i = 0; i < vaccineList.size(); i++){
             vaccineObj = vaccineList.get(i);
             getVaccines += "\t[" + (i+1) + "]. "
                          + vaccineObj.getVaccineID()
                          + "(" + vaccineObj.getVaccineName()
                          + ")\n";
         }
         return getVaccines;
     }

     /**
      * This method is used to return the healthcare center
      * that offers the selected vaccine
      * by user using selected vaccine number.
      *
      * It uses contains method to check
      * if batch recorded at healthcare center
      * contains batch recorded to the vaccine
      * and the arraylist of healthcare
      * does not contain healthcare center
      *
      * @param iVC
      * @return the list of healthcare center
      * that offered the vaccine
      */
     public String getAvailVaccineHC(int iVC){

         String showVacHC = "";
         HealthcareCenter dataHC;
         Batch dataBatchVC;
         Vaccine dataVC = getVaccineByIndex(iVC);

         for (int j = 0; j < dataVC.getBatchAgr().size(); j++){
             dataBatchVC = dataVC.getBatchAgr().get(j);

             for (int k = 0; k < getCentreList().size(); k++){
                 dataHC = getCentreList().get(k);
                    // add the healthcare center to the arraylist
                 if ((dataHC.getBatchAgr().contains(dataBatchVC))
                         &&
                     (!listHCVacAdded.contains(dataHC))){
                     listHCVacAdded.add(dataHC);
                 }

             }
         }
        // prints the arraylist of healthcare center
         for (int i = 0; i < listHCVacAdded.size(); i++){
             showVacHC += "\n\t[" + (i + 1) + "]. "
                        + listHCVacAdded.get(i);
         }

         return showVacHC;
     }

     /**
      * This method will return the batch expired date
      * by using selected vaccine number by user.
      *
      * @param iVC
      * @return the batch expired date
      */
     public LocalDate getExpDateBatch(int iVC){
         String expDateStr;
         Batch dataBatchVC;
         LocalDate expDate = null;

         Vaccine dataVC = getVaccineByIndex(iVC);
         // get batch from vaccine
         for (int i = 0; i < dataVC.getBatchAgr().size(); i++) {
             dataBatchVC = dataVC.getBatchAgr().get(i);
             // get batch expired date
             expDateStr = dataBatchVC.getExpiryDate();
             // formatter for format the string into dd/mm/yyyy
             DateTimeFormatter formatter =
                        DateTimeFormatter.ofPattern("d/MM/yyyy");
             // convert string into LocalDate using formatter
             expDate = LocalDate.parse(expDateStr, formatter);
         }
         return expDate;
     }

     /**
      * This method will return the batch expired date
      * by using Batch inputted by user.
      *
      * @param batch
      * @return the batch expired date
      */
     public LocalDate getExpDateBatchByBatch(Batch batch){
         String expDateStr;
         LocalDate expDate;

         // get batch expired date
         expDateStr = batch.getExpiryDate();
         // formatter for format the string into dd/mm/yyyy
         DateTimeFormatter formatter =
                        DateTimeFormatter.ofPattern("d/MM/yyyy");
         // convert string into LocalDate using formatter
         expDate = LocalDate.parse(expDateStr, formatter);

         return expDate;
     }

     /**
      * This method will validate login for the admin
      * by username and password inputted by the user.
      *
      * It uses equals method to validate the login.
      *
      * @param inUsername
      * @param inPassword
      * @return i if the username and password inputted
      * equals to the arraylist of healthcare,
      * otherwise it will return -1
      */
    public int validatesLoginForAdmin(String inUsername,
                                      String inPassword){
        for (int i = 0; i < getCentreList().size(); i++){
            HealthcareCenter dataHC = getCentreListByIndex(i);

            for (int j = 0; j < dataHC.getAdminAgr().size(); j++){
                // Compares the username and password inputted
                if(((dataHC.getAdminAgr().get(j).getUsername()).
                        equals(inUsername))
                        &&
                    (dataHC.getAdminAgr().get(j).getPassword()).
                            equals(inPassword)){
                    return i;
                }
            }
        }
        return -1;
    }

     /**
      * This method will validate login for the patient
      * by username and password inputted by the user.
      *
      * It uses equals method to validate the login.
      *
      * @param inUsername
      * @param inPassword
      * @return i if the username and password inputted
      * equals to the arraylist of healthcare,
      * otherwise it will return -1
      */
     public int validatesLoginForPatient(String inUsername,
                                         String inPassword){

            for (int i = 0; i < getPatientList().size(); i++){
                    Patient dataPatient = getPatientList().get(i);
                    // validates login by comparing
                    // the username and password inputted
                    // with patient's username and password
                    if((dataPatient.getUsername().equals(inUsername)
                            &&
                    (dataPatient.getPassword().equals(inPassword)))){
                            return i;
                    }
            }
            return -1;
    }

     /**
      * This method will validate an available username.
      * So, the username will be unique for
      * each admin and patient.
      *
      * It uses equals method to validate.
      *
      * @param inUsername
      * @return true if the username and password
      * inputted are the same.
      * Otherwise, it will return false.
      */
    public boolean validatesAvailUsername(String inUsername){
            getDataPatient();
            getDataAdministrator();
            // return the value of boolean true
            // if username inputted is equal
        // to the data(arraylist) patient or administrator
            if ((getDataPatient().getUsername().equals(inUsername))
                    ||
                (getDataAdministrator().getUsername().
                        equals(inUsername))){
                    return true;
            }
            return false;
    }

     /**
      * This method will return the patient's full name
      *
      * It uses equals method to compare username inputted
      * with username stored in arraylist patient
      *
      * @param inUsername
      * @return patient's full name if username inputted with
      * username stored in arraylist patient are equals
      */
     public String getPatientFN(String inUsername) {
         String patientUN, patientFN = "";

         for (int i = 0; i < getPatientList().size(); i++) {
             Patient dataPatient = getPatientList().get(i);
             // Store values to the variables
             patientUN = dataPatient.getUsername();

             // if username inputted is equal
             // to the patient's username
             // it will return the patient's full name.
             if (patientUN.equals(inUsername)) {
                 patientFN = dataPatient.getFullName();
             }
         }
         return patientFN;
     }
     /**
      * This method will print all the Healthcare Centers name
      * added to the array list
      *
      * @return all the healthcare centres name
      */
    public String showAllHealthCareCentres(){
            String showCentre = "";
            for (int i =0; i < centreList.size(); i++){
                    showCentre += "\t[" + (i+1) + "]. "
                                + centreList.get(i).getCentreName()
                                + "\n";
            }
            return showCentre;
    }

     /**
      * This method will print all the Vaccines name
      * added to the array list
      *
      * @return all the vaccines name
      */
    public String showAllVaccinesName(){
            String showVaccines = "";

            for (int i = 0; i < vaccineList.size(); i++){
                    showVaccines += "\t[" + (i+1) + "]. "
                                  + vaccineList.get(i).
                                    getVaccineName()
                                  + "\n";
            }
            return showVaccines;
    }

     /**
      * This method will return all batch details
      * that was inputted by the admins
      *
      * @return batch details
      */
    public String showAllBatchesInformation(){
            String showInformation = "", showBatch,
                    showExp, showVac, showHC;

            HealthcareCenter dataHC;
            Vaccine dataVac;
            int showQA;

            for (int i = 0; i < getVaccineList().size(); i++) {
                    dataHC = getCentreListByIndex(i);

                    // get batch
                    for (int j = 0; j < dataHC.getBatchAgr().size(); j++){
                            dataVac = getVaccineByIndex(j);

                            showHC = dataHC.getCentreName();

                            showBatch = dataHC.getBatchAgr().get(j).
                                            getBatchNo();

                            showExp = dataHC.getBatchAgr().get(j).
                                            getExpiryDate();

                            showQA = dataHC.getBatchAgr().get(j).
                                            getQuantityAvailable();

                            showVac = dataVac.getVaccineName();

                            showInformation +=
                                "Healthcare Center: "
                                + showHC
                                + "\n\tBatch no: " + showBatch
                                + "\n\t vaccine name: "
                                        + showVac
                                + "\n\tquantity available: "
                                        + showQA
                                + "\n\tVaccine Expired Date: "
                                        + showExp;
                            }
                    }
            return showInformation;
    }

     /**
      * This method will return batch detail such as
      * Batch number, expiry date, and quantity available
      * from healthcare and batch selected by user.
      *
      * It uses equals method to validate
      * if batch number from healthcare
      * is equals to the selected batch number from user
      *
      * @param idxHC
      * @param selectBatch
      * @return batch details from healthcare
      * and batch selected by user
      */
    public String showDetailBatchHC(int idxHC, String selectBatch){
            String showDetail = "", showBatch, showExp;
            int showQA;

                    HealthcareCenter dataHC =
                            getCentreListVacAddedIdx(idxHC);
                    // get batch
                    for (int j = 0; j < dataHC.getBatchAgr().
                            size(); j++){

                            if (dataHC.getBatchAgr().get(j).
                                    getBatchNo().equals(selectBatch)){

                                    showBatch = dataHC.getBatchAgr().
                                            get(j).getBatchNo();

                                    showExp = dataHC.getBatchAgr().
                                            get(j).getExpiryDate();

                                    showQA = dataHC.getBatchAgr().
                                            get(j).
                                            getQuantityAvailable();

                                    showDetail +=  "\tBatch no: "
                                            + showBatch +
                                        "\n\tquantity available: "
                                        + showQA
                                        + "\n\tVaccine Expired Date: "
                                        + showExp;
                            }
                    }
            return showDetail;
    }

     /**
      * This method will return the batch
      * from healthcare and batch selected by user
      *
      * It uses equals method to validate if batch number from healthcare
      * is equals to the selected batch number from user
      *
      * @param idxHC
      * @param selectBatch
      * @return
      */
    public Batch showBatchFromHCAvail(int idxHC, String selectBatch){
            Batch showBatch = null;

            // array list of Healthcare Center assigned to a variable
            HealthcareCenter dataHC = getCentreListVacAddedIdx(idxHC);
            // get batch
            for (int j = 0; j < dataHC.getBatchAgr().size(); j++){

                    if (dataHC.getBatchAgr().get(j).
                            getBatchNo().equals(selectBatch)){
                            showBatch = dataHC.getBatchAgr().get(j);
                    }
            }
            return showBatch;
    }

     /**
      * This method will return vaccine batches
      * that are ready to give to the patient.
      *
      * It uses LocalDate to ensure that the vaccine batch
      * is not expired by using isAfter.
      *
      * @param hcSelect
      * @param vacSelect
      * @return the batch is not expired
      */
    public String showBatchesHCReady(int hcSelect, int vacSelect){
        String batchListReady = "";
        Batch batch;
        LocalDate dateBatch;

        HealthcareCenter dataHCVac = getCentreListVacAddedIdx(hcSelect);
        Vaccine dataVac = getVaccineByIndex(vacSelect);

            for (int i = 0; i < dataHCVac.getBatchAgr().size(); i++){
                batch = dataHCVac.getBatchAgr().get(i);
                dateBatch = getExpDateBatchByBatch(batch);
                // if the vaccine's batch date is after the today's date
                // then, show the available batches
                if ((dataVac.getBatchAgr().contains(batch)
                        &&
                    dateBatch.isAfter(LocalDate.now())))
                        batchListReady += "\n\t[" + (i + 1) + "]. "
                                + batch;
            }
            return batchListReady;
    }

     /**
      * This method will return patient's vaccination status
      * by inputting the patient's data
      *
      * If login successful,
      * it will return the patient's vaccination status.
      *
      * Otherwise, it will return null if login not successful.
      *
      * @param patientLoggedIn
      * @param inUsername
      * @return vaccination status
      */
    public String getStatusVaccination(Patient patientLoggedIn,
                                       String inUsername){

        String showStatusVac = "";
        // if login successful

        if (patientLoggedIn.getUsername().equals(inUsername)){
            for (int i = 0;
                    i < patientLoggedIn.getVaccinationAgr().size(); i++){

                showStatusVac = patientLoggedIn.getVaccinationAgr().
                                                get(i).getStatus();
            }
        }
        // if login not successfull
        else{
            return null;
        }
        return showStatusVac;
    }

     /**
      * This method will return the boolean value
      * of status vaccine whether it is expired or not expired
      * from healthcare and number vaccine selected by user
      *
      * It uses LocalDate and isAfter method
      * to validate the batch is not expired.
      *
      * @param idxHC
      * @param vacSelect
      * @return the boolean value of status vaccine.
      */
    public boolean isVaccineNotExpired(int idxHC, int vacSelect){
            boolean isNotExpired = false;
            // get today's date
            LocalDate todaysDate = LocalDate.now();

            for (int i = 0; i < getCentreList().size(); i++) {
                    HealthcareCenter dataHCVac =
                                    getCentreListVacAddedIdx(idxHC);

                    for (int j = 0;
                         j < dataHCVac.getBatchAgr().size(); j++){
                            // if the vaccine's batch date
                            // is after the today's date
                            // then, it isn't expired;
                            if (getExpDateBatch(vacSelect).
                                    isAfter(todaysDate)){
                                    isNotExpired = true;
                            }
                            // if requested date
                            // from user's selected vaccine
                            // is before the today's date,
                            // then it's expired.
                            else{
                                    isNotExpired = false;
                            }
                    }
            }
            return isNotExpired;
    }

     /**
      * This method will return the boolean value
      * of appointment expired date whether it is expired
      * or not expired from the appointment
      * requested by the user, healthcare center
      * and number vaccine selected by user
      *
      * It uses LocalDate and isAfter method
      * to validate the batch
      * and appointment date is not expired.
      *
      * Also, it uses DateTimeFormatter
      * to format the appointment date
      * and convert it into LocalDate
      *
      * @param dateReqStr
      * @param idxHC
      * @param selectBatch
      * @return the boolean value
      *         of appointment expired date
      */
    public boolean isDateExpired(String dateReqStr,
                                 int idxHC, String selectBatch){
            // formatter for LocalDate
            DateTimeFormatter formatter =
                        DateTimeFormatter.ofPattern("d/MM/yyyy");
            // convert the appointment date requested
            // into LocalDate using formatter
            LocalDate localDateReq =
                        LocalDate.parse(dateReqStr, formatter);

            Batch inBatch = showBatchFromHCAvail(idxHC,selectBatch);
            LocalDate batchExp = getExpDateBatchByBatch(inBatch);
                // if appointment date requested
                // is after the batch expired date
            if (localDateReq.isAfter(batchExp)){
                // then it's expired
                    return true;
            }
            // otherwise, it's not expired
            return false;
    }

     /**
      * This method will generate
      * a random number for staff ID.
      *
      * The number will be generated from 0 to 100.
      *
      * It uses random class for generate
      * the random number for the staff ID.
      *
      * @return the staff ID number with prefix SID. (e.g. SID123)
      */
    public String generateStaffID() {
            Random rand = new Random();
            int max = 500, noStaff;

            noStaff = rand.nextInt(max);

            return "SID" +noStaff;
    }

     /**
      * This method will generate
      * a random number for Vaccination ID.
      *
      * The number will be generated from 0 to 100.000.
      *
      * It uses random class for generate
      * the random number for the Vaccination ID.
      *
      * @return the staff ID number with prefix VCN. (e.g. SID123)
      */

    public String generateVaccinationID() {
            // Using Random class for generate the staff ID
            Random rand = new Random();
            int max = 100000, noVacID;
            // This will create a Staff ID with maximum number is 50
            noVacID = rand.nextInt(max);

            return "Vaccination ID: VCN " +noVacID;
    }
}
