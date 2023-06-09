package com.pdf.utility;

import java.io.*;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {

	private static final String FILE_NAME = 
			"E:\\sts-projects\\PDF_Generation_Example\\pdfdocs\\sample2.pdf";

    public void writeUsingIText() {

        Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

            //open
            document.open();

            Paragraph p = new Paragraph();
            p.add("Ticket");
            p.setAlignment(Element.ALIGN_CENTER);

            document.add(p);

            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(8);

            document.add(new Paragraph("Ticket Details", f));

          //Create Table object, Here 4 specify the no. of columns
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
           
     
            //Create cells
            PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
            cell1.setColspan(2);
            
     
            //Add cells to table
            table.addCell(cell1);
            table.addCell(cell2);
            
          //Add content to the document using Table objects.
            document.add(table);
     
            //Close document and outputStream.
            document.close();

            System.out.println("Done");
         
        } catch (Exception e) {
            e.printStackTrace();
        }   }
}
