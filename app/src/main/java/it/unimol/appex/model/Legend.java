package it.unimol.appex.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Legend {

    @SerializedName("ID_legends")
    @Expose
    private int idLegend;

    @SerializedName("Nome")
    @Expose
    private String nameLegend;

    @SerializedName("Passiva")
    @Expose
    private String passiveLegend;

    @SerializedName("Tattica")
    @Expose
    private String tatticsLegend;

    @SerializedName("Ultimate")
    @Expose
    private String ultimateLegend;

    @SerializedName("img_leg")
    @Expose
    private String imgLegends;

    public int getIdLegend() {
        return idLegend;
    }

    public String getNameLegend() {
        return nameLegend;
    }

    public String getPassiveLegend() {
        return passiveLegend;
    }

    public String getTatticsLegend() {
        return tatticsLegend;
    }

    public String getUltimateLegend() {
        return ultimateLegend;
    }

    public String getImgLegends() {
        return imgLegends;
    }
}
