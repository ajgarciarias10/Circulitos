package es.tonicotitular.circulitos.UI;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import es.tonicotitular.circulitos.MovimientoBolas.GraphicViewParteFacil;
import es.tonicotitular.circulitos.R;
import es.tonicotitular.circulitos.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    //Declaracion del fragmento
    private FragmentFirstBinding binding;
    //Creacion dato tipo entero que va a simular el nivel
    private int nivel = 0;
    //region  OnCreateView
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    //endregion

    //region AlCrearLavista
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Si el nivel no es igual al que utilizamos en cuantabolasFragment para incrementar el nivel
        if(nivel != CuantasBolasFragment.LaRespuestaes){
            //igualamos el nivel con el numero de bolas del Fragmento si no es igual
                nivel = CuantasBolasFragment.LaRespuestaes;
        }
        //En cada nivel
         switch (nivel){
             case 0 ://Facil
                 binding.btEasyLevel.setEnabled(true);
                 binding.btMediumLevel.setEnabled(false);
                 binding.btHardlevel.setEnabled(false);
                 break;
             case 1://Medio
                 binding.btEasyLevel.setEnabled(false);
                 binding.btMediumLevel.setEnabled(true);
                 binding.btHardlevel.setEnabled(false);
                 break;
             case 2://Dificil
                 binding.btEasyLevel.setEnabled(false);
                 binding.btMediumLevel.setEnabled(false);
                 binding.btHardlevel.setEnabled(true);
                 break;
             case 3 ://Te pasaste el nivel
                 binding.btEasyLevel.setVisibility(View.GONE);
                 binding.btMediumLevel.setVisibility(View.GONE);
                 binding.btHardlevel.setVisibility(View.GONE);
                 //Sonido VICTORY ROYALE FORNITE
                 final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.fin);
                 binding.imageView.setVisibility(View.VISIBLE);
                 //Comenzamos el hilo del sonido
                 mp.start();
                 binding.Finish.setVisibility(View.VISIBLE);
                 binding.Finish.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         //Cerramos el hilo

                         mp.stop();
                         //Se sale de la app
                         System. exit (0);
                     }
                 });
         }
        //region desplazamiento dependiendo el nivel
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
        //endregion
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}