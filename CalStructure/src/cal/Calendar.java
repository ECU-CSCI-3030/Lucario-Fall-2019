/**
 * Calendar
 * 
 * Represents a single calendar in the calendar structure 
 * @author Tristen Schuler
 */

package cal;

import java.util.*;

public class  Calendar
{
	private int year;
	
	private ArrayList<Month> calendar  = new ArrayList<Month>(13);
	
	
	/*
	 * ------------------------------------
	 * Constructors
	 * ------------------------------------
	 */
	
	public Calendar()
	{
		year = 0;
		
		for (int i = 0; i<13; i++)
		{
			Month x = new Month();
			calendar.add(x);
		}
	}
	
	public Calendar(int y)
	{
		year = y;
		
		for (int i = 0; i<13; i++)
		{
			Month x = new Month();
			calendar.add(x);
		}
	}
	
	
	/*
	 * ------------------------------------
	 * get Methods
	 * ------------------------------------
	 */

	public TaskList getTasks(int month, int day)
	{
		return calendar.get(month).getTaskList(day);
	}

	public int getYear() {return this.year;}


	/*
	 * ------------------------------------
	 * remove Methods
	 * ------------------------------------
	 */

	/**
	 * removeTask(month,day,t)
	 *
	 * Removes Task 't' from the calendar at the given date.
	 *
	 * @param month
	 * @param day
	 * @param t
	 */
	public void removeTask(int month, int day, Task t)
	{
		calendar.get(month).removeTask(day, t);
	}

	/**
	 * clearTasks(month,day)
	 *
	 * Removes all Tasks in the calendar at the given date.
	 *
	 * @param month
	 * @param day
	 */
	public void clearTasks(int month,int day)
	{
		calendar.get(month).clearTasks(day);
	}
	
	/*
	 * ------------------------------------
	 * Add Method
	 * ------------------------------------
	 */

	/**
	 * addTask(month,day,t)
	 *
	 * Adds Task 't' to the calendar at the given date.
	 *
	 * @param month
	 * @param day
	 * @param t
	 */
	public void addTask(int month, int day, Task t)
	{
		calendar.get(month).addTask(day, t);
	}
	
	/*
	 * ------------------------------------
	 * Print Method
	 * ------------------------------------
	 */

	/**
	 * printTasks(month,day)
	 *
	 * Prints all the tasks in the calendar at the given date.
	 *
	 * @param month
	 * @param day
	 */
	public void printTasks (int month,int day)
	{
		TaskList tl = getTasks(month, day);
		
		tl.printTasks();
	}


	/**
	 * isEqual(cal)
	 *
	 * Determines whether the Calendar calling the method
	 * has the same year as Calendar 'cal'.
	 * @param cal
	 * @return True if the Calendar calling the method has the same year as Calendar 'cal'.
	 * 		   False if not.
	 */
	public boolean isEqual(Calendar cal)
	{
		if(this.getYear()==cal.getYear())
			return true;
		else
			return false;
	}
}
