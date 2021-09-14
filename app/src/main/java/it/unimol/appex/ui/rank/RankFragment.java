package it.unimol.appex.ui.rank;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import it.unimol.appex.adapters.RanksAdapter;
import it.unimol.appex.api.LocalApiClient;
import it.unimol.appex.databinding.FragmentRankBinding;
import it.unimol.appex.model.Rank;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankFragment extends Fragment {

    private FragmentRankBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentRankBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.rankList.setHasFixedSize(true);
        binding.rankList.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rankList.addItemDecoration(new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL));

        loadRank();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void loadRank() {
        LocalApiClient.getLocalClient().listRank().enqueue(new Callback<List<Rank>>() {
            @Override
            public void onResponse(Call<List<Rank>> call, Response<List<Rank>> response) {
                Log.v("Chiamata", "Success");
                binding.rankList.setAdapter(new RanksAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<Rank>> call, Throwable t) {
                Log.v("Chiamata", "Falliment");
                t.printStackTrace();
            }
        });
    }


}