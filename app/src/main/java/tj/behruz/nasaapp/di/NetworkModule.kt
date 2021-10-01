package tj.behruz.nasaapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tj.behruz.nasaapp.data.sourse.remote.NasaApi
import tj.behruz.nasaapp.domain.extension.Constants
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideHttpLogger():HttpLoggingInterceptor{
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideGsonConvertorFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(1,TimeUnit.MINUTES)
            .callTimeout(1,TimeUnit.MINUTES)
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient,converterFactory: GsonConverterFactory):Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .baseUrl(Constants.baseUrl)
            .build()
    }

    @Provides
    fun provideNasaApi(retrofit: Retrofit): NasaApi {
        return retrofit.create(NasaApi::class.java)
    }


}