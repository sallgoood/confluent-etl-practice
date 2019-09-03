package sall.good.confluent.etl.practice.client.rest

import feign.Body
import feign.Headers
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*
import reactivefeign.spring.config.ReactiveFeignClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@ReactiveFeignClient(name = "\${reactive.feign.client.config.kafka-connect.name}",
        url = "\${reactive.feign.client.config.kafka-connect.url}")
interface KafkaConnectClient {

    @GetMapping("/connectors")
    fun getConnectors(): Flux<String>

    @PostMapping("/connectors/", consumes = [APPLICATION_JSON_VALUE])
    fun createConnector(@RequestBody config: String): Mono<String>

    @DeleteMapping("/connectors/{connectName}", consumes = [APPLICATION_JSON_VALUE])
    fun deleteConnector(@PathVariable connectName: String): Mono<String>

    @PostMapping("/connectors/", consumes = [APPLICATION_JSON_VALUE])
    fun addDefaultMongoDBSinkConnector(@RequestBody config: String = """
            {  
                "name":"ab-sink",
                 "config":{  
                     "connector.class":"com.mongodb.kafka.connect.MongoSinkConnector",
                     "tasks.max":"1",
                      "topics":"AB",
                      "connection.uri":"mongodb://mongo1:27017,mongo2:27017,mongo3:27017",
                      "database":"test",
                      "collection":"AB",
                      "key.converter":"org.apache.kafka.connect.storage.StringConverter",
                      "value.converter":"org.apache.kafka.connect.json.JsonConverter",
                      "value.converter.schemas.enable":"false"
                }
            }
        """): Mono<String>

    @PostMapping("/connectors/", consumes = [APPLICATION_JSON_VALUE])
    fun addDefaultMongoDBSourceConnector(@RequestBody config: String = """
            {  
               "name":"mongo-source",
               "config":{  
                  "tasks.max":"1",
                  "connector.class":"com.mongodb.kafka.connect.MongoSourceConnector",
                  "connection.uri":"mongodb://mongo1:27017,mongo2:27017,mongo3:27017",
                  "topic.prefix":"mongo",
                  "database":"test",
                  "collection":"pageviews"
               }
            }
        """): Mono<String>
}
