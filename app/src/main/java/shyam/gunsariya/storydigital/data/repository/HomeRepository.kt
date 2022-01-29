package shyam.gunsariya.storydigital.data.repository

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import shyam.gunsariya.storydigital.data.model.DummyModel

interface HomeRepository {
    fun getDummyData(): Call<String>
}