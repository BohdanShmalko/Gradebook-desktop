package helpers.tables;

public class PracticeField {
    int number, course;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public PracticeField(int number, int course, String practiceName, String place, String work) {
        this.number = number;
        this.course = course;
        this.practiceName = practiceName;
        this.place = place;
        this.work = work;
    }

    String practiceName, place, work;
}
