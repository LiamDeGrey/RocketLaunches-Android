package com.liamdegrey.rocketlaunches.network.brokers

import com.fasterxml.jackson.databind.ObjectMapper
import com.liamdegrey.rocketlaunches.network.models.UpcomingRocketLaunches
import com.liamdegrey.rocketlaunches.network.services.DataService
import io.reactivex.Single
import okhttp3.OkHttpClient

class DataBroker(
    baseUrl: String,
    httpClient: OkHttpClient,
    objectMapper: ObjectMapper
) : BaseBroker<DataService>(baseUrl, httpClient, objectMapper, DataService::class.java) {

    fun getUpcomingRocketLaunches(): Single<UpcomingRocketLaunches> =
        service.getUpcomingRocketLaunches(MAX_ROCKET_LAUNCHES)

    companion object {
        private const val MAX_ROCKET_LAUNCHES = 50
    }
}