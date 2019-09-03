package sall.good.confluent.etl.practice.client.rest

import reactivefeign.spring.config.ReactiveFeignClient

@ReactiveFeignClient(name = "\${reactive.feign.client.config.kafka-rest.name}",
        url = "\${reactive.feign.client.config.kafka-rest.url}")
interface KafkaRestClient {
}
