package it.unimol.appex.ui.heirloom;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import it.unimol.appex.api.LocalApiClient;
import it.unimol.appex.databinding.FragmentSlideshowBinding;
import it.unimol.appex.model.Heirloom;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeirloomFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;

        LocalApiClient.getLocalClient().listHeirloom().enqueue(new Callback<List<Heirloom>>() {
            @Override
            public void onResponse(Call<List<Heirloom>> call, Response<List<Heirloom>> response) {
                Log.v("Chiamata", "Success");
            }

            @Override
            public void onFailure(Call<List<Heirloom>> call, Throwable t) {
                Log.v("Chiamata", "Falliment");
                t.printStackTrace();
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}