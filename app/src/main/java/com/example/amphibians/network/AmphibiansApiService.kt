package com.example.amphibians.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com/amphibians"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface AmphibiansApiService {
    @GET("Amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}

object AmphibiansApi {
    val retrofitService: AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }
}