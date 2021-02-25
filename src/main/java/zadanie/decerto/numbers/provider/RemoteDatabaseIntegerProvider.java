package zadanie.decerto.numbers.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zadanie.decerto.numbers.exception.DataProviderException;
import zadanie.decerto.numbers.model.db.NumericDatabaseData;
import zadanie.decerto.numbers.repository.IntegerRepository;

import java.security.SecureRandom;
import java.util.Optional;

import static zadanie.decerto.numbers.utils.RandomUtils.randomIntInRange;

@Service
public class RemoteDatabaseIntegerProvider implements NumberProvider {

    private final IntegerRepository databaseIntegerRepository;
    private final SecureRandom random = new SecureRandom();
    private static final int MAX_ATTEMPTS = 10;

    @Autowired
    RemoteDatabaseIntegerProvider(IntegerRepository databaseIntegerRepository) {
        this.databaseIntegerRepository = databaseIntegerRepository;
    }

    @Override
    public Number provide() {
        Optional<NumericDatabaseData> entries;
        int from = randomIntInRange(random, 0, 25);
        int to = randomIntInRange(random, from + 1, 50);
        int attempts = 0;
        do {
            entries = databaseIntegerRepository.findFirstByValueBetween(from, to);
        } while (entries.isEmpty() && attempts++ < MAX_ATTEMPTS);
        if (entries.isPresent())
            return entries.get().getValue();
        throw new DataProviderException("Didn't get excepted data from the database");
    }

}
