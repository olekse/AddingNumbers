package zadanie.decerto.numbers.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zadanie.decerto.numbers.model.number.ProvidedBigDecimal;
import zadanie.decerto.numbers.model.number.ProvidedData;
import zadanie.decerto.numbers.utils.LogUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class Multiplier implements DataProcessor {

    @Override
    public Optional<ProvidedData> process(List<ProvidedData> operands) {
        BigDecimal product = BigDecimal.ONE;
        try {
            for (ProvidedData operand : operands)
                product = product.multiply(operand.asBigDecimal());
        } catch (Exception e) {
            log.error(LogUtils.failedOperationMessage(operands, operation()));
            return Optional.empty();
        }
        return Optional.of(new ProvidedBigDecimal(product));
    }

    @Override
    public String operation() {
        return "multiplication";
    }

}
