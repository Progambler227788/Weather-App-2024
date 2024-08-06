package com.example.weatherapphere.utilities

import com.example.weatherapphere.models.ForecastResponse
import  com.example.weatherapphere.models.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("weather")
    suspend fun getCurrentWeatherData(
        @Query("lat") lat:String,
        @Query("lon") lon:String,
        @Query("APPID") appid:String
    ): Response<WeatherModel>  // Call<>


 @GET("weather")
 suspend fun getCityWeather(  @Query("q") q:String,
                              @Query("APPID") appid:String
 ) : Response<WeatherModel>



    @GET("forecast")
    suspend fun getHourlyForecast(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String
    ): Response<ForecastResponse>


    @GET("forecast")
    suspend fun getHourlyForecastForCity(
        @Query("q") q:String,
        @Query("APPID") appid: String
    ): Response<ForecastResponse>
}