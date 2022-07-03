package br.com.dev.superheroes.application.domain.dto

import br.com.dev.superheroes.infra.model.Hero
import javax.validation.constraints.NotEmpty

data class HeroDTO(
    @field:NotEmpty(message = "'name' is required")
    val name: String,
    var enabled: Boolean
)

fun HeroDTO.toHero() = Hero(null, this.name, this.enabled)