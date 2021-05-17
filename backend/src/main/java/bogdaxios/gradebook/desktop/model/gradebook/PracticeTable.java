package bogdaxios.gradebook.desktop.model.gradebook;

public class PracticeTable {
    //name, course, place, worked
    private String name;
    private int course;
    private String place;
    private String worked;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getWorked() {
        return worked;
    }

    public void setWorked(String worked) {
        this.worked = worked;
    }

    public PracticeTable() {
    }
}
