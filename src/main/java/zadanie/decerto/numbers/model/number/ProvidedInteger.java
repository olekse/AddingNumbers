package zadanie.decerto.numbers.model.number;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class ProvidedInteger implements ProvidedData {

    private final Integer value;

    @Override
    public Integer asInteger() {
        return value;
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
        return new BigDecimal(value);
    }

    @Override
    public String asString() {
        return String.valueOf(value);
    }
}
