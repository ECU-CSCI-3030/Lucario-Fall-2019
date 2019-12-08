package edu.ecu.cs.syllabye.tess;

import java.util.Scanner;
import java.util.regex.*;

public class TessDemo {

	public static void main(String[] args)
	{
		String  imgPath = "C:\\Users\\micha\\eclipse-workspace\\Tesseract\\Testing Data\\testIMG04.jpg";
		TessOCR testing = new TessOCR(imgPath);
		String inputText = testing.tessCall();
		System.out.println(inputText);
		
//	    This example uses Matcher function find() to search whole text
	    Scanner console = new Scanner(System.in);
//        while (true) {
//        	. --> wild card; the . can substitute any character
//        	[bcr]at --> b or c or r --> bat, cat, rat. use [^bcr] for negation
//        	[a-zA-Z] range of characters
//        	[abc] {2} indicates to find [abc] in the next two characters
//        	System.out.println("Enter your regex: ");
            Pattern pattern = 
            Pattern.compile("([sS]unday?|[mM]onday?|[tT]uesday?|[wW]ednesday?|[tT]hursday?|[fF]riday?|[sS]aturday?),? ((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?))(\\.?) ([0-2]\\d|3[0-1]|[1-9])");

//          System.out.println("\"Enter input string to search: \"");
            Matcher matcher = 
            pattern.matcher(inputText);

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
//        }
        console.close();

	}

}
