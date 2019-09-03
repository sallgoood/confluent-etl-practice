package sall.good.confluent.etl.practice.client

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import sall.good.confluent.etl.practice.client.rest.KafkaConnectClient


@ExtendWith(SpringExtension::class)
@SpringBootTest
@Disabled
class KafkaConnectClientTests {

    @Autowired
    lateinit var client: KafkaConnectClient

    @Test
    fun addDefaultMongoDBSinkConnector() {
        client.addDefaultMongoDBSinkConnector().log().subscribe()
    }

    @Test
    fun addDefaultMongoDBSourceConnector() {
        client.addDefaultMongoDBSourceConnector().log().subscribe()
    }

    @Test
    fun deleteDefaultMongoDBSinkConnector() {
        client.deleteConnector("mongo-sink").log().subscribe()
    }
}
