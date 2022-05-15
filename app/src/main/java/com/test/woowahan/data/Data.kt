package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("shopInfo") val shopInfo: ShopInfo,
    @SerializedName("shopMenu") val shopMenu: ShopMenu
)
