package zadanie.decerto.numbers.processor;

import zadanie.decerto.numbers.model.number.ProvidedData;

import java.util.List;
import java.util.Optional;

public interface DataProcessor {

    Optional<ProvidedData> process(List<ProvidedData> operands);
    String operation();

}
