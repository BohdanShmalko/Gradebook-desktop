package bogdaxios.gradebook.desktop.service.gradebook;

import bogdaxios.gradebook.desktop.entity.Faculties;
import bogdaxios.gradebook.desktop.entity.Groups;
import bogdaxios.gradebook.desktop.entity.Specialties;
import bogdaxios.gradebook.desktop.entity.Students;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.NotFoundInf;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.gradebook.GetInf;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.repository.*;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationService {
    @Autowired
    private StudentsRepo studentsRepo;

    @Autowired
    private GroupsRepo groupsRepo;

    @Autowired
    private SpecialtiesRepo specialtiesRepo;

    @Autowired
    private FacultiesRepo facultiesRepo;

    public GetInf getInf(String jwt) throws NotAuthorizedUser, TokenIsBroken, NotFoundInf {
        UserId userId = CheckAuth.check(jwt, "You is not an student", "student");
        Students student = studentsRepo.findStudentsByAuthId(userId.getUserId());
        if (student == null){
            throw new NotFoundInf("student not found please login again");
        }
        Groups group = groupsRepo.findGroupsById(student.getGroup_id());
        Specialties speciality = specialtiesRepo.findSpecialtiesById(group.getSpecialty_id());
        Faculties faculty = facultiesRepo.findFacultiesById(speciality.getFaculties_id());
        GetInf result = new GetInf();
        result.setFullname(student.getFullname());
        result.setGradebook_number(student.getGradebook_number());
        result.setCourse_admission(student.getCourse_admission());
        result.setDate_entry(student.getDate_entry());
        result.setDate_issue(student.getDate_issue());
        result.setPhotoURL(student.getPhoto_url());
        result.setGroup(group.getName());
        result.setDean(faculty.getDean());
        return result;
    }
}
