package cal;

public class CalendarNotFoundException extends Exception
{
    public CalendarNotFoundException ()
    {
        super("ERROR: CALENDAR NOT FOUND");
    }

}
