package it.unimol.appex.ui.weapon;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;
import it.unimol.appex.adapters.WeaponsAdapter;
import it.unimol.appex.api.LocalApiClient;
import it.unimol.appex.databinding.FragmentWeaponBinding;
import it.unimol.appex.model.Weapon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeaponFragment extends Fragment {

    private FragmentWeaponBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentWeaponBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.weaponList.setHasFixedSize(true);
        binding.weaponList.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.weaponList.addItemDecoration(new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL));

        loadWeapon();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void loadWeapon() {
        LocalApiClient.getLocalClient().listWeapon().enqueue(new Callback<List<Weapon>>() {
            @Override
            public void onResponse(Call<List<Weapon>> call, Response<List<Weapon>> response) {
                Log.v("Chiamata", "Success");
                binding.weaponList.setAdapter(new WeaponsAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<Weapon>> call, Throwable t) {
                Log.v("Chiamata", "Falliment");
                t.printStackTrace();
            }
        });
    }


}