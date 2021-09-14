package it.unimol.appex.ui.legends;

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
import it.unimol.appex.adapters.LegendsAdapter;
import it.unimol.appex.api.LocalApiClient;
import it.unimol.appex.databinding.FragmentHeirloomBinding;
import it.unimol.appex.databinding.FragmentLegendsBinding;
import it.unimol.appex.model.Heirloom;
import it.unimol.appex.model.Legend;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LegendsFragment extends Fragment {

    private FragmentLegendsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLegendsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.legendsList.setHasFixedSize(true);
        binding.legendsList.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.legendsList.addItemDecoration(new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL));

        loadLegend();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void loadLegend() {
        LocalApiClient.getLocalClient().listLegends().enqueue(new Callback<List<Legend>>() {
            @Override
            public void onResponse(Call<List<Legend>> call, Response<List<Legend>> response) {
                Log.v("Chiamata", "Success");
                binding.legendsList.setAdapter(new LegendsAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<Legend>> call, Throwable t) {
                Log.v("Chiamata", "Falliment");
                t.printStackTrace();
            }
        });
    }
}