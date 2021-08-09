package com.example.rxkoinapp.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MissionDto(

    @SerializedName("mission_name")
    @Expose
    val missionName: String? = null,

    @SerializedName("mission_id")
    @Expose
    val missionId: String? = null,

    @SerializedName("manufacturers")
    @Expose
    val manufacturers: List<String>? = null,

    @SerializedName("payload_ids")
    @Expose
    val payloadIds: List<String>? = null,

    @SerializedName("wikipedia")
    @Expose
    val wikipedia: String? = null,

    @SerializedName("website")
    @Expose
    val website: String? = null,

    @SerializedName("twitter")
    @Expose
    val twitter: String? = null,

    @SerializedName("description")
    @Expose
    val description: String? = null
)
