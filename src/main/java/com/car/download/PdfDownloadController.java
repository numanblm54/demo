package com.car.download;



import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/pdf")
public class PdfDownloadController {

    @GetMapping("/download")
    public org.springframework.http.ResponseEntity<byte[]> downloadPdf() {
        try {
            byte[] pdfBytes = createPdf();
            if (pdfBytes != null) {
                // PDF dosyasını istemciye indirme için doğru başlıkları ekliyoruz
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=dosya.pdf"); // Dosya ismini belirtiyoruz
                headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE); // PDF dosyası olarak belirtiyoruz

                return new org.springframework.http.ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
            } else {
                throw new RuntimeException("PDF oluşturulamadı.");
            }
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException("PDF oluşturulurken bir hata oluştu: " + e.getMessage());
        }
    }

    private byte[] createPdf() throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document();
        
        // PDF dosyasını oluşturuyoruz
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        document.add(new Paragraph("Merhaba, bu bir test PDF dosyasıdır!"));
        document.close();
        
        return byteArrayOutputStream.toByteArray();
    }
}


