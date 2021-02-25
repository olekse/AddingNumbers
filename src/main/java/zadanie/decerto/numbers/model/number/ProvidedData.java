package zadanie.decerto.numbers.model.number;

import java.io.Serializable;
import java.math.BigDecimal;

public interface ProvidedData extends Serializable {

    Integer asInteger();
    Double asDouble();
    Float asFloat();
    BigDecimal asBigDecimal();
    String asString();

}
