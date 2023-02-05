package printer.Client;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import javax.print.PrintService;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

public class PrinterJobClient {
	public void printing(String filePath, String fileName) {
		System.out.println("Inside of printerClient and printing");

		/*
		 * Creating a Print Service Array which will get List of all the Printer Names
		 * and look for Printer available and will set to desired one
		 */
		PrintService[] printersNameList = PrinterJob.lookupPrintServices();

		if (printersNameList.length == 0) {
			throw new IllegalStateException("No Printer Found");
		}
		System.out.println("Available printers: " + Arrays.asList(printersNameList));

		/*
		 * myService is set to null, in future it'll hold the printer name printer name
		 * is derived from PrinterService[] Array using for loop
		 */
		PrintService myPrinterService = null;
		for (PrintService printService : printersNameList) {
			if (printService.getName().equals("Canon LBP2900")) {
//			if (printService.getName().equals("Microsoft Print to PDF")) {
				myPrinterService = printService;
				break;
			}
		}

		if (myPrinterService == null) {
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
			File file = new File(filePath + fileName);

			/* Create the document with file on the Local Machine */
			PDDocument document = null;
			document = PDDocument.load(file);
			/* Creating Physical Printing Job */
			PrinterJob printingJob = PrinterJob.getPrinterJob();
			
			/* Setting up Printer and Unique Job Name */
			printingJob.setJobName(fileName);
			printingJob.setPrintService(myPrinterService);
			printingJob.setPageable(new PDFPageable(document));
			
			/* Physically Printing the Job */
			printingJob.print();

			/* closing the loaded document */
			document.close();
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (PrinterException pe) {
			pe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}