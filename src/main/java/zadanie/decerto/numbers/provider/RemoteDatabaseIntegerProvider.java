package zadanie.decerto.numbers.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zadanie.decerto.numbers.model.number.ProvidedInteger;
import zadanie.decerto.numbers.model.number.ProvidedData;
import zadanie.decerto.numbers.repository.IntegerRepository;


@Service
public class RemoteDatabaseIntegerProvider implements DataProvider {

    private final IntegerRepository databaseIntegerRepository;

    @Autowired
    RemoteDatabaseIntegerProvider(IntegerRepository databaseIntegerRepository) {
        this.databaseIntegerRepository = databaseIntegerRepository;
    }

    @Override
    public ProvidedData provide() {
        return new ProvidedInteger(databaseIntegerRepository.queryRandomInteger());
    }

}
