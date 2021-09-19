package it.unimol.appex.ui.heirloom;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;

import it.unimol.appex.databinding.FragmentDetailBinding;
import it.unimol.appex.databinding.FragmentHeirloomBinding;
import it.unimol.appex.model.Heirloom;

public class HeirloomDetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Heirloom heirloom = new Gson().fromJson(getArguments()
                .getString("heirloomJson"), Heirloom.class);

        String pureBase64Encoded = heirloom.getImgHeirloom().substring(heirloom.getImgHeirloom()
                .indexOf(",") + 1);

        byte[] decodedString = Base64.decode(pureBase64Encoded, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        binding.imageDetail.setImageBitmap(decodedByte);

        binding.nameDetail.setText(heirloom.getNomeHeriloom());
        binding.descriptionDetail.setText(heirloom.getDescrizioneHeirloom());
        //binding.passiveDetail.set(heirloom.getIdLegends());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
