/*
 *
 *  * Created by Behruz on 10/1/21, 2:48 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 10/1/21, 2:39 PM
 *
 */

package tj.behruz.nasaapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nasaimages")
data class NasaImages(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    val date:String,
    val explanation:String,
    val hdurl:String,
    val media_type:String,
    val service_version:String,
    val title:String,
    val url:String
)