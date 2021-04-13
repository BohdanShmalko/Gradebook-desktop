package helpers.tables;

public class Atestation {
    int number;
    String examName, date;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Atestation(int number, String examName, String date) {
        this.number = number;
        this.examName = examName;
        this.date = date;
    }
}
