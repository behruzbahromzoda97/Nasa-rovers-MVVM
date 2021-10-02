/*
 *
 *  * Created by Behruz on 10/1/21, 2:48 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 10/1/21, 2:39 PM
 *
 */

package tj.behruz.nasaapp.data.sourse.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import tj.behruz.nasaapp.domain.models.NasaImages

@Dao
interface NasaImagesDao {

    @Query("Select * from nasaimages")
    fun getNasaImages(): List<NasaImages>

    @Insert
    fun insert(images:List<NasaImages>)


}