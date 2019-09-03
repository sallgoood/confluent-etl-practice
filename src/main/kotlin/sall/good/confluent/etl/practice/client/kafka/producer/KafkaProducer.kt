package sall.good.confluent.etl.practice.client.kafka.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import sall.good.confluent.etl.practice.client.kafka.OGGMessage


@Component
class KafkaProducer(val template: KafkaTemplate<String, OGGMessage<Any>>) {

    fun produce(message: OGGMessage<Any>) {
        template.send(message.table, message)
    }
}
