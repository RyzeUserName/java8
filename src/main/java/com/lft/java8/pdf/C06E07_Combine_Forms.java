package com.lft.java8.pdf;

import com.itextpdf.forms.PdfPageFormCopier;
import com.itextpdf.kernel.pdf.*;
import java.io.File;
import java.io.IOException;

public class C06E07_Combine_Forms {
    public static final String DEST = "d:\\pdf\\combined_forms.pdf";
    public static final String SRC1 = "E:\\study\\java8\\src\\main\\java\\com\\lft\\java8\\pdf\\data\\subscribe.pdf";
    public static final String SRC2 = "E:\\study\\java8\\src\\main\\java\\com\\lft\\java8\\pdf\\data\\state.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C06E07_Combine_Forms().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        PdfDocument destPdfDocument = new PdfDocument(new PdfWriter(dest));
        PdfDocument[] sources = new PdfDocument[] {
            new PdfDocument(new PdfReader(SRC1)),
            new PdfDocument(new PdfReader(SRC2))
        };
        PdfPageFormCopier formCopier = new PdfPageFormCopier();
        for (PdfDocument sourcePdfDocument : sources) {
            sourcePdfDocument.copyPagesTo(
                1, sourcePdfDocument.getNumberOfPages(),
                destPdfDocument, formCopier);
            sourcePdfDocument.close();
        }
        destPdfDocument.close();
    }
}