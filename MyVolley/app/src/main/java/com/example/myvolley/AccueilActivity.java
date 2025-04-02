package com.example.myvolley;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AccueilActivity extends AppCompatActivity {
    private TextView bienvenueText, idText, pseudoText, emailText;
    private Button logoutButton;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_accueilactivity);

        bienvenueText = findViewById(R.id.bienvenueTextView);
        idText = findViewById(R.id.idTextView);
        pseudoText = findViewById(R.id.pseudoTextView);
        emailText = findViewById(R.id.emailTextView);
        logoutButton = findViewById(R.id.logoutButton);

        sessionManager = new SessionManager(this);

        if (!sessionManager.isLogged()) {
            Intent intent = new Intent(AccueilActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        String pseudo = sessionManager.getLogin();
        String id = sessionManager.getId();
        String email = sessionManager.getEmail();

        bienvenueText.setText("Bienvenue, " + pseudo + " !");
        idText.setText("Id : " + id);
        pseudoText.setText("Pseudo : " + pseudo);
        emailText.setText("Email : " + email);


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sessionManager.logout();

                Intent intent = new Intent(AccueilActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                finish();
            }
        });
    }
}
