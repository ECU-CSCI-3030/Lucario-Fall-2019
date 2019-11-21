
/**
 * TaskList
 * 
 * Represents a list of tasks in the calendar structure. 
 * @author Tristen Schuler
 */

package cal;

import java.util.*;

public class TaskList 
{
	private LinkedList<Task> tasklist = new LinkedList<Task>();


	/**
	 * addTask(t)
	 *
	 * Adds Task 't' to the TaskList
	 *
	 * @param t
	 */
	public void addTask(Task t)
	{
		tasklist.add(t);
	}


	/**
	 * removeTask(t)
	 *
	 * Removes all instances of Task 't' from the TaskList.
	 * @param t
	 */
	public void removeTask(Task t)
	{
		Iterator<Task> iter = tasklist.iterator();

		while (iter.hasNext())
		{
			Task current = iter.next();

			if (current.isEqual(t))
			{
				iter.remove();

				if(iter.hasNext())
				{
					iter.next();
				}
				else
					break;
			}
		}	
	}


	/**
	 * clearTasks()
	 * 
	 * Removes all Tasks in the TaskList.
	 */
	public void clearTasks()
	{
		tasklist.clear();
	}


	/**
	 * printTasks()
	 *
	 * Prints all the Tasks in the TaskList.
	 * Prints the Tasks in the same format as Task.toString()
	 */
	public void printTasks()
	{
		if(tasklist.isEmpty())
		{
			System.out.print("There are no tasks for this date");

		}
		else
		{

			Iterator<Task> iter = tasklist.iterator();

			while (iter.hasNext())
			{
				System.out.println(iter.next().toString() + "\n");
			}
		}
	}

}
