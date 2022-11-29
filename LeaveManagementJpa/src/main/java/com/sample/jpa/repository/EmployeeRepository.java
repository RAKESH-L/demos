package com.sample.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.jpa.entity.Employee;
import com.sample.jpa.entity.Leave;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findById(int id);

//	@Modifying
//	@Query(value="DELETE FROM EMPLOYEE WHERE ID = :id", nativeQuery = true)
//	void deleteById(int id);

	@Query("select l from Leave l where l.employee.id=?1")
	List<Leave> getLeaveByEmployeeId(int id);
	

	

}
