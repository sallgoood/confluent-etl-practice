package sall.good.confluent.etl.practice.client.kafka

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import sall.good.confluent.etl.practice.client.kafka.producer.KafkaProducer
import sall.good.confluent.etl.practice.client.kafka.producer.payload.MProvider
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@ExtendWith(SpringExtension::class)
@SpringBootTest
@Disabled
internal class KafkaProducerTests {

    @Autowired lateinit var producer: KafkaProducer

    @Test
    fun produce() {
        val now = LocalDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ISO_DATE_TIME)
        producer.produce(OGGMessage.inserted("M_PROVIDER", MProvider("1")))
    }
}
