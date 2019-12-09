package cal;

public class Task 
{
	private String act;
	private String course;
	
	public Task()
	{
		act = course = "";
	}
	
	public Task(String a, String c)
	{
		act = a;
		course =c;
	}
	
	/*
	 * -------------------------------------
	 * Get Methods
	 * -------------------------------------
	 */
	
	public String getAct()
	{
		return act;
	}
	
	public String getCourse()
	{
		return course;
	}
	
	
	
	/*
	 * -------------------------------------
	 * Set Methods
	 * -------------------------------------
	 */
	
	public void setAct(String a)
	{
		act = a;
	}
	
	public void setCourse(String c)
	{
		course = c; 
	}
	
	
	/*
	 * -------------------------------------
	 * isEqual Method
	 * -------------------------------------
	 */

	/**
	 * isEqual(Task t)
	 *
	 * Returns true if the Task calling the method is equal to Task 't'.
	 * Returns false if not.
	 *
	 * @param t
	 * @return
	 */
	public boolean isEqual(Task t)
	{
		String atest1 = this.act.toLowerCase();
		String atest2 = t.act.toLowerCase();
		
		String ctest1 = this.course.toLowerCase();
		String ctest2 = t.course.toLowerCase();

		return atest1.equals(atest2) && ctest1.equals(ctest2);
	}
	

	/**
	 * toString()
	 * 
	 * returns a task in a string.
	 * 
	 * Format:
	 * 
	 * act
	 * course
	 * 
	 * For example,
	 * 
	 * if
	 * task.act = Midterm
	 * task.course = CSCI 3030
	 * 
	 * task.toString() would result in
	 * 
	 * Midterm
	 * CSCI 3030
	 * 
	 *
	 */
	@Override
	public String toString()
	{
		return act + "\n" + course;
	}
}
