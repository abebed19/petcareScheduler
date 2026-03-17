import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            System.out.println("3. Display pets");
            System.out.println("4. Display appointments for a Pet");
            System.out.println("5. Save to file ");
            System.out.println("6. Exit");

            String option = scanner.nextLine();

            switch (option){
                case "1":
                    registerPet();
                    break;
                case "2":
                    scheduleAppointment();
                    break;

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
                break;
            }catch(Exception ex){
                System.out.println("Please provide date and time using yyyy-MM-dd HH:mm:ss");
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
}
