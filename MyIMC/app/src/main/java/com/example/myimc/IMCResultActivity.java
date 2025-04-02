package com.example.myimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IMCResultActivity extends AppCompatActivity {

    private TextView tvIMCValue;
    private TextView tvCategory;
    private ImageView ivCategoryImage;
    private Button btnRecalculate;
    private ImageButton btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_imc_result_activity);

        tvIMCValue = findViewById(R.id.tv_imc_value);
        tvCategory = findViewById(R.id.tv_category);
        ivCategoryImage = findViewById(R.id.iv_category_image);
        btnRecalculate = findViewById(R.id.btn_recalculate);
        btnRetour = findViewById(R.id.btnRetour);


        float imc = getIntent().getFloatExtra("imcValue", 0);
        String categorie = getIntent().getStringExtra("imcCategory");


        tvIMCValue.setText(String.format("%.1f", imc));
        if (categorie.equals("Corpulence normale")) {
            tvCategory.setText(getString(R.string.bravo_votre_imc_est_dans_la_zone) + categorie);
        } else {
            tvCategory.setText(getString(R.string.attention_votre_imc_est_dans_la_zone) + categorie);
        }


        int imageResId = R.drawable.normal;
        switch (categorie) {
            case "Maigreur":
                imageResId = R.drawable.maigreur;
                break;
            case "Surpoids":
                imageResId = R.drawable.surpoids;
                break;
            case "Obésité modérée":
                imageResId = R.drawable.obesite1;
                break;
            case "Obésité sévère":
                imageResId = R.drawable.obesite2;
                break;
            case "Obésité morbide":
                imageResId = R.drawable.obesite3;
                break;
        }
        ivCategoryImage.setImageResource(imageResId);

        btnRecalculate.setOnClickListener(v -> {
            Intent intent = new Intent(IMCResultActivity.this, CalculIMCActivity.class);
            startActivity(intent);
            finish();
        });



        btnRetour.setOnClickListener(v -> {
            Intent retourIntent = new Intent(IMCResultActivity.this, Activity2.class);
            startActivity(retourIntent);
            finish();
        });
    }
}
