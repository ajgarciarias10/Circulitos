package es.tonicotitular.circulitos.UI;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.tonicotitular.circulitos.R;
import es.tonicotitular.circulitos.databinding.FragmentCuantasBolasBinding;

public class CuantasBolasFragment extends Fragment {
    FragmentCuantasBolasBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



       // int numerodeBolasRojasDelBundle= Integer.parseInt(arrayBolas[0]);
        //int numerodeBolasAmarillasdelBundle = Integer.parseInt(arrayBolas[1]);
/**
 *

        binding.btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numerodeBolasRojas = Integer.parseInt(binding.red.getText().toString());
                int numerodeBolasAmarillas = Integer.parseInt(binding.yellow.getText().toString());

                if (numerodeBolasRojas != numerodeBolasRojasDelBundle || numerodeBolasAmarillas!= numerodeBolasAmarillasdelBundle){
                    binding.frameLayout4.setBackgroundColor(Color.RED);
                    int incorrecto = 0;


                }
                else{
                    int correcto = 1;
                    binding.frameLayout4.setBackgroundColor(Color.GREEN);

                }
            }
        });
 */

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuantas_bolas, container, false);
    }
}