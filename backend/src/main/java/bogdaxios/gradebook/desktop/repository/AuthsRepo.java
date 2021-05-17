package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Auths;
import org.springframework.data.repository.CrudRepository;

public interface AuthsRepo extends CrudRepository<Auths, Long> {
    Auths findAuthsByLogin (String login);
    Auths findAuthsByLoginAndPassword (String login, String password);

}
