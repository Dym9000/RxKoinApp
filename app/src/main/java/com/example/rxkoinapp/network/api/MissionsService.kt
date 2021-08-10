package com.example.rxkoinapp.network.api

import com.example.rxkoinapp.network.dto.MissionDto
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface MissionsService {

    @GET("missions")
    fun getMissions(): Flowable<List<MissionDto>>

}