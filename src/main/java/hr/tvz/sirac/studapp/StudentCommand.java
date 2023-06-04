package hr.tvz.sirac.studapp;
import java.util.Date;
import javax.validation.constraints.*;

public class StudentCommand {
    @NotBlank(message = "Ime ne smije biti prazno.")
    private String name;

    @NotBlank(message = "Prezime ne smije biti prazno.")
    private String lastName;

    @NotNull(message = "Datum rođenja ne smije biti prazan.")
    @Past(message = "Datum rođenja ne smije biti u budućnosti.")
    private Date birthDate;

    @NotBlank(message = "JMBAG ne smije biti prazan.")
    @Size(min = 10, max = 10, message = "JMBAG mora imati točno 10 znamenki.")
    private String JMBAG;

    @NotNull(message = "ECTS bodovi ne smiju biti prazni.")
    @Min(value = 0, message = "ECTS bodovi ne smiju biti manji od 0.")
    @Max(value = 60, message = "ECTS bodovi ne smiju biti veći od 60.")
    private Integer ECTS;

    public StudentCommand() {}

    public StudentCommand(String name, String lastName, Date birthDate, String JMBAG, Integer ECTS) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.JMBAG = JMBAG;
        this.ECTS = ECTS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getJMBAG() {
        return JMBAG;
    }

    public void setJMBAG(String JMBAG) {
        this.JMBAG = JMBAG;
    }

    public Integer getECTS() {
        return ECTS;
    }

    public void setECTS(Integer ECTS) {
        this.ECTS = ECTS;
    }
}
