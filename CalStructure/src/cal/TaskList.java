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

	public String toString()
	{
		StringBuilder tl = null;
		if(tasklist.isEmpty())
		{
			System.out.print("There are no tasks for this date");

		}
		else
		{

			Iterator<Task> iter = tasklist.iterator();

			while (iter.hasNext()) {
				tl.append(iter.next().toString()).append("\n");
			}
		}
		return tl.toString();
	}

	/**
	 * getTask(index)
	 *
	 * Returns the Task at the index 'index' in the tasklist.
	 * @param index
	 * @return the Task at index 'index' in the tasklist.
	 */
	public Task getTask(int index)
	{
		return tasklist.get(index);
	}

	/**
	 * isEmpty()
	 *
	 * Determines whether the TaskList is empty
	 * @return True if the list is empty. False if not.
	 */
	public boolean isEmpty()
	{
		return tasklist.isEmpty();
	}
}