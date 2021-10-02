/*
 *
 *  * Created by Behruz on 10/1/21, 4:42 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 10/1/21, 4:42 PM
 *
 */

package tj.behruz.nasaapp.data.repositories

import kotlinx.coroutines.flow.FlowCollector
import tj.behruz.nasaapp.domain.models.Resource

interface NasaRepository {

    suspend fun getNasaImages(): FlowCollector<Resource>
}