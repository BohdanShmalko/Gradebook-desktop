package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Teachers;
import org.springframework.data.repository.CrudRepository;

public interface TeachersRepo extends CrudRepository<Teachers, Long> {
    Teachers getTeachersByNameAndSurnameAndAndFathername(String name, String surname, String fathername);
}
