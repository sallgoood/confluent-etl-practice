package sall.good.confluent.etl.practice

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import sall.good.confluent.etl.practice.client.kafka.OGGMessage
import sall.good.confluent.etl.practice.client.kafka.producer.KafkaProducer
import sall.good.confluent.etl.practice.client.kafka.producer.payload.A
import sall.good.confluent.etl.practice.client.kafka.producer.payload.B
import sall.good.confluent.etl.practice.client.kafka.producer.payload.MProvider
import sall.good.confluent.etl.practice.client.rest.KafkaConnectClient
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@ExtendWith(SpringExtension::class)
@SpringBootTest
class ConfluentEtlPracticeApplicationTests {

	@Autowired
	lateinit var client: KafkaConnectClient

	@Autowired lateinit var producer: KafkaProducer

	@Test
	fun contextLoads() {
	}

	@Test
	fun setup() {
		client.addDefaultMongoDBSinkConnector().log().subscribe()
		Thread.sleep(1000L)
	}

	@Test
	fun deleteAllConnectors() {
		client.deleteConnector("mongo-sink").log().subscribe()
	}


	@Test
	@Disabled
	fun produce() {
		val now = LocalDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ISO_DATE_TIME)
		producer.produce(OGGMessage.inserted("M_PROVIDER", MProvider("1")))
	}

	@Test
	fun test() {
		setup()

		producer.produce(OGGMessage.inserted("A", A("A01", "A01_DT01")))
		producer.produce(OGGMessage.inserted("A", A("A02", "A02_DT01")))

		producer.produce(OGGMessage.inserted("B", B("B01", "A01", "B01_DT01")))
		producer.produce(OGGMessage.inserted("B", B("B02", "A01", "B02_DT01")))
		producer.produce(OGGMessage.inserted("B", B("B03", "A02", "B03_DT01")))
		producer.produce(OGGMessage.inserted("B", B("B04", "A02", "B04_DT01")))
	}
}
