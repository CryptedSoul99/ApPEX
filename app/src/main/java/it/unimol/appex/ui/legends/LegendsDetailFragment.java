package it.unimol.appex.ui.legends;

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

import it.unimol.appex.databinding.FragmentDetailBinding;
import it.unimol.appex.model.Legend;

public class LegendsDetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Legend legend = new Gson().fromJson(getArguments()
                .getString("legendJson"), Legend.class);

        String pureBase64Encoded = legend.getImgLegends().substring(legend.getImgLegends()
                .indexOf(",")  + 1);

        byte[] decodedString = Base64.decode(pureBase64Encoded, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        binding.imageDetail.setImageBitmap(decodedByte);
        binding.nameDetail.setText(legend.getNameLegend());
        binding.descriptionDetail.setText(legend.getDescriptionLegend());
        binding.tacticalDetail.setText(legend.getTatticsLegend());
        binding.ultimateDetail.setText(legend.getUltimateLegend());
        binding.passiveDetail.setText(legend.getPassiveLegend());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}