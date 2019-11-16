import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import java.util.regex.*;
import java.util.Scanner;

public class main
{
	public static void main (String[] args)
	{
		
//		Date curDate = new Date();
//		 
//	    SimpleDateFormat format = new SimpleDateFormat();
//	    String DateToStr = format.format(curDate);
//	    System.out.println("Default pattern: " + DateToStr);
	    
        
//	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern2);
//	    String testDate = "09/03/1990";
//	    String tstday = format.format(curDate);
//	    String date = simpleDateFormat.format(testDate);
//	    System.out.println(date);
		
//	    Pattern Syntax for SimpleDateFormat
//	    G 	Era designator (before christ, after christ)
//	    y 	Year (e.g. 12 or 2012). Use either yy or yyyy.
//	    M 	Month in year. Number of M's determine length of format (e.g. MM, MMM or MMMMM)
//	    d 	Day in month. Number of d's determine length of format (e.g. d or dd)
//	    h 	Hour of day, 1-12 (AM / PM) (normally hh)
//	    H 	Hour of day, 0-23 (normally HH)
//	    m 	Minute in hour, 0-59 (normally mm)
//	    s 	Second in minute, 0-59 (normally ss)
//	    S 	Millisecond in second, 0-999 (normally SSS)
//	    E 	Day in week (e.g Monday, Tuesday etc.)
//	    D 	Day in year (1-366)
//	    F 	Day of week in month (e.g. 1st Thursday of December)
//	    w 	Week in year (1-53)
//	    W 	Week in month (0-5)
//	    a 	AM / PM marker
//	    k 	Hour in day (1-24, unlike HH's 0-23)
//	    K 	Hour in day, AM / PM (0-11)
//	    z 	Time Zone
//	    ' 	Escape for text delimiter
//	    ' 	Single quote
		
		
//		Metacharacters
//		<([{\^-=$!|]})?*+.>
	    String pattern0 = "yyyy-MM-dd";
	    String pattern1 = "MM-dd-yyyy";
	    String pattern2 = "MM/dd/yyyy";
	    
	    
//	    This example uses Matcher function matcher
	    Pattern ama = Pattern.compile("a*m*a*");
	    String amaTest = "will this work? aaaaammaaaaaaaa";
	    Matcher m = ama.matcher(amaTest);
	    boolean b = m.matches();
	    System.out.println(b);
	    
	    
//	    This example uses Matcher function find() to search whole text
	    Scanner console = new Scanner(System.in);
        while (true) {
//        	. --> wild card; the . can substitute any character
//        	[bcr]at --> b or c or r --> bat, cat, rat. use [^bcr] for negation
//        	[a-zA-Z] range of characters
//        	[abc] {2} indicates to find [abc] in the next two characters
        	System.out.println("Enter your regex: ");
            Pattern pattern = 
            Pattern.compile(console.nextLine());

            System.out.println("\"Enter input string to search: \"");
            Matcher matcher = 
            pattern.matcher(console.nextLine());

            boolean found = false;
            while (matcher.find()) {
                System.out.println("I found the text " + matcher.group());
                System.out.println("starting at index " + matcher.start());
                System.out.println("and ending at index " + (matcher.end() - 1));
                found = true;
            }
            if(!found){
                System.out.println("No match found.");
            }
        }
        
//        Long name
//        [jJ]anuary|[fF]ebruary|[mM]arch|[aA]pril|[mM]ay|[jJ]une|[jJ]uly|
//        [aA]ugust|[sS]eptember|[oO]ctober|[nN]ovember|[dD]ecember
//        
//        Abbreviation
//        [jJ]an|[fF]eb|[mM]ar|[aA]pr|[mM]ay|[jJ]un|[jJ]ul|[aA]ug|
//        [sS]ep|[oO]ct|[nN]ov|[dD]ec
//        
//        This expression captures dates in the format of: m/Month yyyy where 1900 <= yyyy <= 2999
//        (?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|
//         [mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|
//         [oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?) (?:19\d\d|2\d{3})
//        
//        This expression captures dates in the format of: dd m/Month | d m/Month
//        (?:[0-2]\d|3[0-1]|[1-9]) (?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|
//        [aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|
//        [sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)
//      
//        This expression captures dates in the format of: dd m/Month | d m/Month
//        (?:[0-2]\d|3[0-1]|[1-9]) (?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|
//        [aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|
//        [sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?) (?:19\d\d|2\d{3})
//        
//        This expression captures dates in the format of: mm/dd/yyyy
//        (?:0[1-9]|1[0-2])/(?:[0-2]\d|3[0-1])/(?:19\d{2}|2\d{3})
//        
//        
//        (?:\d[0-2])/(?:[0-3]\d)/(?:\d{2})
//        
//        Scanner console2 = new Scanner(System.in);
//        boolean finishReadingFile = true;
//        while(true) {
//        	System.out.println("Finding dates");
//        	Pattern date = Pattern.compile("[jJ]anuary");
//        }
        
	}
}
