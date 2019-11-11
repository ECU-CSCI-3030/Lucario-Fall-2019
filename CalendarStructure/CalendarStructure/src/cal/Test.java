/**
 * Test
 * 
 * currently being used to test Calendar Structure. 
 * 
 * @author Tristen Schuler
 */


package cal;


public class Test 
{
	
	public static void main(String[] args)
	{
		Calendar caltest = new Calendar(2019);
		
		
		
		Task semidterm = new Task("Midterm","CSCI 3030");
		Task dbmidterm = new Task("Midterm","CSCI 3700");
		Task automatamidterm = new Task("Midterm","CSCI 4602");
		Task gdmidterm = new Task("Midterm","CSCI 3050");
		Task mlmidterm = new Task("Midterm","CSCI 4120");
		
		int day = 20;
		int month = 12;
		
		caltest.addTask(month, day, semidterm);
		caltest.addTask(month, day, dbmidterm);
		caltest.addTask(month, day, automatamidterm);
		caltest.addTask(month, day, gdmidterm);
		caltest.addTask(month, day, mlmidterm);
		
		TaskList tltest = caltest.getTasks(month, day);
		
		tltest.printTasks();
		
		System.out.print("\nremoving 3030 midterm\n\n");
		
		caltest.removeTask(month, day, semidterm);
		
		caltest.getTasks(month, day).printTasks();
		
		System.out.print("\nClearing Tasks\n\n");
		
		caltest.clearTasks(month, day);
		
		caltest.getTasks(month, day).printTasks();
		
		
		
		
		
	}
	
	
}
