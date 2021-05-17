package bogdaxios.gradebook.desktop.service.gradebook;

import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.gradebook.GetPractice;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.service.CheckAuth;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class PracticeService {
    public GetPractice getInf(String jwt) throws NotAuthorizedUser, TokenIsBroken, ParseException {
        UserId userId = CheckAuth.check(jwt, "You is not an student");
        throw new NotAuthorizedUser(""); //mock
    }
}
