package zadanie.decerto.numbers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zadanie.decerto.numbers.model.db.NumericDatabaseData;

@Repository
public interface IntegerRepository extends JpaRepository<NumericDatabaseData, Integer> {


    @Query(nativeQuery=true, value="SELECT num FROM numbers ORDER BY random() LIMIT 1")
    Integer queryRandomInteger();

}
