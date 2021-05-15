package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Auths;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepo extends CrudRepository<Auths, Long> {
    Auths findAuthsByLogin (String login);

}
