package br.com.fiap.techfood.techfood

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TechfoodApplication

fun main(args: Array<String>) {
	runApplication<TechfoodApplication>(*args)
}
