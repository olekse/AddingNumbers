package zadanie.decerto.numbers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zadanie.decerto.numbers.model.NumericDatabaseData;

import java.util.Optional;

@Repository
public interface IntegerRepository extends JpaRepository<NumericDatabaseData, Integer> {

    Optional<NumericDatabaseData> findFirstByValueBetween(Integer min, Integer max);

}
