package edu.bit.ex.vo;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@Getter
@Setter
public class CustomUser extends User {
	
	private EmpVO emp;
	
	//기본적으로 부모의 생성자를 호출해야만 정상적으로 작동

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	
	public CustomUser(EmpVO empVO) {	
		
		super(empVO.getEname(), Integer.toString(empVO.getEmpno()),Collections
				    .singletonList(new SimpleGrantedAuthority(empVO.getAuthorities())));

		// TODO Auto-generated constructor stub
		this.emp = empVO;
	}	
}