package bogdaxios.gradebook.desktop.service.user;

import bogdaxios.gradebook.desktop.entity.Admins;
import bogdaxios.gradebook.desktop.entity.Auths;
import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.exeptions.UserAlreadyExist;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.model.user.CreateAdmin;
import bogdaxios.gradebook.desktop.repository.AdminsRepo;
import bogdaxios.gradebook.desktop.repository.AuthsRepo;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthService {
    @Autowired
    private AuthsRepo authRepo;

    @Autowired
    private AdminsRepo adminsRepo;

    public Admins registration(String jwt, CreateAdmin ca) throws UserAlreadyExist, NotAuthorizedUser, TokenIsBroken {
        UserId userId = CheckAuth.check(jwt, "You is not an student", "admin");

        Auths reqAuth = ca.getAuths();
        if (authRepo.findAuthsByLogin(reqAuth.getLogin()) != null) {
            throw new UserAlreadyExist("Admin with this login is already exist!");
        }

        Auths createdAuth = authRepo.save(reqAuth);
        Admins admin = ca.getAdmins();
        admin.setAuth_id(createdAuth.getId());
        Admins currentAdmin = adminsRepo.findAdminsById(userId.getUserId());
        admin.setFaculties_id(currentAdmin.getFaculties_id());
        return adminsRepo.save(admin);
    }
}
