package tj.behruz.nasaapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tj.behruz.nasaapp.data.sourse.local.AppDatabase
import tj.behruz.nasaapp.data.sourse.local.dao.PhotoDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).allowMainThreadQueries().build()
    }


    @Provides
    internal fun providePhotoDao(appDatabase: AppDatabase): PhotoDao {
        return appDatabase.photoDao
    }


}