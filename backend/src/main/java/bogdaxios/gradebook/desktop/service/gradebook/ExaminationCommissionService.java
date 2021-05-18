package bogdaxios.gradebook.desktop.service.gradebook;

import bogdaxios.gradebook.desktop.entity.*;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.gradebook.GetExaminationCommission;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.repository.*;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExaminationCommissionService {
    @Autowired
    private StudentsRepo studentsRepo;

    @Autowired
    private TeachersRepo teachersRepo;

    @Autowired
    private Thesis_membersRepo thesis_membersRepo;

    @Autowired
    private ThesisRepo thesisRepo;

    @Autowired
    private GroupsRepo groupsRepo;

    @Autowired
    private SpecialtiesRepo specialtiesRepo;

    @Autowired
    private FacultiesRepo facultiesRepo;

    public GetExaminationCommission getInf(String jwt) throws NotAuthorizedUser, TokenIsBroken {
        UserId userId = CheckAuth.check(jwt, "You is not an student", "student");
        Students student = studentsRepo.findStudentsByAuthId(userId.getUserId());
        Thesis thesis = thesisRepo.findByStudentId(student.getId());
        GetExaminationCommission gec = new GetExaminationCommission();
        gec.setDecision(thesis.getDecision());
        gec.setDate_issue(thesis.getDate_issue());
        gec.setNumber(thesis.getNumber());
        gec.setStudentName(student.getFullname());
        Groups group = groupsRepo.findGroupsById(student.getGroup_id());
        Specialties speciality = specialtiesRepo.findSpecialtiesById(group.getSpecialty_id());
        Faculties faculty = facultiesRepo.findFacultiesById(speciality.getFaculties_id());
        gec.setDean(faculty.getDean());

        List<Thesis_members> members = thesis_membersRepo.findAllByThesisId(thesis.getId());
        List<Teachers> commission = null;
        for (Thesis_members current : members) {
            Teachers teacher = teachersRepo.getTeachersById(current.getTeacher_id());
            if (current.getStatus().equals("head")) {
                gec.setHead(teacher);
            } else {
                commission.add(teacher);
            }
        }
        gec.setTeachers(commission);
        return gec;
    }
}
