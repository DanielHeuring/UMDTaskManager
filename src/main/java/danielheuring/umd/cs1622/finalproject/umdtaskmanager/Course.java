package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

public class Course {

    private String name;
    private String professor;

    public Course( String name, String professor ) {
        this.name = name;
        this.professor = professor;
    }

    public String getName() {
        return name;
    }

    public String getProfessor() {
        return professor;
    }

}
