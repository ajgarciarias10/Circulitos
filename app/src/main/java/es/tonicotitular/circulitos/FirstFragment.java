package es.tonicotitular.circulitos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import es.tonicotitular.circulitos.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    public GraphicViewParteFacil graphicViewParteFacil;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.btEasyLevel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Bundle nivel = new Bundle();
                nivel.putInt("nivel",1);


                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_areyouready,nivel);



            }
        });
        binding.btHardlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle nivel = new Bundle();
                nivel.putInt("nivel",3);

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_areyouready,nivel);

            }
        });
        binding.btMediumLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle nivel = new Bundle();
                nivel.putInt("nivel",2);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_areyouready,nivel);


            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}