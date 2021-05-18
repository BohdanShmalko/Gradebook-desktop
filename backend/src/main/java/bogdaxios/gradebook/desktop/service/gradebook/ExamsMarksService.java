package bogdaxios.gradebook.desktop.service.gradebook;

import bogdaxios.gradebook.desktop.entity.Certification;
import bogdaxios.gradebook.desktop.entity.Certification_members;
import bogdaxios.gradebook.desktop.entity.Students;
import bogdaxios.gradebook.desktop.entity.Teachers;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.gradebook.ExamMark;
import bogdaxios.gradebook.desktop.model.gradebook.GetExamsMarks;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.repository.CertificationRepo;
import bogdaxios.gradebook.desktop.repository.Certification_membersRepo;
import bogdaxios.gradebook.desktop.repository.StudentsRepo;
import bogdaxios.gradebook.desktop.repository.TeachersRepo;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamsMarksService {
    @Autowired
    private StudentsRepo studentsRepo;

    @Autowired
    private CertificationRepo certificationRepo;

    @Autowired
    private Certification_membersRepo certification_membersRepo;

    @Autowired
    private TeachersRepo teachersRepo;

    public GetExamsMarks getInf(String jwt) throws NotAuthorizedUser, TokenIsBroken {
        UserId userId = CheckAuth.check(jwt, "You is not an student", "student");
        Students student = studentsRepo.findStudentsByAuthId(userId.getUserId());
        List<Certification> allCert = certificationRepo.findAllByStudentId(student.getId());
        GetExamsMarks gem = new GetExamsMarks();
        List<ExamMark> lem = null;
        for (int i = 0; i < allCert.size(); i++){
            Certification current = allCert.get(i);
            List<Certification_members> cm = certification_membersRepo.findAllByCertificationId(current.getId());
            List<Teachers> t = null;
            for (int j = 0; j < cm.size(); j++){
                Teachers currentT = teachersRepo.getTeachersById(cm.get(i).getTeacher_id());
                t.set(i, currentT);
            }
            ExamMark element = new ExamMark();
            element.setMark(current.getMark());
            element.setEcts(current.getEcts());
            element.setTeachers(t);
            lem.set(i, element);
        }
        gem.setExamMarks(lem);
        return gem;
    }
}
