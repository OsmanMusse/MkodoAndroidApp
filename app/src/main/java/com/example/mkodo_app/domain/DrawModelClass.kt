package com.example.mkodo_app.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class DrawModelClass(
    val id: String,
    val drawDate:String,
    val number1: Int,
    val number2: Int,
    val number3: Int,
    val number4: Int,
    val number5: Int,
    val number6: Int,
    @SerializedName("bonus-ball") val bonusBall: Int,
    val topPrize: Long
) : Parcelable
