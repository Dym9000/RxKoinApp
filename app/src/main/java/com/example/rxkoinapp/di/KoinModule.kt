package com.example.rxkoinapp.di

import com.example.rxkoinapp.network.api.MissionsService
import com.example.rxkoinapp.network.mapper_dto.MissionDtoMapper
import com.example.rxkoinapp.ui.missions_display.MissionDisplayViewModel
import com.example.rxkoinapp.utils.mapper.GenericMapper
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val baseUrl = "https://api.spacexdata.com/v3/"

val viewModelModule = module{
    viewModel { MissionDisplayViewModel(get(), get())}
}

val missionDtoMapperModule = module {
    single <GenericMapper<*,*>>{MissionDtoMapper()}
}

val missionServiceModule = module {
    fun provideMissionService(): MissionsService{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(MissionsService::class.java)
    }
    single {provideMissionService()}
}

val compositeDisposable = module {
    fun provideCompositeDisposable(): CompositeDisposable{
        return CompositeDisposable()
    }
    single {provideCompositeDisposable()}
}