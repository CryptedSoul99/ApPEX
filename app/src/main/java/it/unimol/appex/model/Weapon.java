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

    public int getIdWeapon() {
        return idWeapon;
    }

    public String getNameWeapon() {
        return nameWeapon;
    }

    public String getTypeWeapon() {
        return typeWeapon;
    }

    public String getFireModWeapon() {
        return fireModWeapon;
    }

    public String getHopupWeapon() {
        return hopupWeapon;
    }

    public String getAmmoWeapon() {
        return ammoWeapon;
    }

    public int getDamageWeapon() {
        return damageWeapon;
    }

    public String getImgWeapon() {
        return imgWeapon;
    }

    public int getRarityWeapon() {
        return rarityWeapon;
    }

    public int getLegendWeapon() {
        return legendWeapon;
    }
}
