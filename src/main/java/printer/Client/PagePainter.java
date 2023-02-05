package printer.Client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;

public class PagePainter {
	public static void main(String[] args) {
//	public void printing() {
		System.out.println("inside of printerClient and printing");
		/* Encapsulating the data which will come in DocPrintJob */
		DocFlavor flavorService = DocFlavor.SERVICE_FORMATTED.PAGEABLE;

		/* Setting Page Details */
		PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
//		attr.add(Sides.DUPLEX);
		attr.add(MediaSizeName.ISO_A4);
		attr.add(OrientationRequested.PORTRAIT);
		System.out.println(attr);

		/*
		 * Creating a Print Service Array which will get List of all the Printer Names
		 * and look for Printer available and will set to desired one
		 */
		PrintService[] printers = PrintServiceLookup.lookupPrintServices(flavorService, attr);

		if (printers.length == 0) {
			throw new IllegalStateException("No Printer Found");
		}
		System.out.println("Available printers: " + Arrays.asList(printers));

		/*
		 * myService is set to null, in future it'll hold the printer name printer name
		 * is derived from PrinterService[] Array using for loop
		 */
		PrintService myService = null;
		for (PrintService printService : printers) {
//			if (printService.getName().equals("Brother DCP-L2520D series")) {
			if (printService.getName().equals("Microsoft Print to PDF")) {
				myService = printService;
				break;
			}
		}

		if (myService == null) {
			throw new IllegalStateException("Printer Not Found");
		}

		/*
		 * Getting the file from path directly and Create a FileInputStream.
		 * 
		 * Made a SimpleDoc which will consist fileInputStream and DocFlavor and Doc's
		 * Attributes
		 * 
		 * Set a DocPrintJob using myService who holds the PrinterService i.e. printer
		 * Name. and createPrintJob on this PrinterService. call the print method on
		 * DocPrintJob.print() consisting SimpleDoc and PrintRequestAttributeSet if any.
		 */

		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\tanvi\\OneDrive\\Desktop\\Tanvir\\EXP.pdf");
			System.out.println("fis size: " + fis.available());
			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
//			InputStream inputStream = file.getInputStream();
			
			Doc doc = new SimpleDoc(fis, flavor, null);
			InputStream isDoc = (InputStream) doc.getPrintData();
			System.out.println("SimpleDoc inputStream:" + isDoc.available());

			DocPrintJob printJob = myService.createPrintJob();
			printJob.print(doc, attr);
//			inputStream.close();
//			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (PrintException pe) {
			pe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}