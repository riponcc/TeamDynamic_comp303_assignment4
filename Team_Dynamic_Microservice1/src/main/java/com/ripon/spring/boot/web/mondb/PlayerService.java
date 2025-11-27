package com.ripon.spring.boot.web.mondb;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PlayerService {

    private final PlayerRepository playerRepo;

    public PlayerService(PlayerRepository playerRepo) {
        this.playerRepo = playerRepo;
    }

    //  Get all players
    public Flux<Player> getPlayers() {
        return playerRepo.findAll();
    }

    // Get player by ID
    public Mono<Player> getPlayer(int playerId) {
        return playerRepo.findById(playerId);
    }

    // Add player 
    public Mono<Player> addPlayer(Player player) {
        return playerRepo.existsById(player.getPlayerId())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new Exception("Player ID already exists."));
                    }
                    return playerRepo.save(player);
                });
    }

    // Update player with existence check
    public Mono<Player> updatePlayer(Player player) {
        return playerRepo.existsById(player.getPlayerId())
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.error(new Exception("Player ID not found."));
                    }
                    return playerRepo.save(player);
                });
    }

    // Delete player by ID
    public Mono<Void> deletePlayer(int playerId) {
        return playerRepo.deleteById(playerId);
    }
    
    public Flux<Player> getPlayersByTeam(int teamId) {
        return playerRepo.findByTeamId(teamId);
    }
}

