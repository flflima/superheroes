package br.com.dev.superheroes.infra.service

import br.com.dev.superheroes.application.domain.dto.HeroDTO

interface SuperheroService {
    fun createHero(heroDTO: HeroDTO)

    fun getAllHeroes(): List<HeroDTO>
}