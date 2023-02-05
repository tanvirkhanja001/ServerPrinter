package printer.Client;

import com.spire.doc.Document;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrinterDocx {

    public static void main(String[] args) {

        //load a Word document that you want to print
        Document document = new Document();
        document.loadFromFile("C:\\Users\\Administrator\\Desktop\\DocoumentToPrint.docx");

        //Create a PrinterJob object
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        //Create a PageFormat object and set it to the default size and orientation
        PageFormat pageFormat = printerJob.defaultPage();

        //Return a copy of the Paper object associated with this PageFormat
        Paper paper = pageFormat.getPaper();

        //Set the imageable area of this Paper
        paper.setImageableArea(0, 0, pageFormat.getWidth(), pageFormat.getHeight());

        //Set the number of copies
        printerJob.setCopies(1);

        //Set the Paper object for this PageFormat
        pageFormat.setPaper(paper);

        //Call painter to render the pages in the specified format
        printerJob.setPrintable(document, pageFormat);

        //Execute print
        try {
            printerJob.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}