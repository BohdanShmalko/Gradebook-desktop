package bogdaxios.gradebook.desktop.model.gradebook;

import bogdaxios.gradebook.desktop.entity.Teachers;

import java.sql.Timestamp;
import java.util.List;

public class GetExaminationCommission {
    private String decision;
    private Teachers head;
    private List<Teachers> teachers;
    private Timestamp date_issue;
    private int number;
    private String studentName;
    private String dean;

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Teachers getHead() {
        return head;
    }

    public void setHead(Teachers head) {
        this.head = head;
    }

    public List<Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teachers> teachers) {
        this.teachers = teachers;
    }

    public Timestamp getDate_issue() {
        return date_issue;
    }

    public void setDate_issue(Timestamp date_issue) {
        this.date_issue = date_issue;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public GetExaminationCommission() {
    }
}
