package zadanie.decerto.numbers.utils;

import zadanie.decerto.numbers.model.number.ProvidedData;

import java.util.List;
import java.util.stream.Collectors;

public class LogUtils {

    private LogUtils(){}

    public static String failedOperationMessage(List<ProvidedData> operands, String operation) {
        return operation + " operation failed. Operands: [" + operands.stream().map(ProvidedData::asString).collect(Collectors.joining(", ")) + "]";
    }

}
