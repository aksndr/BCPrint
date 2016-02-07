import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Aksndr on 31.01.2016.
 */


public class ReaderTest {
    @org.junit.Test
    public void testReadPdf() throws IOException, DocumentException {
        String src = "D:\\Temp\\bcprint\\1\\in2.pdf";
        String dest = "D:\\Temp\\bcprint\\1\\out.pdf";
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        Map<String, PdfLayer> layers = stamper.getPdfLayers();
        PdfWriter writer = stamper.getWriter();
        PdfContentByte cb = stamper.getOverContent(1);

        PdfImportedPage page = writer.getImportedPage(reader, 1);
    }


}
