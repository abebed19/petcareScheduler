import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String Id;
    private String name;
    private String species;
    private int age;
    private String ownerName;
    private String contactInfo;
    private LocalDate registrationDate;
    private List<Appointment> appointments;

    public Pet(String id, String name,String species, int age, String ownerName,String contactInfo){
        this.Id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.registrationDate = LocalDate.now();
        this.appointments = new ArrayList<>();
    }
    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }



}