package it.unimol.appex.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OfficalApiClient {
    public static final int version = 5;
    public static final String auth = "ZLuvr8EyVaoMj6N6G2Xk";

    public static OfficialServicesInterface getOfficialClient(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mozambiquehe.re/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(OfficialServicesInterface.class);
    }
}
