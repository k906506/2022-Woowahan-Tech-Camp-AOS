package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class OrderCondition(
    @SerializedName("minimumOrderablePrice") val minimumOrderAblePrice: Int
)
