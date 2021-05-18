package bogdaxios.gradebook.desktop.service.user;

import bogdaxios.gradebook.desktop.entity.Teachers;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.exeptions.UserAlreadyExist;
import bogdaxios.gradebook.desktop.model.user.CreateTeacher;
import bogdaxios.gradebook.desktop.repository.TeachersRepo;
import bogdaxios.gradebook.desktop.security.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherAuthService {
    @Autowired
    private TeachersRepo teachersRepo;

    public Teachers registration(String jwt, CreateTeacher ct) throws UserAlreadyExist, NotAuthorizedUser, TokenIsBroken {
        if(jwt.isEmpty()){
            throw new NotAuthorizedUser("You is not an admin");
        }
        new JWT().decodeJWT(jwt);
        Teachers reqTeacher = ct.getTeachers();
        if (teachersRepo.getTeachersByNameAndSurnameAndAndFathername(reqTeacher.getName(), reqTeacher.getSurname(), reqTeacher.getFathername()) != null) {
            throw new UserAlreadyExist("This teacher is already exist!");
        }
        return teachersRepo.save(reqTeacher);
    }
}
