package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class MenuPrices(
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: String,
    @SerializedName("priceWithoutDiscount") val priceWithoutDiscount: String
)