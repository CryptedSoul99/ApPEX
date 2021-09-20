package it.unimol.appex.ui.user;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import it.unimol.appex.R;
import it.unimol.appex.api.OfficalApiClient;
import it.unimol.appex.databinding.FragmentRankBinding;
import it.unimol.appex.databinding.FragmentUserBinding;
import it.unimol.appex.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragment extends Fragment{

    private FragmentUserBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentUserBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        String userName = getArguments().getString("userName");
        String platform = getArguments().getString("platform");
        Log.v("success", userName);
        Log.v("success", platform);

            loadUser(userName, platform);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void loadUser(String userName, String platform ){

        OfficalApiClient.getOfficialClient().getUser(OfficalApiClient.version,
                platform, userName, OfficalApiClient.auth)
                .enqueue(new Callback<User>() {
                             @Override
                             public void onResponse(Call<User> call,@NonNull Response<User> response) {
                                 if (response.body() != null) {
                                     Log.v("Chiamata", "Success");

                                     Picasso.get().load(response.body().globalJson.rankJson.rankImg).into(binding.userImage);
                                     binding.userName.setText(response.body().globalJson.userName);
                                     binding.platform.setText(response.body().globalJson.platform);
                                     binding.level.setText(String.valueOf(response.body().globalJson.level));
                                     binding.rankScore.setText(String.valueOf(response.body().globalJson.rankJson.rankScore));
                                     binding.rankName.setText(response.body().globalJson.rankJson.rankName);
                                     binding.rankScoreArena.setText(String.valueOf(response.body().globalJson.arenaJson.rankArenaScore));
                                     //binding.selectedLegends.setText(response.body().realtimeJson.selectedLegend);

                                     if (response.body().globalJson.arenaJson.rankArenaName != null){
                                         binding.rankNameArena.setText(response.body().globalJson.arenaJson.rankArenaName);
                                     }else
                                     {
                                         binding.rankNameArena.setText("Unknown");
                                     }

                                 }
                             }

                             @Override
                             public void onFailure(Call<User> call, Throwable t) {
                                 Log.v("Chiamata", "Falliment");
                                 t.printStackTrace();
                             }
                         }
                );
    }
}