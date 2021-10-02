/*
 *
 *  * Created by Behruz on 10/1/21, 4:41 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 10/1/21, 4:41 PM
 *
 */

package tj.behruz.nasaapp.domain.repositories

import tj.behruz.nasaapp.data.networking.Result
import tj.behruz.nasaapp.data.sourse.local.dao.NasaImagesDao
import tj.behruz.nasaapp.data.sourse.remote.NasaApi
import tj.behruz.nasaapp.domain.extension.Constants
import tj.behruz.nasaapp.domain.models.NasaImages
import tj.behruz.nasaapp.domain.models.Resource
import javax.inject.Inject

class NasaRepositoryImpl @Inject constructor(private val nasaApi: NasaApi, private val nasaImagesDao: NasaImagesDao) {

    private var localDate: List<NasaImages> = nasaImagesDao.getNasaImages()


    suspend fun getNasaImages(): Resource {
        return if (localDate.isEmpty()) {
            when (val remoteMessage = nasaApi.getNasaImages(Constants.key, 20)) {
                is Result.Success -> {
                    nasaImagesDao.insert(remoteMessage.value)
                    Resource.Success(remoteMessage.value)

                }
                else -> {
                    Resource.Loading
                }
            }

        } else {
            Resource.Success(localDate)
        }

    }

}