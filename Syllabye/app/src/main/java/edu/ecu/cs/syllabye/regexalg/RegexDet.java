/*
 * Authors: Jameson Bergstedt and Leonardo Espinoza
 * 
 * Demonstrates how to extract multiple "groups" from a given string
 * using regular expressions and the Pattern and Matcher classes.
 * 
 * Note: "\\S" means "A non-whitespace character".
 * @see http://java.sun.com/j2se/1.5.0/docs/api/java/util/regex/Pattern.html
 * 
 * To use:
 * 			
 */
package edu.ecu.cs.syllabye.regexalg;

import edu.ecu.cs.syllabye.tess.TessOCR;
//import cal.*;
//import java.time.LocalDate;
//import java.time.MonthDay;
//import java.time.Year;
//import java.time.format.*;
//import java.time.temporal.TemporalAccessor;
import java.io.*;
//import java.util.regex.*;

public class RegexDet {
	public static void main(String[] args) throws IOException {
		String  imgPath = "C:\\Users\\micha\\eclipse-workspace\\Tesseract\\Testing Data\\testIMG04.jpg";
		TessOCR testing = new TessOCR(imgPath);
		String result = testing.tessCall();
		ParsingAlg.parsAlg(result);
		String result2 = "balfjaklh Monday, Sep 06 lkba;kgfhaset;oi Monday, September 06 iahfieah monday, sep 06";
		String result3 = "abjksadhf 02/25/2019 kadfjah 05/15/2099 klsjdafl;kash Monday, February 07 aljgflauhea Tuesday, Feb 08 kjahdfah september 6 skalja; sep 06 kjsahflkajh 11/30 skafhas 09/15";
		ParsingAlg.parsAlg(result2);
		ParsingAlg.parsAlg(result3);
	}
}
		
