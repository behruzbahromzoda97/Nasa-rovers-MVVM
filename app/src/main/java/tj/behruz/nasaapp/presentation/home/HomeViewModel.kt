/*
 *
 *  * Created by Behruz on 10/1/21, 6:09 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 10/1/21, 6:09 PM
 *
 */

package tj.behruz.nasaapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import tj.behruz.nasaapp.domain.models.Resource
import tj.behruz.nasaapp.domain.repositories.NasaRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val nasaRepositoryImpl: NasaRepositoryImpl): ViewModel() {

    val images = MutableLiveData<Resource>()

    init {
        viewModelScope.launch {
            images.postValue(nasaRepositoryImpl.getNasaImages())
        }

    }


}