/**
 * CalendarList
 *
 * Holds a LinkedList of the Calendar structure
 * @author Tristen Schuler
 */



package cal;



import java.util.*;


public class CalendarList
{

    private LinkedList<Calendar> calendars;

    public CalendarList()
    {
        calendars = new LinkedList<Calendar>();
    }

    public void addCalendar(int year)
    {
        Calendar newcal = new Calendar(year);
        if(calendars.isEmpty())
        {
            calendars.add(newcal);
        }
        else
        {
            Iterator<Calendar> iter = calendars.iterator();
            boolean added = false;

            while(iter.hasNext())
            {
                if(year < iter.next().getYear())
                {
                    calendars.add(newcal);
                    added = true;
                    break;
                }
            }
            if(!added)
            {
                System.out.println("A calendar of the year " + year + " is already in the list.");
            }
        }
    }

    public Calendar getCalendar(int year) throws CalendarNotFoundException
    {
        Iterator<Calendar> iter = calendars.iterator();

            while (iter.hasNext())
            {
                Calendar iterated = iter.next();
                if(iterated.getYear()==year)
                {
                    return iterated;
                }
            }

            throw new CalendarNotFoundException();
    }

    public boolean isEmpty()
    {
        if(calendars.isEmpty())
            return true;
        else
            return true;
    }

}
