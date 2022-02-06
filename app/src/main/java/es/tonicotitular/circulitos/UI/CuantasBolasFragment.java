package es.tonicotitular.circulitos.UI;

import static es.tonicotitular.circulitos.MovimientoBolas.GraphicViewParteDificil.ballsdificil;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.tonicotitular.circulitos.MovimientoBolas.GraphicViewMedium;
import es.tonicotitular.circulitos.MovimientoBolas.GraphicViewParteDificil;
import es.tonicotitular.circulitos.MovimientoBolas.GraphicViewParteFacil;
import es.tonicotitular.circulitos.R;
import es.tonicotitular.circulitos.UI.UICONBOLAS.SecondFragment;
import es.tonicotitular.circulitos.databinding.FragmentCuantasBolasBinding;
import es.tonicotitular.circulitos.databinding.FragmentSecondBinding;

public class CuantasBolasFragment extends Fragment {
    public static int LaRespuestaes = 0 ;
    FragmentCuantasBolasBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = new Bundle();
        bundle = getArguments();
        int nivel = bundle.getInt("respuesta");





        binding.btsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numerodeBolasRojas = Integer.parseInt(binding.red.getText().toString());
                int numerodeBolasAmarillas = Integer.parseInt(binding.yellow.getText().toString());
                switch (nivel){
                    case 1:
                       int numerodeBolasRojasfacil = 2 , numerodeBolasAmarillasfacil= 2;
                     if (numerodeBolasRojas != numerodeBolasRojasfacil || numerodeBolasAmarillas!= numerodeBolasAmarillasfacil) {
                         final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.incorrecta);
                         CountDownTimer count = new CountDownTimer(3000, 1000) {
                             @Override
                             public void onTick(long millisUntilFinished) {

                                 mp.start();
                                 binding.frameLayout4.setBackgroundColor(Color.RED);

                             }

                             @Override
                             public void onFinish() {


                                     GraphicViewParteFacil.ballsfacil.clear();


                                 mp.stop();
                                 NavHostFragment.findNavController(CuantasBolasFragment.this).navigate(R.id.action_cuantasBolasFragment_to_FirstFragment);

                             }


                         }.start();
                     }
                     else{
                         CountDownTimer count = new CountDownTimer(3000, 1000) {
                             final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.correcta);
                             @Override
                             public void onTick(long millisUntilFinished) {
                                 mp.start();
                                 binding.frameLayout4.setBackgroundColor(Color.GREEN);
                             }

                             @Override
                             public void onFinish() {


                                     GraphicViewParteFacil.ballsfacil.clear();

                                 mp.stop();
                                 NavHostFragment.findNavController(CuantasBolasFragment.this).navigate(R.id.action_cuantasBolasFragment_to_FirstFragment);
                             }
                         }.start();

                         LaRespuestaes = 1;


                     }
                        break;
                    case 2 :
                        int numerodeBolasRojasMedio= 3 , numerodeBolasAmarillasMedio= 4;
                        if (numerodeBolasRojas != numerodeBolasRojasMedio || numerodeBolasAmarillas!= numerodeBolasAmarillasMedio) {
                            final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.incorrecta);
                            CountDownTimer count = new CountDownTimer(3000, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {

                                    mp.start();
                                    binding.frameLayout4.setBackgroundColor(Color.RED);

                                }

                                @Override
                                public void onFinish() {

                                    GraphicViewMedium.ballsMedium.clear();

                                    mp.stop();
                                    NavHostFragment.findNavController(CuantasBolasFragment.this).navigate(R.id.action_cuantasBolasFragment_to_FirstFragment);

                                }


                            }.start();
                        }
                        else{
                            CountDownTimer count = new CountDownTimer(3000, 1000) {
                                final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.correcta);
                                @Override
                                public void onTick(long millisUntilFinished) {

                                    mp.start();
                                    binding.frameLayout4.setBackgroundColor(Color.GREEN);
                                }

                                @Override
                                public void onFinish() {
                                    GraphicViewMedium.ballsMedium.clear();
                                    mp.stop();
                                    NavHostFragment.findNavController(CuantasBolasFragment.this).navigate(R.id.action_cuantasBolasFragment_to_FirstFragment);
                                }
                            }.start();
                            LaRespuestaes = 2;


                        }
                        break;
                    case 3 :
                        int numerodeBolasRojasDificil= 3 , numerodeBolasAmarillasDificil= 2;
                        if (numerodeBolasRojas != numerodeBolasRojasDificil || numerodeBolasAmarillas!= numerodeBolasAmarillasDificil) {
                            final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.incorrecta);
                            CountDownTimer count = new CountDownTimer(3000, 1000) {

                                @Override
                                public void onTick(long millisUntilFinished) {


                                    mp.start();
                                    binding.frameLayout4.setBackgroundColor(Color.RED);

                                }

                                @Override
                                public void onFinish() {
                                    ballsdificil.clear();
                                    mp.stop();
                                    NavHostFragment.findNavController(CuantasBolasFragment.this).navigate(R.id.action_cuantasBolasFragment_to_FirstFragment);

                                }


                            }.start();
                        }
                        else{
                            CountDownTimer count = new CountDownTimer(3000, 1000) {
                                final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.correcta);
                                @Override
                                public void onTick(long millisUntilFinished) {

                                    mp.start();
                                    binding.frameLayout4.setBackgroundColor(Color.GREEN);
                                }

                                @Override
                                public void onFinish() {
                                    ballsdificil.clear();
                                    mp.stop();
                                    NavHostFragment.findNavController(CuantasBolasFragment.this).navigate(R.id.action_cuantasBolasFragment_to_FirstFragment);
                                }
                            }.start();
                            LaRespuestaes = 3;


                        }
                        break;
                }




            }
        });


    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentCuantasBolasBinding.inflate(inflater, container, false);
        return binding.getRoot();



    }

}