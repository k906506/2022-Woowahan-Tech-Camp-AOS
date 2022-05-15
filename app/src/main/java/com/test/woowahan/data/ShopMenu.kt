package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class ShopMenu(
    @SerializedName("groupMenus") val groupMenus: List<GroupMenus>
)
