package it.unimol.appex.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rank {

    @SerializedName("ID_rank")
    @Expose
    private int idRank;

    @SerializedName("Costo_ingresso")
    @Expose
    private int entryCostRank;

    @SerializedName("Punti_accesso")
    @Expose
    private String entryPointRank;

    @SerializedName("Lega")
    @Expose
    private String leagueRank;

    @SerializedName("Descrizione")
    @Expose
    private String descriptionRank;

    @SerializedName("Img_rank")
    @Expose
    private String imgRank;

    public int getIdRank() {
        return idRank;
    }

    public int getEntryCostRank() {
        return entryCostRank;
    }

    public String getEntryPointRank() {
        return entryPointRank;
    }

    public String getLeagueRank() {
        return leagueRank;
    }

    public String getDescriptionRank() {
        return descriptionRank;
    }

    public String getImgRank() {
        return imgRank;
    }
}
