/**
 * Demonstrates the usage of MarvinIMG class.
 * 
 */
package bnw;

public class TestMarvinIMG {
	
	public static void main(String[] args) {
		new MarvinIMG(".\\testIMG04.jpg");
    	MarvinIMG.doBlackAndWhite();
    	MarvinIMG.doBlackAndWhite(150);
    	MarvinIMG.doHalfTone();
    	MarvinIMG.doGrayScale();
    	MarvinIMG.doCrop(5, 5, 100, 100);
    	}
}
