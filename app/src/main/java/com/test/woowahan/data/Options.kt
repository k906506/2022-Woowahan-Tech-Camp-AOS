package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class Options(
    @SerializedName("optionId") val optionId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("discountPrice") val discountPrice: Int,
    @SerializedName("price") val price: Int,
    @SerializedName("soldOut") val soldOut: Boolean
)
