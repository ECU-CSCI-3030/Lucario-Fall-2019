/**
 * Month
 * 
 * Represents a month in the calendar structure. 
 * @author Tristen Schuler
 */




package cal;

import java.util.*;

public class Month 
{
	
	private ArrayList<TaskList> month;
	
	public Month()
	{
		month = new ArrayList<TaskList>(32);
		TaskList e = new TaskList();
		for (int i = 0; i<= 31; i++)
		{
			month.add(e);
		}
	}

	/**
	 * getTaskList(day)
	 *
	 * Returns the TaskList at month[day].
	 *
	 * @param day
	 * @return
	 */
	public TaskList getTaskList(int day)
	{
		return month.get(day);
	}

	/**
	 * removeTask(day,t)
	 *
	 * Removes Task 't' from the TaskList at month[day].
	 *
	 * @param day
	 * @param t
	 */
	public void removeTask(int day, Task t)
	{
		month.get(day).removeTask(t);
	}

	/**
	 * addTask(day,t)
	 *
	 * Adds Task 't' to the TaskList at month[day].
	 *
	 * @param day
	 * @param t
	 */
	public void addTask(int day, Task t)
	{
		month.get(day).addTask(t);
	}


	/**
	 * clearTasks(day)
	 *
	 * Removes all Tasks from the TaskList at month[day]
	 * @param day
	 */
	public void clearTasks(int day)
	{
		month.get(day).clearTasks();
	}
	
	
	
}
