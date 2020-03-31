package com.lft.java8.pdf;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 描述
 * @author Ryze
 * @date 2020-01-14 17:22
 */
public class C01E01_HelloWorld {
    public static final String DEST = "d:\\pdf\\hello_world.pdf";

    public static void main(String args[]) throws IOException, FileNotFoundException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C01E01_HelloWorld().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, FileNotFoundException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
        // Initialize document
        Document document = new Document(pdf);
        //Add paragraph to the document
        document.add(new Paragraph("Hello World!"));
        //Close document
        document.close();
    }
}
