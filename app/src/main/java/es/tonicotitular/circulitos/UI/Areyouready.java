package es.tonicotitular.circulitos.UI;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import es.tonicotitular.circulitos.R;
import es.tonicotitular.circulitos.databinding.FragmentAreyoureadyBinding;
public class Areyouready extends Fragment {
    //Utilizamos el binding para llamar a cada objeto que utilizamos en la interfaz
    private FragmentAreyoureadyBinding binding;


    TranslateAnimation an ;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentAreyoureadyBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }




    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int nivel;
        Bundle bundle = new Bundle();
        bundle = getArguments();
        nivel = bundle.getInt("nivel");

        final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.song);



        an  = new TranslateAnimation( 0.0f,0.0f,0.0F,3600.0f);
        an.setDuration(3000);
        binding.tvEstasListo.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                switch (nivel){
                    case 1:
                        mp.start();
                        break;
                    case 2:
                        mp.start();
                        break;
                    case 3 :
                        mp.start();
                        break;

                }

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                switch (nivel){
                    case 1:
                        mp.stop();
                        Bundle bundlefacil = new Bundle();
                       String[] bolas = new String[2];
                       bolas[0] = "2";
                       bolas[1] = "2";
                        bundlefacil.putStringArray("bolas",bolas);
                        NavHostFragment.findNavController(Areyouready.this).navigate(R.id.action_areyouready_to_secondFragment,bundlefacil);

                        break;
                    case 2:
                        mp.stop();
                        Bundle bundlemedio = new Bundle();
                        String[] bolasmedio = new String[2];
                        bolasmedio[0] = "3";
                        bolasmedio[1] = "4";
                        NavHostFragment.findNavController(Areyouready.this)
                                .navigate(R.id.action_areyouready_to_medium_level_fragment,bundlemedio);

                        break;
                    case 3 :
                        mp.stop();
                        Bundle bundledificil = new Bundle();
                        String[] bundledificila = new String[2];
                        bundledificila[0] = "2";
                        bundledificila[1] = "3";
                        NavHostFragment.findNavController(Areyouready.this)
                                .navigate(R.id.action_areyouready_to_hardLevel,bundledificil);

                        break;

                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });





    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}