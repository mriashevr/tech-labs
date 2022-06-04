package controllers.controllers.wrapper;

import lombok.Data;
import java.time.LocalDate;

@Data
public class KotikWrapper {
    private final String name;
    private final LocalDate birthday;
    private final String breed;
    private final String color;
    private final Long owner;
}
