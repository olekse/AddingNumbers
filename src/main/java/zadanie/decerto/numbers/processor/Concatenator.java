package zadanie.decerto.numbers.processor;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Concatenator implements DataProcessor {

    @Override
    public Optional<String> process(List<Object> operands) {
        return Optional.of(operands.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }

    @Override
    public String operation() {
        return "concatenation";
    }
}
