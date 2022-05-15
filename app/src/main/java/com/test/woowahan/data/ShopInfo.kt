package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class ShopInfo(
    @SerializedName("shopNumber") val shopNumber: String,
    @SerializedName("shopName") val shopName: String,
    @SerializedName("headerImages") val headerImages: List<Images>,
    @SerializedName("statisticsInfo") val statisticsInfo: StatisticsInfo,
    @SerializedName("orderCondition") val orderCondition: OrderCondition,
    @SerializedName("deliveryTimeInfo") val deliveryTimeInfo: DeliveryTimeInfo,
    @SerializedName("deliveryTipInfo") val deliveryTipInfo: DeliveryTipInfo
)
