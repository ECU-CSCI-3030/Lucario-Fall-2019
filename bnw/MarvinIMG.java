/**
 * Author: Leo Espinoza
 * 
 * MarvinIMG is a class used to apply a black and white filter and a grayscale
 * filter to an image. It also does other functions such as halftone and crops
 * an image.
 * 
 * For more documentation on the API marvin, go to link:
 * http://marvinproject.sourceforge.net/javadoc/marvin.html
 * 
 * For more documentation on the MarvinPluginCollection, visit link:
 * http://marvinproject.sourceforge.net/javadoc/marvin/MarvinPluginCollection.html
 * 
 * To use:
 * 			new MarvinIMG(imgPath) where imgPath is a string
 * 			MarvinIMG.doBlackAndWhite() or any other function
 */

package bnw;

import static marvin.MarvinPluginCollection.*;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class MarvinIMG {
	
	private static MarvinImage originalIMG;
	private static MarvinImage outputIMG;
	
	/**
	 * MarvinIMG(imgPath) creates an instance of a a MarvinImage with
	 * the given image path.
	 * 
	 * @param imgPath Image path to the image used for editing.
	 */
	public MarvinIMG(String imgPath) {
		MarvinIMG.originalIMG = MarvinImageIO.loadImage(imgPath);
		MarvinIMG.outputIMG = originalIMG.clone();
	}
	
	/**
	 * getOriginalIMG returns the original image.
	 * @return MarvinImage
	 */
	public MarvinImage getOriginalIMG() {
		return MarvinIMG.originalIMG;
	}
	
	/**
	 * setOriginalIMG(setIMG) sets a new image to be edited.
	 * 
	 * @param setIMG New image to be edited.
	 */
	public void setOriginalIMG(MarvinImage setIMG) {
		MarvinIMG.originalIMG = setIMG;
	}
	
	/**
	 * getOutputIMG() returns the output image (the edited version).
	 * 
	 * @return MarvinImage
	 */
	public MarvinImage getOutputIMG() {
		return MarvinIMG.outputIMG;
	}
	
	/**
	 * doBlackAndWhite() applies a black and white filter to the original
	 * image. Default threshold value is 190.
	 */
	public static void doBlackAndWhite() {
		thresholding(originalIMG, outputIMG, 190);
		MarvinImageIO.saveImage(outputIMG, ".\\bnw1.jpg");
	}
	
	/**
	 * doBlackAndWhite(num) applies a black and white filter to the original
	 * image with a given threshold value num.
	 * 
	 * @param num The threshold value
	 */
	public static void doBlackAndWhite(int num) {
		thresholding(originalIMG, outputIMG, num);
		MarvinImageIO.saveImage(outputIMG, ".\\bnwcustom.jpg");
	}
	
	/**
	 * doHalfTone() applies a half tone filter to the original image.
	 */
	public static void doHalfTone() {
		halftoneErrorDiffusion(originalIMG, outputIMG);
		MarvinImageIO.saveImage(outputIMG, ".\\halftoneIMG.jpg");
	}
	
	/**
	 * doGrayScale() applies a grayscale filter to the original image.
	 */
	public static void doGrayScale() {
		grayScale(originalIMG, outputIMG);
		MarvinImageIO.saveImage(outputIMG, ".\\grayscaleIMG.jpg");
	}
	
	/**
	 * doCrop(x, y, width, height) crops the original image starting at the
	 * given x and y pixel coordinate and crops to a size of given
	 * width and height.
	 * 
	 * @param x			x coordinate
	 * @param y			y coordinate
	 * @param width		width size
	 * @param height	height size
	 */
	public static void doCrop(int x, int y, int width, int height) {
		crop(originalIMG, outputIMG, x, y, width, height);
		MarvinImageIO.saveImage(outputIMG, ".\\croppedImage.jpg");
	}
}
