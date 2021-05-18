package bogdaxios.gradebook.desktop.service.gradebook;

import bogdaxios.gradebook.desktop.entity.Practices;
import bogdaxios.gradebook.desktop.entity.Students;
import bogdaxios.gradebook.desktop.entity.Teachers;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.gradebook.GetPractice;
import bogdaxios.gradebook.desktop.model.gradebook.Practice;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.repository.PracticesRepo;
import bogdaxios.gradebook.desktop.repository.StudentsRepo;
import bogdaxios.gradebook.desktop.repository.TeachersRepo;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeService {
    @Autowired
    private PracticesRepo practicesRepo;

    @Autowired
    private StudentsRepo studentsRepo;

    @Autowired
    private TeachersRepo teachersRepo;

    public GetPractice getInf(String jwt) throws NotAuthorizedUser, TokenIsBroken {
        UserId userId = CheckAuth.check(jwt, "You is not an student", "student");
        Students student = studentsRepo.findStudentsByAuthId(userId.getUserId());
        List<Practices> practics = practicesRepo.findAllByStudentId(student.getId());
        GetPractice practices = new GetPractice();
        List<Practice> allPractice = null;
        for (int i = 0; i < practics.size(); i++){
            Practices current = practics.get(i);
            Teachers teacher = teachersRepo.getTeachersById(current.getTeacher_id());
            Practice element = new Practice();
            element.setFrom_date(current.getFrom_date());
            element.setTo_date(current.getTo_date());
            element.setTeacher(teacher.getName() + " " + teacher.getSurname() + " " + teacher.getFathername());
            element.setMark(current.getMark());
            element.setEcts(current.getEcts());
            element.setDate(current.getDate());
            allPractice.set(i, element);
        }
        practices.setPractices(allPractice);
        return practices;
    }
}
