package zadanie.decerto.numbers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zadanie.decerto.numbers.mappers.NumberSource;
import zadanie.decerto.numbers.mappers.Processor;
import zadanie.decerto.numbers.model.front.ExecutorConfiguration;
import zadanie.decerto.numbers.service.OperationExecutorService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static zadanie.decerto.numbers.mappers.NumberSource.*;
import static zadanie.decerto.numbers.mappers.Processor.ADD;
import static zadanie.decerto.numbers.mappers.Processor.MULTIPLY;

@Controller
public class OperationController {

    private static final String ADD_OPERATION = "add";
    private static final String MULTIPLY_OPERATION = "multiply";
    private static final String LOCAL_RANDOM_DATASOURCE = "localRandom";
    private static final String REMOTE_DATASOURCE_DATASOURCE = "remoteDatabase";
    private static final String REMOTE_RANDOM_DATASOURCE = "remoteRandom";
    private static final String REPORT_JSP_VIEW = "report";
    private static final String EXECUTOR_FORM_JSP_VIEW = "executorForm";
    private static final String REPORT_MODEL_NAME = "reportObject";
    private final OperationExecutorService reportProviderService;

    private static final Map<String, NumberSource> sources = Map.ofEntries(
            Map.entry(REMOTE_RANDOM_DATASOURCE, REMOTE_RANDOM),
            Map.entry(REMOTE_DATASOURCE_DATASOURCE, REMOTE_DATABASE),
            Map.entry(LOCAL_RANDOM_DATASOURCE, LOCAL_RANDOM));

    private static final Map<String, Processor> processors = Map.ofEntries(
            Map.entry(ADD_OPERATION, ADD),
            Map.entry(MULTIPLY_OPERATION, MULTIPLY));

    @Autowired
    public OperationController(OperationExecutorService reportProviderService) {
        this.reportProviderService = reportProviderService;
    }

    @GetMapping("/")
    public String executorForm(Model model) {
        ExecutorConfiguration configuration = new ExecutorConfiguration();
        model.addAttribute("configuration", configuration);
        return EXECUTOR_FORM_JSP_VIEW;
    }

    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("configuration") ExecutorConfiguration configuration, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return EXECUTOR_FORM_JSP_VIEW;
        var report = reportProviderService.execute(
                processors.get(configuration.getOperation()),
                Arrays.stream(configuration.getSources())
                        .map(sources::get)
                        .collect(Collectors.toList()));
        model.addAttribute(REPORT_MODEL_NAME, report);
        return REPORT_JSP_VIEW;
    }

}