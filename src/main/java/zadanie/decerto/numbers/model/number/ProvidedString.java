package zadanie.decerto.numbers.model.number;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class ProvidedString implements ProvidedData {

    private final String value;

    @Override
    public Integer asInteger() {
        throw makeNotConvertibleEx("Integer");
    }

    @Override
    public Double asDouble() {
        throw makeNotConvertibleEx("Double");
    }

    @Override
    public Float asFloat() {
        throw makeNotConvertibleEx("Float");
    }

    @Override
    public BigDecimal asBigDecimal() {
        throw makeNotConvertibleEx("BigDecimal");
    }

    @Override
    public String asString() {
        return value;
    }

    private static IllegalStateException makeNotConvertibleEx(String type) {
        return new IllegalStateException("String cannot be converted to " + type);
    }

}
