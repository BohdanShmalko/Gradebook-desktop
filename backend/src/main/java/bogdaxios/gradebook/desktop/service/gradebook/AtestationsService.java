package bogdaxios.gradebook.desktop.service.gradebook;

import bogdaxios.gradebook.desktop.entity.Certification;
import bogdaxios.gradebook.desktop.entity.Students;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.gradebook.Atestation;
import bogdaxios.gradebook.desktop.model.gradebook.GetAtestations;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.repository.CertificationRepo;
import bogdaxios.gradebook.desktop.repository.StudentsRepo;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtestationsService {
    @Autowired
    private StudentsRepo studentsRepo;

    @Autowired
    private CertificationRepo certificationRepo;

    public GetAtestations getInf(String jwt) throws NotAuthorizedUser, TokenIsBroken {
        UserId userId = CheckAuth.check(jwt, "You is not an student", "student");
        Students student = studentsRepo.findStudentsByAuthId(userId.getUserId());
        List <Certification> allCert = certificationRepo.findAllByStudentId(student.getId());
        GetAtestations ga = new GetAtestations();
        List<Atestation> la = null;
        for (int i = 0; i < allCert.size(); i++){
            Certification current = allCert.get(i);
            Atestation element = new Atestation();
            element.setDate(current.getDate());
            element.setName(current.getName());
            la.set(i, element);
        }
        ga.setAtestations(la);
        return ga;
    }
}
