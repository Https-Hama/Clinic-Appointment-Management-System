package main;

import java.util.ArrayList;

public class Clinic {

    private String clinicName;

    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;

    public Clinic(String clinicName) {
        this.clinicName = clinicName;
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void displayDoctors() {
        for (int i = 0; i < doctors.size(); i++) {
            doctors.get(i).displayInfo();
            System.out.println();
        }
    }

    public void displayPatients() {
        for (int i = 0; i < patients.size(); i++) {
            patients.get(i).displayInfo();
            System.out.println();
        }
    }

    public void displayAppointments() {
        for (int i = 0; i < appointments.size(); i++) {
            appointments.get(i).displayInfo();
            System.out.println();
        }
    }

    public String getClinicName() {
        return clinicName;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    // find methods (searching )
    public Doctor findDoctorById(int id) throws RecordNotFoundException{
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getDoctorID() == id) {
                return doctors.get(i);
            }
        }
        throw new RecordNotFoundException("Doctor with ID " + id + " not found.");
    }

    public Patient findPatientById(int id) throws RecordNotFoundException{
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientID() == id) {
                return patients.get(i);
            }
        }
        throw new RecordNotFoundException("Patient with ID " + id + " not found.");
    }

    public Appointment findAppointmentById(int id) throws RecordNotFoundException{
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentID() == id) {
                return appointments.get(i);
            }
        }
        throw new RecordNotFoundException("Appointment with ID " + id + " not found.");
    }

// ---------- Booking ----------
    public void bookAppointment(int appointmentID, int patientID, int doctorID, String date, String time) throws RecordNotFoundException, TimeSlotUnavailableException{

        Patient patient = findPatientById(patientID);
        Doctor doctor = findDoctorById(doctorID);

        // check double-booking for this doctor at the same date and time
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getDoctor().getDoctorID() == doctorID && a.getDate().equals(date) && a.getTime().equals(time) && a.getStatus() != AppointmentStatus.CANCELLED) {
                throw new TimeSlotUnavailableException("Doctor ID " + doctorID + " already has an appointment on " + date + " at " + time);    
            }
        }
        Appointment appointment = new Appointment(appointmentID, patient, doctor, date, time);
        appointments.add(appointment);
        System.out.println("Appointment booked successfully.");
    }

    // ---------- Remove / Cancel ----------
    public void removeAppointment(int id) throws RecordNotFoundException{
        Appointment appointment = findAppointmentById(id);
        appointments.remove(appointment);
        System.out.println("Appointment removed successfully.");
    }

    public void cancelAppointment(int id) throws RecordNotFoundException, InvalidStatusChangeException{
        Appointment appointment = findAppointmentById(id);

        if (appointment.getStatus() == AppointmentStatus.COMPLETED) {
            System.out.println("Cannot cancel an appointment that is already completed.");
        }

        appointment.setStatus(AppointmentStatus.CANCELLED);
        System.out.println("Appointment cancelled successfully.");
    }
    
    // ---------- Update status ----------

    public void updateAppointmentStatus(int id, AppointmentStatus newStatus) throws RecordNotFoundException, InvalidStatusChangeException{

        Appointment appointment = findAppointmentById(id);

        if (appointment.getStatus() == AppointmentStatus.COMPLETED && newStatus == AppointmentStatus.CANCELLED) {
            System.out.println("Cannot cancel an appointment that is already completed.");
        }

        appointment.setStatus(newStatus);
        System.out.println("Appointment status updated to " + newStatus);
    }
    
    
    // ---------- Reports ----------

    public void doctorScheduleReport(int doctorID) throws RecordNotFoundException{
        Doctor doctor = findDoctorById(doctorID);
        System.out.println("Schedule for Dr. " + doctor.getName() + " (ID: " + doctorID + ")");
        System.out.println("-----------------------------------------");

        boolean found = false;
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getDoctor().getDoctorID() == doctorID) {
                a.displayInfo();
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments found for this doctor.");
        } 
    }
    
    
        public void patientHistoryReport(int patientID) throws RecordNotFoundException{
        Patient patient = findPatientById(patientID);
        System.out.println("Appointment history for " + patient.getName() + " (ID: " + patientID + ")");
        System.out.println("-----------------------------------------");

        boolean found = false;
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getPatient().getPatientID() == patientID) {
                a.displayInfo();
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointment history found for this patient.");
        }
    }

}
