package com.monka.potal.api.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monka.potal.api.model.Team;
import com.monka.potal.api.service.TeamService;

@RestController
public class TeamsController {
	
	private final TeamService service;
	
	public TeamsController(TeamService teamService) {
		this.service = teamService;
	}

	@GetMapping("/teams")
	public List<Team> getTeams(){
		return service.getAllTeams();
	}
	
	@GetMapping("/teams/{teamId}")
	public Team getTeam(@PathVariable Long teamId){
		return service.getTeamById(teamId);
	}
	
	@PostMapping(value="/teams", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Team createTeam(@RequestBody Team team){
		return service.save(team);
	}
	
	@PutMapping("/teams/{teamId}")
	public Team updateTeam(@PathVariable Long teamId, @RequestBody Team team){
		return service.update(teamId, team);
	}
	
	@DeleteMapping("/teams/{teamId}")
	public void deleteTeam(@PathVariable Long teamId){
		service.delete(teamId);;
	}
}
