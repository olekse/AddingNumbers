package zadanie.decerto.numbers.model.front;

import lombok.Getter;
import zadanie.decerto.numbers.model.number.ProvidedData;

import java.util.List;

@Getter
public class OperationReport {

    private final boolean isSuccess;
    private final List<ProvidedData> operands;
    private final String operator;
    private final ProvidedData result;

    public OperationReport(List<ProvidedData> operands, String operator) {
        this.operands = operands;
        this.operator = operator;
        isSuccess = false;
        result = null;
    }

    public OperationReport(List<ProvidedData> operands, String operator, ProvidedData result) {
        this.operands = operands;
        this.operator = operator;
        this.result = result;
        isSuccess = true;
    }

}
