package com.example.rxkoinapp.utils

data class DataState<T>(val state: DataStateType, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): DataState<T> {
            return DataState(DataStateType.SUCCESS, data, null)
        }

        fun <T> error(data: T?, errorMessage: String?): DataState<T> {
            return DataState(DataStateType.ERROR, data, errorMessage)
        }
    }

}