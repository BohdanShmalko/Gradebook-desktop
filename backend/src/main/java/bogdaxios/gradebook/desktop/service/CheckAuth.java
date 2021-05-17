package bogdaxios.gradebook.desktop.service;

import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.secure.UserId;
import bogdaxios.gradebook.desktop.security.JWT;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CheckAuth {
    public static UserId check(String jwt, String msg) throws NotAuthorizedUser, TokenIsBroken, ParseException {
        if (jwt.isEmpty()) {
            throw new NotAuthorizedUser("You is not authorized");
        }
        String jsonFromJWT = new JWT().decodeJWT(jwt);
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonFromJWT);
        Long userId = (Long) jsonObject.get("userId");
        String userStatus = (String) jsonObject.get("status");
        if (!userStatus.equals("admin")) {
            throw new NotAuthorizedUser(msg);
        }
        UserId jwtInf = new UserId();
        jwtInf.setUserId(userId);
        jwtInf.setStatus(userStatus);
        return jwtInf;
    }
}
