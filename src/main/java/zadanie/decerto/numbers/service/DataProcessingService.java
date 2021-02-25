package zadanie.decerto.numbers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import zadanie.decerto.numbers.mappers.Processor;
import zadanie.decerto.numbers.model.front.OperationReport;
import zadanie.decerto.numbers.model.number.ProvidedData;
import zadanie.decerto.numbers.processor.DataProcessor;

import java.util.List;

@Service
public class DataProcessingService {

    private final ApplicationContext context;

    @Autowired
    DataProcessingService(ApplicationContext context) {
        this.context = context;
    }

    public OperationReport processData(Processor processor, List<ProvidedData> operands){
        DataProcessor dataProcessor = context.getBean(processor.getBeanClass());
        return dataProcessor.process(operands)
                .map(result -> new OperationReport(operands, dataProcessor.operation(), result))
                .orElseGet(() -> new OperationReport(operands, dataProcessor.operation()));
    }

}
