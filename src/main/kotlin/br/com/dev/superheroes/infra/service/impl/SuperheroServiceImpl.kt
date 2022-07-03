package br.com.dev.superheroes.infra.service.impl

import br.com.dev.superheroes.application.domain.dto.HeroDTO
import br.com.dev.superheroes.application.domain.dto.toHero
import br.com.dev.superheroes.infra.repository.SuperheroRepository
import br.com.dev.superheroes.infra.service.SuperheroService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SuperheroServiceImpl(@Autowired val superheroRepository: SuperheroRepository) : SuperheroService {
    override fun createHero(heroDTO: HeroDTO) {
        superheroRepository.create(heroDTO.toHero())
    }

    override fun getAllHeroes(): List<HeroDTO> {
        val heroes = this.superheroRepository.getAllHeroes()
        return heroes.map { HeroDTO(it.name, it.enabled) }
    }
}