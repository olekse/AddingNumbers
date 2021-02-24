package zadanie.decerto.numbers.model;

import lombok.Data;

import java.util.List;

@Data
public class OperationReport {

    private final boolean isSuccess;
    private final List<String> operands;
    private final String operator;
    private final String result;

    public OperationReport(List<String> operands, String operator) {
        this.operands = operands;
        this.operator = operator;
        isSuccess = false;
        result = null;
    }

    public OperationReport(List<String> operands, String operator, String result) {
        this.operands = operands;
        this.operator = operator;
        this.result = result;
        isSuccess = true;
    }

    @Override
    public String toString() {
        String common = "Operaion report - Operands:[" + String.join(", ", operands) + "] | Operator: " + operator;
        return common + (isSuccess ? " | Success! Result: " + result : " | Operation failed!");
    }

}
