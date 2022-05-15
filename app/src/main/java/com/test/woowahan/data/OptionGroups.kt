package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class OptionGroups(
    @SerializedName("optionGroupId") val optionGroupId : Int,
    @SerializedName("name") val name : String,
    @SerializedName("minOrderableQuantity") val minOrderAbleQuantity : Int,
    @SerializedName("maxOrderableQuantity") val maxOrderAbleQuantity : Int,
    @SerializedName("options") val options : List<Options>
)
