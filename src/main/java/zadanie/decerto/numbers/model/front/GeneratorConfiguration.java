package zadanie.decerto.numbers.model.front;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class GeneratorConfiguration {

    @Size(min = 2, message = "At least 2 sources must be selected!")
    String[] sources;

}
