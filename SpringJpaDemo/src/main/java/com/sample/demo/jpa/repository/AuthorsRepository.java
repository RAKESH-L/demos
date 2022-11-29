package com.sample.demo.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.demo.jpa.entity.Authors;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer>{ 
	public Optional<Authors> findByEmail(String email);
	
	@Modifying
	@Query(value="UPDATE AUTHORS SET EMAIL = :email WHERE AUTHORID = :id", nativeQuery = true )
	public int updateEmail(@Param("id") int id, @Param("email") String email);
}
