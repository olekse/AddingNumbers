package zadanie.decerto.numbers.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class StrictAdder implements DataProcessor {

    @Override
    public Optional<String> process(List<Object> operands) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Object operand: operands)
            if (operand instanceof Number)
                sum = sum.add(new BigDecimal(operand.toString()));
            else {
                log.error("Adder commanded to add Not A Number");
                return Optional.empty();
            }
        return Optional.of(sum.toString());
    }

    @Override
    public String operation() {
        return "sum";
    }

}
