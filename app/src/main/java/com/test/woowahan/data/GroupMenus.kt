package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class GroupMenus(
    @SerializedName("menuGroupId") val menuGroupId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("folded") val folded: Boolean,
    @SerializedName("menus") val menus: List<Menus>

)
