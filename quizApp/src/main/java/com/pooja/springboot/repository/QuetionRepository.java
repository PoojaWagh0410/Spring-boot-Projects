package com.pooja.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pooja.springboot.entity.Quetion;

@Repository
public interface QuetionRepository extends JpaRepository<Quetion, Integer> {

	List<Quetion> findByCategory(String category);

	@Query(value = "SELECT q FROM Quetion q WHERE difficultyLevel LIKE %:difficultyLevel% AND category LIKE %:category%")
	List<Quetion> findByDifficultyLevelAndCategory(String difficultyLevel, String category);

//	@Query(value = "SELECT * FROM quetion WHERE category = :category ORDER BY RAND() LIMIT :numQue", nativeQuery = true)
//	List<Quetion> findRandomQuetionByCategory(@Param("category") String category, @Param("numQue") int numQue);

	
	
}
