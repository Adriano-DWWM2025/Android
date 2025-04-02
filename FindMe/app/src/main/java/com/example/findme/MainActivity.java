package com.example.findme;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int nbrAlea;
    private EditText nbrTest;
    private Button nbrSend;
    private TextView nbrHint;
    private TextView nbrTestHisto;
    private int life = 10;
    private int count = 1;
    private String histo = "";
    private ProgressBar lifeCount;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        int nbrAlea = (int) ((Math.random()*100)+1);
        lifeCount = findViewById(R.id.lifeCount);
        nbrTest = findViewById(R.id.testNumber);
        nbrSend = findViewById(R.id.sendTest);
        nbrHint = findViewById(R.id.hintText);
        nbrTestHisto = findViewById(R.id.historicText);
        nbrTestHisto.setText("");
        Log.i("tag",String.valueOf(nbrAlea));

            nbrSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String strNbrTest = nbrTest.getText().toString();
                    if ( strNbrTest.isEmpty()) {
                        Toast.makeText(MainActivity.this, "La saisie ne peut pas être vide", Toast.LENGTH_LONG).show();
                        return;
                    }

                    int intNbrTest = Integer.parseInt(strNbrTest);

                    if (intNbrTest > 100 || intNbrTest <= 0) {
                        Toast.makeText(MainActivity.this, "La valeur saisie doit être entre 0 et 100", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (life == 0) {
                        Toast.makeText(MainActivity.this, "Vs avez perdu", Toast.LENGTH_LONG).show();
                    } else if (intNbrTest == nbrAlea) {
                        Toast.makeText(MainActivity.this, "Bravo, vous avez trouvé en "+count+" coups", Toast.LENGTH_LONG).show();
                    } else if (intNbrTest > nbrAlea) {
                        nbrHint.setText("Le nombre secret est plus petit");
                        histo += strNbrTest + " | ";
                        nbrTestHisto.setText(histo);
                        life -= 1;
                        lifeCount.incrementProgressBy(-10);
                        count += 1;
                        nbrTest.setText("");
                    } else if (intNbrTest < nbrAlea) {
                        nbrHint.setText("Le nombre secret est plus grand");
                        histo += strNbrTest + " | ";
                        nbrTestHisto.setText(histo);
                        life -= 1;
                        lifeCount.incrementProgressBy(-10);
                        count += 1;
                        nbrTest.setText("");
                    }

                }
            });
    }
}