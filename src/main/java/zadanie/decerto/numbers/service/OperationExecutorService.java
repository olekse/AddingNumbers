package zadanie.decerto.numbers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import zadanie.decerto.numbers.processor.DataProcessor;
import zadanie.decerto.numbers.provider.*;
import zadanie.decerto.numbers.model.OperationReport;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationExecutorService {

    private final ApplicationContext context;

    @Autowired
    OperationExecutorService(ApplicationContext context) {
        this.context = context;
    }

    public OperationReport execute(Class<? extends DataProcessor> processor, List<Class<? extends DataProvider>> providers) {
        List<Object> operands = providers.stream()
                .map(context::getBean)
                .map(DataProvider::provide)
                .collect(Collectors.toList());
        List<String> operandsAsStrings = operands.stream().map(String::valueOf).collect(Collectors.toList());
        DataProcessor dataProcessor = context.getBean(processor);
        return dataProcessor.process(operands)
                .map(result -> new OperationReport(operandsAsStrings, dataProcessor.operation(), result))
                .orElseGet(() -> new OperationReport(operandsAsStrings, dataProcessor.operation()));
    }

}
