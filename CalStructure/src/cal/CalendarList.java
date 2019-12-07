/**
 * CalendarList
 *
 * Holds a LinkedList of the Calendar structure with methods to operate on it.
 * @author Tristen Schuler
 */



package cal;



import com.sun.deploy.security.SelectableSecurityManager;

import java.util.*;


public class CalendarList
{

    private LinkedList<Calendar> calendars;

    // Constructor
    public CalendarList()
    {
        calendars = new LinkedList<Calendar>();
    }

    /**
     * addCalendar(year)
     *
     * Adds an empty calendar with the year given to the calendar list. If a calendar with the year given
     * is already in the list it will not be added, and prints to the screen that a calendar with that year
     * is already in the list.
     * @param year
     */
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

    /**
     * addCalendar(newcal)
     *
     * Adds the calendar given to the calendar list. If a calendar with the same year as 'newcal'
     * is already in the list it will not be added, and prints to the screen that a calendar with that year
     * is already in the list.
     *
     * NOTE: If you would like to replace a calendar you can use the replaceCal function.
     *
     * @param newcal
     */
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

    /**
     * getCalendar(year)
     *
     * Returns a calendar in the calendar list that has the same year as 'year'.
     * Throws CalendarNotFoundException if a calendar with that year is not in the list.
     *
     * @param year
     * @return The calendar in the list with the year given.
     * @throws CalendarNotFoundException
     */
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

    /**
     * isEmpty()
     *
     * Returns true if list is empty, false if it isn't.
     *
     * @return true if empty, false if not empty
     */
    public boolean isEmpty()
    {
        if(calendars.isEmpty())
            return true;
        else
            return true;
    }

    /**
     * removeCal(year)
     *
     * Removes the calendar with the given year from the calendar list.
     * Throws CalendarNotFoundException if a calendar with the given year
     * is not in the list.
     *
     * Throws CalendarNotFoundException if there is no calendar with the given
     * year in the calendar list.
     *
     * @param year
     * @throws CalendarNotFoundException
     */
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

    /**
     * replaceCal(newcal)
     *
     * Removes the calendar in the calendar list that has the same year as 'newcal'.
     * Then adds newcal to the calendar list.
     *
     * @param newcal
     */
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


    /**
     * addTask(month,day,year,t)
     *
     * Adds task 't' to the calendar in the calendar list with the year given.
     * If there is not a calendar with the given year in the list, then the task will not be added.
     *
     * @param month
     * @param day
     * @param year
     * @param t
     */
    public void addTask(int month, int day, int year, Task t)
    {
        try
        {
            this.getCalendar(year).addTask(month, day, t);
        }
        catch (CalendarNotFoundException e)
        {
            System.out.println(e);
            System.out.println("ERROR IN CalendarList.addTask()");
        }
    }

    /**
     * removeTask(month,day,year,t)
     *
     * Removes Task 't' from the calendar in the calendar list with the given year.
     *
     * @param month
     * @param day
     * @param year
     * @param t
     */
    public void removeTask(int month, int day, int year, Task t)
    {
        try
        {
            this.getCalendar(year).removeTask(month, day, t);
        }
        catch (CalendarNotFoundException e)
        {
            System.out.println(e);
            System.out.println("ERROR IN CalendarList.removeTask()");
        }
    }

    /**
     * getTasks(month,day,year)
     *
     * Returns a TaskList of all the tasks of the given date.
     *
     * @param month
     * @param day
     * @param year
     * @return
     */
    public TaskList getTasks(int month, int day, int year)
    {
        try
        {
            return this.getCalendar(year).getTasks(month, day);
        }
        catch (CalendarNotFoundException e)
        {
            System.out.println(e);
            System.out.println("ERROR IN CalendarList.getTasks()");
        }
        return null;
    }


    /**
     * dateCheck(month,day,year)
     *
     * Determines whether a date exists. Returns true if the date exists, False if not.
     * @param month
     * @param day
     * @param year
     *
     * @return True if date exist, False if not.
     */
    private boolean dateCheck(int month, int day, int year)
    {
        if (month >= 1 && month <= 12)
        {
            return checkDay(month,day,year);
        }
        else
            return false;
    }


    /**
     * isLeapYear(year)
     *
     * Determines whether a given year is a leap year
     * @param year
     * @return True if 'year' is a leap year. False if not.
     */
    private boolean isLeapYear(int year)
    {
        if (year%4==0)
            return true;
        else
            return false;
    }


    /**
     * checkDay(month,day,year)
     *
     * Determines whether the 'day' given is in the 'month' given,
     * during the 'year' given.
     *
     * @param month
     * @param day
     * @param year
     * @return True if the 'day' is in the 'month' during 'year'. False if not.
     */
    private boolean checkDay(int month, int day, int year)
    {
        if(month == 1)
        {
            if(day >= 1 && day<=31)
                return true;
            else
                return false;
        }
        else if(month == 2)
        {
            if(isLeapYear(year))
            {
                if(day >= 1 && day<=29)
                    return true;
                else
                    return false;
            }
            else
            {
                if(day >= 1 && day<=28)
                    return true;
                else
                    return false;
            }
        }
        else if(month == 3)
        {
            if (day >= 1 && day <= 31)
                return true;
            else
                return false;
        }
        else if(month == 4)
        {
            if (day >= 1 && day <= 30)
                return true;
            else
                return false;
        }
        else if(month == 5)
        {
            if (day >= 1 && day <= 31)
                return true;
            else
                return false;
        }
        else if(month == 6)
        {
            if (day >= 1 && day <= 30)
                return true;
            else
                return false;
        }
        else if(month == 7)
        {
            if (day >= 1 && day <= 31)
                return true;
            else
                return false;
        }
        else if(month == 8)
        {
            if (day >= 1 && day <= 31)
                return true;
            else
                return false;
        }
        else if(month == 9)
        {
            if (day >= 1 && day <= 30)
                return true;
            else
                return false;
        }
        else if(month == 10)
        {
            if (day >= 1 && day <= 31)
                return true;
            else
                return false;
        }
        else if(month == 11)
        {
            if (day >= 1 && day <= 30)
                return true;
            else
                return false;
        }
        else if(month == 12)
        {
            if (day >= 1 && day <= 31)
                return true;
            else
                return false;
        }
        else
            return false;
    }




}


