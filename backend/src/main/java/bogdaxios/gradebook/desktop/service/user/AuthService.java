package bogdaxios.gradebook.desktop.service.user;

import bogdaxios.gradebook.desktop.entity.Auths;
import bogdaxios.gradebook.desktop.exeptions.IncorrectLoginInformation;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.model.user.GetUser;
import bogdaxios.gradebook.desktop.repository.AuthsRepo;
import bogdaxios.gradebook.desktop.security.JWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthsRepo authRepo;

    public String authentication(GetUser ga) throws IncorrectLoginInformation, JsonProcessingException {
        Auths auths = ga.getAuths();
        Auths correctUser = authRepo.findAuthsByLoginAndPassword(auths.getLogin(), auths.getPassword());
        if (correctUser == null) {
            throw new IncorrectLoginInformation();
        }
        UserId userId = new UserId();
        userId.setUserId(correctUser.getId());
        userId.setStatus(correctUser.getStatus());
        String json = new ObjectMapper().writeValueAsString(userId);
        return new JWT().generateJWT(json);
    }
}
