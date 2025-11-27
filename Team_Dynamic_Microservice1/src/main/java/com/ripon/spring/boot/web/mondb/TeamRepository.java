package com.ripon.spring.boot.web.mondb;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepository  extends ReactiveMongoRepository<Team, Integer>{

}