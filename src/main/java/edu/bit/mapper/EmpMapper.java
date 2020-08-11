package edu.bit.mapper;

import org.apache.ibatis.annotations.Select;

import edu.bit.ex.vo.EmpVO;

public interface EmpMapper {
	
	@Select("select * from emp where ename = #{enma}")
	public EmpVO readUser(String ename);


   
   }
   