package zadanie.decerto.numbers.provider;

import org.springframework.stereotype.Service;


@Service
public class RandomIntegerProvider extends LocalSecureRandomProvider {

    @Override
    public Object provide() {
        int from = 10;
        int to = 100;
        return random.nextInt(to - from) + from;
    }

}
