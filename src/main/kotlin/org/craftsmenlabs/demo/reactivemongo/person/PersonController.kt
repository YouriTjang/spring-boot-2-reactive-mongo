package org.craftsmenlabs.demo.reactivemongo.person

import org.springframework.data.mongodb.core.CollectionOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import javax.annotation.PostConstruct


@RestController
class PersonController(
        val blockingMongo: MongoTemplate,
        val eventRepository: PersonRepository) {

    private val persons = Arrays.asList<Person>(
            Person("David", "DeButser"),
            Person("Bas", "Beuker"),
            Person("Patrick", "Preact"),
            Person("Kevin", "Knutselaar")
    )

    @PostConstruct
    fun postConstruct() {
        blockingMongo.dropCollection(Person::class.java)
        blockingMongo.createCollection(Person::class.java, CollectionOptions.empty().capped().size(2048).maxDocuments(1000))
    }

    @GetMapping(value = "/person", produces = arrayOf(MediaType.APPLICATION_STREAM_JSON_VALUE))
    internal fun streamEvents(): Flux<Person> {
        return eventRepository.findPeopleBy()
    }

    @GetMapping(value = "/insertrandom")
    internal fun insertRandom(): Mono<Person> {
        val random = ThreadLocalRandom.current()
        val randomPerson = persons[random.nextInt(persons.size)]

        return eventRepository.save(randomPerson)
    }
}