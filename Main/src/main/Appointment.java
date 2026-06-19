package main;


public class Appointment {
     private int appointmentID;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;
    private AppointmentStatus status;

    public Appointment(int appointmentID, Patient patient, Doctor doctor, String date, String time) {
        this.appointmentID = appointmentID;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        status = AppointmentStatus.SCHEDULED;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
    
    public void displayInfo(){
        System.out.println("Appointment ID : " + appointmentID);
        System.out.println("Patient Name   : " + patient.getName());
        System.out.println("Doctor Name    : " + doctor.getName());
        System.out.println("Date           : " + date);
        System.out.println("Time           : " + time);
        System.out.println("Status         : " + status);
        System.out.println("Fee            : $" + doctor.getConsultationFee());
    }
    
}
