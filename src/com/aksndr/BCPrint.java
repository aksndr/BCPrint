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
        } catch (DocumentException e) {
            return failed(e.getMessage());
        }
        return succeed(value);
    }

    private byte[] createSheet(List<String> barCodes) throws DocumentException {
        Document document = new Document(PageSize.A4, 20, 15, 15, 5);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(document, bos);
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

    private PdfPTable createTable(PdfContentByte cb, List<String> barCodes) throws DocumentException {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell defCell = table.getDefaultCell();
        defCell.setBorder(25);
        defCell.setBorderColor(BaseColor.WHITE);
        defCell.setPadding(5);
        defCell.setFixedHeight(58.5f);

        for (String bCode : barCodes) {
            table.addCell(getBarcode(cb, bCode));
        }
        table.completeRow();
        return table;
    }

    private Image getBarcode(PdfContentByte cb, String s) {
        Barcode128 code128 = new Barcode128();
        code128.setCode(s);
        return code128.createImageWithBarcode(cb, null, null);
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
