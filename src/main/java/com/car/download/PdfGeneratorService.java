package com.car.download;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfGeneratorService implements IDocumentService {

    @Override
    public byte[] create() {
        try {
            // ByteArrayOutputStream, PDF içeriğini hafızada tutmamıza yarar
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            // PDF dokümanı oluşturuyoruz
            Document document = new Document();
            // PdfWriter kullanarak byte array'e yazıyoruz
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            // PDF'e basılacak içerik
            document.add(new Paragraph("Merhaba, bu bir test PDF dosyasıdır!"));
            document.close();
            // PDF'in byte dizisini döndürüyoruz
            return byteArrayOutputStream.toByteArray();
        } catch (DocumentException e) {
            e.printStackTrace();  // Hata mesajını yazdırıyoruz
            return null;  // Eğer DocumentException hatası oluşursa null döndürüyoruz
        }
    }
}