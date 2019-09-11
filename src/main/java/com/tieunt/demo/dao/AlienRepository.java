package com.tieunt.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tieunt.demo.model.Alien;

public interface AlienRepository extends JpaRepository<Alien, Integer> {
//	List<Alien> findByTech(String tech);
//
//	List<Alien> findByAidGreaterThan(int aid);
//	
//	@Query("from Alien where tech=?1 order by aname")
//	List<Alien> findByTechSorted(String tech);
}
