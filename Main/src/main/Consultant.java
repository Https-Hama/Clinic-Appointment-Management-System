package main;

public class Consultant extends Doctor {
    public Consultant(int doctorID, String name)
    {
        super(doctorID, name, 80.0);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Doctor ID: " + getDoctorID());
        System.out.println("Name: " + getName());
        System.out.println("Type: Consultant");
        System.out.println("Consultation Fee: " + getConsultationFee());
    }
}
