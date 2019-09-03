package sall.good.confluent.etl.practice.model.mongo.item

import java.time.Instant

data class Item (
        val id: String,
        val itemCode: String,
        val providerId: String,
        val zipCode: String,
        val countryCode: String,
        val airportCode: String,
        val longitude: Double,
        val latitude: Double,
        val stopped: Boolean,
        val requested: Boolean,
        val outrightBought: Boolean,
        val createdAt: Instant,
        val updatedAt: Instant,
        val active: Boolean
)
