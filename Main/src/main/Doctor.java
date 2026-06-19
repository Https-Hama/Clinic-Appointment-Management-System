package main;

public class Doctor {
    private int doctorID;
    private String name;
    private double consultationFee;

    public Doctor(int doctorID, String name, double consultationFee) {
        this.doctorID = doctorID;
        this.name = name;
        setConsultationFee(consultationFee);
    }
    
    public int getDoctorID() {
        return doctorID;
    }
    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getConsultationFee() {
        return consultationFee;
    }
    public void setConsultationFee(double consultationFee) {
        if (consultationFee > 0) {
             this.consultationFee = consultationFee;
        }else{
            System.out.println("Consultation fee cannot be negative.");
        }
       }
    public void displayInfo()
    {
        System.out.println("Doctor ID : " + doctorID);
        System.out.println("Name      : " + name);
        System.out.println("Fee       : $" + consultationFee);
    }
}
