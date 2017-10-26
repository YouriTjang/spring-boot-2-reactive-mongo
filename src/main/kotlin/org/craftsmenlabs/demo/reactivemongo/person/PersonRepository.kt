package org.craftsmenlabs.demo.reactivemongo.person

import org.springframework.data.mongodb.repository.Tailable
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface PersonRepository : ReactiveCrudRepository<Person, String> {

    @Tailable
    fun findPeopleBy(): Flux<Person>

}