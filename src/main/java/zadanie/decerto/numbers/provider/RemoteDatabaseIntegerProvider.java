package zadanie.decerto.numbers.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zadanie.decerto.numbers.repository.IntegerRepository;


@Service
public class RemoteDatabaseIntegerProvider implements NumberProvider {

    private final IntegerRepository databaseIntegerRepository;

    @Autowired
    RemoteDatabaseIntegerProvider(IntegerRepository databaseIntegerRepository) {
        this.databaseIntegerRepository = databaseIntegerRepository;
    }

    @Override
    public Number provide() {
        return databaseIntegerRepository.queryRandomInteger();
    }

}
