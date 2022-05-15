package com.test.woowahan.data

import com.google.gson.annotations.SerializedName

data class DeliveryTipInfo(
    @SerializedName("deliveryTipPrice") val deliveryTipPrice: String,
    @SerializedName("deliveryTipChargePhrase") val deliveryTipChargePhrase: String
)
