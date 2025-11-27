package com.ripon.spring.boot.web.mondb;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import reactor.core.publisher.Mono;

@Controller
public class TeamController {

    private final TeamService service;
    
    public TeamController(TeamService service) {
        this.service = service;
         
    }

    // LANDING PAGE
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // TEAM LIST
    @GetMapping("/team")
    public String listTeams(Model model) {
        model.addAttribute("team", service.getTeams());
        return "view_team";
    }
    
    //Add new team

    @GetMapping("/team/new")
    public String newTeamForm(Model model) {
        model.addAttribute("team", new Team());
        return "new_team";
    }

    @PostMapping("/team")
    public Mono<String> createTeam(@ModelAttribute Team team) {
        return service.addTeam(team)
                .thenReturn("redirect:/team");
    }
   //Edit existing team
    @GetMapping("/team/edit/{id}")
    public Mono<String> editTeamForm(@PathVariable int id, Model model) {
        return service.getTeam(id)
                .doOnNext(t -> model.addAttribute("team", t))
                .thenReturn("edit_team");
    }

    @PostMapping("/team/update/{id}")
    public Mono<String> updateTeam(@PathVariable int id, @ModelAttribute Team team) {
        team.setTeamId(id);
        return service.updateTeam(team)
                .thenReturn("redirect:/team");
    }
   //Delete team by Id
    @GetMapping("/team/delete/{id}")
    public Mono<String> deleteTeam(@PathVariable int id) {
        return service.deleteTeam(id)
                .thenReturn("redirect:/team");
    }
    
  @GetMapping("/team/{id}")
  public Mono<String> viewTeam(@PathVariable int id, Model model) {

      return service.getTeam(id)
              .flatMap(team -> service.getPlayersByTeam(id)
                      .collectList()
                      .map(players -> {
                          model.addAttribute("team", team);
                          model.addAttribute("players", players); 
                          return "show_team_player";
                      })
              )
              .switchIfEmpty(
                      Mono.fromRunnable(() -> {
                          model.addAttribute("error", "Team not found!");
                          model.addAttribute("team", null);
                          model.addAttribute("players", List.of());
                      }).thenReturn("show_team_player")
              );
  }
    
}
