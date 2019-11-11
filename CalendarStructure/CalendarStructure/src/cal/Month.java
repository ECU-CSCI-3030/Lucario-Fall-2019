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
	
	ArrayList<TaskList> month;
	
	public Month()
	{
		month = new ArrayList<TaskList>(32);
		TaskList e = new TaskList();
		for (int i = 0; i<= 31; i++)
		{
			month.add(e);
		}
	}
	
	public TaskList getTaskList(int day)
	{
		return month.get(day);
	}
	
	public void removeTask(int day, Task t)
	{
		month.get(day).removeTask(t);
	}
	
	public void addTask(int day, Task t)
	{
		month.get(day).addTask(t);
	}
	
	public void clearTasks(int day)
	{
		month.get(day).clearTasks();
	}
	
	
	
}
