/*
 * Author: Leo Espinoza
 * 
 * The class TessOCR uses Tesseract and the function doOCR to
 * do OCR on a given image file. 
 * 
 * For more documentation on Tesseract, visit
 * https://github.com/tesseract-ocr/tesseract/wiki/Documentation
 * 
 * To use:
 * 		Create an instance of TessOCR(fileName).
 * 		Do object.tessCall() to use Tesseract's doOCR function.
 * 
 */

package tess;

import java.io.File;
import net.sourceforge.tess4j.*;

public class TessOCR
{
	private String fileName;
	
	/**
	 * TessOCR() is the default constructor. Initializes fileName to be empty.
	 */
	public TessOCR()
	{
		fileName = "";
	}
	
	/**
	 * TessOCR(fileName) instantiates an object of type TessOCR.
	 * @param fileName Name of file to do OCR on.
	 */
	public TessOCR(String fileName)
	{
		this.fileName = fileName;
	}
	
	/**
	 * tessCall(fileName) uses OCR on image file fileName and returns its
	 * prediction as a string.
	 * 
	 * @param fileName File to be used in doOCR.
	 * @return String
	 */
	public String tessCall()
	{
		if (fileName.isEmpty())
		{
			return "No file name was given!";
		}
		//replace string with your fileName inside of new File
		File imageFile = new File("testIMG04.jpg");
		ITesseract instance = new Tesseract();
    //replace path with your path to Tess4J
		instance.setDatapath("C:\\Users\\Chick3n\\Desktop\\ECU Fall 2019\\Software Engineering\\Syllabye\\Tess4J");
		instance.setLanguage("eng");
		
		try {
			String result = instance.doOCR(imageFile);
			//System.out.println(result);
			return result;
		}
		catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
		
		return "Error! File not loaded.";
	}

}
