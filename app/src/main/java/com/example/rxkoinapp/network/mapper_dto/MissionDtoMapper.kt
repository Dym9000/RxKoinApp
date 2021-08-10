package com.example.rxkoinapp.network.mapper_dto

import com.example.rxkoinapp.domain.Mission
import com.example.rxkoinapp.network.dto.MissionDto
import com.example.rxkoinapp.utils.mapper.GenericMapper

class MissionDtoMapper: GenericMapper<MissionDto, Mission>() {

    override fun mapFrom(input: MissionDto): Mission {
        return Mission(
            missionName = input.missionName ?: NO_NAME,
            missionId = input.missionId.orEmpty(),
            website = input.website.orEmpty()
        )
    }

    override fun mapTo(input: Mission): MissionDto {
        return MissionDto(
            missionName = input.missionName,
            missionId = input.missionId,
            website = input.website
        )
    }

    companion object{
        const val NO_NAME = "Name not given yet"
    }

}