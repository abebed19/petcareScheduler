import java.io.Serializable;
import java.time.LocalDateTime;

public class Appointment implements Serializable {
    private String appointmentType;
    private LocalDateTime dateTime;
    private String note;
    public Appointment(String appointmentType, LocalDateTime dateTime, String note) {
        this.appointmentType = appointmentType;
        this.dateTime = dateTime;
        this.note = note;
    }

    public String getAppointmentType() { return this.appointmentType; }
    public LocalDateTime getDateTime() { return this.dateTime; }
    public String getNote() { return this.note; }
    public void setAppointmentType(String appointmentType) { this.appointmentType = appointmentType; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public void setNote(String note) { this.note = note; }
    @Override
    public String toString() {
        return String.format("%s - %s - %s", this.appointmentType, this.dateTime, this.note);
    }
}
