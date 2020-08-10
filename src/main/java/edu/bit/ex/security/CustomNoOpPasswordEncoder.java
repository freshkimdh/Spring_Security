package edu.bit.ex.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		
		log.warn("before encofe : " + rawPassword);
		return rawPassword.toString(); // ��ȣȭ�� �Ƚ�Ű�ڴٴ� ��
		//���ͱ״�� ��Ī���Ѷ�
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		log.warn("mathches: " + rawPassword + " : " + encodedPassword);
		
		return rawPassword.toString().equals(encodedPassword);
		
	}

}



//encode
//��ȣȭ ��Ű�� ��

//matches