////		*******ctrl+/ ON ALL CODE BELOW AND IT WORKS
//		String  imgPath = "C:\\Users\\Chick3n\\eclipse-workspace\\Tesseract\\Testing Data\\testIMG04.jpg";
//		TessOCR testing = new TessOCR(imgPath);
//		String result = testing.tessCall();
////		System.out.println(result);
////		String result = "balfjaklh Monday, Sep 06 lkba;kgfhaset;oi Monday, September 06 iahfieah monday, sep 06";
//		
////		String result = "abjksadhf 02/25/2019 kadfjah 05/15/2099 klsjdafl;kash Monday, February 07 aljgflauhea Tuesday, Feb 08 kjahdfah september 6 skalja; sep 06 kjsahflkajh 11/30 skafhas 09/15";
//		
//		
//		Writer writer = new BufferedWriter(new OutputStreamWriter(
//		new FileOutputStream("C:\\Users\\Chick3n\\eclipse-workspace\\Tesseract\\outputFile.txt"), "utf-8")); 
//
//		Pattern p;
//		Matcher m;
//		int x = 0;
//		do
//		{
//			x = getPat(result);
//			switch(x)
//			{
//				//MONTH/DAY/YEAR
//				case 1:{
//					System.out.println("Case1\n");									//debugging purposes
//					p = Pattern.compile("(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])/(?:19\\d{2}|2\\d{3})");
//					m = p.matcher(result);
//					
//					//If the pattern is found, then it will write to file
//					//System.out.println(m.find());
//					//System.out.println(m.group());
//					
//					if(m.find())													//debugging purposes
//					{
//						writer.write(m.group() + "\n");
//						System.out.println(m.group() + " has been written\n\n");
//					}
//					
//					String dateTest = m.group();									
//					System.out.println("I printed out the date: " + dateTest); 		//debugging purposes
//					
//					DateTimeFormatter formatter = new DateTimeFormatterBuilder()
//							.parseCaseInsensitive()
//							.append(DateTimeFormatter.ofPattern("MM/dd/YYYY"))
//							.toFormatter();
//					TemporalAccessor bleh = formatter.parse(dateTest);
//					MonthDay monthDay = MonthDay.from(bleh);
//					
//					String yr = dateTest.substring(6);								//debugging purposes
//					int yrNum = Integer.parseInt(yr);								//debugging purposes
//
//					System.out.println("Year is: " + yr);   						//debugging purposes
//					
//					LocalDate parsedDate = monthDay.atYear(yrNum);
//					
//					int monthNum = parsedDate.getMonthValue();
//					int dayNum = parsedDate.getDayOfMonth();
//					System.out.println("Day number is: " + dayNum);					//debugging purposes
//					System.out.println("Month number is: " + monthNum);				//debugging purposes
//					System.out.println("Year number is: " + yrNum);					//debugging purposes
//					
//					//TODO insert monthNum and dayNum into scan list
//					
//					//this will eliminate all of the information we have already scanned.
//					try {
//						result = result.substring(m.end());
//					} catch(IllegalStateException e) {
//						System.out.print("EOS ");
//					}
//					
//					System.out.println("The result is now:\n\n " + result + "\n\n");	//debugging purposes
//					break;
//				}
//				//DAYofWEEK MONTHNAME DAY
//				case 2:{
//					System.out.println("Case2\n");									//debugging purposes
//					p = Pattern.compile("([sS]unday|[mM]onday|[tT]uesday|[wW]ednesday|[tT]hursday|[fF]riday|[sS]aturday),? ((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) ([0-2]\\d|3[0-1]|[1-9])");
//					m = p.matcher(result);
//					
//					//If the pattern is found, then it will write to file
//					//System.out.println(m.find());
//					//System.out.println(m.group());
//					
//					if(m.find())													//debugging purposes
//					{
//						writer.write(m.group(1) + " " + m.group(2) + " " + m.group(3) + "\n");
//						System.out.println(m.group(1) + " " + m.group(2) + " " + m.group(3) + " has been written\n\n");
//					}
//					
//					String dateTest = m.group();									//debugging purposes?
//					System.out.println("I printed out the date: " + dateTest);		//debugging purposes
//					//abbreviated MONTHNAME else it is full month name
//					if(m.group(2).length() == 3) {
//						DateTimeFormatter formatter = new DateTimeFormatterBuilder()
//								.parseCaseInsensitive()
//								.append(DateTimeFormatter.ofPattern("EEEE, MMM dd"))
//								.toFormatter();
//						
//						TemporalAccessor bleh = formatter.parse(dateTest);
//						MonthDay monthDay = MonthDay.from(bleh);
//						LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
//						int monthNum = parsedDate.getMonthValue();
//						int dayNum = parsedDate.getDayOfMonth();
//						System.out.println("Day number is: " + dayNum);				//debugging purposes
//						System.out.println("Month number is: " + monthNum);			//debugging purposes
//						
//						//TODO insert monthNum and dayNum into scan list
//					}
//					else {
//						DateTimeFormatter formatter = new DateTimeFormatterBuilder()
//								.parseCaseInsensitive()
//								.append(DateTimeFormatter.ofPattern("EEEE, MMMM dd"))
//								.toFormatter();
//						TemporalAccessor bleh = formatter.parse(dateTest);
//						MonthDay monthDay = MonthDay.from(bleh);
//						LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
//						int monthNum = parsedDate.getMonthValue();
//						int dayNum = parsedDate.getDayOfMonth();
//						System.out.println("Day number is: " + dayNum);				//debugging purposes
//						System.out.println("Month number is: " + monthNum);			//debugging purposes
//						
//						//TODO insert monthNum and dayNum into scan list
//					}
//					//this will eliminate all of the information we have already scanned.
//					try {
//						result = result.substring(m.end());
//					} catch(IllegalStateException e) {
//						System.out.print("EOS ");
//					}
//					System.out.println("The result is now:\n\n " + result + "\n\n");//debugging purposes
//					
//					break;
//				}
//				//MONTHNAME DAY
//				case 3:{															//debugging purposes
//					System.out.println("Case3\n");
//					p = Pattern.compile("((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) ([0-2][0-9]|3[0-1]|[1-9])");
//					m = p.matcher(result);
//					//If the pattern is found, then it will write to file
//					//System.out.println(m.find());
//					//System.out.println(m.group());
//					if(m.find())													//debugging purposes
//					{
//						writer.write(m.group(1) + " " + m.group(2) + "\n");
//						System.out.println(m.group(1) + " " + m.group(2) + " has been written\n\n");
//					}
//					
//					String dateTest = m.group();
//					System.out.println("I printed out the date: " + dateTest);		//debugging purposes
//					
//					//DAY = two digits --> 06, 23, 31... so on
//					if(m.group(2).length() == 2 ) {
//						//MONTHNAME is abbreviated
//						if(m.group(1).length() == 3) {
//							DateTimeFormatter formatter = new DateTimeFormatterBuilder()
//									.parseCaseInsensitive()
//									.append(DateTimeFormatter.ofPattern("MMM dd"))
//									.toFormatter();
//							
//							TemporalAccessor bleh = formatter.parse(dateTest);
//							MonthDay monthDay = MonthDay.from(bleh);
//							LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
//							int monthNum = parsedDate.getMonthValue();
//							int dayNum = parsedDate.getDayOfMonth();
//							System.out.println("Day number is: " + dayNum);			//debugging purposes
//							System.out.println("Month number is: " + monthNum);		//debugging purposes
//							
//							//TODO insert monthNum and dayNum into scan list
//						}
//						//MONTHNAME not abbreviated
//						else {
//							DateTimeFormatter formatter = new DateTimeFormatterBuilder()
//									.parseCaseInsensitive()
//									.append(DateTimeFormatter.ofPattern("MMMM dd"))
//									.toFormatter();
//							
//							TemporalAccessor bleh = formatter.parse(dateTest);
//							MonthDay monthDay = MonthDay.from(bleh);
//							LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
//							int monthNum = parsedDate.getMonthValue();
//							int dayNum = parsedDate.getDayOfMonth();
//							System.out.println("Day number is: " + dayNum);			//debugging purposes
//							System.out.println("Month number is: " + monthNum);		//debugging purposes
//							
//							//TODO insert monthNum and dayNum into scan list
//						}
//					}
//					//DAY = one digit --> 5, 2, 9... so on
//					else {
//						//MONTHNAME is abbreviated
//						if(m.group(1).length() == 3) {
//							DateTimeFormatter formatter = new DateTimeFormatterBuilder()
//									.parseCaseInsensitive()
//									.append(DateTimeFormatter.ofPattern("MMM d"))
//									.toFormatter();
//							
//							TemporalAccessor bleh = formatter.parse(dateTest);
//							MonthDay monthDay = MonthDay.from(bleh);
//							LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
//							int monthNum = parsedDate.getMonthValue();
//							int dayNum = parsedDate.getDayOfMonth();
//							System.out.println("Day number is: " + dayNum);			//debugging purposes
//							System.out.println("Month number is: " + monthNum);		//debugging purposes
//							
//							//TODO insert monthNum and dayNum into scan list
//						}
//						else {
//							DateTimeFormatter formatter = new DateTimeFormatterBuilder()
//									.parseCaseInsensitive()
//									.append(DateTimeFormatter.ofPattern("MMMM d"))
//									.toFormatter();
//							
//							TemporalAccessor bleh = formatter.parse(dateTest);
//							MonthDay monthDay = MonthDay.from(bleh);
//							LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
//							int monthNum = parsedDate.getMonthValue();
//							int dayNum = parsedDate.getDayOfMonth();
//							System.out.println("Day number is: " + dayNum);			//debugging purposes
//							System.out.println("Month number is: " + monthNum);		//debugging purposes
//							
//							//TODO insert monthNum and dayNum into scan list
//						}
//					}
//					
//					//this will eliminate all of the information we have already scanned.
//					try {
//						result = result.substring(m.end());
//					} catch(IllegalStateException e) {
//						System.out.print("EOS ");
//					}
//					
//					System.out.println("The result is now:\n\n " + result + "\n\n");//debugging purposes
//					break;
//				}
//				//MONTH/DAY
//				case 4:{															//debugging purposes
//					System.out.println("Case4\n");
//					p = Pattern.compile("(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])");
//					m = p.matcher(result);
//					//If the pattern is found, then it will write to file
//					//System.out.println(m.find());
//					//System.out.println(m.group());
//					if(m.find())													//debugging purposes
//					{
//						writer.write(m.group() + "\n");
//						System.out.println(m.group() + " has been written\n\n");
//					}
//					
//					String dateTest = m.group();									//debugging purposes
//					System.out.println("I printed out the date: " + dateTest); 		//debugging purposes
//					
//					DateTimeFormatter formatter = new DateTimeFormatterBuilder()
//							.parseCaseInsensitive()
//							.append(DateTimeFormatter.ofPattern("MM/dd"))
//							.toFormatter();
//					TemporalAccessor bleh = formatter.parse(dateTest);
//					MonthDay monthDay = MonthDay.from(bleh);
//					LocalDate parsedDate = monthDay.atYear(Year.now().getValue());
//					
//					int monthNum = parsedDate.getMonthValue();
//					int dayNum = parsedDate.getDayOfMonth();
//					System.out.println("Day number is: " + dayNum);					//debugging purposes
//					System.out.println("Month number is: " + monthNum);				//debugging purposes
//					
//					//this will eliminate all of the information we have already scanned.
//					try {
//						result = result.substring(m.end());
//					} catch(IllegalStateException e) {
//						System.out.print("EOS ");
//					}
//									
//					System.out.println("The result is now:\n\n " + result + "\n\n");//debugging purposes
//					break;
//					}
//				}
//			}
//		while(x!=0);
//		writer.close();	
//		}
//		
//	public static int getPat(String result) {
//		String pat1 = "(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])/(?:19\\d{2}|2\\d{3})";
//		String pat2 = "([sS]un|[mM]on|[tT]ues|[wW]ednes|[tT]hurs|[fF]ri|[sS]atur)day,? .*((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) .*([0-2]\\d|3[0-1]|[1-9]).*";
//		String pat3 = "((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) ([0-2][0-9]|3[0-1]|[1-9])";
//		String pat4 = "(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])";
//		Pattern p = null;
//		Matcher m;
//		for(int i = 1; i<=5; i++) {
//				if(i==1) {
//				p = Pattern.compile(pat1);
//				m = p.matcher(result);
//				if(m.find())
//					return 1;
//				}
//				else if(i==2) {
//				p = Pattern.compile(pat2);
//				m = p.matcher(result);
//				if(m.find())
//					return 2;
//				}
//				else if(i==3) {
//				p = Pattern.compile(pat3);
//				m = p.matcher(result);
//				if(m.find())
//					return 3;
//				}
//				else if(i==4) {
//				p = Pattern.compile(pat4);
//				m = p.matcher(result);
//				//System.out.println(m.find() +"\n");
//				if(m.find())
//					return 4;
//				}
//		}
//		return 0;
//	}
//}
