package bogdaxios.gradebook.desktop.service;

import bogdaxios.gradebook.desktop.entity.Auths;
import bogdaxios.gradebook.desktop.exeptions.UserAlreadyExist;
import bogdaxios.gradebook.desktop.repository.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthRepo authRepo;

    public Auths registration(Auths auth) throws UserAlreadyExist {
        if (authRepo.findAuthsByLogin(auth.getLogin()) != null) {
            throw new UserAlreadyExist("User already exist");
        }
        return authRepo.save(auth);
    }
}
