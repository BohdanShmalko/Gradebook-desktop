package bogdaxios.gradebook.desktop.service.user;

import bogdaxios.gradebook.desktop.exeptions.NotAuthorizedUser;
import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;
import bogdaxios.gradebook.desktop.model.user.CreateGroup;
import bogdaxios.gradebook.desktop.entity.Groups;
import bogdaxios.gradebook.desktop.exeptions.UserAlreadyExist;
import bogdaxios.gradebook.desktop.repository.GroupsRepo;
import bogdaxios.gradebook.desktop.security.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupAuthService {
    @Autowired
    private GroupsRepo groupsRepo;

    public Groups registration(String jwt, CreateGroup cg) throws UserAlreadyExist, NotAuthorizedUser, TokenIsBroken {
        if(jwt.isEmpty()){
            throw new NotAuthorizedUser("You is not an admin");
        }
        new JWT().decodeJWT(jwt);
        Groups reqGroup = cg.getGroups();
        if (groupsRepo.findGroupsByName(reqGroup.getName()) != null){
            throw new UserAlreadyExist("Group with this name is already exist!");
        }
        return groupsRepo.save(reqGroup);
    }
}
