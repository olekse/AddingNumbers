package zadanie.decerto.numbers.model.front;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ExecutorConfiguration {

    @NotNull(message = "Operation must be selected!")
    String operation;

}
