package tess4j;

import java.io.File;
import java.io.*;
import net.sourceforge.tess4j.*;

public class test {
	public static void main(String[] args) throws IOException{
			
			// creating file instance and referencing the file in its location
			File imagefile = new File("C:\\Users\\jaber\\eclipse-workspace\\Syllabye_Tesseract_Test\\images\\iphoneimage_test4.jpg");
			// creating a new tesseract instance and setting the data path that
			// references trained data and the Enlgish language library
			ITesseract instance = new Tesseract(); // JNA Interface Mapping
			instance.setDatapath("C:\\Users\\jaber\\eclipse-workspace\\Syllabye_Tesseract_Test\\tessdata");
			
			// create a try catch to run the OCR on the document referenced above
			try {
				String result = instance.doOCR(imagefile);
				System.out.println(result);
				
			// catch that delivers an error message if OCR fails
			} catch (TesseractException e) {
				System.err.println(e.getMessage());
			}
	}
}
