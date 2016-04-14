package com.andresgariglio.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends MongoRepository<Person, String> {

	List<Person> findByLastName(@Param("lastName") String lastName);

}