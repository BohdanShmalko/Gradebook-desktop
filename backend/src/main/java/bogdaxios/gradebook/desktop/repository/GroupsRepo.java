package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Groups;
import org.springframework.data.repository.CrudRepository;

public interface GroupsRepo extends CrudRepository<Groups, Long> {
    Groups findGroupsByName(String name);
}
