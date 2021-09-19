package it.unimol.appex.ui.rank;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;

import java.util.List;

import it.unimol.appex.R;
import it.unimol.appex.adapters.RanksAdapter;
import it.unimol.appex.api.PersonalApiClient;
import it.unimol.appex.databinding.FragmentRankBinding;
import it.unimol.appex.model.Rank;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankFragment extends Fragment implements RanksAdapter.OnRankListner{

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
        PersonalApiClient.getLocalClient().listRank().enqueue(new Callback<List<Rank>>() {
            @Override
            public void onResponse(Call<List<Rank>> call, Response<List<Rank>> response) {
                Log.v("Chiamata", "Success");
                binding.rankList.setAdapter(new RanksAdapter(response.body(),
                        RankFragment.this::onRankClick));
            }

            @Override
            public void onFailure(Call<List<Rank>> call, Throwable t) {
                Log.v("Chiamata", "Falliment");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onRankClick(Rank rank, int position){
        Bundle bundle = new Bundle();
        bundle.putString("rankJson", new Gson().toJson(rank));

        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main)
                .navigate(R.id.nav_rank_detail, bundle);
    }
}