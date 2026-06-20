
package main;

public class GeneralPractitioner extends Doctor{
     public GeneralPractitioner(int doctorID, String name){
        super(doctorID, name, 20.0);
    }
     
     @Override
    public void displayInfo() {
        System.out.println("Doctor ID: " + getDoctorID());
        System.out.println("Name: " + getName());
        System.out.println("Type: General Practitioner");
        System.out.println("Consultation Fee: " + getConsultationFee());
    }
}
