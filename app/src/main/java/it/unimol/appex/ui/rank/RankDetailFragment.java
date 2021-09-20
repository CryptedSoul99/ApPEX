package it.unimol.appex.ui.rank;

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
import it.unimol.appex.model.Rank;

public class RankDetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Rank rank = new Gson().fromJson(getArguments()
                .getString("rankJson"), Rank.class);

        String pureBase64Encoded = rank.getImgRank().substring(rank.getImgRank()
                .indexOf(",")  + 1);

        byte[] decodedString = Base64.decode(pureBase64Encoded, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        binding.imageDetail.setImageBitmap(decodedByte);

        binding.nameDetail.setText(rank.getLeagueRank());
        binding.descriptionDetail.setText(rank.getDescriptionRank());
        binding.tacticalDetail.setText(String.valueOf(rank.getEntryPointRank()));
        binding.passiveDetail.setText(String.valueOf(rank.getEntryCostRank()));


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}