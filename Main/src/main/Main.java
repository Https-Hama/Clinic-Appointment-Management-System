package main;

public class Main {

    public static void main(String[] args) {
        Doctor d1 = new GeneralPractitioner(101, "Ali");
        Doctor d2 = new Specialist(102, "Sara");
        Doctor d3 = new Consultant(103, "Ahmed");
        
        
        d1.displayInfo(); 
        d2.displayInfo(); 
        d3.displayInfo(); 
    }

}
