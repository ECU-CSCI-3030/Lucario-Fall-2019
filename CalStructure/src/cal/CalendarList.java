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


    public void addCalendar(Calendar newcal)
    {
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
                if(newcal.getYear() < iter.next().getYear())
                {
                    calendars.add(newcal);
                    added = true;
                    break;
                }
            }
            if(!added)
            {
                System.out.println("A calendar of the year " + newcal.getYear() + " is already in the list.");
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

    public void removeCal(int year) throws CalendarNotFoundException
    {
        {
            Iterator<Calendar> iter = calendars.iterator();
            int increment = 0;
            boolean removed = false;
            while (iter.hasNext())
            {
                Calendar iterated = iter.next();

                if(iterated.getYear()==year)
                {
                    calendars.remove(increment);
                    removed = true;
                    break;
                }

                increment++;
            }

            if(!removed)
                throw new CalendarNotFoundException();
        }
    }


    public void replaceCal(Calendar newcal)
    {
        try
        {
            this.removeCal(newcal.getYear());
        }
        catch (CalendarNotFoundException e)
        {
            System.out.print(e);
            System.out.println("ERROR IN REMOVING CALENDAR");
        }

        this.addCalendar(newcal);
    }
}
