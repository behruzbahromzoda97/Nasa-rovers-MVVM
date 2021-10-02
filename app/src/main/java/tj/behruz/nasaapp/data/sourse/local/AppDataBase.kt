/*
 *
 *  * Created by Behruz on 10/1/21, 2:48 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 10/1/21, 2:39 PM
 *
 */

package tj.behruz.nasaapp.data.sourse.local

import androidx.room.Database
import androidx.room.RoomDatabase
import tj.behruz.nasaapp.data.sourse.local.dao.NasaImagesDao
import tj.behruz.nasaapp.domain.models.NasaImages

@Database(entities = [NasaImages::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract val nasaImagesDao: NasaImagesDao

    companion object {
        const val DB_NAME = "NasaApp.db"
    }
}