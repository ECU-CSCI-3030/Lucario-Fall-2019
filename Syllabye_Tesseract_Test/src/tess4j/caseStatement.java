package tess4j;

import java.io.*;
import net.sourceforge.tess4j.*;
import java.util.regex.*;

public class caseStatement {
	public static void main(String[] args) throws IOException{
			
			
		
		
		// creating file instance and referencing the file in its location
			File imagefile = new File("C:\\Users\\jaber\\eclipse-workspace\\Syllabye_Tesseract_Test\\images\\3700_syllabus.pdf");
			// creating a new tesseract instance and setting the data path that
			// references trained data and the Enlgish language library
			ITesseract instance = new Tesseract(); // JNA Interface Mapping
			instance.setDatapath("C:\\Users\\jaber\\eclipse-workspace\\Syllabye_Tesseract_Test\\tessdata");
			
			// create a try catch to run the OCR on the document referenced above
			
			String result = "";
			try {
				result = instance.doOCR(imagefile);
				System.out.println(result);
				
			// catch that delivers an error message if OCR fails
			} catch (TesseractException e) {
				System.err.println(e.getMessage());
			}

	Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("C:\\Users\\jaber\\eclipse-workspace\\Syllabye_Tesseract_Test\\output\\outputFile.txt"), "utf-8")); 

Pattern p;
Matcher m;
	int x = 0;
		do
		{
			x = getPat(result);
			switch(x)
			{
	//			MONTH/DAY/YEAR
				case 1:{
					System.out.println("Case1\n");
					p = Pattern.compile("(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])/(?:19\\d{2}|2\\d{3})");
					m = p.matcher(result);
	//				If the pattern is found, then it will write to file
					//System.out.println(m.find());
					//System.out.println(m.group());
					if(m.find())
					{
						writer.write(m.group() + "\n");
						System.out.println(m.group() + " has been written\n\n");
					}									
	//					this will eliminate all of the information we have already scanned.
					try {
						result = result.substring(m.end());
					} catch(IllegalStateException e) {
						System.out.print("EOS ");
					}
						System.out.println("The result is now:\n\n " + result + "\n\n");
					break;
				}
	//			DAYofWEEK MONTH DAY
				case 2:{
					System.out.println("Case2\n");
					p = Pattern.compile("([sS]unday|[mM]onday|[tT]uesday|[wW]ednesday|[tT]hursday|[fF]riday|[sS]aturday),? .*((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) .*([0-2]\\d|3[0-1]|[1-9]).*");
					m = p.matcher(result);
	//				If the pattern is found, then it will write to file
					//System.out.println(m.find());
					//System.out.println(m.group());
					if(m.find())
					{
						writer.write(m.group(1) + " " + m.group(2) + " " + m.group(3) + "\n");
						System.out.println(m.group(1) + " " + m.group(2) + " " + m.group(3) + " has been written\n\n");
					}									
	//					this will eliminate all of the information we have already scanned.
					try {
						result = result.substring(m.end());
					} catch(IllegalStateException e) {
						System.out.print("EOS ");
					}
						System.out.println("The result is now:\n\n " + result + "\n\n");
					break;
				}
	//			MONTH DAY
				case 3:{
					System.out.println("Case3\n");
					p = Pattern.compile("((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) ([0-2][0-9]|3[0-1]|[1-9])");
					m = p.matcher(result);
	//				If the pattern is found, then it will write to file
					//System.out.println(m.find());
					//System.out.println(m.group());
					if(m.find())
					{
						writer.write(m.group(1) + " " + m.group(2) + "\n");
						System.out.println(m.group(1) + " " + m.group(2) + " has been written\n\n");
					}									
	//				this will eliminate all of the information we have already scanned.
					try {
						result = result.substring(m.end());
					} catch(IllegalStateException e) {
						System.out.print("EOS ");
					}
						System.out.println("The result is now:\n\n " + result + "\n\n");
					break;
				}
	//			DAY/MONTH
				case 4:{
					System.out.println("Case4\n");
					p = Pattern.compile("(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])");
					m = p.matcher(result);
	//				If the pattern is found, then it will write to file
					//System.out.println(m.find());
					//System.out.println(m.group());
					if(m.find())
					{
						writer.write(m.group() + "\n");
						System.out.println(m.group() + " has been written\n\n");
					}									
	//				this will eliminate all of the information we have already scanned.
					try {
						result = result.substring(m.end());
					} catch(IllegalStateException e) {
						System.out.print("EOS ");
					}
									
					System.out.println("The result is now:\n\n " + result + "\n\n");
					break;
				}
			}
	}while(x!=0);
	writer.close();	
}

public static int getPat(String result)
{
	String pat1 = "(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])/(?:19\\d{2}|2\\d{3})";
	String pat2 = "([sS]un|[mM]on|[tT]ues|[wW]ednes|[tT]hurs|[fF]ri|[sS]atur)day,? .*((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) .*([0-2]\\d|3[0-1]|[1-9]).*";
	String pat3 = "((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) ([0-2][0-9]|3[0-1]|[1-9])";
	String pat4 = "(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])";
	Pattern p = null;
	Matcher m;
	for(int i = 1; i<=5; i++)
	{
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
//TODO: Create two methods to get the date (getDate() and getMonth())

/*
 * public int getDate(String date){
 * 
 * }
 */
}



