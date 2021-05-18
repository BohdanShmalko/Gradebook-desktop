package bogdaxios.gradebook.desktop.service.marks;

import bogdaxios.gradebook.desktop.entity.Practices;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.marks.Practice;
import bogdaxios.gradebook.desktop.model.marks.PracticeUnit;
import bogdaxios.gradebook.desktop.repository.PracticesRepo;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatePracticeService {
    @Autowired
    private PracticesRepo practicesRepo;

    public void saveInf(String jwt, Practice practice) throws TokenIsBroken, NotAuthorizedUser {
        CheckAuth.check(jwt, "You is not an student", "admin");
        List<PracticeUnit> allPractices = practice.getPractices();
        for (PracticeUnit practiceUnit : allPractices) {
            Practices practices = new Practices();
            practices.setName(practiceUnit.getName());
            practices.setCourse(practiceUnit.getCourse());
            practices.setPlace(practiceUnit.getPlace());
            practices.setWorked(practiceUnit.getWorked());
            practices.setFrom_date(practiceUnit.getFrom_date());
            practices.setTo_date(practiceUnit.getTo_date());
            practices.setMark(practiceUnit.getMark());
            practices.setEcts(practiceUnit.getEcts());
            practices.setTeacher_id(practiceUnit.getTeacherId());
            practices.setStudentId(practiceUnit.getStudentId());
            practicesRepo.save(practices);
        }
    }
}
