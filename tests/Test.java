import com.aksndr.BCPrint;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {

    BCPrint bcPrint = new BCPrint();

    @org.junit.Test
    public void createBCSheet() throws IOException {
        List<String> barCodes = buildTestBCodes();

        Map<String, Object> result = bcPrint.getSheet(barCodes);

        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        Assert.assertTrue((Boolean) result.get("ok"));

        byte[] value = (byte[])result.get("value");

        Assert.assertNotNull(value);
        Assert.assertTrue(value.length > 0);

        FileOutputStream fos = new FileOutputStream("D:\\RND\\workspace\\BCPrint\\docs\\2.pdf");
        fos.write(value);
        fos.close();
    }

    private List<String> buildTestBCodes() {
        List<String> barCodes = new ArrayList<>();

        for (int i = 1; i < 43; i++) {
            String barcode = "00000001" + String.format("%012d", i);
            barCodes.add(barcode);
        }
        return barCodes;
    }


    @org.junit.Test
    public void divide() {
        Integer count = 11;
        Integer divider = 3;
        System.out.print((int) Math.ceil((double) count / divider));
    }

    @org.junit.Test
    public void testcode () throws Exception {
        Document document = new Document(PageSize.A4, 20,15,15,5);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(document, bos);
        document.open();

        PdfContentByte cb = writer.getDirectContent();
        document.add(createTable(cb));
        document.newPage();
        document.close();

        bos.close();
        byte[] arr = bos.toByteArray();

        FileOutputStream fos = new FileOutputStream("D:\\RND\\workspace\\BCPrint\\docs\\2.pdf");
        fos.write(arr);
        fos.close();
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
