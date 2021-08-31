package kittler.matheus.test.model

import com.google.gson.annotations.SerializedName

data class  Recover(
    @SerializedName("user") val user : User?,
    @SerializedName("message") val message : Message?
)