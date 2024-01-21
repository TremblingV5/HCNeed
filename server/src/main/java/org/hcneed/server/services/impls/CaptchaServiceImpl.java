package org.hcneed.server.services.impls;

import org.hcneed.server.services.CaptchaService;
import org.springframework.stereotype.Service;

@Service
public class CaptchaServiceImpl implements CaptchaService {
    @Override
    public boolean SendEmailCaptcha(String email) {
        return false;
    }

    @Override
    public boolean ValidateEmailCaptcha(String email, String captcha) {
        return false;
    }
}
