package es.tonicotitular.circulitos.UI;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import es.tonicotitular.circulitos.MovimientoBolas.AlbumStorageDirFactory;
import es.tonicotitular.circulitos.MovimientoBolas.GraphicViewParteFacil;
import es.tonicotitular.circulitos.R;
import es.tonicotitular.circulitos.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    //ACCION EN EL CASO DE QUE LA FOTO SEA PEQUEÑA
    private static final int ACTION_TAKE_PHOTO_B = 1;
    private static final int ACTION_TAKE_PHOTO_S = 2;
    //Ruta actual de la foto
    private String mCurrentPhotoPath;
    //Bits de imagenes para setearlo
    private Bitmap mImageBitmap;
    //Lo utilizamos para meternos en el album de fotos del telefono
    private AlbumStorageDirFactory mAlbumStorageDirFactory = null;
    //region Tipo de prefijo de fotos
        private static final String JPEG_FILE_PREFIX = "IMG_";
        private static final String JPEG_FILE_SUFFIX = ".jpg";
    //endregion

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
        if (nivel != CuantasBolasFragment.LaRespuestaes) {
            //igualamos el nivel con el numero de bolas del Fragmento si no es igual
            nivel = CuantasBolasFragment.LaRespuestaes;
        }
        //En cada nivel
        switch (nivel) {
            case 0://Facil
                //DEPENDIENDO del nivel seteamos el nivel
                binding.btEasyLevel.setEnabled(true);
                binding.btMediumLevel.setEnabled(false);
                binding.btHardlevel.setEnabled(false);
                break;
            case 1://Medio
                //DEPENDIENDO del nivel seteamos el nivel
                binding.btEasyLevel.setEnabled(false);
                binding.btMediumLevel.setEnabled(true);
                binding.btHardlevel.setEnabled(false);
                break;
            case 2://Dificil
                //DEPENDIENDO del nivel seteamos el nivel
                binding.btEasyLevel.setEnabled(false);
                binding.btMediumLevel.setEnabled(false);
                binding.btHardlevel.setEnabled(true);
                break;
            case 3://Te pasaste el nivel
                //DEPENDIENDO del nivel seteamos el nivel
                binding.btEasyLevel.setVisibility(View.GONE);
                binding.btMediumLevel.setVisibility(View.GONE);
                binding.btHardlevel.setVisibility(View.GONE);
                //Sonido VICTORY ROYALE FORNITE
                final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.fin);
                binding.imageView.setVisibility(View.VISIBLE);
                //Comenzamos el hilo del sonido
                mp.start();
                //Iniciamos la camara si le da al icono de la foto
                binding.displayCamera.setVisibility(View.VISIBLE);
                binding.displayCamera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Funcion para iniciar la cámara
                    dispatchTakePictureIntent(ACTION_TAKE_PHOTO_S);
                    }
                });
                binding.Finish.setVisibility(View.VISIBLE);
                binding.Finish.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Cerramos el hilo
                        mp.stop();
                        //Se sale de la app
                        System.exit(0);
                    }
                });
        }

        //region desplazamiento dependiendo el nivel
        binding.btEasyLevel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Bundle nivel = new Bundle();
                nivel.putInt("nivel", 1);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_areyouready, nivel);
            }
        });
        binding.btHardlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle nivel = new Bundle();
                nivel.putInt("nivel", 3);

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_areyouready, nivel);

            }
        });
        binding.btMediumLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle nivel = new Bundle();
                nivel.putInt("nivel", 2);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_areyouready, nivel);


            }
        });
        //endregion
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }
    //region evento que se mete en la camara
        private void dispatchTakePictureIntent(int actionCode) {

            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//la accion para sacar la imagen
            switch (actionCode) {
                //En el caso de que la imagen sea pequeña
                case ACTION_TAKE_PHOTO_B:
                    File f = null;

                    try {
                        f = setUpPhotoFile();
                        mCurrentPhotoPath = f.getAbsolutePath();
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    } catch (IOException e) {
                        e.printStackTrace();
                        f = null;
                        mCurrentPhotoPath = null;
                    }
                    break;

                default:
                    break;
            } // switch

            startActivityForResult(takePictureIntent, actionCode);
        }
    //endregion

    private File setUpPhotoFile() throws IOException {

        File f = createImageFile();
        mCurrentPhotoPath = f.getAbsolutePath();

        return f;
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = JPEG_FILE_PREFIX + timeStamp + "_";
        File albumF = getAlbumDir();
        File imageF = File.createTempFile(imageFileName, JPEG_FILE_SUFFIX, albumF);
        return imageF;
    }

    private File getAlbumDir() {
        File storageDir = null;

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

            storageDir = mAlbumStorageDirFactory.getAlbumStorageDir(getAlbumName());

            if (storageDir != null) {
                if (!storageDir.mkdirs()) {
                    if (!storageDir.exists()) {
                        Log.d("CameraSample", "failed to create directory");
                        return null;
                    }
                }
            }

        } else {
            Log.v(getString(R.string.app_name), "External storage is not mounted READ/WRITE.");
        }

        return storageDir;
    }

    private String getAlbumName() {
        return getString(R.string.album_name);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {

            case ACTION_TAKE_PHOTO_S: {
                if (resultCode == RESULT_OK) {
                    handleSmallCameraPhoto(data);
                }
                break;
            } // ACTION_TAKE_PHOTO_S

        } // switch
    }

    private void handleSmallCameraPhoto(Intent intent) {
        Bundle extras = intent.getExtras();
        mImageBitmap = (Bitmap) extras.get("data");
        binding.displayImage.setImageBitmap(mImageBitmap);
        binding.displayImage.setVisibility(View.VISIBLE);

    }

}