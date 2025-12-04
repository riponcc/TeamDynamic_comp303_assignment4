package com.abdul.Microservice2;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayerService {

    private final WebClient webClient;

    public PlayerService(WebClient.Builder webClientBuilder) {
    		this.webClient = webClientBuilder.baseUrl("http://Team-Dynamic-Microservice1").build();
    	}

    public Flux<Player> getPlayers() {
        return webClient.get().uri("/api/players").retrieve().bodyToFlux(Player.class);
    }

    public Mono<Player> getPlayer(int id) {
        return webClient.get().uri("/api/players/{id}", id).retrieve().bodyToMono(Player.class);
    }

    public Mono<Player> addPlayer(Player player) {
        return webClient.post().uri("/api/players").bodyValue(player).retrieve().bodyToMono(Player.class);
    }

    public Mono<Player> updatePlayer(int id, Player player) {
        return webClient.put().uri("/api/players/{id}", id).bodyValue(player).retrieve().bodyToMono(Player.class);
    }

    public Mono<Void> deletePlayer(int id) {
        return webClient.delete().uri("/api/players/{id}", id).retrieve().bodyToMono(Void.class);
    }
}
