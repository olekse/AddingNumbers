package zadanie.decerto.numbers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import zadanie.decerto.numbers.mappers.DataProviders;
import zadanie.decerto.numbers.model.number.ProvidedData;
import zadanie.decerto.numbers.provider.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataGenerationService {

    private final ApplicationContext context;

    @Autowired
    DataGenerationService(ApplicationContext context) {
        this.context = context;
    }

    public List<ProvidedData> runProviders(List<DataProviders> providers) {
         return providers.stream()
                .map(DataProviders::getBeanClass)
                .map(context::getBean)
                .map(DataProvider::provide)
                .collect(Collectors.toList());
    }



}
