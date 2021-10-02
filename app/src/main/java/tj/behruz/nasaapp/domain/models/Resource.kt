/*
 *
 *  * Created by Behruz on 10/2/21, 11:53 AM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 10/2/21, 11:53 AM
 *
 */

package tj.behruz.nasaapp.domain.models

sealed class Resource {

    class Success<T>(val date: T): Resource()
    object Loading: Resource()
    class Error(val err:Throwable):Resource()

}