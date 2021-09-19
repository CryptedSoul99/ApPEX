package it.unimol.appex.api;

import it.unimol.appex.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OfficialServicesInterface {
    @GET("bridge")
    Call<User> getUser(@Query("version") int version,@Query("platform") String platform,
                       @Query("player") String player,@Query("auth") String auth);
}
