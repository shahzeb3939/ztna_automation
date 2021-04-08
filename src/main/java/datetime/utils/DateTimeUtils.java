package datetime.utils;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;


public class DateTimeUtils {
    public static DateTime stringToLocalISO(String dateTime,String format) {
        return LocalDateTime.parse(dateTime, DateTimeFormat.forPattern(format)).toDateTime().toDateTimeISO();
    }
}
