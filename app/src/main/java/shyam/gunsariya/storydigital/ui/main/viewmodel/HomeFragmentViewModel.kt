package shyam.gunsariya.storydigital.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shyam.gunsariya.storydigital.data.model.DummyModel
import shyam.gunsariya.storydigital.data.repository.HomeRepository

class HomeFragmentViewModel(val repository: HomeRepository): ViewModel() {

    var listData : MutableLiveData<DummyModel> = MutableLiveData()

    fun getDummyData() {
        viewModelScope.launch {
            val result = repository.getDummyData()

            //api response
            result.enqueue(object: Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    val res = response.body()?.split("/")?.get(1)
                    val model : DummyModel? = Gson().fromJson(res,DummyModel::class.java)
                    listData.postValue(model)
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }

            })
        }
    }

}