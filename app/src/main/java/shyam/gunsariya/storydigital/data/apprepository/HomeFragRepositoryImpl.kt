package shyam.gunsariya.storydigital.data.apprepository

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import shyam.gunsariya.storydigital.data.model.DummyModel
import shyam.gunsariya.storydigital.data.repository.HomeRepository

class HomeFragRepositoryImpl(private val repository: HomeFragRepository): HomeRepository {
    override fun getDummyData(): Call<String> {
        return repository.getDummyData()
    }
}