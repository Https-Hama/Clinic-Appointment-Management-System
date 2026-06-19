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
    
    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
    }
    public void addPatient(Patient patient){
        patients.add(patient);
    }
    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }
    
     public void displayDoctors(){
        for (int i = 0; i < doctors.size(); i++){
            doctors.get(i).displayInfo();
            System.out.println();
        }
    }
     
      public void displayPatients(){
        for (int i = 0; i < patients.size(); i++){
            patients.get(i).displayInfo();
            System.out.println();
        }
    }
      public void displayAppointments()
    {
        for (int i = 0; i < appointments.size(); i++)
        {
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
      
      
}
