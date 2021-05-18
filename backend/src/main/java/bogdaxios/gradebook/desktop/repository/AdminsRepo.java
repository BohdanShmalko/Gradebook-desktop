package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Admins;
import org.springframework.data.repository.CrudRepository;

public interface AdminsRepo extends CrudRepository<Admins, Long> {
    Admins findAdminsById(Long id);
}
