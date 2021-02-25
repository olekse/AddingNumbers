package zadanie.decerto.numbers.model.front;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OperationReport {

    private final boolean isSuccess;
    private final List<Number> operands;
    private final String operator;
    private final Number result;

    public OperationReport(List<Number> operands, String operator) {
        this.operands = operands;
        this.operator = operator;
        isSuccess = false;
        result = null;
    }

    public OperationReport(List<Number> operands, String operator, Number result) {
        this.operands = operands;
        this.operator = operator;
        this.result = result;
        isSuccess = true;
    }

    @Override
    public String toString() {
        String common = "Operaion report\nOperands:[" + operands.stream().map(Object::toString).collect(Collectors.joining(", ")) + "]\nOperator: " + operator + "\nStatus: ";
        return common + (isSuccess ? "Success! Result: " + result : "Failure.");
    }

}
