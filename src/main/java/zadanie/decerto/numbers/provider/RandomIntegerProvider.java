package zadanie.decerto.numbers.provider;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;


@Service
public class RandomIntegerProvider implements NumberProvider {

    protected final SecureRandom random = new SecureRandom();

    @Override
    public Number provide() {
        int from = 10;
        int to = 100;
        return random.nextInt(to - from) + from;
    }

}
