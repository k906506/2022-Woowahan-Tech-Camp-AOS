package com.test.woowahan.repo

import com.test.woowahan.request.ApiRequestFactory

class RequestRepository {
    suspend fun requestData() = ApiRequestFactory.retrofit.requestData()
}