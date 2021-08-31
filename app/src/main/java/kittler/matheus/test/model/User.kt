package kittler.matheus.test.model

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("name") var name : String?,
    @SerializedName("profile_picture") var photo : String?,
    val post : String?,
    val date: String?
)