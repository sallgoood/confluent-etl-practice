package sall.good.confluent.etl.practice.model.oracle.item

import java.time.Instant

//com.rakuten.travel.kadas.logic.autogenerated.model.ItDpiQuestions
data class DpiStaff(
        val id: String,
        val itemId: String,
        val active: Boolean,
        val createdAt: Instant,
        val updatedAt: Instant
)