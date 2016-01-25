package com.aksndr;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Created by Aksndr on 08.10.2015. */

public class BCPrint {

    public BCPrint() {}

    public Map<String, Object> getSheet(List<String> barCodes) {
        if (barCodes.isEmpty()) return failed("Received barcodes list is empty.");
        byte[] value;
        try {
            value = createSheet(barCodes);
        } catch (Exception e) {
            return failed(e.getMessage());
        }
        return succeed(value);
    }

    private byte[] createSheet(List<String> barCodes) throws Exception {
        Document document = new Document(PageSize.A4, 0f, 0f, -5f, -5f); //
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(document, bos);
        writer.setPDFXConformance(PdfWriter.PDFX32002);
        writer.setPdfVersion(PdfWriter.VERSION_1_3);
        document.open();

        PdfContentByte cb = writer.getDirectContent();
        document.add(createTable(cb, barCodes));
        document.newPage();
        document.close();

        try {
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }

    private PdfPTable createTable(PdfContentByte cb, List<String> barCodes) throws Exception {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell defCell = table.getDefaultCell();
        defCell.setUseBorderPadding(true);

        defCell.setBorderColor(BaseColor.WHITE);
        defCell.setUseBorderPadding(true);
        defCell.setPaddingRight(15);
        defCell.setPaddingLeft(15);
        defCell.setPaddingTop(10);
//        defCell.setPaddingBottom(11);
        defCell.setFixedHeight(60.5f);

        for (String bCode : barCodes) {
            table.addCell(getBarcode(cb, bCode));
        }
        table.completeRow();
        return table;
    }

    private Image getBarcode(PdfContentByte cb, String s) throws IOException, DocumentException {
        BaseFont bf = BaseFont.createFont("c:/Windows/Fonts/arial.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED); //BaseFont.HELVETICA
        Barcode128 code = new Barcode128();
        code.setCode(s);
        code.setBarHeight(20f);
        code.setFont(bf);
        Image bCode = code.createImageWithBarcode(cb, null, null);
        return bCode;
    }

    private static Map<String, Object> succeed(Object value){
        Map<String, Object> result = new HashMap<>();
        result.put("ok", true);
        result.put("value", value);
        return result;
    }

    private static Map<String, Object> failed(String errMsg){
        Map<String, Object> result = new HashMap<>();
        result.put("ok", false);
        result.put("errMsg", errMsg);
        return result;
    }
}
