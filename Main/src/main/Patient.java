package main;

public class Patient {
    private int patientID;
    private String name;
    private String gender;
    private int age;
    private String phone;

    public Patient(int patientID, String name,String gender,int age, String phone) {
        this.patientID = patientID;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
    }

    
    //get and set => patient ID
    public int getPatientID() {
        return patientID;
    }
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
    
    //get and set => name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    //get and set => gender
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    //get and set => age
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //get and set => phone
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
     public void displayInfo()
    {
        System.out.println("Patient ID : " + patientID);
        System.out.println("Name       : " + name);
        System.out.println("Gender     : " + gender);
        System.out.println("Age        : " + age);
        System.out.println("Phone      : " + phone);
    }
    
}
