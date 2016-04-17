package org.soluvas.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by ceefour on 17/04/2016.
 */
public class BCryptPasswordEncoderApp {

    public static void main(String[] args) {
        final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode(args[0]));
    }
}
