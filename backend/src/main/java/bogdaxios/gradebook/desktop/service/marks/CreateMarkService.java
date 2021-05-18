package bogdaxios.gradebook.desktop.service.marks;

import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.marks.Mark;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.springframework.stereotype.Service;

@Service
public class CreateMarkService {
    public void saveInf(String jwt, Mark mark) throws TokenIsBroken, NotAuthorizedUser {
        UserId userId = CheckAuth.check(jwt, "You is not an student", "admin");
    }
}
