package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Faculties;
import org.springframework.data.repository.CrudRepository;

public interface FacultiesRepo extends CrudRepository<Faculties, Long> {
    Faculties findFacultiesById(Long id);
}
