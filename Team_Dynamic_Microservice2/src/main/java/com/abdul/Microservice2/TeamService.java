package com.abdul.Microservice2;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TeamService {

    private final WebClient webClient;

    public TeamService(WebClient.Builder webClientBuilder) {
    		this.webClient = webClientBuilder.baseUrl("http://Team-Dynamic-Microservice1").build();
    }

    public Flux<Team> getTeams() {
        return webClient.get().uri("/api/teams").retrieve().bodyToFlux(Team.class);
    }

    public Mono<Team> getTeam(int id) {
        return webClient.get().uri("/api/teams/{id}", id).retrieve().bodyToMono(Team.class);
    }

    public Mono<Team> addTeam(Team team) {
        return webClient.post().uri("/api/teams").bodyValue(team).retrieve().bodyToMono(Team.class);
    }

    public Mono<Team> updateTeam(int id, Team team) {
        return webClient.put().uri("/api/teams/{id}", id).bodyValue(team).retrieve().bodyToMono(Team.class);
    }

    public Mono<Void> deleteTeam(int id) {
        return webClient.delete().uri("/api/teams/{id}", id).retrieve().bodyToMono(Void.class);
    }
    
    public Flux<Player> getPlayersByTeam(int id) {
        return webClient.get().uri("/api/teams/{id}/player", id).retrieve().bodyToFlux(Player.class);
    }
}
