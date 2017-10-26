package org.craftsmenlabs.demo.reactivemongo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ReactiveMongoApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(ReactiveMongoApplication::class.java, *args)
        }
    }
}