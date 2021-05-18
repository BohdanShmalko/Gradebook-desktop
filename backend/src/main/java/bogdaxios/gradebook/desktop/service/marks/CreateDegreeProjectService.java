package bogdaxios.gradebook.desktop.service.marks;

import bogdaxios.gradebook.desktop.entity.Thesis;
import bogdaxios.gradebook.desktop.entity.Thesis_members;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.marks.DegreeProject;
import bogdaxios.gradebook.desktop.repository.ThesisRepo;
import bogdaxios.gradebook.desktop.repository.Thesis_membersRepo;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDegreeProjectService {
    @Autowired
    private ThesisRepo thesisRepo;

    @Autowired
    private Thesis_membersRepo thesis_membersRepo;

    public void saveInf(String jwt, DegreeProject degreeProject) throws TokenIsBroken, NotAuthorizedUser {
        CheckAuth.check(jwt, "You is not an student", "admin");
        Thesis thesis = new Thesis();
        thesis.setStudentId(degreeProject.getStudentId());
        thesis.setTopic(degreeProject.getTopic());
        thesis.setSubmission_date(degreeProject.getSubmission_date());
        thesis.setDate_protection(degreeProject.getDate_protection());
        thesis.setMark(degreeProject.getMark());
        thesis.setEcts(degreeProject.getEcts());
        thesis.setDecision(degreeProject.getDecision());
        thesis.setDate_issue(degreeProject.getDate_issue());
        thesis.setNumber(degreeProject.getNumber());
        thesis.setHonors(degreeProject.isHonors());
        Thesis saved = thesisRepo.save(thesis);
        Thesis_members head = new Thesis_members();
        head.setStatus("head");
        head.setTeacher_id(degreeProject.getHeadId());
        head.setThesisId(saved.getId());
        thesis_membersRepo.save(head);
        for (Long teacherId : degreeProject.getTeachers()) {
            Thesis_members tm = new Thesis_members();
            tm.setStatus("member");
            tm.setTeacher_id(teacherId);
            tm.setThesisId(saved.getId());
            thesis_membersRepo.save(tm);
        }

    }
}
