package zadanie.decerto.numbers.processor;

import java.util.List;
import java.util.Optional;

public interface DataProcessor {

    Optional<String> process(List<Object> operands);
    String operation();

}
