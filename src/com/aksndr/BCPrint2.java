package com.aksndr;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Aksndr on 07.02.2016.
 */
public class BCPrint2 {

    public byte[] createSheet(List<String> barCodes) throws Exception {
        Document document = new Document(PageSize.A4); //, 5, 5, 5, 5
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(document, bos);
        writer.setPDFXConformance(PdfWriter.PDFXNONE);
        writer.setPdfVersion(PdfWriter.VERSION_1_4);
        document.open();

        PdfContentByte cb = writer.getDirectContent();
        int i = 0;
        float y = Utilities.millimetersToPoints(2);
        float x = Utilities.millimetersToPoints(6);
        for (String bCode : barCodes) {
            i++;
            Image image = getBarcode(cb, bCode);
            //for (float x = 10f; x < PageSize.A4.getWidth(); ) {
            //for (float y = 5f; y < PageSize.A4.getHeight(); ) {
            //float y1 = PageSize.A4.getHeight() - y;
//                    image.setAbsolutePosition(x, y1);
            image.setAbsolutePosition(x, document.getPageSize().getHeight() - image.getHeight() - y);
            writer.getDirectContent().addImage(image);

            // document.add(image);

            // }
            x += Utilities.millimetersToPoints(10) + image.getWidth();
            //}


            //image.setAbsolutePosition(10f, 10f);
            // document.add(image);
            if ((i % 3) == 0) {
                y += Utilities.millimetersToPoints(21.3f);
                x = Utilities.millimetersToPoints(6);
            }
        }


//        cb.fill();
        document.close();
        byte[] b = bos.toByteArray();
        try {
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }


    private Image getBarcode(PdfContentByte cb, String s) throws IOException, DocumentException {
        BaseFont bf = BaseFont.createFont("c:/Windows/Fonts/arial.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED); //BaseFont.HELVETICA
        Barcode128 code = new Barcode128();
        code.setCode(s);
        code.setBaseline(12);
        code.setSize(12);
        code.setBarHeight(Utilities.millimetersToPoints(10));
        code.setX(1.16f); //.16
        code.setFont(bf);

        Image bCode = code.createImageWithBarcode(cb, null, null);
        return bCode;
    }

}
