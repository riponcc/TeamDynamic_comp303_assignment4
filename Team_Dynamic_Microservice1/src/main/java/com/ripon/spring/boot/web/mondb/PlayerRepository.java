package com.ripon.spring.boot.web.mondb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;



import reactor.core.publisher.Flux;

@Repository
public interface PlayerRepository  extends ReactiveMongoRepository<Player, Integer> {
	
	//Get all players of the team
	
	Flux<Player> findByTeamId(int teamId);

}
