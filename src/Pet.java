import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pet implements Serializable {
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

    public String getId() { return this.Id; }
    public String getName() { return this.name; }
    public String getSpecies() { return this.species; }
    public int getAge() { return this.age; }
    public String getOwnerName() { return this.ownerName; }
    public String getContactInfo() { return this.contactInfo; }
    public LocalDate getRegistrationDate() { return this.registrationDate; }
    public List<Appointment> getAppointments() { return this.appointments; }
    public void setId(String id) { this.Id = id; }
    public void setName(String name) { this.name = name; }
    public void setSpecies(String species) { this.species = species; }
    public void setAge(int age) { this.age = age; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    @Override
    public String toString() {
        return "Id : " + this.Id +
                "\nName : " + this.name +
                "\nSpecies : " + this.species +
                "\nAge : " + this.age +
                "\nOwnerName : " + this.ownerName +
                "\nContact Info : " + this.contactInfo+
                "\nRegistration Date : " + this.registrationDate;


    }
}