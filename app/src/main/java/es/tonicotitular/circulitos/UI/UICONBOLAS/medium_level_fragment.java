package es.tonicotitular.circulitos.UI.UICONBOLAS;

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

import es.tonicotitular.circulitos.R;
import es.tonicotitular.circulitos.databinding.FragmentMediumLevelFragmentBinding;
import es.tonicotitular.circulitos.databinding.FragmentSecondBinding;

public class medium_level_fragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private FragmentMediumLevelFragmentBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMediumLevelFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.elbhico);


        CountDownTimer count = new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                binding.contador.setText(String.valueOf(millisUntilFinished / 1000));
                mp.start();
            }

            public void onFinish() {
                int respuesta = 2;
                Bundle bundle = new Bundle();
                bundle.putInt("respuesta",respuesta);
                NavHostFragment.findNavController(medium_level_fragment.this).navigate(R.id.action_medium_level_fragment_to_cuantasBolasFragment,bundle);
                mp.stop();
            }
        }.start();
    }
}