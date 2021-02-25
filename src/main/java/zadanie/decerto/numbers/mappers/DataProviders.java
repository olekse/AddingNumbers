package zadanie.decerto.numbers.mappers;
import zadanie.decerto.numbers.provider.*;

public enum DataProviders {

    LOCAL_RANDOM(RandomIntegerProvider.class),
    REMOTE_RANDOM(RemoteRandomIntegerProvider.class),
    REMOTE_DATABASE(RemoteDatabaseIntegerProvider.class),
    RANDOM_UUID(RandomUUIDProvider.class);

    private final Class<? extends DataProvider> beanClass;

    public Class<? extends DataProvider> getBeanClass() {
        return beanClass;
    }

    DataProviders(Class<? extends DataProvider> source) {
        this.beanClass = source;
    }

}