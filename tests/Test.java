import com.aksndr.BCPrint;
import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import org.junit.Assert;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {

    @org.junit.Test
    public void createBCSheet(){
        List<String> barCodes = new ArrayList<>();

        Map<String, Object> result = BCPrint.getSheet(barCodes);

        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        Assert.assertTrue((Boolean) result.get("ok"));

        byte[] value = (byte[])result.get("value");

        Assert.assertNotNull(value);
        Assert.assertTrue(value.length > 0);


    }


    @org.junit.Test
    public void devide(){
        Integer count = 11;
        Integer devider = 3;

        System.out.print((int) Math.ceil((double) count / devider));

    }

    @org.junit.Test
    public void testcode () throws Exception {
        Document document = new Document(PageSize.A4, 20,15,15,5);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                "D:\\Temp\\barcodetest\\2.pdf"));
        document.open();

        PdfContentByte cb = writer.getDirectContent();

        document.add(createTable(cb));

        document.newPage();

        document.close();
    }


    public static PdfPTable createTable(PdfContentByte cb) throws DocumentException {
        // a table with three columns
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell defCell = table.getDefaultCell();
        defCell.setBorder(25);
        defCell.setBorderColor(BaseColor.WHITE);
        defCell.setPadding(5);
        defCell.setFixedHeight(58.5f);


        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000015"));
        table.addCell(getBarcode(cb, "00000001000000000017"));
        table.addCell(getBarcode(cb, "00000001000000000018"));
        table.completeRow();

        return table;
    }

    private static Image getBarcode(PdfContentByte cb,String s) {
        Barcode128 code128 = new Barcode128();
        code128.setCode(s);
        return code128.createImageWithBarcode(cb, null, null);
    }
}
