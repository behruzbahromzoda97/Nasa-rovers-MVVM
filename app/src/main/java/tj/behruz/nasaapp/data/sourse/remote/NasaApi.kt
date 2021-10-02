/*
 *
 *  * Created by Behruz on 10/1/21, 2:48 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 10/1/21, 2:39 PM
 *
 */

package tj.behruz.nasaapp.data.sourse.remote

import retrofit2.http.GET
import retrofit2.http.Query
import tj.behruz.nasaapp.data.networking.Result
import tj.behruz.nasaapp.domain.models.NasaImages

interface NasaApi {

    @GET("apod")
    suspend fun getNasaImages(@Query("api_key") apiKey: String, @Query("count") count: Int): Result<List<NasaImages>>

}