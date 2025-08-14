package com.example.scedule2.encoder;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
    /*
    public String encode(String Password) {
         return BCrypt.withDefaults().hashToString(BCrypt.MIN_COST,
                 Password.toCharArray());
    }

    public boolean matches(String Password, String encodedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(Password.toCharArray(), encodedPassword);
        return result.verified;
    }
    */
}
