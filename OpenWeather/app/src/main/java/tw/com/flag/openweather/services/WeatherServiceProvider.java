package tw.com.flag.openweather.services;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import models.Currently;
import models.Weather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tw.com.flag.openweather.MainActivity;
import tw.com.flag.openweather.events.ErrorEvent;
import tw.com.flag.openweather.events.WeatherEvent;

public class WeatherServiceProvider {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Retrofit retrofit;
    private static final String Base_URL = "https://api.darksky.net/forecast/7e87d17a004526d5f1ff090ae5eb689e/";

    private Retrofit getRetrofit() {
        if (this.retrofit == null) {
            this.retrofit = new Retrofit.Builder()
                    .baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return this.retrofit;
    }


    public void getWeatherServices(double lat, double lon) {
        WeatherServices weatherServices = getRetrofit().create(WeatherServices.class);
        Call<Weather> weatherData = weatherServices.getWeather(lat,lon);
        weatherData.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Weather weather = response.body();
                if(response!=null) {
                    Currently currently = weather.getCurrently();
                    Log.e(TAG, "Temperature = " + currently.getTemperature());
                    EventBus.getDefault().post(new WeatherEvent(weather));
                }else{
                    Log.e(TAG, "No response. Check security key.");
                    EventBus.getDefault().post(new ErrorEvent("No weather data available"));
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.e(TAG, "onFailure : Unable to get weather data.");
                EventBus.getDefault().post(new ErrorEvent("Unable to connect weather server"));
            }
        });
    }
}


