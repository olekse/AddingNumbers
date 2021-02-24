package zadanie.decerto.numbers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import zadanie.decerto.numbers.processor.Concatenator;
import zadanie.decerto.numbers.processor.StrictAdder;
import zadanie.decerto.numbers.provider.RandomIntegerProvider;
import zadanie.decerto.numbers.provider.RandomStringProvider;
import zadanie.decerto.numbers.provider.RemoteDatabaseIntegerProvider;
import zadanie.decerto.numbers.provider.RemoteRandomIntegerProvider;
import zadanie.decerto.numbers.service.OperationExecutorService;

import java.util.Arrays;

@Controller
public class OperationController {

    private static final String REPORT_JSP_VIEW = "report";
    private static final String REPORT_MODEL_NAME = "reportText";
    private final OperationExecutorService reportProviderService;

    @Autowired
    public OperationController(OperationExecutorService reportProviderService) {
        this.reportProviderService = reportProviderService;
    }

    @GetMapping({"/", "/add"})
    public String add(Model model) {
        var report = reportProviderService.execute(
                StrictAdder.class,
                Arrays.asList(
                        RemoteDatabaseIntegerProvider.class,
                        RandomIntegerProvider.class,
                        RemoteRandomIntegerProvider.class));
        model.addAttribute(REPORT_MODEL_NAME, report);
        return REPORT_JSP_VIEW;
    }

    @GetMapping("/concat")
    public String concat(Model model) {
        model.addAttribute(REPORT_MODEL_NAME, reportProviderService.execute(
                Concatenator.class,
                Arrays.asList(
                        RandomStringProvider.class,
                        RandomIntegerProvider.class)));
        return REPORT_JSP_VIEW;
    }

    @GetMapping("/addFail")
    public String addFail(Model model) {
        model.addAttribute(REPORT_MODEL_NAME, reportProviderService.execute(
                StrictAdder.class,
                Arrays.asList(
                        RandomStringProvider.class,
                        RandomIntegerProvider.class)));
        return REPORT_JSP_VIEW;
    }

}