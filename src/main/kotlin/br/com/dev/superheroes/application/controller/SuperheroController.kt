package br.com.dev.superheroes.application.controller

import br.com.dev.superheroes.application.domain.dto.HeroDTO
import br.com.dev.superheroes.infra.service.SuperheroService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("heroes")
class SuperheroController(
    @Autowired val superheroService: SuperheroService
) {

    @PostMapping
    fun createHero(@Valid @RequestBody hero: HeroDTO): ResponseEntity<Any> {
        println(hero)
        this.superheroService.createHero(hero)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun getHeroes(): ResponseEntity<List<HeroDTO>> {
        return ResponseEntity.ok(this.superheroService.getAllHeroes())
    }
}