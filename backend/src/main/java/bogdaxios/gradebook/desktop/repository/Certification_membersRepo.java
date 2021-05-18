package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Certification_members;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Certification_membersRepo extends CrudRepository<Certification_members, Long> {
    List<Certification_members> findAllByCertificationId(Long id);
}
