package br.com.dev.superheroes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["br.com.dev.superheroes"])
@EntityScan(basePackages = ["br.com.dev.superheroes.infra.model"])
class SuperheroesApplication

fun main(args: Array<String>) {
    runApplication<SuperheroesApplication>(*args)
}
