package br.com.dev.superheroes.infra.repository.impl

import br.com.dev.superheroes.infra.model.Hero
import br.com.dev.superheroes.infra.repository.SuperheroRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SuperheroRepositoryImpl : SuperheroRepository {
    val heroes = mutableListOf<Hero>()

    override fun create(hero: Hero): Hero {
        hero.id = heroes.size.toString() + LocalDateTime.now().toString()
        heroes.add(hero)
        println(hero)
        return hero
    }

    override fun getAllHeroes(): List<Hero> = heroes
}