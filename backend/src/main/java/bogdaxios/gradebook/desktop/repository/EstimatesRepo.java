package bogdaxios.gradebook.desktop.repository;

import bogdaxios.gradebook.desktop.entity.Estimates;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstimatesRepo extends CrudRepository<Estimates, Long> {
    List<Estimates> findAllByStudentIdAndSemesterAndSpeciesName(Long id, int semester, String species_name);
}
