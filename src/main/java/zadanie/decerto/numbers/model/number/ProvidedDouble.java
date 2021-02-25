package zadanie.decerto.numbers.model.number;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class ProvidedDouble implements ProvidedData {

    private final Double value;

    @Override
    public Integer asInteger() {
        return (int) Math.round(value);
    }

    @Override
    public Double asDouble() {
        return value;
    }

    @Override
    public Float asFloat() {
        return value.floatValue();
    }

    @Override
    public BigDecimal asBigDecimal() {
        return BigDecimal.valueOf(value);
    }

    @Override
    public String asString() {
        return String.valueOf(value);
    }
}
