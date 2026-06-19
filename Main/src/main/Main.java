package main;

public class Main {

    public static void main(String[] args) {
        // Create clinic
        Clinic clinic = new Clinic("City Health Clinic");

        // Create doctors
        Doctor doctor1 = new GeneralPractitioner(101, "Ahmed Ali");
        Doctor doctor2 = new Specialist(102, "Sara Hassan");
        Doctor doctor3 = new Consultant(103, "Omar Kareem");

        // Add doctors
        clinic.addDoctor(doctor1);
        clinic.addDoctor(doctor2);
        clinic.addDoctor(doctor3);

        Patient patient1 = new Patient(201, "Ali Mohammed", 22, "07701234567");
        Patient patient2 = new Patient(202, "Noor Ahmed", 30, "07807654321");

        // Add patients
        clinic.addPatient(patient1);
        clinic.addPatient(patient2);

        // Create appointments
        Appointment appointment1 = new Appointment(301,patient1,doctor1,"20/06/2026","10:00 AM");

        Appointment appointment2 = new Appointment(302,patient2,doctor2,"21/06/2026","11:30 AM");

        // Add appointments
        clinic.addAppointment(appointment1);
        clinic.addAppointment(appointment2);

        // Display everything
        System.out.println("===== Doctors =====");
        clinic.displayDoctors();

        System.out.println("===== Patients =====");
        clinic.displayPatients();

        System.out.println("===== Appointments =====");
        clinic.displayAppointments();
    }

}
