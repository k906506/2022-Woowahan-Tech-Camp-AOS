package com.test.woowahan.request

import com.test.woowahan.data.ResponseBody
import retrofit2.http.GET

interface Service {

    @GET("2022_wooah_app")
    suspend fun requestData(): ResponseBody
}