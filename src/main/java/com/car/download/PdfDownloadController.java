package com.car.download;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfDownloadController {

    private final IDocumentService documentService;

    // IDocumentService üzerinden bağımlılığı alıyoruz
    public PdfDownloadController(IDocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/pdf/download")
    public ResponseEntity<byte[]> downloadPdf() {
        // PDF oluşturma işlemi
        byte[] pdfBytes = documentService.create();

        // Eğer pdfBytes null veya boşsa hata mesajı döndür
        if (pdfBytes == null || pdfBytes.length == 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("PDF oluşturulurken bir hata oluştu.".getBytes());
        }

        // PDF başarıyla oluşturulmuşsa indirilmeye hazır hale getir
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generated.pdf")
                .body(pdfBytes);
    }
}
