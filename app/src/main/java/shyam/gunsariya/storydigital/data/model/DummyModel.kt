package shyam.gunsariya.storydigital.data.model

import com.google.gson.annotations.SerializedName

//model class
data class DummyModel(
    @SerializedName("data")
    val data: List<Data>
) {
    data class Data(
        @SerializedName("id")
        val id: String,
        @SerializedName("text")
        val text: String
    )
}