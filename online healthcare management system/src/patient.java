import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    private String name;
    private int id;
    private String contact;

    public Patient(int id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + "\nName: " + name + "\nContact: " + contact;
    }
}

class Doctor {
    private String name;
    private int id;
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id + "\nName: " + name + "\nSpecialization: " + specialization;
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String appointmentTime;

    public Appointment(Patient patient, Doctor doctor, String appointmentTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentTime = appointmentTime;
    }

    public void printAppointmentDetails() {
        System.out.println("\nAppointment Details:");
        System.out.println(patient);
        System.out.println(doctor);
        System.out.println("Appointment Time: " + appointmentTime);
    }
}

class HealthcareSystem {
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();

    public void addPatient(int id, String name, String contact) {
        patients.add(new Patient(id, name, contact));
    }

    public void addDoctor(int id, String name, String specialization) {
        doctors.add(new Doctor(id, name, specialization));
    }

    public void scheduleAppointment(int patientId, int doctorId, String appointmentTime) {
        Patient patient = null;
        Doctor doctor = null;

        // Search for the patient and doctor
        for (Patient p : patients) {
            if (p.getId() == patientId) {
                patient = p;
                break;
            }
        }
        for (Doctor d : doctors) {
            if (d.getId() == doctorId) {
                doctor = d;
                break;
            }
        }

        if (patient != null && doctor != null) {
            appointments.add(new Appointment(patient, doctor, appointmentTime));
            System.out.println("Appointment scheduled successfully!");
        } else {
            System.out.println("Invalid patient or doctor ID.");
        }
    }

    public void showAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.printAppointmentDetails();
            }
        }
    }

    public void showDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            System.out.println("\nAvailable Doctors:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }

    public void showPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("\nRegistered Patients:");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }
}

public class OnlineHealthcareManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HealthcareSystem system = new HealthcareSystem();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Online Healthcare Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. View Doctors");
            System.out.println("6. View Patients");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient contact: ");
                    String contact = scanner.nextLine();
                    system.addPatient(patientId, patientName, contact);
                    break;

                case 2:
                    System.out.print("Enter doctor ID: ");
                    int doctorId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter doctor specialization: ");
                    String specialization = scanner.nextLine();
                    system.addDoctor(doctorId, doctorName, specialization);
                    break;

                case 3:
                    System.out.print("Enter patient ID: ");
                    int pId = scanner.nextInt();
                    System.out.print("Enter doctor ID: ");
                    int dId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter appointment time (e.g., 2024-11-13 14:00): ");
                    String appointmentTime = scanner.nextLine();
                    system.scheduleAppointment(pId, dId, appointmentTime);
                    break;

                case 4:
                    system.showAppointments();
                    break;

                case 5:
                    system.showDoctors();
                    break;

                case 6:
                    system.showPatients();
                    break;

                case 7:
                    System.out.println("Exiting system...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
