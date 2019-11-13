/**
 * Calendar
 * 
 * Represents a single calendar in the calendar structure 
 * @author Tristen Schuler
 */

package cal;

import java.util.*;

public class Calendar 
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


	public void removeTask(int month, int day, Task t)
	{
		calendar.get(month).removeTask(day, t);
	}
	
	public void clearTasks(int month,int day)
	{
		calendar.get(month).clearTasks(day);
	}
	
	/*
	 * ------------------------------------
	 * Add Method
	 * ------------------------------------
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
	
	public void printTasks (int month,int day)
	{
		TaskList tl = getTasks(month, day);
		
		tl.printTasks();
	}
}
