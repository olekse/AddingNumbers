package zadanie.decerto.numbers.provider;

import org.springframework.stereotype.Service;
import zadanie.decerto.numbers.model.number.ProvidedInteger;
import zadanie.decerto.numbers.model.number.ProvidedData;

import java.security.SecureRandom;


@Service
public class RandomIntegerProvider implements DataProvider {

    protected final SecureRandom random = new SecureRandom();

    @Override
    public ProvidedData provide() {
        return new ProvidedInteger(random.nextInt(100) + 1);
    }

}
