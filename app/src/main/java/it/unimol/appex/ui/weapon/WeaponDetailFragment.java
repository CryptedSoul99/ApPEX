package it.unimol.appex.ui.weapon;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import it.unimol.appex.databinding.FragmentWeaponDetailBinding;
import it.unimol.appex.model.Weapon;

public class WeaponDetailFragment extends Fragment {

    private FragmentWeaponDetailBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentWeaponDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Weapon weapon = new Gson().fromJson(getArguments()
                .getString("weaponJson"), Weapon.class);

        String pureBase64Encoded = weapon.getImgWeapon().substring(weapon.getImgWeapon()
                .indexOf(",")  + 1);

        byte[] decodedString = Base64.decode(pureBase64Encoded, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        binding.imageWeaponDetail.setImageBitmap(decodedByte);
        binding.nameDetail.setText(weapon.getNameWeapon());
        binding.descriptionDetail.setText(weapon.getDescriptionWeapon());
        binding.ammoTypeDetail.setText(weapon.getAmmoWeapon());
        binding.damageDetail.setText(String.valueOf(weapon.getDamageWeapon()));
        binding.fireModDetail.setText(weapon.getFireModWeapon());
        binding.hopUpDetail.setText(weapon.getHopupWeapon());
        binding.TypeDetail.setText(weapon.getTypeWeapon());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}