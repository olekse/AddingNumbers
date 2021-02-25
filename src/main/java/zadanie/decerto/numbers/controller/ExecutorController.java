package zadanie.decerto.numbers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zadanie.decerto.numbers.mappers.Processor;
import zadanie.decerto.numbers.model.front.ExecutorConfiguration;
import zadanie.decerto.numbers.model.front.SessionAttributes;
import zadanie.decerto.numbers.model.number.ProvidedData;
import zadanie.decerto.numbers.service.DataProcessingService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static zadanie.decerto.numbers.mappers.Processor.ADD;
import static zadanie.decerto.numbers.mappers.Processor.MULTIPLY;

@Controller
public class ExecutorController {

    private static final String ADD_OPERATION = "add";
    private static final String ERROR_JSP = "error";
    private static final String MULTIPLY_OPERATION = "multiply";
    private static final String REPORT_JSP_VIEW = "executorReport";
    private static final String EXECUTOR_FORM_JSP_VIEW = "executor";
    private static final String REPORT_MODEL_NAME = "reportObject";
    private static final String EXECUTOR_CONFIGURATION_MODEL_ATTRIBUTE_NAME = "executorConfiguration";

    private final DataProcessingService dataProcessingService;

    private static final Map<String, Processor> processors = Map.ofEntries(
            Map.entry(ADD_OPERATION, ADD),
            Map.entry(MULTIPLY_OPERATION, MULTIPLY));

    @Autowired
    public ExecutorController(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    @GetMapping("/executor/configuration")
    public String executorForm(Model model) {
        ExecutorConfiguration configuration = new ExecutorConfiguration();
        model.addAttribute(EXECUTOR_CONFIGURATION_MODEL_ATTRIBUTE_NAME, configuration);
        return EXECUTOR_FORM_JSP_VIEW;
    }

    @PostMapping("/executor/report")
    public String submitForm(@Valid @ModelAttribute(EXECUTOR_CONFIGURATION_MODEL_ATTRIBUTE_NAME) ExecutorConfiguration configuration, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors())
            return EXECUTOR_FORM_JSP_VIEW;
        Object savedGeneratedData = session.getAttribute(SessionAttributes.OPERANDS);
        if (savedGeneratedData instanceof List && ((List<?>) savedGeneratedData).get(0) instanceof ProvidedData) {
            @SuppressWarnings("unchecked")
            List<ProvidedData> generatedDataStoredInSession = (List<ProvidedData>)savedGeneratedData;
            model.addAttribute(REPORT_MODEL_NAME, dataProcessingService.processData(processors.get(configuration.getOperation()), generatedDataStoredInSession));
            return REPORT_JSP_VIEW;
        }
        return ERROR_JSP;
    }

}