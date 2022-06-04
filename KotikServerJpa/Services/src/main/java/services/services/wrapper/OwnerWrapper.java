package services.services.wrapper;

import lombok.Data;
import java.time.LocalDate;

@Data
public class OwnerWrapper {
    private final String name;
    private final LocalDate birthday;
}

