package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Students;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepo extends CrudRepository<Students, Long> {
    Students findStudentsById(Long id);
    Students findStudentsByAuthId(Long id);
}
