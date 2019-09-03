package sall.good.confluent.etl.practice.model.oracle.item

import java.time.Instant

interface CommonProperties {
    val active: Boolean
    val createdAt: Instant
    val updatedAt: Instant
}
