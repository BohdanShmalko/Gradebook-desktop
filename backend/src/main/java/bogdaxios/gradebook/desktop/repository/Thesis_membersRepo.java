package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Thesis_members;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Thesis_membersRepo extends CrudRepository<Thesis_members, Long> {
    List<Thesis_members> findAllByThesisId(Long id);
}
