package it.unimol.appex.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonalApiClient {
    public static LocalServicesInterface getLocalClient(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gitlabsfagnano.ddns.net:5000")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(LocalServicesInterface.class);
    }
}
