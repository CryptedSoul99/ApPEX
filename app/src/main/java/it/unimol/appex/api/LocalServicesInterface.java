package it.unimol.appex.api;

import java.util.List;

import it.unimol.appex.model.Heirloom;
import it.unimol.appex.model.Legends;
import it.unimol.appex.model.Rank;
import it.unimol.appex.model.Weapon;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LocalServicesInterface {
    @GET("heirloom")
    Call<List<Heirloom>> listHeirloom();

    @GET("legends")
    Call<List<Legends>> listLegends();

    @GET("/weapon")
    Call<List<Weapon>> listWeapon();

    @GET("/rank")
    Call<List<Rank>> listRank();
}
