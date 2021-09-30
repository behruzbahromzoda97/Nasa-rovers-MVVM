package tj.behruz.nasaapp.data.sourse.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {

    @GET("apod")
    suspend fun getNasaImages(@Query("api_key") apiKey:String,@Query("count") count:Int)

}