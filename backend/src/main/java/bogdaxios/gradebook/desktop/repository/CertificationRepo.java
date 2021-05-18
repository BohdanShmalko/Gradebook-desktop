package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Certification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CertificationRepo extends CrudRepository<Certification, Long> {
    List<Certification> findAllByStudentId(Long id);
}
