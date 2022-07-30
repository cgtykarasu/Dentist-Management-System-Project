import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Cagatay KARASU
 */

public class Main {

    public static void main(String[] args) throws Exception {

        // 1. Load the data access driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //------------------------------------------------------------------------//


        Scanner input = new Scanner(System.in);

        int choice = 0;

        while (choice != 11) {

            System.out.println("\n" +
                    "1-\tAdd a new dentist\n" +
                    "2-\tDelete a dentist\n" +
                    "3-\tAdd a new patient\n" +
                    "4-\tDelete a patient\n" +
                    "5-\tAdd a new appointment\n" +
                    "6-\tDelete an appointment\n" +
                    "7-\tAdd a new treatment procedure\n" +
                    "8-\tDelete a treatment procedure\n" +
                    "9-\tList dentists\n" +
                    "10-\tList appointments\n" +
                    "11-\tExit the system");

            System.out.print("Select the option what you want to do please : ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addNewDentist();
                    break;

                case 2:
                    deleteDentist();
                    break;

                case 3:
                    addNewPatient();
                    break;

                case 4:
                    deletePatient();
                    break;

                case 5:
                    addNewAppointment();
                    break;

                case 6:
                    deleteAppointment();
                    break;

                case 7:
                    addNewTreatment();
                    break;

                case 8:
                    deleteTreatment();
                    break;

                case 9:
                    listDoctors();
                    break;

                case 10:
                    searchAppointments();
                    break;

                case 11:
                    System.exit(1);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private static void addNewDentist() {

        String url = "jdbc:mysql://localhost:3306/g21";
        String user = "root";
        String password = "";

        Scanner input = new Scanner(System.in);

        System.out.print("Type the new dentist's first name please : ");
        String name = input.next();

        System.out.print("Type the new dentist's last name please : ");
        String lName = input.next();

        System.out.print("Type the new dentist's year of service please : ");
        String yearOfService = input.next();

        try (Connection cn = DriverManager.getConnection(url,user,password);
             PreparedStatement st = cn.prepareStatement("INSERT INTO dentist (DFirstName, DLastName, YearOfService) " +
                     "VALUES (?, ?, ?)")){

            st.setString(1,name);
            st.setString(2,lName);
            st.setString(3,yearOfService);
            int rows = st.executeUpdate();
            System.out.println(rows);

            System.out.println("The new dentist " + name + " " + lName +  " added successfully.");
        }

        catch (SQLException e) {

            System.out.println("ERROR : Adding is invalid!");
        }
    }

    private static void deleteDentist() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/g21";
        String user = "root";
        String password = "";

        Scanner input = new Scanner(System.in);

        System.out.print("Type the dentist's first name you want to delete please : ");
        String delName = input.next();

        System.out.print("Type the dentist's last name you want to delete please : ");
        String delLName = input.next();

        Connection cn = DriverManager.getConnection(url,user,password);
        PreparedStatement st = cn.prepareStatement("DELETE FROM dentist WHERE DFirstName = ? && DLastName = ?");

        ResultSet resultSet = st.executeQuery("select * from dentist");
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();


        while (resultSet.next()) {

            names.add(resultSet.getString("DFirstName"));
            lastNames.add(resultSet.getString("DLastName"));
        }

        String[] namesArr = new String[names.size()];
        namesArr = names.toArray(namesArr);

        String[] lastNamesArr = new String[lastNames.size()];
        lastNamesArr = lastNames.toArray(lastNamesArr);

        boolean found = false;

        for (String s : namesArr) {

            for (String t : lastNamesArr) {

                if (s.equals(delName) && t.equals(delLName)) {

                    st.setString(1,delName);
                    st.setString(2,delLName);
                    int rows = st.executeUpdate();
                    System.out.println(rows);

                    System.out.println("The dentist " + delName + " " + delLName +  " deleted successfully.");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {

            System.out.println(delName + " " + delLName + " is not found!");
        }
    }

    private static void addNewPatient() {

        String url = "jdbc:mysql://localhost:3306/g21";
        String user = "root";
        String password = "";

        Scanner input = new Scanner(System.in);

        System.out.print("Type the new patient's first name please : ");
        String pName = input.next();

        System.out.print("Type the new patient's last name please : ");
        String pLName = input.next();

        System.out.print("Type the new patient's address please : ");
        String address = input.next();

        System.out.print("Type the new patient's contact number please : ");
        String cNumber = input.next();

        System.out.print("Type the new patient's email address please : ");
        String email = input.next();


        try (Connection cn = DriverManager.getConnection(url,user,password);
             PreparedStatement st = cn.prepareStatement("INSERT INTO patient " +
                     "(PFirstName, PLastName, Address, ContactNumber, EmailAddress) " +
                     "VALUES (?, ?, ?, ?, ?)")){

            st.setString(1,pName);
            st.setString(2,pLName);
            st.setString(3,address);
            st.setString(4,cNumber);
            st.setString(5,email);

            int rows = st.executeUpdate();
            System.out.println(rows);

            System.out.println("The new patient\n-----------------------\n" +
                    "Name & Lastname : " + pName + " " + pLName +  "\n" +
                    "Address : " + address + "\n" +
                    "Contact Number : " + cNumber + "\n" +
                    "Email Address : " + email + "\nadded successfully.");
        }

        catch (SQLException e) {

            System.out.println("ERROR : Adding is invalid!");
        }
    }

    private static void deletePatient() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/g21";
        String user = "root";
        String password = "";

        Scanner input = new Scanner(System.in);

        System.out.print("Type the patient's first name you want to delete please : ");
        String delPName = input.next();

        System.out.print("Type the patient's last name you want to delete please : ");
        String delPLName = input.next();

        Connection cn = DriverManager.getConnection(url,user,password);
        PreparedStatement st = cn.prepareStatement("DELETE FROM patient WHERE PFirstName = ? && PLastName = ?");

        ResultSet resultSet = st.executeQuery("select * from patient");
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();


        while (resultSet.next()) {

            names.add(resultSet.getString("PFirstName"));
            lastNames.add(resultSet.getString("PLastName"));
        }

        String[] namesArr = new String[names.size()];
        namesArr = names.toArray(namesArr);

        String[] lastNamesArr = new String[lastNames.size()];
        lastNamesArr = lastNames.toArray(lastNamesArr);

        boolean found = false;

        for (String s : namesArr) {

            for (String t : lastNamesArr) {

                if (s.equals(delPName) && t.equals(delPLName)) {

                    st.setString(1,delPName);
                    st.setString(2,delPLName);
                    int rows = st.executeUpdate();
                    System.out.println(rows);

                    System.out.println("The patient " + delPName + " " + delPLName +  " deleted successfully.");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {

            System.out.println(delPName + " " + delPLName + " is not found!");
        }
    }

    private static void addNewAppointment() throws Exception{

        String url = "jdbc:mysql://localhost:3306/g21";
        String user = "root";
        String password = "";

        Scanner input = new Scanner(System.in);

        // ------------------------ PATIENT SECTION ------------------------ //

        System.out.print("Write the name of the patient you want to add an appointment : ");
        String appPName = input.next();

        System.out.print("Write the last name of the patient you want to add an appointment : ");
        String appPLName = input.next();

        Connection cn = DriverManager.getConnection(url,user,password);
        PreparedStatement st = cn.prepareStatement("SELECT PID FROM patient WHERE PFirstName = ? && PLastName = ?");
        st.setString(1,appPName);
        st.setString(2,appPLName);

        ResultSet rs = st.executeQuery("select PID from patient WHERE PFirstName = '"+appPName+"' &&  PLastName = '"+appPLName+"'");

        rs.next();

        int id = rs.getInt("PID");
        String id2 = Integer.toString(id);

        System.out.println("PATIENT ID : " + id2);


        // ------------------------ DATE TIME SECTION ------------------------ //

        System.out.print("Write the appointment date please (Format : yyyy-MM-dd) : ");
        String date = input.next();

        System.out.print("Write the appointment time please (Format : HH:mm:ss) : ");
        String time = input.next();

        // ------------------------ DENTIST SECTION ------------------------ //

        System.out.print("Which dentist's appointment is this? Write the name please : ");
        String appDName = input.next();

        System.out.print("Write the dentist's last name please : ");
        String appDLName = input.next();

        Connection cn2 = DriverManager.getConnection(url,user,password);
        PreparedStatement st2 = cn2.prepareStatement("SELECT DID FROM dentist WHERE DFirstName = ? && DLastName = ?");
        st2.setString(1,appDName);
        st2.setString(2,appDLName);

        ResultSet rs2 = st.executeQuery("SELECT DID FROM dentist WHERE DFirstName = '" + appDName + "' &&  DLastName = '" + appDLName +"'");

        rs2.next();

        int id3 = rs2.getInt("DID");
        String id4 = Integer.toString(id3);

        System.out.println("DENTIST ID : " + id4);

        // ------------------------  TREATMENT SECTION ------------------------ //

        System.out.println("1 - Diş çekimi\n2 - Kanal Tedavisi\n3 - Diş Kaplama\n4 - Implant");
        System.out.print("What treatment procedure will dentist use? Enter the number please : ");
        String treatmentChoice = input.next();

        String treatment = "";

        switch (treatmentChoice) {

            case "1" :

                treatment = "Diş çekimi";
                break;

            case "2" :

                treatment = "Kanal tedavisi";
                break;

            case "3" :

                treatment = "Diş kaplama";
                break;

            case "4" :

                treatment = "Implant";
                break;

            default :
                System.out.println("ERROR : Invalid choice!");
        }

        // ------------------------  APPOINTMENT PROCEDURE SECTION ------------------------ //

        Connection connection = DriverManager.getConnection(url,user,password);

        String query = "INSERT INTO appointmentprocedure (AID, PID, TPID) " +
                "VALUES (?, ?, ?)";

        PreparedStatement prest;
        prest = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        prest.setString(1,null);
        prest.setString(2,id2);
        prest.setString(3,treatmentChoice);
        prest.executeUpdate();

        ResultSet resultSet1 = prest.getGeneratedKeys();

        int lastappID = 0;
        if (resultSet1.next()) {

            lastappID = resultSet1.getInt(1);
        }

        System.out.println("ID : " + lastappID);

        String lastappID2 = Integer.toString(lastappID);

     //   System.out.println("APPOINTMENT PROCEDURE LAST ID : " + lastappID2);

        String query2 = "INSERT INTO appointment " +
                "(Date, Time, PID, DID, APID, TPID) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement prest2;
        prest2 = connection.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
        prest2.setString(1,date);
        prest2.setString(2,time);
        prest2.setString(3,id2);
        prest2.setString(4,id4);
        prest2.setString(5,lastappID2);
        prest2.setString(6,treatmentChoice);
        prest2.executeUpdate();
        System.out.println("The appointment is created successfully : \n" +
                "Appointment Details : \n" +
                "Patient : " + appPName + " " + appPLName + "\n" +
                "Dentist : " + appDName + " " + appDLName + "\n" +
                "Date & Time : " + date + " " + time + "\n" +
                "Procedure : " + treatment);

        ResultSet resultSet2 = prest2.getGeneratedKeys();

        int lastappID3 = 0;
        if (resultSet2.next()) {

            lastappID3 = resultSet2.getInt(1);
        }

        String lastappID4 = Integer.toString(lastappID3);

        System.out.println("APPOINTMENT LAST ID : " + lastappID4);

        String query3 = "UPDATE appointmentprocedure SET AID = ? WHERE APID = ?";

        PreparedStatement prpstt = connection.prepareStatement(query3);

        prpstt.setString(1, lastappID4);
        prpstt.setString(2, lastappID2);

        prpstt.executeUpdate();
        connection.close();
    }

    private static void deleteAppointment() throws SQLException{

        String url = "jdbc:mysql://localhost:3306/g21";
        String user = "root";
        String password = "";

        Scanner input = new Scanner(System.in);

        System.out.print("Write the patient's name whose appointment you want to delete : ");
        String delApPName = input.next();

        System.out.print("Write the patient's last name whose appointment you want to delete : ");
        String delApPLName = input.next();

        System.out.print("Write the appointment's date you want to delete (Format : yyyy-MM-dd) : ");
        String delApDate = input.next();

        System.out.print("Write the appointment's time you want to delete (Format : HH:mm:ss) : ");
        String delApTime = input.next();

        Connection cn3 = DriverManager.getConnection(url,user,password);
        PreparedStatement st3 = cn3.prepareStatement("SELECT PID FROM patient WHERE PFirstName = ? && PLastName = ?");
        st3.setString(1,delApPName);
        st3.setString(2,delApPLName);

        ResultSet resultSet3 = st3.executeQuery("SELECT PID FROM patient WHERE PFirstName = '" + delApPName + "' && PLastName = '" + delApPLName + "'");

        resultSet3.next();

        int id5 = resultSet3.getInt("PID");
        String id6 = Integer.toString(id5);

    //    System.out.println("PID : " + id6);

        String delApp = "DELETE FROM appointment WHERE Date = ? && Time = ? && PID = ?";

        Connection cn4 = DriverManager.getConnection(url,user,password);
        PreparedStatement st4 = cn4.prepareStatement("SELECT APID FROM appointment WHERE Date = ? && Time = ? && PID = ?");
        st4.setString(1,delApDate);
        st4.setString(2,delApTime);
        st4.setString(3,id6);

        Connection connection1 = DriverManager.getConnection(url,user,password);
        PreparedStatement preparedStatement = connection1.prepareStatement(delApp);


        try (ResultSet resultSet4 = st4.executeQuery("SELECT APID FROM appointment WHERE Date = '" + delApDate + "' && Time = '" + delApTime + "' && PID = '" + id6 + "'")) {

            resultSet4.next();

            int id7 = resultSet4.getInt("APID");
            String id8 = Integer.toString(id7);

        //    System.out.println("APID : " + id8);

            String query = "UPDATE appointmentprocedure SET AID = ? WHERE APID = ?";

            PreparedStatement prpstt = cn4.prepareStatement(query);

            prpstt.setString(1, null);
            prpstt.setString(2, id8);

            prpstt.executeUpdate();
            cn4.close();

            preparedStatement.setString(1,delApDate);
            preparedStatement.setString(2,delApTime);
            preparedStatement.setString(3,id6);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows);

            System.out.println(delApPName + " " + delApPLName + "'s appointment is deleted successfully.\n" +
                    "Apoointment's Date : " + delApDate + "\nAppointment's Time : " + delApTime);
        }

        catch (SQLException e) {

            System.out.println("ERROR : Appointment is not found!xxx");
        }
    }

    private static void addNewTreatment() {

        String url = "jdbc:mysql://localhost:3306/g21";
        String user = "root";
        String password = "";

        Scanner input = new Scanner(System.in);

        System.out.print("Type the new treatment's description please : ");
        String description = input.nextLine();

        System.out.print("Type the new treatment's cost : ");
        String cost = input.next();

        try (Connection cn = DriverManager.getConnection(url,user,password);
             PreparedStatement st = cn.prepareStatement("INSERT INTO treatmentprocedure (Description, Cost) " +
                     "VALUES (?, ?)")){

            st.setString(1,description);
            st.setString(2,cost);
            int rows = st.executeUpdate();
            System.out.println(rows);

            System.out.println("The new treatment " + description + " (" + cost +  " TL) added successfully.");
        }

        catch (SQLException e) {

            System.out.println("ERROR : Adding is invalid!");
        }
    }

    private static void deleteTreatment() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/g21";
        String user = "root";
        String password = "";

        Scanner input = new Scanner(System.in);

        System.out.print("Type the treatment's description you want to delete please : ");
        String delTreatment = input.nextLine();


        Connection cn = DriverManager.getConnection(url,user,password);
        PreparedStatement st = cn.prepareStatement("DELETE FROM treatmentprocedure WHERE Description = ?");

        ResultSet resultSet2 = st.executeQuery("select Description from treatmentprocedure");
        ArrayList<String> descriptions = new ArrayList<>();

        while (resultSet2.next()) {

            descriptions.add(resultSet2.getString(1));

        }

        String[] descArr = new String[descriptions.size()];
        descArr = descriptions.toArray(descArr);

        for (String s : descArr) {
            System.out.println(s);
        }

        boolean found = false;

        for (String s : descArr) {

            if (s.equals(delTreatment)) {

                st.setString(1, delTreatment);
                int rows = st.executeUpdate();
                System.out.println(rows);

                System.out.println("The treatment " + delTreatment + " deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println(delTreatment + " is not found!");
        }
    }

    private static void searchAppointments() throws SQLException {

        /*Scanner input = new Scanner(System.in);

        System.out.print("Type the new treatment's description please : ");
        String description = input.nextLine();

        System.out.print("Type the new treatment's cost : ");
        String cost = input.next();*/

        String url = "jdbc:mysql://localhost:3306/g21";
        String user = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url,user,password);

        Statement statement = connection.createStatement();
        String search = "SELECT dentist.DID, dentist.DFirstName, dentist.DLastName, appointment.Date, " +
                "appointment.Time, patient.PFirstName, patient.PLastName, patient.ContactNumber, treatmentprocedure.Description " +
                "FROM dentist " +
                "INNER JOIN appointment ON appointment.DID = dentist.DID " +
                "INNER JOIN treatmentprocedure ON treatmentprocedure.TPID = appointment.TPID " +
                "INNER JOIN patient ON patient.PID = appointment.PID ORDER BY dentist.DFirstName ASC";

        ResultSet resultSet = statement.executeQuery(search);

        while (resultSet.next()) {

            System.out.println(
                    resultSet.getString("DID") + " " +
                    resultSet.getString("DFirstName") + " " +
                    resultSet.getString("DLastName") + " " +
                    resultSet.getString("Date") + " " +
                    resultSet.getString("Time") + " " +
                    resultSet.getString("PFirstName") + " " +
                    resultSet.getString("PLastName") + " " +
                    resultSet.getString("ContactNumber") + " " +
                    resultSet.getString("Description")
            );
        }
    }

    private static void listDoctors() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/g21";
        String user = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url,user,password);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from dentist");

        System.out.print("########################\nDentists are\n------------\n");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("DFirstName") + " " +
                    resultSet.getString("DLastName"));
        }
    }
}

