/**
 *
 *      @author     : Renaldhi Fahrezi
 *      Student ID  : E1900355
 *      Date created: 30 October 2021
 *
 */

// import for all utility classes
import java.util.*;

/**
 * This is the PCVS Console class.
 * All the methods will be loaded in this class.
 *
 * The program will be running in this class.
 *
 * It takes input from user and give an output to the user
 */
public class PCVSConsole {
    /**
     * This is the main function.
     * It runs the whole program.
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Declare variables for user input (scanner)
         * and some variables have initialized values
         */
        Scanner scan = new Scanner(System.in);

        int option = 10, option2, centreOption, vacSelect,
                selectHCInfo, vaccineIDNum,
                qAvailable, qAdministered = 0;

        char batchOpt = ' ';

        String username, password, email, fullName, staffID,
                passport, vBatch, expiryDate, dateReq,
                vaccinationID, selectBatch = "";

        // Creating an object from PCVS Class
        PCVS pcvsObj = new PCVS();

        /**
         * This is the main menu.
         * It will loop until the user chooses exit by pressing 0
         */
        while (option != 0){
            System.out.println("\nPCVS System." +
                               "\n Please Select Menu Below:");
            System.out.println("\t[1]. Sign Up ");
            System.out.println("\t[2]. Login for Administrator");
            System.out.println("\t[3]. Login for Patient");
            System.out.println("\t[4]. Display all users");
            //System.out.println("\t[9]. DEBUGGING");
            System.out.println("\t[0]. Exit");
            System.out.print("\nSelect number: ");
            option = scan.nextInt();
            scan.nextLine();

            // switch case for main menu
            switch(option){
                // exit menu
                case 0:
                    System.out.println("Program closed. " +
                            "Thank you.\n Stay healthy and stay safe.");
                    break; // break case 0

                // Sign Up Account menu
                case 1:
                    System.out.println("\nSign Up for a new account.");
                    System.out.println("\t[1]. Administrator");
                    System.out.println("\t[2]. Patient");
                    System.out.print("\nSelect number: ");
                    option2 = scan.nextInt();
                    scan.nextLine();
                    // conditional statement for choosing account
                    if (option2 == 1 || option2 == 2){
                        System.out.print("\nEnter username: ");
                        username = scan.nextLine();

                        /**
                         * Check whether the username
                         * is available or has been taken
                         * to validate the username is unique.
                         *
                         * if boolean's value is true from the method,
                         * it will return this message.
                         */
                        if (pcvsObj.validatesAvailUsername(username)){
                            System.out.println("\n\tSorry. " +
                                            "Username has been taken. "
                                            + "Please try another one.");
                        }
                        else{
                            System.out.print("Enter password: ");
                            password = scan.nextLine();

                            System.out.print("Enter email: ");
                            email = scan.nextLine();

                            System.out.print("Enter Full Name: ");
                            fullName = scan.nextLine();

                            // generates staff ID
                            staffID = pcvsObj.generateStaffID();
                            // creates a new object from user input
                            Administrator adminAgr =
                                    new Administrator(username, password,
                                            email, fullName, staffID);

                            // conditional statement
                            // to sign up for Administrator
                            if (option2 == 1) {
                                System.out.println("\nPlease select " +
                                                "the health care centre: ");
                                System.out.println(pcvsObj.
                                                showAllHealthCareCentres());
                                System.out.print("Select number: ");
                                centreOption = scan.nextInt();
                                scan.nextLine();
                                // conditional statement to select
                                // the Healthcare Center (1-5)
                                if (centreOption > 0
                                        &&
                                    centreOption < 6){
                                    // assign the array list of
                                    // Healthcare Center into a variable
                                    HealthcareCenter selectHCAdmin =
                                            pcvsObj.getCentreListByIndex(
                                                    centreOption-1);
                                    // assign admin to selected healthcare center
                                    selectHCAdmin.setAdminAgr(adminAgr);
                                    // prints selected Healthcare Center
                                    System.out.println("\tYou're now " +
                                            "registered at: "
                                            + pcvsObj.getCentreListByIndex(
                                                    centreOption - 1)
                                            + ",with staff ID: " + staffID);
                                }
                                else {
                                    System.out.println("\tWrong number. " +
                                            "Please input the valid number.");
                                }
                                // adding assigned admin to the arraylist
                                pcvsObj.setAdminList(adminAgr);
                            }
                            // conditional statement to sign up for Patient
                            else{
                                System.out.print("Enter IC Passport: ");
                                passport = scan.nextLine();
                                // adding Patient object to the arraylist
                                Patient patientAgr = new Patient(username,
                                        password, email, fullName, passport);

                                pcvsObj.setPatientList(patientAgr);
                                System.out.println("\nYou're now Registered.");
                            }
                        }
                    }
                    // conditional statement if user inputs wrong number
                    else{
                        System.out.println("Please input valid number.");
                    }
                    break; // break case 1

                // Login menu for Administrator
                case 2:
                    System.out.println("\nLogin for an existing " +
                                        "account for Admin.");
                    System.out.print("Enter username: ");
                    username = scan.nextLine();

                    System.out.print("Enter password: ");
                    password = scan.nextLine();

                    // validates login for admin
                    if(pcvsObj.
                            validatesLoginForAdmin(
                                    username, password) == -1) {
                        System.out.println("\nERROR!" +
                                "\nWrong username or password");
                    }
                    else{
                        // get the admin assigned to the healthcare
                        HealthcareCenter HCAdmin =
                                pcvsObj.getAdminInHC(username);
                        System.out.println("Logged In.");
                        System.out.println("\n\tWelcome Admin, "
                                            + username);
                        System.out.println("\tYou're registered at "
                                            + HCAdmin.getCentreName());

                        System.out.println("\nSelect menu below.");
                        System.out.println("\t[1]. Input for " +
                                            "New Vaccine Batch");
                        System.out.println("\t[2]. View Vaccine " +
                                            "Batch Information");
                        System.out.println("\t[3]. Back");
                        System.out.print("\nSelect number: ");
                        option2 = scan.nextInt();
                        scan.nextLine();
                        // switch case for login menu admin
                        switch (option2) {
                            // input vaccine batch
                            case 1:
                                System.out.println(pcvsObj.
                                        getAllVaccinesID());
                                System.out.print("Select Vaccine ID: ");
                                vaccineIDNum = scan.nextInt();
                                // conditional statement to select
                                // the Vaccines (1-5)
                                scan.nextLine();
                                while (vaccineIDNum  < 0 || vaccineIDNum > 5){
                                    System.out.println("\nPlease input " +
                                            "the valid number.");
                                    System.out.print("Select vaccine ID: ");
                                    vaccineIDNum = scan.nextInt();
                                    scan.nextLine();
                                }
                                System.out.println(pcvsObj.
                                        getVaccineName(
                                                vaccineIDNum-1) +
                                        pcvsObj.getVaccineManufact
                                                (vaccineIDNum-1));

                                System.out.print("\nInput vaccine batch: ");
                                vBatch = scan.nextLine();

                                System.out.print("Input expiry date" +
                                        "(dd/mm/yyyy): ");
                                expiryDate = scan.nextLine();

                                System.out.print("Input quantity of doses" +
                                        " available: ");
                                qAvailable = scan.nextInt();
                                scan.nextLine();

                                // create a new batch object from user input
                                Batch batchAgr = new Batch(vBatch,
                                        expiryDate, qAvailable,
                                        qAdministered);
                                // and assign it into the Healthcare Center
                                pcvsObj.setBatchToHC (HCAdmin,batchAgr);
                                // and into the vaccine
                                pcvsObj.setBatchToVaccine(
                                        vaccineIDNum - 1,
                                        batchAgr);
                                System.out.println("\nRegistered." +
                                        "\nVaccine ID V0" + vaccineIDNum
                                        + ",batch " + vBatch
                                        + ", with " + qAvailable
                                        + " doses and expired at "
                                        + expiryDate);
                                break;
                            // view vaccine batch information
                            case 2:
                                System.out.print("Vaccine batch information: ");
                                System.out.println(pcvsObj.
                                        showAllBatchesInformation());
                                break;
                            // back menu
                            case 3:
                                break;
                            default:
                                System.out.println("You've inputted " +
                                        "a wrong number");
                        }
                    }
                    break; // break case 2

                // login menu for patient
                case 3:
                    System.out.println("\nLogin for an existing account" +
                            " for patient.");
                    System.out.print("\nEnter username: ");
                    username = scan.nextLine();

                    System.out.print("Enter password: ");
                    password = scan.nextLine();

                    /**
                     * Validates whether the username and
                     * the password inputted by a user is equal to
                     * the patient object that stored in ArrayList.
                     * if true, it will log in.
                     */
                    if (pcvsObj.validatesLoginForPatient(username,
                            password) == -1) {
                        System.out.println("Sorry. " +
                                "Wrong username or password");
                    }
                    else{
                        System.out.println("Logged In.");
                        System.out.println("\tWelcome Patient, "
                                + pcvsObj.getPatientFN(username));
                        System.out.println("\nSelect menu below.");
                        System.out.println("\t[1]. Request vaccination " +
                                "appointment");
                        System.out.println("\t[2]. View vaccination " +
                                "Appointment status");
                        System.out.println("\t[3]. Back");
                        System.out.print("Select number: ");
                        option2 = scan.nextInt();
                        scan.nextLine();

                        switch(option2){
                            case 1:
                                // it loops until the user press no
                                do{
                                    System.out.println("\nHere's " +
                                            "list of available vaccines: ");
                                    System.out.println(pcvsObj.
                                            showAllVaccinesName());

                                    System.out.print("Input number: ");
                                    vacSelect = scan.nextInt();
                                    scan.nextLine();
                                    while (vacSelect  < 0 || vacSelect > 5){
                                        System.out.println("Please " +
                                                "input the valid number.");
                                        System.out.print("Input number: ");
                                        vacSelect = scan.nextInt();
                                        scan.nextLine();
                                    }
                                    // prints vaccine name and the manufacturer
                                    System.out.println(pcvsObj.
                                            getVaccineName(
                                                    vacSelect-1)
                                            + pcvsObj.
                                            getVaccineManufact(
                                                    vacSelect-1));
                                    // prints the healthcare centers
                                    // that offer the vaccine selected by user
                                    System.out.println("\nHere's Healthcare centres " +
                                            "that offer the vaccine: ");
                                    System.out.println(pcvsObj.
                                            getAvailVaccineHC(vacSelect-1));

                                    System.out.println("\nSelect " +
                                            "the Healthcare centres to more details.");
                                    System.out.print("\tSelect number: ");
                                    selectHCInfo = scan.nextInt();
                                    scan.nextLine();

                                    // validates if the vaccine's batch date
                                    // is expired or not expired to today's date
                                    if (pcvsObj.
                                            isVaccineNotExpired(selectHCInfo-1,
                                                    vacSelect-1)){
                                        // if it's not expired,
                                        // then return the vaccine's available
                                        if (!pcvsObj.showBatchesHCReady(
                                                selectHCInfo-1, vacSelect-1).equals("")){
                                            // prints the vaccines that is not expired
                                            System.out.println(pcvsObj.
                                                    showBatchesHCReady(selectHCInfo - 1,
                                                            vacSelect - 1));

                                            System.out.print("\nSelect a batch " +
                                                    "number of the vaccine: ");
                                            selectBatch = scan.nextLine();

                                            System.out.println(pcvsObj.
                                                    showDetailBatchHC(
                                                        selectHCInfo - 1,
                                                        selectBatch));
                                            // user choose to take the batch
                                            // or not take the batch
                                            System.out.print("\nDo you want " +
                                                    "to take " +
                                                    "this batch? [Y]es/[N]o: ");
                                            batchOpt = scan.nextLine().charAt(0);

                                        }
                                        // if all the batches are expired
                                        else {
                                            System.out.println("\n\tSorry, " +
                                                "all the batches from " +
                                                "this healthcare center " +
                                                "are expired.");
                                            batchOpt = 'm';
                                        }
                                    }

                                }while (batchOpt != 'Y' && batchOpt != 'y');

                                System.out.print("\nWhat date " +
                                        "would you like to request?" +
                                        "(dd/mm/yyyy): ");
                                dateReq = scan.nextLine();
                                // if the date requested
                                // is expired to the batch
                                while(pcvsObj.isDateExpired(dateReq,
                                        selectHCInfo-1,
                                        selectBatch)){

                                        System.out.println("\n\tSorry, " +
                                                "the date you requested " +
                                                "is expired for the batch." +
                                                "\nPlease try another date.");

                                        System.out.print("\n" +
                                                "What date " +
                                                "would you like to request?" +
                                                "(dd/mm/yyyy): ");
                                        dateReq = scan.nextLine();
                                }
                                // generates vaccination ID
                                vaccinationID = pcvsObj.
                                        generateVaccinationID();
                                // creates patient appointment
                                // by creating an object of Vaccination
                                Vaccination vaccinationPatient
                                        = new Vaccination(vaccinationID,
                                        dateReq,"Pending",
                                        null);
                                // creates batch object by
                                // the healthcare and batch
                                // selected by the user
                                Batch batchVac = pcvsObj.
                                        showBatchFromHCAvail(
                                        selectHCInfo-1,
                                                selectBatch);
                                // creates patient object
                                // by the username and password logged in
                                Patient patientLoggedIn
                                        = pcvsObj.getPatient(
                                                username,
                                                password);
                                // adding the vaccination appointment
                                // to the arraylist
                                pcvsObj.setVaccination(vaccinationPatient,
                                            batchVac,
                                            patientLoggedIn);

                                System.out.println("\nRegistered on "
                                        + dateReq
                                        + "with vaccinationID: " +
                                        vaccinationID
                                        +
                                        "\n\tPlease wait for us " +
                                        "to confirm your vaccination request." +
                                        "\n\tThank you." +
                                        "\n\tStay Healthy and Stay Safe!");
                                break;

                            case 2:
                                System.out.println("Patient's full name: "
                                        + pcvsObj.getPatientFN(username));
                                System.out.println("Your appointment status: "
                                        + pcvsObj.getStatusVaccination(
                                            pcvsObj.
                                                getPatient(
                                                    username, password),
                                                    username));
                                break;

                            // back menu
                            case 3:
                                break;

                            default:
                                System.out.println("You've inputted " +
                                        "a wrong number");
                        }
                    }
                    break; // break case 3
                case 4:
                // original sorted
                    System.out.println("Here is " +
                            "the list of admins: ");
                    System.out.println(pcvsObj.
                            showAllAdminFullName());

                    System.out.println("Here is " +
                            "the list of patients: ");
                    System.out.println(pcvsObj.
                            showAllPatientFullName());

                break;

                // This case is for debugging
                // purposes only.
                // It will return the objects
                // that assigned to the arraylist
//                case 9:
//
//                    // print array list patient
//                    System.out.println("Array List of Patient: ");
//                    for (int i = 0; i < pcvsObj.getPatientList().
//                    size(); i++){
//                        System.out.println(pcvsObj.
//                        getPatientList().get(i));
//                    }
//
//                    System.out.println("===============
//                    ==============\n");
//
//                    // print array list newAdmin
//                    System.out.println("Array List
//                    of newAdmin: ");
//                    for (int i = 0; i < pcvsObj.getAdminList().
//                    size(); i++){
//                        System.out.println(pcvsObj.
//                        getAdminList().get(i));
//                    }
//
//                    System.out.println("==============
//                    ===============\n");
//
//                    // print array list newAdmin assigned
//                    to the healthcare centres
//                    for (int i = 0; i < pcvsObj.getCentreList().
//                    size(); i++){
//                        HealthcareCenter dataHC
//                        = pcvsObj.getCentreListByIndex(i);
//
//                        for (int j = 0; j < dataHC.getAdminAgr().
//                        size(); j++){
//                            System.out.println(
//                            "Admin Agr List with
//                            the selected HealthCare Centre\n");
//                            System.out.println(dataHC.getAdminAgr().
//                            get(j)
//                            + ", assigned to: "
//                            + pcvsObj.getCentreList().get(i));
//                        }
//                    }
//
//                    System.out.println("=============
//                    ================\n");
//
//                    System.out.println("Vaccine with i
//                    nputted batch: ");
//                    for (int i = 0; i < pcvsObj.getCentreList().
//                    size(); i++){
//                        HealthcareCenter dataHC = pcvsObj.
//                        getCentreListByIndex(i);
//
//                        for (int j = 0; j < dataHC.getBatchAgr().
//                        size(); j++){
//                            System.out.println("Batch List
//                            with the selected HealthCare Centre\n");
//                            System.out.println(dataHC.getBatchAgr().get(j)
//                            + ", assigned to: "
//                            + pcvsObj.getCentreList().get(i));
//
//                            System.out.println("Batch List with
//                            the selected Vaccine\n");
//                            System.out.println(dataHC.getBatchAgr().get(j)
//                            + ", assigned to: " + pcvsObj.getVaccineList().get(i));
//
//                        }
//                    }
//                    break;

                default:
                    System.out.println("You've inputted wrong number. " +
                            "Please enter the valid number.");
                    break; // break default case
            } // end bracket switch case
        }// end bracket while case
    }// end bracket main function
}
