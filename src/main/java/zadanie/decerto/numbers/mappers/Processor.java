package zadanie.decerto.numbers.mappers;

import zadanie.decerto.numbers.processor.Adder;
import zadanie.decerto.numbers.processor.DataProcessor;
import zadanie.decerto.numbers.processor.Multiplier;

public enum Processor {
    ADD(Adder.class),
    MULTIPLY(Multiplier.class);

    private final Class<? extends DataProcessor> beanClass;

    public Class<? extends DataProcessor> getBeanClass() {
        return beanClass;
    }

    Processor(Class<? extends DataProcessor> processor) {
        this.beanClass = processor;
    }

}