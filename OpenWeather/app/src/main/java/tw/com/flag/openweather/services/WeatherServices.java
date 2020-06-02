package tw.com.flag.openweather.services;

import models.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherServices {
    @GET("{lat},{lon}")
    Call<Weather> getWeather(@Path("lat") double lat,@Path("lon") double lon);
}
