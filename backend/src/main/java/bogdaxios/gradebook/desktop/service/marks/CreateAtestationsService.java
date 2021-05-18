package bogdaxios.gradebook.desktop.service.marks;

import bogdaxios.gradebook.desktop.entity.Certification;
import bogdaxios.gradebook.desktop.entity.Certification_members;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.marks.Atestation;
import bogdaxios.gradebook.desktop.model.marks.AtestationUnit;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.repository.CertificationRepo;
import bogdaxios.gradebook.desktop.repository.Certification_membersRepo;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateAtestationsService {
    @Autowired
    CertificationRepo certificationRepo;

    @Autowired
    Certification_membersRepo certification_membersRepo;

    public void saveInf(String jwt, Atestation atestation) throws TokenIsBroken, NotAuthorizedUser {
        UserId userId = CheckAuth.check(jwt, "You is not an student", "admin");
        List<AtestationUnit> allAtestations = atestation.getAtestations();
        for (AtestationUnit atestationUnit : allAtestations){
            Certification certification = new Certification();
            certification.setStudentId(atestationUnit.getStudentId());
            certification.setName(atestationUnit.getName());
            certification.setMark(atestationUnit.getMark());
            certification.setEcts(atestationUnit.getEcts());
            Certification saved = certificationRepo.save(certification);
            for (Long teacherId : atestationUnit.getTeachers()){
                Certification_members cm = new Certification_members();
                cm.setTeacher_id(teacherId);
                cm.setCertificationId(saved.getId());
                certification_membersRepo.save(cm);
            }
        }
    }
}
