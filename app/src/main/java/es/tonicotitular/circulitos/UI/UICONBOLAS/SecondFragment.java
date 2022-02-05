package es.tonicotitular.circulitos.UI.UICONBOLAS;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import es.tonicotitular.circulitos.MovimientoBolas.GraphicViewParteFacil;
import es.tonicotitular.circulitos.R;
import es.tonicotitular.circulitos.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();



    }
        public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.elbhico);


            CountDownTimer count = new CountDownTimer(5000, 1000) {
                public void onTick(long millisUntilFinished) {
                    binding.Contador.setText(String.valueOf(millisUntilFinished / 1000));
                    mp.start();
                }

                public void onFinish() {
                    int respuesta = 1;
                    Bundle bundle = new Bundle();
                    bundle.putInt("respuesta",respuesta);
                    NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_secondFragment_to_cuantasBolasFragment,bundle);
                    mp.stop();
                }
            }.start();

    }




        @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


