package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int
)
