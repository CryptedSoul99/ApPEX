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

        loadUser();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void loadUser(){
        OfficalApiClient.getOfficialClient().getUser(OfficalApiClient.version,
                "PS4", "Crypted_Soul99", OfficalApiClient.auth)
                .enqueue(new Callback<User>() {
                             @Override
                             public void onResponse(Call<User> call,@NonNull Response<User> response) {
                                 if (response.body() != null) {
                                     Log.v("Chiamata", "Success");
                                     Log.v("Chiamata", response.body().globalJson.rankJson.rankName);

                                     binding.userName.setText(response.body().globalJson.userName);
                                     binding.level.setText(String.valueOf(response.body().globalJson.level));
                                     Picasso.get().load(response.body().globalJson.rankJson.rankImg).into(binding.userImage);
                                 /*binding.userName.setText(response.body().globalJson.userName);
                                 binding.userName.setText(response.body().globalJson.userName);
                                 binding.userName.setText(response.body().globalJson.userName);
                                 binding.userName.setText(response.body().globalJson.userName);
                                 binding.userName.setText(response.body().globalJson.userName);
                                 binding.userName.setText(response.body().globalJson.userName);*/
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