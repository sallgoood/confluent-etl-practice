package sall.good.confluent.etl.practice.client.kafka

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

data class OGGMessage<T>(
        val table: String,
        val op_type: String, // enum, I(nsert), U(pdate), D(elete)
        val op_ts: String, // 2017-01-01T00:00:01.000000
        val current_ts: String,
        val primary_keys: List<String>,
        val tokens: Map<String, String>,
        val before: T?,
        val after: T?
) {
    companion object {
        fun <T> inserted(table: String, after: T?): OGGMessage<T> {
            val now = LocalDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ISO_DATE_TIME)
            return OGGMessage(table, "I", now, now, listOf(), mapOf(), null, after)
        }

        fun <T> updated(table: String, before: T?, after: T?): OGGMessage<T> {
            val now = LocalDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ISO_DATE_TIME)
            return OGGMessage(table, "I", now, now, listOf(), mapOf(), before, after)
        }

        fun <T> deleted(table: String, before: T?, after: T?): OGGMessage<T> {
            val now = LocalDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ISO_DATE_TIME)
            return OGGMessage(table, "I", now, now, listOf(), mapOf(), before, after)
        }
    }
}
