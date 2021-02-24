package zadanie.decerto.numbers.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "numbers")
@Data
public class NumericDatabaseData {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "num")
    private Integer value = 0;

}
