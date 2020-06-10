# OpenWeather App  

  
## Introduction  
This is a RESTful API client app which receives the current weather of Taipei.  
It contains the MVC design pattern concept, and the way of refracting the code.   
In the project, I built a weather forecast app using a service called DarkSky API.  
And here are some libraries I used  
  
**1. [Retrofit](https://square.github.io/retrofit/):** 
 *To get response from an ApI sever.  
 *A HTTP client for Android and Java.  
 *Retrofit turns HTTP API into Java interface.   
    
**2. [ButterKnife](https://jakewharton.github.io/butterknife/):**  
 *To access and update UI easily from the code.  
 *ButterKnife bind Android views and callbacks to the fields and methods.  
 *Eliminate the findViewById calls by using @BindView annotations on fields.  
   
**3. [EventBus](https://github.com/greenrobot/EventBus):**  
 *To simplify communication betwwen various Android components.  
 *Especially dealing with Service and Activity.  
 *EventBus uses publisher/subscriber pattern.  
 *It decouples event senders and recievers.  
    
## API structure of data  
In DarkSkyAPI, the structure of the data response is JSON.  
I went to the webside [JSON to POJO](http://www.jsonschema2pojo.org/)   
It can convert raw JSON string into Plain Old Java Objects, which is also known as POJO.  
The annotation would be GSON, so we need to import GSON in gradle.[GSON](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.7)  

  
    
## MVC design pattern   
**Model**  
In the model package, put the POJO data in it. (Currently.java, Weather.java).  
  
**View**  
It is the MainAvtivity.  
  
**Controller**  
I create a package called WeatherService, and it includes the :  
 *WeatherServiceProvider.java (create a Retrofit builder & converter)  
 *WeatherService.interface (Retrofit turns the HTTP API into a Java interface.)  
  
Another package called Event, and it includes the :
 *ErrorEvent(Fail to connect)    
 *WeatherEvent(Get the data and changing UI icon)  
     
  
## License

