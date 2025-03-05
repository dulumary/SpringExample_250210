package com.marondal.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marondal.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	// 모든행을 id컬럼을 기반으로 내림차순 조회 
	public List<Student> findAllByOrderByIdDesc();
	
	// id기준으로 내림차순 으로 정렬된 결과를 2개만 조회 
	// ORDER BY `id` DESC LIMIT 2
	public List<Student> findTop2ByOrderByIdDesc();
	
	// 전달 받은 이름과 일치하는 행 조회 
	// WHERE `name` = #{name}
	public List<Student> findByName(String name);
	
	// 전달받은 이름들과 일치하는 행 조회 
	// WHERE `name` IN (#{}, #{})
	public List<Student> findByNameIn(List<String> nameList);
	
	// 전달받은 키워드가 포함된 email 컬럼을 가진 행 조회 
	// WHERE `email` LIKE '%${keyword}%'
	public List<Student> findByEmailContaining(String keyword);
	
	// id 컬럼 값이 특정한 값 사이에 포함된 행을 id기반으로 내림차순 정렬 조회 
	// WHERE `id` BETWEEN 1 AND 3 ORDER BY `id` DESC
	public List<Student> findByIdBetweenOrderByIdDesc(int start, int end);
	
	// 쿼리 직접 작성
	// dreamJob 일치하는 행 조회 
	@Query(value="SELECT * FROM `new_student` WHERE `dreamJob` = :dreamJob", nativeQuery=true)
	public List<Student> selectByDreamJob(@Param("dreamJob") String dreamJob);
	

}
