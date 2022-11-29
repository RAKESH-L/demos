package com.sample.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.demo.jpa.entity.Books;
import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{
//	public List<Books> findByTitle(String title);
//	public List<Books> findByAithorId(int id);
	
	@Modifying
	@Query(value="UPDATE BOOKS SET PRICE = :price WHERE BOOKID = :id", nativeQuery = true)
	public int updateBookPrice(@Param("id") int id, @Param("price") double price);
	
//	@Query(value = "SELECT * FROM BOOKS WHERE PRICE BETWEEN (:min, :max)")
//	public List<Books> findBookaBetween(@Param("min") double min, @Param("max") double max);
}
