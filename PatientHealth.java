import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Patient class
class Patient 
{
    private String name;
    private int age;
    private String gender;
    private String contactDetails;
    private List<MedicalRecord> medicalRecords;
    private String currentHealthStatus;
    private String allergies;
    private String insuranceInformation;

    // Constructor
    public Patient(String name, int age, String gender, String contactDetails,
                   List<MedicalRecord> medicalRecords, String currentHealthStatus,
                   String allergies, String insuranceInformation) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactDetails = contactDetails;
        this.medicalRecords = medicalRecords;
        this.currentHealthStatus = currentHealthStatus;
        this.allergies = allergies;
        this.insuranceInformation = insuranceInformation;
    }

    // Getters and setters

    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    public String getGender() 
    {
        return gender;
    }

    public String getContactDetails() 
    {
        return contactDetails;
    }

    public List<MedicalRecord> getMedicalRecords() 
    {
        return medicalRecords;
    }

    public String getCurrentHealthStatus() 
    {
        return currentHealthStatus;
    }

    public String getAllergies() 
    {
        return allergies;
    }

    public String getInsuranceInformation() 
    {
        return insuranceInformation;
    }
}

// MedicalRecord class
class MedicalRecord 
{
    private String date;
    private String diagnosis;
    private List<String> medications;

    public MedicalRecord(String date, String diagnosis, List<String> medications) 
    {
        this.date = date;
        this.diagnosis = diagnosis;
        this.medications = medications;
    }

    // Getters and setters

    public String getDate() 
    {
        return date;
    }

    public String getDiagnosis() 
    {
        return diagnosis;
    }

    public List<String> getMedications() {
        return medications;
    }
}

// PublicHealth interface
interface PublicHealth 
{
    void performPublicHealthActivities(Patient patient);
}

public class PatientHealth
{
    public static void main(String[] args) 
    {
        // Input from the user
        Scanner in = new Scanner(System.in);

        System.out.println("Enter patient details:");

        System.out.print("Name: ");
        String name = in.nextLine();

        System.out.print("Age: ");
        int age = in.nextInt();
        in.nextLine(); // Consuming the newline character

        System.out.print("Gender: ");
        String gender = in.nextLine();

        System.out.print("Contact Details: ");
        String contactDetails = in.nextLine();

        System.out.print("Allergies: ");
        String allergies = in.nextLine();

        System.out.print("Current Health Status: ");
        String currentHealthStatus = in.nextLine();

        System.out.print("Insurance Information: ");
        String insuranceInformation = in.nextLine();

        // Create medical records for the patient
        List<MedicalRecord> medicalRecords = new ArrayList<>();

        System.out.println("\nEnter medical records for the patient (type 'exit' to finish):");

        while (true) {
            System.out.print("Date (MM/DD/YYYY): ");
            String date = in.nextLine();

            if (date.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Diagnosis: ");
            String diagnosis = in.nextLine();

            System.out.print("Medications (comma-separated): ");
            String medicationsInput = in.nextLine();
            List<String> medications = List.of(medicationsInput.split(","));

            MedicalRecord medicalRecord = new MedicalRecord(date, diagnosis, medications);
            medicalRecords.add(medicalRecord);
        }

        // Creating a Patient object with user input
        Patient patient = new Patient(name, age, gender, contactDetails, medicalRecords,
                currentHealthStatus, allergies, insuranceInformation);

        // Lambda expression for public health activities
        PublicHealth publicHealth = p -> {
            System.out.println("\nPerforming public health activities for patient: " + p.getName());
            // Displaying patient's medical records
            System.out.println("\nMedical Records:");
            for (MedicalRecord record : p.getMedicalRecords()) {
                System.out.println("Date: " + record.getDate());
                System.out.println("Diagnosis: " + record.getDiagnosis());
                System.out.println("Medications: " + record.getMedications());
                System.out.println();
            }
        };

        // Performing public health activities using the lambda expression
        publicHealth.performPublicHealthActivities(patient);

        // Closing the scanner
        in.close();
    }
}
