package tw.com.flag.openweather.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntConsumer;

import tw.com.flag.openweather.R;

public class WeatherIconUtil {
    public static final Map<String,Integer> ICONS;
    static {
        Map<String,Integer> iconMap = new HashMap<>();
        iconMap.put("clear-day", R.drawable.ic_clear_day);
        iconMap.put("clear-night", R.drawable.ic_clear_night);
        iconMap.put("cloudy", R.drawable.ic_cloudy);
        iconMap.put("fog", R.drawable.ic_fog);
        iconMap.put("partly-cloudy-day", R.drawable.ic_partly_cloudy_day);
        iconMap.put("partly-cloudy-night", R.drawable.ic_partly_cloudy_night);
        iconMap.put("rain", R.drawable.ic_rain);
        iconMap.put("sleet", R.drawable.ic_sleet);
        iconMap.put("snow", R.drawable.ic_snow);
        iconMap.put("thunderstorm", R.drawable.ic_thunderstorm);
        iconMap.put("wind", R.drawable.ic_wind);

        ICONS = Collections.unmodifiableMap(iconMap);
    }



}
