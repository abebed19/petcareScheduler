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

            }
        }
    }

    public static void RegisterNewPet(){

    }
}
