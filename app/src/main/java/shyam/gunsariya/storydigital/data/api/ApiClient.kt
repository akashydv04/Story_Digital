package shyam.gunsariya.storydigital.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object ApiClient {

    private var retrofit: Retrofit? = null

    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    fun getClient(): ApiService? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://git.io")
                .build()
        }
        return retrofit?.create(ApiService::class.java)
    }

}