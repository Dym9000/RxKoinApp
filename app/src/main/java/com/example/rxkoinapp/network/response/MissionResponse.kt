package com.example.rxkoinapp.network.response

import com.example.rxkoinapp.network.dto.MissionDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MissionResponse(
    @SerializedName("missions")
    @Expose
    val missions: List<MissionDto>
)
