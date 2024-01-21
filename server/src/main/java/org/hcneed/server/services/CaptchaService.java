package org.hcneed.server.services;

public interface CaptchaService {
    boolean SendEmailCaptcha(String email);
    boolean ValidateEmailCaptcha(String email, String captcha);
}
