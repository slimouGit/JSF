package de;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Validity {
    public LocalDate convertDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
