import java.util.HashMap;
import java.util.Scanner;

public class PetCareScheduler {

    private  static Scanner scanner = new Scanner(System.in);
    private static HashMap<String,Pet> pets = new HashMap<>();
    public static void main(String[] args){

        while(true){
            System.out.println("Please select your desired Option from the following");
            System.out.println("1. Create Pet");
            System.out.println("2. Create Appointments");
            System.out.println("3. Display pets");
            System.out.println("4. Display appointments for a Pet");
            System.out.println("5. Save to file ");
            System.out.println("6. Exit");

            String option = scanner.nextLine();

            switch (option){
                case "1":
                    registerPet();
                    System.out.println(pets.isEmpty());
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
        System.out.println("Enter pet age: ");
        int age = Integer.parseInt(scanner.nextLine().trim());
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
}
