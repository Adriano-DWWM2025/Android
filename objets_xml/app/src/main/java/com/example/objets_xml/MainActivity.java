package com.example.objets_xml;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textView, textView2;
    private Switch switch2;
    private ConstraintLayout cL;
    private SeekBar seekBar;
    private int progress;
    private RatingBar ratingBar;
    private CheckBox checkBox, checkBox2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        switch2 = findViewById(R.id.switch2);
        cL = findViewById(R.id.cL);

        //=================================Switch===============================//

        switch2.setEnabled(true);
        switch2.setChecked(true);
        switch2.setClickable(true);


        boolean monSwitch2 = switch2.isClickable();
        boolean mon2Switch2 = switch2.isChecked();

            String valeurs = "\r valeur du checked: " + String.valueOf(mon2Switch2)
                    + "\n\r valeur du Clickable: " + String.valueOf(monSwitch2);

            Toast.makeText(this, valeurs, Toast.LENGTH_SHORT).show();

            switch2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean monSwitch2 = switch2.isClickable();
                    boolean mon2Switch2 = switch2.isChecked();

                    if (mon2Switch2 == true) {
                        cL.setBackgroundColor(Color.CYAN);
                    } else {
                        cL.setBackgroundColor(Color.GREEN);
                    }

                    String valeurs = "\r valeur du checked: " + String.valueOf(mon2Switch2)
                            + "\n\r valeur du Clickable: " + String.valueOf(monSwitch2);

                    Toast.makeText(MainActivity.this, valeurs, Toast.LENGTH_SHORT).show();
                }
            });

        //=================================SeekBar===============================//

        seekBar = findViewById(R.id.seekBar);
        textView2 = findViewById(R.id.textView2);
        seekBar.setMax(100);
        seekBar.setProgress(progress);
        textView2.setText("" + progress);
        textView2.setTextSize(progress);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressToto, boolean fromUser) {
                progress = progressToto;
                textView2.setText("" + progress);
                textView2.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            seekBar.setBackgroundColor(Color.BLUE);
            textView2.setBackgroundColor(Color.BLUE);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setBackgroundColor(Color.YELLOW);
                textView2.setBackgroundColor(Color.YELLOW);
            }
        });
        //=================================RatingBar===============================//

        ratingBar = findViewById(R.id.ratingBar);
        ratingBar .setNumStars(5);
        ratingBar .setProgress(3);
        ratingBar .setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d("star","Valeur de ratingBar : " +ratingBar);
                Log.d("star","Valeur de ratingBar : " +rating);
                Log.d("star","Valeur de ratingBar : " +fromUser);

            }
        });

        //=================================CheckBox===============================//

        checkBox = findViewById(R.id.checkBox);
        checkBox = findViewById(R.id.checkBox2);
        checkBox .setEnabled(true);
        checkBox .setChecked(true);


        boolean monCheckBox = checkBox.isChecked();
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Toast.makeText(MainActivity.this, "CheckBox", Toast.LENGTH_SHORT).show();
                checkBox .setChecked(false);
            }
        });

        }

    //=================================RadioButton===============================//

    public void monClickRadio (View radioButtonClick){
        boolean valeurDuChecked = ((RadioButton)radioButtonClick).isChecked();
        if (radioButtonClick.getId()==R.id.radioButton1) {
            if (valeurDuChecked) Toast.makeText(this, "radioButton1 : " +valeurDuChecked, Toast.LENGTH_SHORT).show();
        }
        if (radioButtonClick.getId()==R.id.radioButton2) {
            if (valeurDuChecked)
                Toast.makeText(this, "radioButton2 : "+valeurDuChecked, Toast.LENGTH_SHORT).show();
        }

    }


}