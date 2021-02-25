package zadanie.decerto.numbers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import zadanie.decerto.numbers.mappers.DataProviders;
import zadanie.decerto.numbers.model.front.GeneratorConfiguration;
import zadanie.decerto.numbers.service.DataGenerationService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static zadanie.decerto.numbers.mappers.DataProviders.*;
import static zadanie.decerto.numbers.model.front.SessionAttributes.OPERANDS;

@Controller
public class GenerationController {

    private static final String GENERATOR_CONFIG_JSP_VIEW = "generator";
    private static final String GENERATOR_REPORT_JSP_VIEW = "generatorReport";
    private static final String LOCAL_RANDOM_DATASOURCE = "localRandom";
    private static final String RANDOM_UUID_PROVIDER = "randomUuid";
    private static final String REMOTE_DATASOURCE_DATASOURCE = "remoteDatabase";
    private static final String REMOTE_RANDOM_DATASOURCE = "remoteRandom";
    private static final String SOURCE_CONFIGURATION_MODEL_ATTRIBUTE_NAME = "sourcesConfiguration";
    private static final String GENERATED_DATA_PREVIEW_MODEL_ATTRIBUTE = "generatedData";

    private static final Map<String, DataProviders> sources = Map.ofEntries(
            Map.entry(REMOTE_RANDOM_DATASOURCE, REMOTE_RANDOM),
            Map.entry(REMOTE_DATASOURCE_DATASOURCE, REMOTE_DATABASE),
            Map.entry(LOCAL_RANDOM_DATASOURCE, LOCAL_RANDOM),
            Map.entry(RANDOM_UUID_PROVIDER, RANDOM_UUID)
    );

    private final DataGenerationService dataGenerationService;

    @Autowired
    public GenerationController(DataGenerationService reportProviderService) {
        this.dataGenerationService = reportProviderService;
    }

    @GetMapping("/generator/config")
    public String generatorConfiguration(Model model) {
        GeneratorConfiguration configuration = new GeneratorConfiguration();
        model.addAttribute(SOURCE_CONFIGURATION_MODEL_ATTRIBUTE_NAME, configuration);
        return GENERATOR_CONFIG_JSP_VIEW;
    }

    @PostMapping("/generator/report")
    public String generate(@Valid @ModelAttribute(SOURCE_CONFIGURATION_MODEL_ATTRIBUTE_NAME) GeneratorConfiguration configuration, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors())
            return GENERATOR_CONFIG_JSP_VIEW;
        var operands = dataGenerationService.runProviders(
                Arrays.stream(configuration.getSources())
                        .map(sources::get)
                        .collect(Collectors.toList()));
        session.setAttribute(OPERANDS, operands);
        model.addAttribute(GENERATED_DATA_PREVIEW_MODEL_ATTRIBUTE, operands);
        return GENERATOR_REPORT_JSP_VIEW;
    }

}
