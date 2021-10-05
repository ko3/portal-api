package com.monka.potal.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.monka.potal.api.model.Team;
import com.monka.potal.api.repository.TeamRepository;

@Service
public class TeamService {
	
	private final TeamRepository repository;
	
	public TeamService(TeamRepository repository) {
		this.repository = repository;
	}
	
	public List<Team> getAllTeams(){
		List<Team> teams = new ArrayList<>();
		repository.findAll().forEach(entity -> teams.add(map(entity)));
		return teams;
	}
	
	public Team getTeamById(Long teamId) {
		return map(repository.findById(teamId).orElse(new com.monka.potal.api.entity.Team()));
	}
	
	public Team save(Team team) {
		return map(repository.save(map(team)));
	}
	
	public Team update(Long teamId, Team team) {
		team.setId(teamId);
		return map(repository.save(map(team)));
	}
	
	public void delete(Long teamId) {
		repository.deleteById(teamId);
	}
	private Team map(com.monka.potal.api.entity.Team source) {
		Team target = new Team();
		target.setId(source.getId());
		target.setName(source.getName());
		return target;
	}
	
	private com.monka.potal.api.entity.Team map(Team source) {
		com.monka.potal.api.entity.Team target = new com.monka.potal.api.entity.Team();
		target.setId(source.getId());
		target.setName(source.getName());
		return target;
	}

}
