package bogdaxios.gradebook.desktop.service.marks;

import bogdaxios.gradebook.desktop.entity.Estimates;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.marks.Mark;
import bogdaxios.gradebook.desktop.repository.EstimatesRepo;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMarkService {
    @Autowired
    private EstimatesRepo estimatesRepo;

    public void saveInf(String jwt, Mark mark) throws TokenIsBroken, NotAuthorizedUser {
        CheckAuth.check(jwt, "You is not an student", "admin");
        Estimates estimates = new Estimates();
        estimates.setStudentId(mark.getStudentId());
        estimates.setMark(mark.getMark());
        estimates.setEcts(mark.getEcts());
        estimates.setTeacher_id(mark.getTeacherId());
        estimates.setHours(mark.getHours());
        estimates.setLoans(mark.getLoans());
        estimates.setSubject(mark.getSubject());
        String species;
        int semester;
        if (mark.getPage() % 2 == 0) {
            species = "test";
            semester = mark.getPage() / 2;
        } else {
            species = "exam";
            semester = mark.getPage() / 2 + 1;
        }
        estimates.setSemester(semester);
        estimates.setSpeciesName(species);

        estimatesRepo.save(estimates);
    }
}
