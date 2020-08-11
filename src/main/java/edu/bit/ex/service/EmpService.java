package edu.bit.ex.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.bit.ex.vo.EmpVO;
import edu.bit.mapper.EmpMapper;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@NoArgsConstructor
@Service
public class EmpService {
	
	@Inject
	private EmpMapper empMapper;
	
	public EmpVO getUser(String empNo){
		log.info("readUser .. ");
		return empMapper.readUser(empNo);
	}
	
}