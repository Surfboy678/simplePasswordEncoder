package com.security.passwordencoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class MyPasswordEncoder implements PasswordEncoder {

  @Override
  public String encode(CharSequence charSequence) {

    StringBuilder sb = new StringBuilder();

    String identifier = "@54$";

    String passwordWithIdentifier = (charSequence + identifier);

    for (byte c : passwordWithIdentifier.getBytes()) sb.append(c).toString();

    BigInteger passwordInt = new BigInteger(sb.toString());

    String version = "V1.0$@";

    String password = (version + passwordInt);

    return password;
  }

  @Override
  public boolean matches(CharSequence charSequence, String s) {
    return encode(charSequence).equals(s);
  }
}
