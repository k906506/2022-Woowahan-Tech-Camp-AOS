package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class Menus(
    @SerializedName("franchisePromotionId") val franchisePromotionId: Int = -1,
    @SerializedName("menuId") val menuId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("images") val images: List<Images>? = null,
    @SerializedName("description") val description: String = "",
    @SerializedName("best") val best: Boolean = false,
    @SerializedName("liquor") val liquor: Boolean = false,
    @SerializedName("soldOut") val soldOut: Boolean = false,
    @SerializedName("badges") val badges: List<Badges>? = null,
    @SerializedName("menuPrices") val menuPrices: List<MenuPrices>,
    @SerializedName("optionGroups") val optionGroups: List<OptionGroups>? = null
)
