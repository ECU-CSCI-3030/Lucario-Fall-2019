package cal;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarListTest
{
    @Test
    public void addCalendarGivenYear()
    {
        CalendarList cl = new CalendarList();
        cl.addCalendar(2019);
        Calendar test;
        try
        {
            test = cl.getCalendar(2019);
            assertTrue(test.getYear()==2019);
        }
        catch(CalendarNotFoundException e)
        {
            System.out.println(e);
        }

    }

    @Test
    public void AddCalendarGivenCalendar()
    {
        CalendarList cl = new CalendarList();
        Calendar test = new Calendar(2019);

        cl.addCalendar(test);

        try
        {
            test = cl.getCalendar(2019);
            assertTrue(test.getYear()==2019);
        }
        catch(CalendarNotFoundException e)
        {
            System.out.println(e);
            System.out.println("Error in Adding Calendar");
        }
    }

    @Test
    public void removeCal()
    {
        CalendarList cl = new CalendarList();
        cl.addCalendar(2019);


        try
        {
            cl.removeCal(2019);
        }
        catch(CalendarNotFoundException e)
        {
            System.out.println(e);
            System.out.println("Error in Removing Calendar");
        }

        assertFalse(cl.calExists(2019));
    }

    @Test
    public void replaceCal()
    {
        CalendarList cl = new CalendarList();
        Calendar test = new Calendar(2019);
        cl.addCalendar(test);
        Task task = new Task("Midterm","CSCI 3700");
        test.addTask(2,12,task);
        cl.replaceCal(test);


        try
        {
            String taskstring = cl.getCalendar(2019).getTasks(2,12).getTask(0).toString();
            String shouldbe = "Midterm" + "\n" + "CSCI 3700";
            assertEquals(taskstring,shouldbe);
        }
        catch(CalendarNotFoundException e)
        {
            System.out.println(e);
            System.out.println("Error in Retrieving Calendar");
        }

    }

    @Test
    public void addTask()
    {
        CalendarList cl = new CalendarList();
        cl.addCalendar(2019);
        Task task = new Task("Midterm","CSCI 3700");
        cl.addTask(2,12,2019,task);
        TaskList tl = cl.getTasks(2,12,2019);
        assertTrue(task.equals(tl.getTask(0)));
    }

    @Test
    public void removeTask()
    {
        CalendarList cl = new CalendarList();
        cl.addCalendar(2019);
        Task task = new Task("Midterm","CSCI 3700");
        cl.addTask(2,12,2019,task);
        cl.removeTask(2,12,2019,task);

        TaskList tl = cl.getTasks(2,12,2019);
        assertTrue(tl.isEmpty());
    }


    @Test
    public void dateCheck()
    {
        CalendarList cl = new CalendarList();
        //first give it a false date
        assertFalse(cl.dateCheck(2,30,2019));

        //second a legitimate date on a leap year
        assertTrue(cl.dateCheck(2,29,2020));

        //third a false date on a leap year
        assertFalse(cl.dateCheck(2,29,2019));


    }
}