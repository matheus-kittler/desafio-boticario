package kittler.matheus.test.model

import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class Message(
    @SerializedName("content") var content : String?,
    @SerializedName("created_at") var created_at : String?
) {
    fun bindDateHour() : String? {
        val dateTime: ZonedDateTime = ZonedDateTime.parse(created_at)
        return dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a"))
    }
}