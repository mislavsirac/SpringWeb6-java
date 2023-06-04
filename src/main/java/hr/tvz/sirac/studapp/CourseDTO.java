package hr.tvz.sirac.studapp;

public class CourseDTO {
    private Long id;
    private String name;
    private int ects;

    public CourseDTO(Long id, String name, int ects) {
        this.id = id;
        this.name = name;
        this.ects = ects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }
}
