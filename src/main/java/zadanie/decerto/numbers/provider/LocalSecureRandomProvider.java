package zadanie.decerto.numbers.provider;

import java.security.SecureRandom;

public abstract class LocalSecureRandomProvider implements DataProvider {

    protected final SecureRandom random = new SecureRandom();

}
