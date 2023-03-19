package hr.tvz.sirac.studapp;

import java.util.Date;

public class Student {
    String name;
    String lastName;
    Date birthDate;
    String JMBAG;
    Integer ECTS;

    public Student(String name, String lastName, Date birthDate, String JMBAG, Integer ECTS) {
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
