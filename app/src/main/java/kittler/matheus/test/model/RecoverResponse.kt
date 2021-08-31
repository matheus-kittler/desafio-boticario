package kittler.matheus.test.model

import com.google.gson.annotations.SerializedName

class RecoverResponse(
    @SerializedName("news") val news: List<Recover>
)