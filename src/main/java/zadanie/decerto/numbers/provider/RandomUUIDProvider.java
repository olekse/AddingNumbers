package zadanie.decerto.numbers.provider;

import org.springframework.stereotype.Service;
import zadanie.decerto.numbers.model.number.ProvidedData;
import zadanie.decerto.numbers.model.number.ProvidedString;

import java.util.UUID;

@Service
public class RandomUUIDProvider implements DataProvider {

    @Override
    public ProvidedData provide() {
        return new ProvidedString(UUID.randomUUID().toString());
    }

}
