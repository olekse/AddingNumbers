package zadanie.decerto.numbers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import zadanie.decerto.numbers.mappers.NumberSource;
import zadanie.decerto.numbers.mappers.Processor;
import zadanie.decerto.numbers.processor.DataProcessor;
import zadanie.decerto.numbers.provider.*;
import zadanie.decerto.numbers.model.front.OperationReport;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationExecutorService {

    private final ApplicationContext context;

    @Autowired
    OperationExecutorService(ApplicationContext context) {
        this.context = context;
    }

    public OperationReport execute(Processor processor, List<NumberSource> providers) {
        List<Number> operands = providers.stream()
                .map(NumberSource::getBeanClass)
                .map(context::getBean)
                .map(NumberProvider::provide)
                .collect(Collectors.toList());
        DataProcessor dataProcessor = context.getBean(processor.getBeanClass());
        return dataProcessor.process(operands)
                .map(result -> new OperationReport(operands, dataProcessor.operation(), result))
                .orElseGet(() -> new OperationReport(operands, dataProcessor.operation()));
    }



}
