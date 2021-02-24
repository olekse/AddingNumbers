package zadanie.decerto.numbers.provider;

import org.springframework.stereotype.Component;

@Component
public class RandomStringProvider extends LocalSecureRandomProvider {

    private static final int LENGTH = 10;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Override
    public Object provide() {
        StringBuilder sb = new StringBuilder(LENGTH);
        for(int i = 0; i < LENGTH; i++)
            sb.append(AB.charAt(random.nextInt(AB.length())));
        return sb.toString();
    }

}
