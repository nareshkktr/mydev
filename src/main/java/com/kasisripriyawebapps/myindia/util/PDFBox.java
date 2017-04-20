package com.kasisripriyawebapps.myindia.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFBox {
	public static void main(String args[]) {

	    PDFParser parser = null;
	    PDDocument pdDoc = null;
	    COSDocument cosDoc = null;
	    PDFTextStripper pdfStripper;

	    String parsedText;
	    String fileName = "C:\\Users\\kanduk\\Desktop\\Adilabad_SAR-2013.pdf";
	    File file = new File(fileName);
	    
	    try {
			PDDocument doc = PDDocument.load(file);
			parsedText=new PDFTextStripper().getText(doc);
			System.out.print(parsedText);
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
