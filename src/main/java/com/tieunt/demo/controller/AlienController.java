package com.tieunt.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tieunt.demo.model.Alien;
import com.tieunt.demo.service.AlienService;

@RestController
public class AlienController {
	@Autowired
	AlienService alienService;

	@GetMapping(path = "/aliens/all", produces = "application/xml")
	public List<Alien> getAliens() {
		return alienService.getAliens();
	}

	@GetMapping(path = "/aliens", produces = "application/json")
	public List<Alien> getAliens(@PathParam(value = "page") int page, @PathParam(value = "size") int size) {
		return alienService.getAliensByPage(page, size);
	}

	@PostMapping(path = "/aliens", consumes = "application/json")
	public Alien addAlien(@RequestBody Alien alien) {
		return alienService.addAlien(alien);
	}

	@PutMapping("/aliens")
	public Alien updateAlien(@RequestBody Alien alien) {
		return alienService.updateAlien(alien);
	}

	@GetMapping("/aliens/{aid}")
	public Alien getAlien(@PathVariable int aid) {
		return alienService.getAlien(aid);
	}

	@DeleteMapping("/aliens/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		alienService.deleteAlien(aid);
		return "deleted";
	}
}
