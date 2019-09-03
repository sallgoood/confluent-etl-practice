package sall.good.confluent.etl.practice

import feign.Logger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.loadbalancer.reactive.ReactiveLoadBalancerAutoConfiguration
import org.springframework.context.annotation.Bean
import reactivefeign.spring.config.EnableReactiveFeignClients

@SpringBootApplication(exclude = [ReactiveLoadBalancerAutoConfiguration::class])
@EnableReactiveFeignClients
class ConfluentEtlPracticeApplication

fun main(args: Array<String>) {
	runApplication<ConfluentEtlPracticeApplication>(*args)

	@Bean
	fun feignLoggerLevel() : Logger.Level {
		return Logger.Level.FULL
	}
}
