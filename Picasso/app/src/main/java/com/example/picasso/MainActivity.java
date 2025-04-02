package com.example.picasso;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    private Button btn;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imageView);
        btn = findViewById(R.id.button);

        url = "https://tenor.com/view/jdg-joueur-du-grenier-fred-seb-jdg-fete-gif-24342887g.gif";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                affichageIMG(url);
            }
        });
    }

    private void affichageIMG(String url) {
        Picasso.get()
                    .load(url)
                    .resize(600, 600)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(img);
        }

//        RequestCreator pica = new Picasso.Builder(MainActivity.this).build().load(url);
//        pica.placeholder(R.drawable.loading);
//        pica.error(R.drawable.error);
//        pica.into(img);
    }

