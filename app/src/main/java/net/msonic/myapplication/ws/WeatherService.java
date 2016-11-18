package net.msonic.myapplication.ws;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by manuelzegarra on 11/17/16.
 */

public interface WeatherService {

    //http://api.openweathermap.org/data/2.5/weather?q=London&id=524901&APPID=07145f4ed38d2dd403e363c86f40054a
    @GET("weather?id=524901&APPID=07145f4ed38d2dd403e363c86f40054a")
    rx.Observable<WeatherData> query(@Query("q") String city);

}
