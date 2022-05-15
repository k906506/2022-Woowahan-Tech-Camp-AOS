package com.test.woowahan.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class ResponseBody(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("serverDatetime") val serverDatetime: String,
    @SerializedName("data") val data: Data,
)
