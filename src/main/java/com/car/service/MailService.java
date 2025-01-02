package com.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.car.model.Car;
import com.car.model.Person;
import com.car.model.Rental;
import com.car.person_repository.PersonRepository;
import com.car.rental_repository.RentalRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	
	@Autowired
	private PersonRepository personRepository;
	
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RentalRepository rentalRepository;


    // Kişiye e-posta gönderme ve toplam ücret bilgisiyle mesaj hazırlama
    public void sendRentalEmail(String firstName,String lastName) throws MessagingException {
        // 1. Kiralama verilerini al
        Person person = personRepository.findPersonByFirstNameAndLastName(firstName, lastName);

        if (person==null) {
            throw new IllegalArgumentException("This person is not found.");
        }
        
        Rental rental = rentalRepository.findRentalByPerson(person);
        
        if (rental==null) {
            throw new IllegalArgumentException("This person is not rented a car.");
        }


        // 3. Car verisini al (kiralanan araba)
        Car car = rental.getCar();

        // 4. Kiralama süresi ve günlük ücret
        long rentalDays = rental.getRentalDays();
        double dailyRate = car.getPrice().doubleValue();

        // 5. Toplam ücreti hesapla
        double totalAmount = calculateTotalAmount(rentalDays, dailyRate); // rentalDays * dailyRate

        // 6. E-posta içeriğini oluştur
        String subject = "Kiralama Bilgileriniz";
        String content = String.format("Merhaba %s,\n\n" +
                "Kiralamanız %d gün sürdü, günlük ücret %.2f TL. Toplam ücretiniz %.2f TL oldu.\n\n" +
                "Teşekkür ederiz!", person.getFirstName() + " " + person.getLastName(), rentalDays, dailyRate, totalAmount);
        System.out.println(content);
        // 7. E-posta gönderme
        sendEmail(person.getEmail(), subject, content);
    }

    // Toplam ücreti hesaplayan metot
    private double calculateTotalAmount(long rentalDays, double dailyRate) {
        return rentalDays * dailyRate;
    }

    // E-posta gönderme metodunu simüle et
    private void sendEmail(String to, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);  // true, HTML formatında

        // Gerçek gönderim işlemi yerine simülasyon
        mailSender.send(mimeMessage);
        System.out.println("E-posta gönderildi: " + to);
    }

}
