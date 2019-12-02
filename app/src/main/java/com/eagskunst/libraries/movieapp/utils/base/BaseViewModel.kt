package com.eagskunst.libraries.movieapp.utils.base

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kinesis.kinesisapp.utils.base.ScreenState

/**
 * Created by eagskunst in 1/12/2019.
 */
abstract class BaseViewModel : ViewModel(), RemoteErrorEmitter {

    val mutableProgress = MutableLiveData<Int>(View.GONE)
    val mutableScreenState = MutableLiveData<ScreenState>()
    val mutableErrorMessage = MutableLiveData<String>()
    val mutableSuccessMessage = MutableLiveData<String>()
    val mutableErrorType = MutableLiveData<ErrorType>()


    override fun onError(errorType: ErrorType) {
        mutableErrorType.postValue(errorType)
    }

    override fun onError(msg: String) {
        mutableErrorMessage.postValue(msg)
    }

}