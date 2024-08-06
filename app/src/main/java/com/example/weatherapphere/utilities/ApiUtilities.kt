package  com.example.weatherapphere.utilities

import  com.example.weatherapphere.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilities {
    fun getInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(Constants.baseUrl).
        addConverterFactory(GsonConverterFactory.create()).build()
    }
}