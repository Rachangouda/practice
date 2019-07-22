package GeneralTest;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTester {
    static String DateFormatPattern = "yyyy-MM-dd'T'HH:mm:ss.SSZZ";
    public static void main(String[] args) {



        DateTime utc = new DateTime(DateTimeZone.UTC);
        System.out.println("UTC:"+ utc.toDateTime().toString());
        System.out.println("local:" + getDateHumanReadableFormat(utc));
        //System.out.println("to local converter:" + utc.toLocalDateTime());
    }


    private static String getDateHumanReadableFormat(DateTime datetime) {
        DateTime dt = new DateTime();
        DateTimeZone dateTimeZone = DateTimeZone.getDefault();
        System.out.println("default:" + dateTimeZone);
        DateTime dateTimeSystemTimeZone = new DateTime(datetime, dateTimeZone);
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DateFormatPattern);
        return dateTimeSystemTimeZone.toString(dateTimeFormatter);
    }
}
