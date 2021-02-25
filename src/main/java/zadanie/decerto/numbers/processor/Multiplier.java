package zadanie.decerto.numbers.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zadanie.decerto.numbers.utils.LogUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class Multiplier implements DataProcessor {

    @Override
    public Optional<Number> process(List<Number> operands) {
        BigDecimal sum = BigDecimal.ONE;
        try {
            for (Number operand : operands)
                sum = sum.multiply(new BigDecimal(operand.toString()));
        } catch (Exception e) {
            log.error(LogUtils.failedOperationMessage(operands, operation()));
            return Optional.empty();
        }
        return Optional.of(sum);
    }

    @Override
    public String operation() {
        return "multiplication";
    }

}
