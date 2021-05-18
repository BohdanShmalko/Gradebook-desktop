package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Practices;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PracticesRepo extends CrudRepository<Practices, Long> {
    List<Practices> findAllByStudentId(Long id);
}
