package it.unimol.appex.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weapon {

    @SerializedName("ID_weapon")
    @Expose
    private int idWeapon;

    @SerializedName("Nome_arma")
    @Expose
    private String nameWeapon;

    @SerializedName("Descrizione")
    @Expose
    private String descriptionWeapon;

    @SerializedName("Tipo")
    @Expose
    private String typeWeapon;

    @SerializedName("Modalita_fuoco")
    @Expose
    private String fireModWeapon;

    @SerializedName("Hop_up")
    @Expose
    private String hopupWeapon;

    @SerializedName("Tipo_munizioni")
    @Expose
    private String ammoWeapon;

    @SerializedName("Danni_per_colpo")
    @Expose
    private int damageWeapon;

    @SerializedName("Img_weap")
    @Expose
    private String imgWeapon;

    @SerializedName("rarita_heirloom")
    @Expose
    private int rarityWeapon;

    @SerializedName("ID_legends")
    @Expose
    private int legendWeapon;

    //no
    public int getIdWeapon() {
        return idWeapon;
    }
    //si aggiungere descrizione.
    public String getNameWeapon() {
        return nameWeapon;
    }

    public String getDescriptionWeapon() {
        return descriptionWeapon;
    }

    //si
    public String getTypeWeapon() {
        return typeWeapon;
    }
    //si
    public String getFireModWeapon() {
        return fireModWeapon;
    }
    //si
    public String getHopupWeapon() {
        return hopupWeapon;
    }
    //si
    public String getAmmoWeapon() {
        return ammoWeapon;
    }
    //si
    public int getDamageWeapon() {
        return damageWeapon;
    }
    //si
    public String getImgWeapon() {
        return imgWeapon;
    }
//si
    public int getRarityWeapon() {
        return rarityWeapon;
    }
    //no
    public int getLegendWeapon() {
        return legendWeapon;
    }
}
