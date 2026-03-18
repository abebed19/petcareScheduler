import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Scanner;

public class PetCareScheduler {

    private  static Scanner scanner = new Scanner(System.in);
    private static HashMap<String,Pet> pets = new HashMap<>();
    public static void main(String[] args){

        while(true){
            System.out.println("Please select your desired Option from the following");
            System.out.println("1. Register pets");
            System.out.println("2. Schedule appointments");
            System.out.println("3. Save Data");
            System.out.println("4. Display  Pets");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");

            String option = scanner.nextLine();


            switch (option){
                case "1":
                    registerPet();
                    break;
                case "2":
                    scheduleAppointment();
                    break;
                case "3":
                    saveData();
                    break;
                case "4":
                    displayPets();
                    break;
                case "5":
                    generateReport();
                    break;
                default:
                    System.out.println("Invalid Option please provide a valid option");

            }
        }
    }

    public static void registerPet(){
        System.out.println("Enter Pet Id: ");
        String id =  scanner.nextLine().trim();
        System.out.println("Enter pet name: ");
        String name = scanner.nextLine();
        System.out.println("Enter pet species: ");
        String petSpecies = scanner.nextLine();

        boolean isValid = true;
        int age = 0;
        while(isValid){
            System.out.println("Enter pet age: ");
            try {
                 age = Integer.parseInt(scanner.nextLine().trim());
                if (age <= 0) throw new IllegalArgumentException();
                break;

            }catch(NumberFormatException ex){
                System.out.println("Please provide number :" + ex.getMessage());
            }
            catch (IllegalArgumentException e) {
                System.out.println("Please provide valid age");
            }


        }

        System.out.println("Please enter owner name: ");
        String ownerName = scanner.nextLine();
        System.out.println("please provide contact info");
        String contactInfo = scanner.nextLine();

        Pet pet = new Pet(id,name,petSpecies,age,ownerName,contactInfo);

        if(pets.get(id) == null){
            pets.put(id, pet);
            System.out.println("Pet registered Successfully");
        } else{
            return;
        }
    }
    public static void scheduleAppointment(){
        System.out.println("Enter appointment type: ");
        String appointmentType = scanner.nextLine();
        System.out.println("Enter appointment Date and time using yyyy-MM-dd HH:mm:ss:");
        LocalDateTime dateTime = null;

        while(true){
            try{
                dateTime = LocalDateTime.parse(scanner.nextLine());
                if(!dateTime.isAfter(LocalDateTime.now())) throw new  IllegalArgumentException("Please provide valid date after the current date");
                break;
            }catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            catch (DateTimeParseException ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Enter notes ");
        String note  = scanner.nextLine();
        Appointment appointment = new Appointment(appointmentType,dateTime,note);
        System.out.println("Enter Please tell us Pet  ID: ");
        String petId = scanner.nextLine().trim();
        Pet pet = pets.get(petId);
        if(pet == null){
            System.out.println("Pet Not Found");
            return;
        }
        pet.addAppointment(appointment);
        System.out.println("Appointment scheduled successfully");


    }
    public static void saveData(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Pets.csv"));
            oos.writeObject(pets);
            System.out.println("Data saved successfully");

        }catch (IOException ex){
            System.out.println("Error while saving data: "+ ex.getMessage());
        }
    }

    public static void displayPets(){
        if(pets.isEmpty()){
            System.out.println("No pets registered");
            return;
        }
        for(Pet p : pets.values()){
            System.out.println(p);
             if(!p.getAppointments().isEmpty()){
                 System.out.println("Appointments for the pet");
                 for (Appointment ap : p.getAppointments()){
                     System.out.println(ap);
                 }
             }else {
                 System.out.println("No Appointment found");
             }

        }
        for(Pet p : pets.values()){
            if(!p.getAppointments().isEmpty()){
                System.out.println("Upcoming Appointment for the pets");
                for(Appointment ap : p.getAppointments()){
                    if(ap.getDateTime().isAfter(LocalDateTime.now())){
                        System.out.println(ap);
                    }
                }
            }
        }
        for(Pet p : pets.values()){
            if(!p.getAppointments().isEmpty()){
                System.out.println("Past Appointment historys");
                for(Appointment ap : p.getAppointments()){
                    if(ap.getDateTime().isBefore(LocalDateTime.now())){
                        System.out.println(ap);
                    }
                }
            }
        }

    }
    public static void generateReport(){
        if(pets.isEmpty()){
            System.out.println("No record available to generate report");
            return;
        }
        int totalPets = pets.size();
        System.out.println("Total  pets exist in our catalog :"+ totalPets);
        int totalAppointments =0;
        for(Pet pet : pets.values()){
            if(!pet.getAppointments().isEmpty()){
                totalAppointments = totalAppointments + pet.getAppointments().size();
            }
        }
        System.out.println("Total Appointments handled: " + totalAppointments);
    }
}
