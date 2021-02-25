package zadanie.decerto.numbers.model.front;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ExecutorConfiguration {

    @NotNull(message = "Operation must be selected!")
    String operation;
    @NotNull(message = "Please select sources!")
    @Size(min = 2, message = "At least 2 sources must be selected!")
    String[] sources;

}
