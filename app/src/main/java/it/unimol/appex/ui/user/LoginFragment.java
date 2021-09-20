package it.unimol.appex.ui.user;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import it.unimol.appex.R;
import it.unimol.appex.api.OfficalApiClient;
import it.unimol.appex.databinding.FragmentUserBinding;
import it.unimol.appex.databinding.LoginPageBinding;
import it.unimol.appex.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment{

    private LoginPageBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = LoginPageBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.userNameIns.getText().toString().equals("")) {

                    Bundle bundle = new Bundle();
                    bundle.putString("userName", binding.userNameIns.getText().toString());
                    bundle.putString("platform", binding.platformIns.getSelectedItem().toString());

                    Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main)
                            .navigate(R.id.nav_user, bundle);
                }else{
                    Toast.makeText(getContext(),"Inser valid username",Toast.LENGTH_SHORT).show();
                }

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