package it.unimol.appex.ui.weapon;

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
import it.unimol.appex.adapters.WeaponsAdapter;
import it.unimol.appex.api.PersonalApiClient;
import it.unimol.appex.databinding.FragmentWeaponBinding;
import it.unimol.appex.model.Weapon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeaponFragment extends Fragment implements WeaponsAdapter.OnWeaponListner{

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
        PersonalApiClient.getLocalClient().listWeapon().enqueue(new Callback<List<Weapon>>() {
            @Override
            public void onResponse(Call<List<Weapon>> call, Response<List<Weapon>> response) {
                Log.v("Chiamata", "Success");
                binding.weaponList.setAdapter(new WeaponsAdapter(response.body(),
                        WeaponFragment.this::onWeaponClick));
            }

            @Override
            public void onFailure(Call<List<Weapon>> call, Throwable t) {
                Log.v("Chiamata", "Falliment");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onWeaponClick(Weapon weapon, int position){
        Bundle bundle = new Bundle();
        bundle.putString("weaponJson", new Gson().toJson(weapon));

        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main)
                .navigate(R.id.nav_weapon_detail, bundle);
    }
}