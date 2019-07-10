package he.pdf;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;


public class PdfCreator {

    private static final String DEST = "documents/HappyEuro.pdf";

    public PdfCreator() {
    }

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        new PdfCreator().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);

        //Add paragraph to the document
        document.add(new Paragraph("Hello HappyEuro 4!"));

        //Close document
        document.close();
    }

    public void createHE() throws IOException {
        //Initialize PDF writer

        String DEST = "HappyEuro4.pdf";
        PdfWriter writer = new PdfWriter(DEST);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);

        //Add paragraph to the document
        document.add(new Paragraph("HappyEuro 4!"));

        //Close document
        document.close();
    }
}
