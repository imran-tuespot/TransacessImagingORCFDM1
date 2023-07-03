package com.peniel.utilities;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.RandomAccessFileOrArray;
import com.lowagie.text.pdf.codec.GifImage;
import com.lowagie.text.pdf.codec.TiffImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;

/**
 * User: todds
 * Date: 11/14/11
 * Time: 9:21 AM
 */
public class ToPDF {
    private static final Logger LOGGER = LoggerFactory.getLogger(ToPDF.class);

    public boolean simpleImagesTiff(String inFile, String outFile) throws Exception 
    {
        Document document = new Document();
        PdfWriter.getInstance(document,new FileOutputStream(outFile));
        document.open();

        RandomAccessFileOrArray ra = new RandomAccessFileOrArray(inFile);
        int pages = TiffImage.getNumberOfPages(ra);
        
       
        //Get image of each page
        for(int i = 1; i <= pages; i++)
        {        	
        	Image img = TiffImage.getTiffImage( ra, i );
        	System.out.println("Original Width: " + img.getWidth());
            System.out.println("Original Height " + img.getHeight());
             
        	//Scale the image to fit to new document
        	if (img.getScaledWidth() > 500 || img.getScaledHeight()> 700) 
        	{ 
        		img.scaleToFit(500f, 700f );
        	}
        	
            document.add(img);
        }
        document.newPage();

        document.close();

        return true;
    }

    public boolean simpleImagesJpg(String inFile, String outFile) throws Exception 
    {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(outFile));
        document.open();

        com.lowagie.text.Image image = com.lowagie.text.Image.getInstance(inFile);
        
        System.out.println("Original Width: " + image.getWidth());

        System.out.println("Original Height " + image.getHeight());
        
        if (image.getScaledWidth() > 250 || image.getScaledHeight()> 250) 
    	{  
        	image.scaleToFit(250f, 250f);
    	}
        document.add(image);        

        System.out.println("Scaled Width: " + image.getScaledWidth());

        System.out.println("Scaled Height " + image.getScaledHeight());

        float Resolution = image.getWidth() / image.getScaledWidth() * 72f;

        System.out.println("Resolution: " + Resolution);
        
        document.close();
        
        return true;
    }

}
