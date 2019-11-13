
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

	public void addTask(Task t)
	{
		tasklist.add(t);
	}



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
	 * clears the task list. 
	 */
	public void clearTasks()
	{
		tasklist.clear();
	}



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
