package com.example.rxkoinapp.ui.missions_display

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxkoinapp.domain.Mission
import com.example.rxkoinapp.network.api.MissionsService
import com.example.rxkoinapp.utils.DataState
import com.example.rxkoinapp.utils.mapper.GenericMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 *    View Model handles the call to the retrofit service because all classes required for the call
 *    were supposed to be injected by Koin in the view model. Therefore there is no repository layer.
 *    in this project
 */

class MissionDisplayViewModel constructor(
    private val mapper: GenericMapper<Any,Any>,
    private val missionsService: MissionsService,
    ): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _missions = MutableLiveData<DataState<List<Mission>>>()
    val missions : LiveData<DataState<List<Mission>>>
    get(){
        return _missions
    }

    private fun setupMissionsFeed() {
        val missionsDisposable = missionsService.getMissions()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ missionsResponse ->
                val items = DataState.success(mapper.mapFromList(missionsResponse))
                _missions.value = items as DataState<List<Mission>>
            },
                { t -> DataState.error(null, "Error during fetching data: ${t.message}")}
        )
        compositeDisposable.add(missionsDisposable)
}

    init{
        setupMissionsFeed()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}