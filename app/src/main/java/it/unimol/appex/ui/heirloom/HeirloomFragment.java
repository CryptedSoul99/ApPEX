package it.unimol.appex.ui.heirloom;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import it.unimol.appex.adapters.HeirloomsAdapter;
import it.unimol.appex.api.LocalApiClient;
import it.unimol.appex.databinding.FragmentHeirloomBinding;
import it.unimol.appex.model.Heirloom;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeirloomFragment extends Fragment {

    private FragmentHeirloomBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHeirloomBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.heirloomList.setHasFixedSize(true);
        binding.heirloomList.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.heirloomList.addItemDecoration(new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL));

        loadHeirloom();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void loadHeirloom() {
        LocalApiClient.getLocalClient().listHeirloom().enqueue(new Callback<List<Heirloom>>() {
            @Override
            public void onResponse(Call<List<Heirloom>> call, Response<List<Heirloom>> response) {
                Log.v("Chiamata", "Success");
                binding.heirloomList.setAdapter(new HeirloomsAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<Heirloom>> call, Throwable t) {
                Log.v("Chiamata", "Falliment");
                t.printStackTrace();
            }
        });
    }
}