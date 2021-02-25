package zadanie.decerto.numbers.processor;

import java.util.List;
import java.util.Optional;

public interface DataProcessor {

    Optional<Number> process(List<Number> operands);
    String operation();

}
