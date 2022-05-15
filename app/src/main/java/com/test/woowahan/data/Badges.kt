package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class Badges(
    @SerializedName("text") val text: String,
    @SerializedName("supportOffline") val supportOffline: Boolean,
    @SerializedName("background") val background: Background,
    @SerializedName("border") val border: Background,
    @SerializedName("font") val font: Background
)
