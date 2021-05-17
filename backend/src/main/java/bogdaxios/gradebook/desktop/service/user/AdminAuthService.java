package bogdaxios.gradebook.desktop.service.user;

import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.user.CreateAdmin;
import bogdaxios.gradebook.desktop.entity.Admins;
import bogdaxios.gradebook.desktop.entity.Auths;
import bogdaxios.gradebook.desktop.exeptions.UserAlreadyExist;
import bogdaxios.gradebook.desktop.repository.AdminsRepo;
import bogdaxios.gradebook.desktop.repository.AuthsRepo;
import bogdaxios.gradebook.desktop.security.JWT;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminAuthService {
    @Autowired
    private AuthsRepo authRepo;

    @Autowired
    private AdminsRepo adminsRepo;

    public Admins registration(String jwt, CreateAdmin ca) throws UserAlreadyExist, NotAuthorizedUser, TokenIsBroken, ParseException {
        if (jwt.isEmpty()) {
            throw new NotAuthorizedUser("You is not an admin");
        }
        String jsonFromJWT = new JWT().decodeJWT(jwt);
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonFromJWT);
        Long userId = (Long) jsonObject.get("userId");
        String userStatus = (String) jsonObject.get("status");
        if (!userStatus.equals("admin")) {
            throw new NotAuthorizedUser("You is not an admin");
        }

        Auths reqAuth = ca.getAuths();
        if (authRepo.findAuthsByLogin(reqAuth.getLogin()) != null) {
            throw new UserAlreadyExist("Admin with this login is already exist!");
        }

        Auths createdAuth = authRepo.save(reqAuth);
        Admins admin = ca.getAdmins();
        admin.setAuth_id(createdAuth.getId());
        Optional<Admins> currentAdmin = adminsRepo.findById(userId);
        admin.setFaculties_id(currentAdmin.get().getFaculties_id());
        return adminsRepo.save(admin);
    }
}
