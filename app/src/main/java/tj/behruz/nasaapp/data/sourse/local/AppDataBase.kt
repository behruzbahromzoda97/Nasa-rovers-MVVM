package tj.behruz.nasaapp.data.sourse.local

import androidx.room.Database
import androidx.room.RoomDatabase
import tj.behruz.nasaapp.data.sourse.local.dao.PhotoDao
import tj.behruz.nasaapp.domain.models.NasaImages

@Database(entities = [NasaImages::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract val photoDao: PhotoDao

    companion object {
        const val DB_NAME = "NasaApp.db"
    }
}