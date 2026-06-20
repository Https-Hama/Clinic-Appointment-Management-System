package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Clinic clinic = new Clinic("City Care Clinic");

        int choice;
        do {
            System.out.println("\n===== " + clinic.getClinicName() + " =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Register Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. Remove Appointment");
            System.out.println("6. Update Appointment Status");
            System.out.println("7. Display All Patients");
            System.out.println("8. Display All Doctors");
            System.out.println("9. Display All Appointments");
            System.out.println("10. Doctor Schedule Report");
            System.out.println("11. Patient History Report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear leftover newline after id

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // clear leftover newline after age

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    Patient patient = new Patient(id, name, gender, age, phone);
                    clinic.addPatient(patient);
                    System.out.println("Patient registered successfully.");
                    break;
                }

                case 2: {
                    System.out.print("Enter Doctor ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.println("Select Doctor Type:");
                    System.out.println("1. General Practitioner");
                    System.out.println("2. Specialist");
                    System.out.println("3. Consultant");
                    System.out.print("Choice: ");
                    int type = sc.nextInt();

                    Doctor doctor = null;
                    try {
                        if (type == 1) {
                            doctor = new GeneralPractitioner(id, name);
                        } else if (type == 2) {
                            doctor = new Specialist(id, name);
                        } else if (type == 3) {
                            doctor = new Consultant(id, name);
                        } else {
                            System.out.println("Invalid doctor type.");
                            break;
                        }
                        clinic.addDoctor(doctor);
                        System.out.println("Doctor registered successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }

                case 3: {
                    try {
                        System.out.print("Enter Appointment ID: ");
                        int apptId = sc.nextInt();
                        System.out.print("Enter Patient ID: ");
                        int patientId = sc.nextInt();
                        System.out.print("Enter Doctor ID: ");
                        int doctorId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Date (e.g. 2026-06-21): ");
                        String date = sc.nextLine();
                        System.out.print("Enter Time (e.g. 10:00): ");
                        String time = sc.nextLine();

                        clinic.bookAppointment(apptId, patientId, doctorId, date, time);

                    } catch (RecordNotFoundException | TimeSlotUnavailableException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }

                case 4: {
                    try {
                        System.out.print("Enter Appointment ID to cancel: ");
                        int id = sc.nextInt();
                        clinic.cancelAppointment(id);
                    } catch (RecordNotFoundException | InvalidStatusChangeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }

                case 5: {
                    try {
                        System.out.print("Enter Appointment ID to remove: ");
                        int id = sc.nextInt();
                        clinic.removeAppointment(id);
                    } catch (RecordNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }

                case 6: {
                    try {
                        System.out.print("Enter Appointment ID: ");
                        int id = sc.nextInt();
                        System.out.println("Select new status:");
                        System.out.println("1. Scheduled");
                        System.out.println("2. Completed");
                        System.out.println("3. Cancelled");
                        System.out.print("Choice: ");
                        int statusChoice = sc.nextInt();

                        AppointmentStatus newStatus;
                        if (statusChoice == 1) {
                            newStatus = AppointmentStatus.SCHEDULED;
                        } else if (statusChoice == 2) {
                            newStatus = AppointmentStatus.COMPLETED;
                        } else if (statusChoice == 3) {
                            newStatus = AppointmentStatus.CANCELLED;
                        } else {
                            System.out.println("Invalid status choice.");
                            break;
                        }

                        clinic.updateAppointmentStatus(id, newStatus);

                    } catch (RecordNotFoundException | InvalidStatusChangeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }

                case 7:
                    clinic.displayPatients();
                    break;

                case 8:
                    clinic.displayDoctors();
                    break;

                case 9:
                    clinic.displayAppointments();
                    break;

                case 10: {
                    try {
                        System.out.print("Enter Doctor ID: ");
                        int id = sc.nextInt();
                        clinic.doctorScheduleReport(id);
                    } catch (RecordNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }

                case 11: {
                    try {
                        System.out.print("Enter Patient ID: ");
                        int id = sc.nextInt();
                        clinic.patientHistoryReport(id);
                    } catch (RecordNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }

}
