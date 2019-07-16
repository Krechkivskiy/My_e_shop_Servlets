package service;

public interface MailService {

    void send(String email, String verificationCode);
}
