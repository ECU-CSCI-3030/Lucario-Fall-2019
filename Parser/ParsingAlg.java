package regexalg;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.*;
import java.time.temporal.TemporalAccessor;
import java.util.regex.*;
import ScanTest.*;

public class ParsingAlg {
	
	public static void parsAlg(String result) {
		ScanList slist = new ScanList();
		Pattern p;
		Matcher m;
		int x = 0;
		do
		{
			x = getPat(result);
			switch(x)
			{
				//MONTH/DAY/YEAR
				case 1:{
					System.out.println("Case1\n");									//debugging purposes
					p = Pattern.compile("(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])/(?:19\\d{2}|2\\d{3})");
					m = p.matcher(result);
					
					String dateTest = m.group();									
					System.out.println("I printed out the date: " + dateTest); 		//debugging purposes
					
					DateTimeFormatter formatter = new DateTimeFormatterBuilder()
							.parseCaseInsensitive()
							.append(DateTimeFormatter.ofPattern("MM/dd/YYYY"))
							.toFormatter();
					TemporalAccessor bleh = formatter.parse(dateTest);
					MonthDay monthDay = MonthDay.from(bleh);
					
					String yr = dateTest.substring(6);								//debugging purposes
					int yrNum = Integer.parseInt(yr);								//debugging purposes

					System.out.println("Year is: " + yr);   						//debugging purposes
					
					LocalDate parsedDate = monthDay.atYear(yrNum);
					
					int monthNum = parsedDate.getMonthValue();
					int dayNum = parsedDate.getDayOfMonth();
					System.out.println("Day number is: " + dayNum);					//debugging purposes
					System.out.println("Month number is: " + monthNum);				//debugging purposes
					System.out.println("Year number is: " + yrNum);					//debugging purposes
					
					//TODO insert monthNum and dayNum into scan list
					
					//this will eliminate all of the information we have already scanned.
					try {
						result = result.substring(m.end());
					} catch(IllegalStateException e) {
						System.out.print("EOS ");
					}
					System.out.println("The result is now:\n\n " + result + "\n\n");	//debugging purposes
					slist.addScannedTask(monthNum, dayNum);
					
					break;
				}
				//DAYofWEEK MONTHNAME DAY
				case 2:{
					System.out.println("Case2\n");									//debugging purposes
					p = Pattern.compile("([sS]unday|[mM]onday|[tT]uesday|[wW]ednesday|[tT]hursday|[fF]riday|[sS]aturday),? ((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) ([0-2]\\d|3[0-1]|[1-9])");
					m = p.matcher(result);
					m.matches();
					
					String dateTest = m.group();
					System.out.println("I printed out the date: " + dateTest);		//debugging purposes
					
					//abbreviated MONTHNAME else it is full month name
					if(m.group(2).length() == 3) {
						DateTimeFormatter formatter = new DateTimeFormatterBuilder()
								.parseCaseInsensitive()
								.append(DateTimeFormatter.ofPattern("EEEE, MMM dd"))
								.toFormatter();
						
						TemporalAccessor bleh = formatter.parse(dateTest);
						MonthDay monthDay = MonthDay.from(bleh);
						LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
						int monthNum = parsedDate.getMonthValue();
						int dayNum = parsedDate.getDayOfMonth();
						System.out.println("Day number is: " + dayNum);				//debugging purposes
						System.out.println("Month number is: " + monthNum);			//debugging purposes
						
						slist.addScannedTask(monthNum, dayNum);
					}
					else {
						DateTimeFormatter formatter = new DateTimeFormatterBuilder()
								.parseCaseInsensitive()
								.append(DateTimeFormatter.ofPattern("EEEE, MMMM dd"))
								.toFormatter();
						TemporalAccessor bleh = formatter.parse(dateTest);
						MonthDay monthDay = MonthDay.from(bleh);
						LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
						int monthNum = parsedDate.getMonthValue();
						int dayNum = parsedDate.getDayOfMonth();
						System.out.println("Day number is: " + dayNum);				//debugging purposes
						System.out.println("Month number is: " + monthNum);			//debugging purposes
						
						slist.addScannedTask(monthNum, dayNum);
					}
					
					//this will eliminate all of the information we have already scanned.
					try {
						result = result.substring(m.end());
					} catch(IllegalStateException e) {
						System.out.print("EOS ");
					}
					System.out.println("The result is now:\n\n " + result + "\n\n");//debugging purposes
					break;
				}
				//MONTHNAME DAY
				case 3:{
					System.out.println("Case3\n");									//debugging purposes
					p = Pattern.compile("((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) ([0-2][0-9]|3[0-1]|[1-9])");
					m = p.matcher(result);
					
					String dateTest = m.group();
					
					//DAY = two digits --> 06, 23, 31... so on
					if(m.group(2).length() == 2 ) {
						//MONTHNAME is abbreviated
						if(m.group(1).length() == 3) {
							DateTimeFormatter formatter = new DateTimeFormatterBuilder()
									.parseCaseInsensitive()
									.append(DateTimeFormatter.ofPattern("MMM dd"))
									.toFormatter();
							
							TemporalAccessor bleh = formatter.parse(dateTest);
							MonthDay monthDay = MonthDay.from(bleh);
							LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
							int monthNum = parsedDate.getMonthValue();
							int dayNum = parsedDate.getDayOfMonth();
							System.out.println("Day number is: " + dayNum);			//debugging purposes
							System.out.println("Month number is: " + monthNum);		//debugging purposes
							
							slist.addScannedTask(monthNum, dayNum);
						}
						//MONTHNAME not abbreviated
						else {
							DateTimeFormatter formatter = new DateTimeFormatterBuilder()
									.parseCaseInsensitive()
									.append(DateTimeFormatter.ofPattern("MMMM dd"))
									.toFormatter();
							
							TemporalAccessor bleh = formatter.parse(dateTest);
							MonthDay monthDay = MonthDay.from(bleh);
							LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
							int monthNum = parsedDate.getMonthValue();
							int dayNum = parsedDate.getDayOfMonth();
							System.out.println("Day number is: " + dayNum);			//debugging purposes
							System.out.println("Month number is: " + monthNum);		//debugging purposes
							
							slist.addScannedTask(monthNum, dayNum);
						}
					}
					//DAY = one digit --> 5, 2, 9... so on
					else {
						//MONTHNAME is abbreviated
						if(m.group(1).length() == 3) {
							DateTimeFormatter formatter = new DateTimeFormatterBuilder()
									.parseCaseInsensitive()
									.append(DateTimeFormatter.ofPattern("MMM d"))
									.toFormatter();
							
							TemporalAccessor bleh = formatter.parse(dateTest);
							MonthDay monthDay = MonthDay.from(bleh);
							LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
							int monthNum = parsedDate.getMonthValue();
							int dayNum = parsedDate.getDayOfMonth();
							System.out.println("Day number is: " + dayNum);			//debugging purposes
							System.out.println("Month number is: " + monthNum);		//debugging purposes
							
							slist.addScannedTask(monthNum, dayNum);
						}
						else {
							DateTimeFormatter formatter = new DateTimeFormatterBuilder()
									.parseCaseInsensitive()
									.append(DateTimeFormatter.ofPattern("MMMM d"))
									.toFormatter();
							
							TemporalAccessor bleh = formatter.parse(dateTest);
							MonthDay monthDay = MonthDay.from(bleh);
							LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
							int monthNum = parsedDate.getMonthValue();
							int dayNum = parsedDate.getDayOfMonth();
							System.out.println("Day number is: " + dayNum);			//debugging purposes
							System.out.println("Month number is: " + monthNum);		//debugging purposes
							
							slist.addScannedTask(monthNum, dayNum);
						}
					}
					
					//this will eliminate all of the information we have already scanned.
					try {
						result = result.substring(m.end());
					} catch(IllegalStateException e) {
						System.out.print("EOS ");
					}
					System.out.println("The result is now:\n\n " + result + "\n\n");//debugging purposes
					break;
				}
				//MONTH/DAY
				case 4:{															//debugging purposes
					System.out.println("Case4\n");
					p = Pattern.compile("(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])");
					m = p.matcher(result);
					//If the pattern is found, then it will write to file
					
					String dateTest = m.group();
					System.out.println("I printed out the date: " + dateTest); 		//debugging purposes
					
					DateTimeFormatter formatter = new DateTimeFormatterBuilder()
							.parseCaseInsensitive()
							.append(DateTimeFormatter.ofPattern("MM/dd"))
							.toFormatter();
					TemporalAccessor bleh = formatter.parse(dateTest);
					MonthDay monthDay = MonthDay.from(bleh);
					LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
					
					int monthNum = parsedDate.getMonthValue();
					int dayNum = parsedDate.getDayOfMonth();
					System.out.println("Day number is: " + dayNum);					//debugging purposes
					System.out.println("Month number is: " + monthNum);				//debugging purposes
					
					//this will eliminate all of the information we have already scanned.
					try {
						result = result.substring(m.end());
					} catch(IllegalStateException e) {
						System.out.print("EOS ");
					}
					
					slist.addScannedTask(monthNum, dayNum);
					System.out.println("The result is now:\n\n " + result + "\n\n");//debugging purposes
					break;
					}
				}
			}
		while(x!=0);
		}

	private static int getPat(String result) {
		String pat1 = "(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])/(?:19\\d{2}|2\\d{3})";
		String pat2 = "([sS]un|[mM]on|[tT]ues|[wW]ednes|[tT]hurs|[fF]ri|[sS]atur)day,? .*((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) .*([0-2]\\d|3[0-1]|[1-9]).*";
		String pat3 = "((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) ([0-2][0-9]|3[0-1]|[1-9])";
		String pat4 = "(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])";
		Pattern p = null;
		Matcher m;
		for(int i = 1; i<=5; i++) {
				if(i==1) {
				p = Pattern.compile(pat1);
				m = p.matcher(result);
				if(m.find())
					return 1;
				}
				else if(i==2) {
				p = Pattern.compile(pat2);
				m = p.matcher(result);
				if(m.find())
					return 2;
				}
				else if(i==3) {
				p = Pattern.compile(pat3);
				m = p.matcher(result);
				if(m.find())
					return 3;
				}
				else if(i==4) {
				p = Pattern.compile(pat4);
				m = p.matcher(result);
				//System.out.println(m.find() +"\n");
				if(m.find())
					return 4;
				}
		}
		return 0;
	}
}

