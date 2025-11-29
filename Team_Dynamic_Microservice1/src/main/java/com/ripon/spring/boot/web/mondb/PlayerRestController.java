package com.ripon.spring.boot.web.mondb;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {

    private final PlayerService playerService;

    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public Flux<Player> getAllPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/{id}")
    public Mono<Player> getPlayer(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    @PostMapping
    public Mono<Player> addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @PutMapping("/{id}")
    public Mono<Player> updatePlayer(@PathVariable int id, @RequestBody Player player) {
        player.setPlayerId(id);
        return playerService.updatePlayer(player);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePlayer(@PathVariable int id) {
        return playerService.deletePlayer(id);
    }
}