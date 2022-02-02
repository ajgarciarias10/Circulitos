package es.tonicotitular.circulitos;

import android.animation.ObjectAnimator;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import java.sql.Time;
import java.util.Timer;

import es.tonicotitular.circulitos.databinding.FragmentAreyoureadyBinding;
import es.tonicotitular.circulitos.databinding.FragmentFirstBinding;

public class Areyouready extends Fragment {

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
        an  = new TranslateAnimation( 0.0f,0.0f,0.0F,3600.0f);
        an.setDuration(3000);
        binding.tvEstasListo.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                switch (nivel){
                    case 1:
                        NavHostFragment.findNavController(Areyouready.this)
                                .navigate(R.id.action_areyouready_to_secondFragment);
                        break;
                    case 2:
                        NavHostFragment.findNavController(Areyouready.this)
                                .navigate(R.id.action_areyouready_to_medium_level_fragment);
                        break;
                    case 3 :
                        NavHostFragment.findNavController(Areyouready.this)
                                .navigate(R.id.action_areyouready_to_hardLevel);
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