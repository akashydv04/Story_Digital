package shyam.gunsariya.storydigital.data.apprepository

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import shyam.gunsariya.storydigital.data.api.ApiService
import shyam.gunsariya.storydigital.data.model.DummyModel

class HomeFragRepository(private val apiService: ApiService) {
    fun getDummyData(): Call<String> {
        return apiService.getDummyData()
    }
}