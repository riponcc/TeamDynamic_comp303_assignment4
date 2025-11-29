package com.ripon.spring.boot.web.mondb;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/teams")
public class TeamRestController {

    private final TeamService teamService;

    public TeamRestController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public Flux<Team> getAllTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/{id}")
    public Mono<Team> getTeam(@PathVariable int id) {
        return teamService.getTeam(id);
    }

    @PostMapping
    public Mono<Team> addTeam(@RequestBody Team team) {
        return teamService.addTeam(team);
    }

    @PutMapping("/{id}")
    public Mono<Team> updateTeam(@PathVariable int id, @RequestBody Team team) {
        team.setTeamId(id);
        return teamService.updateTeam(team);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteTeam(@PathVariable int id) {
        return teamService.deleteTeam(id);
    }
}
