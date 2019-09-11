package com.tieunt.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tieunt.demo.dao.AlienRepository;
import com.tieunt.demo.model.Alien;

@Service
public class AlienService {
	@Autowired
	private AlienRepository alienRepository;

	public List<Alien> getAliens() {
		return alienRepository.findAll();
	}

	public Alien getAlien(int aid) {
		return alienRepository.getOne(aid);
	}

	public Alien addAlien(Alien alien) {
		return alienRepository.save(alien);
	}

	public Alien updateAlien(Alien alien) {
		return alienRepository.save(alien);
	}

	public void deleteAlien(int aid) {
		alienRepository.deleteById(aid);
	}

	public List<Alien> getAliensByPage(int page, int size) {
		List<Alien> aliens = new ArrayList<Alien>();
		Page<Alien> currentPage = alienRepository.findAll(PageRequest.of(page, size));
		currentPage.forEach(aliens::add);
		String result = String.format("totalPage: %d, totolResult: %d", currentPage.getTotalPages(),
				currentPage.getTotalElements());
		System.out.println(result);
		return aliens;
	}
}
