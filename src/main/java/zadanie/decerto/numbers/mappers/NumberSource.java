package zadanie.decerto.numbers.mappers;
import zadanie.decerto.numbers.provider.NumberProvider;
import zadanie.decerto.numbers.provider.RandomIntegerProvider;
import zadanie.decerto.numbers.provider.RemoteDatabaseIntegerProvider;
import zadanie.decerto.numbers.provider.RemoteRandomIntegerProvider;

public enum NumberSource {

    LOCAL_RANDOM(RandomIntegerProvider.class),
    REMOTE_RANDOM(RemoteRandomIntegerProvider.class),
    REMOTE_DATABASE(RemoteDatabaseIntegerProvider.class);

    private final Class<? extends NumberProvider> beanClass;

    public Class<? extends NumberProvider> getBeanClass() {
        return beanClass;
    }

    NumberSource(Class<? extends NumberProvider> source) {
        this.beanClass = source;
    }

}