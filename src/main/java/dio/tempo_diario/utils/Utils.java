package dio.tempo_diario.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String convertDate(String date) {
        if (date.contains("/")) {
            date = date.replace('/', '-');
        }

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date, inputFormatter);

        return date1.format(outputFormatter);
    }

}
