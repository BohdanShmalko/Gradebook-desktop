package bogdaxios.gradebook.desktop.service.gradebook;

import bogdaxios.gradebook.desktop.entity.Students;
import bogdaxios.gradebook.desktop.entity.Teachers;
import bogdaxios.gradebook.desktop.entity.Thesis;
import bogdaxios.gradebook.desktop.entity.Thesis_members;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.gradebook.GetDegreeProject;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.repository.StudentsRepo;
import bogdaxios.gradebook.desktop.repository.TeachersRepo;
import bogdaxios.gradebook.desktop.repository.ThesisRepo;
import bogdaxios.gradebook.desktop.repository.Thesis_membersRepo;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DegreeProjectService {
    @Autowired
    private StudentsRepo studentsRepo;

    @Autowired
    private TeachersRepo teachersRepo;

    @Autowired
    private Thesis_membersRepo thesis_membersRepo;

    @Autowired
    private ThesisRepo thesisRepo;

    public GetDegreeProject getInf(String jwt) throws NotAuthorizedUser, TokenIsBroken {
        UserId userId = CheckAuth.check(jwt, "You is not an student", "student");
        Students student = studentsRepo.findStudentsByAuthId(userId.getUserId());
        Thesis thesis = thesisRepo.findByStudentId(student.getId());
        GetDegreeProject gdp = new GetDegreeProject();
        gdp.setStudent_name(student.getFullname());
        gdp.setTopic(thesis.getTopic());
        gdp.setSubmission_date(thesis.getSubmission_date());
        gdp.setDate_protection(thesis.getDate_protection());
        gdp.setMark(thesis.getMark());
        gdp.setEcts(thesis.getEcts());
        List<Thesis_members> members = thesis_membersRepo.findAllByThesisId(thesis.getId());
        List<Teachers> commission = null;
        for (Thesis_members current : members) {
            Teachers teacher = teachersRepo.getTeachersById(current.getTeacher_id());
            if (current.getStatus().equals("head")) {
                gdp.setHead(teacher);
            } else {
                commission.add(teacher);
            }
        }
        gdp.setTeachers(commission);
        return gdp;
    }
}
