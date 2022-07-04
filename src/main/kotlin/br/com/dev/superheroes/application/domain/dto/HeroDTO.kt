package br.com.dev.superheroes.application.domain.dto

import br.com.dev.superheroes.infra.model.Hero
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class HeroDTO(
    @field:NotEmpty(message = "'name' is required")
    val name: String,
    @field:NotNull(message = "'enabled' is required")
    val enabled: Boolean
)

fun HeroDTO.toHero() = Hero(null, this.name, this.enabled)