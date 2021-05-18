package bogdaxios.gradebook.desktop.service.gradebook;

import bogdaxios.gradebook.desktop.entity.Estimates;
import bogdaxios.gradebook.desktop.entity.Students;
import bogdaxios.gradebook.desktop.entity.Teachers;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.gradebook.GetMark;
import bogdaxios.gradebook.desktop.model.gradebook.Mark;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.repository.EstimatesRepo;
import bogdaxios.gradebook.desktop.repository.SpecialtiesRepo;
import bogdaxios.gradebook.desktop.repository.StudentsRepo;
import bogdaxios.gradebook.desktop.repository.TeachersRepo;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksService {
    @Autowired
    private EstimatesRepo estimatesRepo;

    @Autowired
    private StudentsRepo studentsRepo;

    @Autowired
    private TeachersRepo teachersRepo;


    public GetMark getInf(String jwt, int pageNumber) throws NotAuthorizedUser, TokenIsBroken {
        UserId userId = CheckAuth.check(jwt, "You is not an student", "student");
        String species; //pageNumber % 2 == 0 ? "exam" : "test";
        int semester;
        if (pageNumber % 2 == 0) {
            species = "test";
            semester = pageNumber / 2;
        } else {
            species = "exam";
            semester = pageNumber / 2 + 1;
        }
        Students student = studentsRepo.findStudentsByAuthId(userId.getUserId());
        List<Estimates> estimates = estimatesRepo.findAllByStudentIdAndSemesterAndSpeciesName(student.getId(), semester, species);
        GetMark allMarks = new GetMark();
        List<Mark> marks = null;
        for (int i = 0; i < estimates.size(); i++) {
            Estimates current = estimates.get(i);
            Teachers teacher = teachersRepo.getTeachersById(current.getTeacher_id());
            Mark mark = new Mark();
            mark.setSubject(current.getSubject());
            mark.setHours(current.getHours());
            mark.setLoans(current.getLoans());
            mark.setMark(current.getMark());
            mark.setEcts(current.getEcts());
            mark.setDate(current.getDate());
            mark.setSemester(semester);
            mark.setTeacher(teacher.getName() + " " + teacher.getSurname() + " " + teacher.getFathername());
            marks.add(i, mark);
        }
        allMarks.setMarks(marks);
        return allMarks;
    }
}
