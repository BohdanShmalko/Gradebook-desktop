package bogdaxios.gradebook.desktop.service.gradebook;

import bogdaxios.gradebook.desktop.entity.Practices;
import bogdaxios.gradebook.desktop.entity.Students;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.gradebook.GetPracticeTable;
import bogdaxios.gradebook.desktop.model.gradebook.PracticeTable;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.repository.PracticesRepo;
import bogdaxios.gradebook.desktop.repository.StudentsRepo;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeTableService {
    @Autowired
    private PracticesRepo practicesRepo;

    @Autowired
    private StudentsRepo studentsRepo;

    public GetPracticeTable getInf(String jwt) throws NotAuthorizedUser, TokenIsBroken {
        UserId userId = CheckAuth.check(jwt, "You is not an student", "student");
        Students student = studentsRepo.findStudentsByAuthId(userId.getUserId());
        List<Practices> practics = practicesRepo.findAllByStudentId(student.getId());
        GetPracticeTable pt = new GetPracticeTable();
        List<PracticeTable> lpt = null;
        for (int i = 0; i < practics.size(); i++) {
            Practices current = practics.get(i);
            PracticeTable element = new PracticeTable();
            element.setName(current.getName());
            element.setCourse(current.getCourse());
            element.setPlace(current.getPlace());
            element.setWorked(current.getWorked());
            lpt.set(i, element);
        }
        pt.setPracticesTable(lpt);
        return pt;
    }
}
