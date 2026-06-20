package main;

public class Specialist extends Doctor{
    public Specialist(int doctorID, String name)
    {
        super(doctorID, name, 100);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Doctor ID: " + getDoctorID());
        System.out.println("Name: " + getName());
        System.out.println("Type: Specialist");
        System.out.println("Consultation Fee: " + getConsultationFee());
    }

}
