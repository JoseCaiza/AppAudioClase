package com.example.prymireproductordeaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //dedclarar objetos
    ImageView imvMusica;
    Button btnPlay, btnStop, btnPause;
    //declarar
    MediaPlayer mp;

    int pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mapear objetos
        btnPause=findViewById(R.id.bt_pause);
        btnPlay=findViewById(R.id.bt_play);
        btnStop=findViewById(R.id.bt_stop);
        imvMusica=findViewById(R.id.iv_musica);
    }
    //crear el metodo play
    public void Play(View view){
        if(mp==null){
            mp=MediaPlayer.create(this,R.raw.lola);
            mp.start();
            Toast.makeText(this,"Play",Toast.LENGTH_LONG).show();
        }else if (!mp.isPlaying()){
            mp.seekTo(pause);
            mp.start();
            Toast.makeText(this,"Renaudando",Toast.LENGTH_LONG).show();
        }
    }
    //meotod del pause
    public void pause (View view){
        if(mp!=null){
            mp.pause();
            pause=mp.getCurrentPosition();
            Toast.makeText(this,"Pause",Toast.LENGTH_LONG).show();
        }
    }
    //metodo stop
    public void stop(View view){
        mp.stop();
        mp=null;
        Toast.makeText(this,"Stop",Toast.LENGTH_LONG).show();
    }
}
