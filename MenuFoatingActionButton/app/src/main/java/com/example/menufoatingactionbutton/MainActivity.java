package com.example.menufoatingactionbutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabMain, fabOption1, fabOption2;
    private boolean isFABOpen=false; //etat de mon menu flotant


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabMain = findViewById(R.id.fab_main);
        fabOption1 = findViewById(R.id.fab_option1);
        fabOption2 = findViewById(R.id.fab_option2);

        fabMain.setOnClickListener(new View.OnClickListener() { //gérer le clic sur le FAB main
            @Override
            public void onClick(View view) {

                if (!isFABOpen){
                    showFABMenu(); //Afficher le Menu
                }else{
                    closeFABMenu(); //Fermer le Menu
                }

            }
        });

        fabOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Option1", Toast.LENGTH_SHORT).show();
                closeFABMenu();
            }
        });
        fabOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Option2", Toast.LENGTH_SHORT).show();
                closeFABMenu();
            }
        });

    }
    private void showFABMenu(){
        isFABOpen=true;
        fabMain.setImageResource(android.R.drawable.arrow_down_float);
        fabOption1.setVisibility(View.VISIBLE);
        fabOption2.setVisibility(View.VISIBLE);
        fabOption1.animate().translationY(-60);
        fabOption2.animate().translationY(-120);

    }

    private void closeFABMenu(){
        isFABOpen=false;
        fabMain.setImageResource(android.R.drawable.arrow_up_float);
        fabOption1.animate().translationY(0);
        fabOption2.animate().translationY(0).withEndAction(new Runnable() {
            @Override
            public void run() {
        fabOption1.setVisibility(View.INVISIBLE);
        fabOption2.setVisibility(View.INVISIBLE);
            }
        });
    }
}