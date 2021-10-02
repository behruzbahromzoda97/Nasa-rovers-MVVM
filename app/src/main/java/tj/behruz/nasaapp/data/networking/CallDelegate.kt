/*
 * *
 *  * Created by Behruz Bahromzoda on 5/2/21 12:01 AM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 5/2/21 12:01 AM
 *
 */

package tj.amvol.data.networking

import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal abstract class CallDelegate<In, Out>(protected val proxy: Call<In>) : Call<Out> {

    override fun execute(): Response<Out> = throw NotImplementedError()

    final override fun enqueue(callback: Callback<Out>) = enqueueImpl(callback)

    final override fun clone(): Call<Out> = cloneImpl()

    override fun cancel() = proxy.cancel()

    override fun request(): Request = proxy.request()

    override fun isExecuted() = proxy.isExecuted

    override fun isCanceled() = proxy.isCanceled

    abstract fun enqueueImpl(callback: Callback<Out>)

    abstract fun cloneImpl(): Call<Out>
}