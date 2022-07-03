package br.com.dev.superheroes.infra.repository

import br.com.dev.superheroes.infra.model.Hero

interface SuperheroRepository {
    fun create(hero: Hero): Hero

    fun getAllHeroes(): List<Hero>
}