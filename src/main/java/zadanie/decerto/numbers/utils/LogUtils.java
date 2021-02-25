package zadanie.decerto.numbers.utils;

import java.util.List;
import java.util.stream.Collectors;

public class LogUtils {

    private LogUtils(){}

    public static String failedOperationMessage(List<Number> operands, String operation) {
        return operation + " operation failed. Operands: [" + operands.stream().map(String::valueOf).collect(Collectors.joining(", ")) + "]";
    }

}
