package shyam.gunsariya.storydigital.data.repository

import retrofit2.Call

// home repository interface
interface HomeRepository {
    fun getDummyData(): Call<String>
}