package zadanie.decerto.numbers.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zadanie.decerto.numbers.exception.DataProviderException;
import zadanie.decerto.numbers.model.NumericDatabaseData;
import zadanie.decerto.numbers.repository.IntegerRepository;

import java.util.Optional;

@Service
public class RemoteDatabaseIntegerProvider implements DataProvider {

    private final IntegerRepository databaseIntegerRepository;

    @Autowired
    RemoteDatabaseIntegerProvider(IntegerRepository databaseIntegerRepository) {
        this.databaseIntegerRepository = databaseIntegerRepository;
    }

    @Override
    public Object provide() {
        Optional<NumericDatabaseData> entries = databaseIntegerRepository.findFirstByValueBetween(10, 20);
        if (entries.isPresent())
            return entries.get().getValue();
        throw new DataProviderException("Didn't get excepted data from the database");
    }
}
