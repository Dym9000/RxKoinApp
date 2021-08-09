package com.example.rxkoinapp.di

import com.example.rxkoinapp.network.mapper_dto.MissionDtoMapper
import com.example.rxkoinapp.utils.mapper.GenericMapper
import org.koin.dsl.module

val missionDtoMapperModule = module {
    single <GenericMapper<*,*>>{MissionDtoMapper()}
}