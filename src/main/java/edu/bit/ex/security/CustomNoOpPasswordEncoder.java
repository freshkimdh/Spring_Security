package edu.bit.ex.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		
		log.warn("before encofe : " + rawPassword);
		return rawPassword.toString(); // 암호화를 안시키겠다는 것
		//날것그대로 매칭시켜라
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		log.warn("mathches: " + rawPassword + " : " + encodedPassword);
		
		return rawPassword.toString().equals(encodedPassword);
		
	}

}



//encode
//암호화 시키는 것

//matches