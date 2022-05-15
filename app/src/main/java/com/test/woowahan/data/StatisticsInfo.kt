package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class StatisticsInfo(
    @SerializedName("starAveragePoint") val starAveragePoint: Double,
    @SerializedName("reviewCountLatest") val reviewCountLatest: Int,
    @SerializedName("shopPhoneNumber") val shopPhoneNumber: String,
    @SerializedName("favorite") val favorite: Boolean
)
