package printer.Client;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.print.PrintService;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

public class PrintJobWatcher {

    // Printing service
//    @SuppressWarnings({ "serial", "null" })
    public static void main(String[] args) throws PrinterException {
        // Set required printer name
        String printerNameDesired = "Brother DCP-L2520D series";
        // Get all printer services
        PrintService[] service = PrinterJob.lookupPrintServices(); // list of
        int count = service.length;
        PrintService printer = null;
        // loop to get required printer serices
        for (int i = 0; i < count; i++) {
            if (service[i].getName().equalsIgnoreCase(printerNameDesired)) {
                System.out.println("=====>" + service[i].getName());
                printer = service[i];
            }
        }
        // if printer service is not empty then print
        if (!printer.getName().isEmpty()) {
            List<String> supplierNames = Arrays.asList("CERTIFICATE OF EXPERIENCE.pdf");
            for (String supplierName : supplierNames) {

                File file = new File("C:\\Users\\tanvi\\OneDrive\\Desktop\\Tanvir\\" + supplierName);
                // create the docuemnt with file on local machine
                PDDocument document = null;
                try {
                    document = PDDocument.load(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // create the job
                PrinterJob job = PrinterJob.getPrinterJob();
                // set unique name to each file
                job.setJobName(supplierName);
                job.setPrintService(printer);
                job.setPageable(new PDFPageable(document));
                try {
                    job.print();
                } catch (PrinterException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}