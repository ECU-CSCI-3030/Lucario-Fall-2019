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
		CalendarList callist = new CalendarList();
		callist.addCalendar(caltest);



		try
		{
			caltest = callist.getCalendar(2019);
		}
		catch(CalendarNotFoundException e)
		{
			System.out.println(e);
		}

		
		
		Task semidterm = new Task("Midterm","CSCI 3030");
		Task dbmidterm = new Task("Midterm","CSCI 3700");
		Task automatamidterm = new Task("Midterm","CSCI 4602");
		Task gdmidterm = new Task("Midterm","CSCI 3050");
		Task mlmidterm = new Task("Midterm","CSCI 4120");
		
		int day = 20;
		int month = 12;
		int year = 2019;
		
		caltest.addTask(month, day, semidterm);
		caltest.addTask(month, day, dbmidterm);
		caltest.addTask(month, day, automatamidterm);
		caltest.addTask(month, day, gdmidterm);
		caltest.addTask(month, day, mlmidterm);



		try
		{
			callist.removeCal(2019);
		}
		catch(CalendarNotFoundException e)
		{
			System.out.println(e);
			System.out.println("remove issue");
		}


		callist.addCalendar(caltest);

		Calendar caltest2 = caltest;




		callist.replaceCal(caltest2);




		Calendar memtest = null;
		try
		{
			memtest = callist.getCalendar(2019);
		}
		catch(CalendarNotFoundException e)
		{
			System.out.println(e);
		}

		
		TaskList tltest = caltest.getTasks(month, day);
		
		tltest.printTasks();
		
		System.out.print("\nremoving 3030 midterm\n\n");

		memtest.removeTask(month, day, semidterm);
		
		memtest.getTasks(month, day).printTasks();
		
		System.out.print("\nClearing Tasks\n\n");
		
		memtest.clearTasks(month, day);
		
		memtest.getTasks(month, day).printTasks();

		System.out.print("\nAdding Tasks using CalendarList Method\n\n");

		callist.addTask(month,day,year,semidterm);
		callist.addTask(month,day,year,dbmidterm);
		callist.addTask(month,day,year,automatamidterm);
		callist.addTask(month,day,year,mlmidterm);

		System.out.print("\nTesting CalendarList.getTasks()\n\n");

		callist.getTasks(month,day,year).printTasks();

		System.out.print("\nTesting CalendarList.removeTask()\n " +
				         "Removing CSCI 3030 Midterm\n\n");

		callist.removeTask(month,day,year,semidterm);

		callist.getTasks(month,day,year).printTasks();


	}
}
