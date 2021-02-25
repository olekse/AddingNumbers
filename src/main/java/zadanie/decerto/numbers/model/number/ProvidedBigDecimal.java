package zadanie.decerto.numbers.model.number;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class ProvidedBigDecimal implements ProvidedData {

    private final BigDecimal value;

    @Override
    public Integer asInteger() {
        return value.intValue();
    }

    @Override
    public Double asDouble() {
        return value.doubleValue();
    }

    @Override
    public Float asFloat() {
        return value.floatValue();
    }

    @Override
    public BigDecimal asBigDecimal() {
        return value;
    }

    @Override
    public String asString() {
        return value.toString();
    }
}
