package br.com.dev.superheroes.infra.repository

import br.com.dev.superheroes.infra.model.Hero
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository

@EnableScan
interface SuperheroRepository: CrudRepository<Hero, String> {

}