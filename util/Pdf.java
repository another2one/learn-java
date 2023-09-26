package util;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;
import org.fit.pdfdom.PDFDomTreeConfig;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Pdf {

    public static String parseWithPdfDomTree(InputStream is, int startPage, int endPage, PDFDomTreeConfig config)
            throws IOException, ParserConfigurationException {
        PDDocument pdf = PDDocument.load(is);
        PDFDomTree parser = new PDFDomTree(config);
        parser.setStartPage(startPage);
        parser.setEndPage(endPage);
        Writer output = new StringWriter();
        parser.writeText(pdf, output);
        pdf.close();
        String htmlOutput = output.toString();
        return htmlOutput;
    }



    public static void main(String[] args) throws IOException, ParserConfigurationException {
        PDFDomTreeConfig config = PDFDomTreeConfig.createDefaultConfig();
        config.setImageHandler(PDFDomTreeConfig.saveToDirectory(new File("C:/Users/lizhi/Desktop")));
        config.setFontHandler(config.getImageHandler());
        String htmlOutput = parseWithPdfDomTree(new FileInputStream("C:/Users/lizhi/Desktop/ss.pdf"), 0, 10, config);
        // 加粗样式有点问题，去掉
        htmlOutput = htmlOutput.replace("font-weight:bold;", "");
        FileUtils.write(new File("C:/Users/lizhi/Desktop/ss.html"), htmlOutput, "utf-8");
    }
}