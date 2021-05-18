package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Thesis;
import org.springframework.data.repository.CrudRepository;

public interface ThesisRepo extends CrudRepository<Thesis, Long> {
    Thesis findByStudentId(Long id);
}
