package br.com.dev.superheroes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SuperheroesApplication

fun main(args: Array<String>) {
	runApplication<SuperheroesApplication>(*args)
}
