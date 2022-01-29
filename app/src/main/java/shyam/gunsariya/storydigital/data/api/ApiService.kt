package shyam.gunsariya.storydigital.data.api

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import shyam.gunsariya.storydigital.data.model.DummyModel




interface ApiService {

    @GET("/fjaqJ")
    fun getDummyData(): Call<String>
}