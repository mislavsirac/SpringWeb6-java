package hr.tvz.sirac.studapp;

public class StudentDTO {
    String JMBAG;
    Integer ECTS;
    Boolean paysForCollege;

    public StudentDTO(String JMBAG, Integer ECTS, Boolean paysForCollege) {
        this.JMBAG = JMBAG;
        this.ECTS = ECTS;
        this.paysForCollege = paysForCollege;
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

    public Boolean getPaysForCollege() {
        return paysForCollege;
    }

    public void setPaysForCollege(Boolean paysForCollege) {
        this.paysForCollege = paysForCollege;
    }
}
