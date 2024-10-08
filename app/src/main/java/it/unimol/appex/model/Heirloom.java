package it.unimol.appex.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Heirloom {
    @SerializedName("ID_heirloom")
    @Expose
    private int idHeirloom;

    @SerializedName("ID_legends")
    @Expose
    private int idLegends;

    @SerializedName("Nome_heirloom")
    @Expose
    private String nomeHeriloom;

    @SerializedName("Descrizione")
    @Expose
    private String descrizioneHeirloom;

    @SerializedName("img")
    @Expose
    private String imgHeirloom;

    @SerializedName("Nome")
    @Expose
    private String nomeLeggenda;

    public int getIdHeirloom() {
        return idHeirloom;
    }

    public int getIdLegends() {
        return idLegends;
    }

    public String getNomeHeriloom() {
        return nomeHeriloom;
    }

    public String getDescrizioneHeirloom() {
        return descrizioneHeirloom;
    }

    public String getImgHeirloom() {
        return imgHeirloom;
    }

    public String getNomeLeggenda() {
        return nomeLeggenda;
    }
}
