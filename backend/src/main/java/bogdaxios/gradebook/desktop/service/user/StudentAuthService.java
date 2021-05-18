package bogdaxios.gradebook.desktop.service.user;

import bogdaxios.gradebook.desktop.entity.Auths;
import bogdaxios.gradebook.desktop.entity.Students;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.exeptions.UserAlreadyExist;
import bogdaxios.gradebook.desktop.model.user.CreateStudent;
import bogdaxios.gradebook.desktop.repository.AuthsRepo;
import bogdaxios.gradebook.desktop.repository.StudentsRepo;
import bogdaxios.gradebook.desktop.security.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentAuthService  {
    @Autowired
    private AuthsRepo authRepo;

    @Autowired
    private StudentsRepo studentsRepo;

    public Students registration(String jwt, CreateStudent rs) throws UserAlreadyExist, NotAuthorizedUser, TokenIsBroken {
        if(jwt.isEmpty()){
            throw new NotAuthorizedUser("You is not an admin");
        }
        new JWT().decodeJWT(jwt);
        Auths auth = rs.getAuths();
        if (authRepo.findAuthsByLogin(auth.getLogin()) != null) {
            throw new UserAlreadyExist("Student with this login is already exist!");
        }

        Auths createdAuth = authRepo.save(auth);
        Students students = rs.getStudents();
        students.setAuthId(createdAuth.getId());

        return studentsRepo.save(students);
    }
}
