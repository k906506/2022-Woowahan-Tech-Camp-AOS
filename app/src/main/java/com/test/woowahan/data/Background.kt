package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class Background(
    @SerializedName("color") val color: String,
    @SerializedName("alpha") val alpha: String
)