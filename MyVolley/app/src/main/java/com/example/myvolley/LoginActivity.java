package com.example.myvolley;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextPseudo, editTextPassword;
    private Button buttonLogin, buttonRegister;
    private RequestQueue queue;
    private MyRequest request;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_loginactivity);

        editTextPseudo = findViewById(R.id.editTextTextPseudo);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        queue = MySingleton.getInstance(this).getRequestQueue();
        request = new MyRequest(this, queue);

        sessionManager = new SessionManager(this);
        if (sessionManager.isLogged()) {
            Intent i = new Intent(getApplicationContext(), AccueilActivity.class);
            startActivity(i);
            finish();
        }

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String LOGIN = editTextPseudo.getText().toString().trim();
                final String PASSWORD = editTextPassword.getText().toString().trim();

                request.login(LOGIN, PASSWORD, new MyRequest.LoginPHP(){
                    @Override
                    public void toutOK(String id, String pseudo, String email) {
                        Log.d("PHP", "Connexion réussie : " + pseudo);

                        sessionManager.insertUser(id, pseudo, email);

                        Intent i = new Intent(LoginActivity.this, AccueilActivity.class);
//                        i.putExtra("userId", id);
//                        i.putExtra("userPseudo", pseudo);
//                        i.putExtra("userEmail", email);
                        Toast.makeText(LoginActivity.this, "Connexion réussie !", Toast.LENGTH_SHORT).show();
                        startActivity(i);
                        finish();
                    }


                    @Override
                    public void pasOK(String message) {
//                        pgbar.setVisibility(View.GONE);
                        buttonRegister.setVisibility(View.VISIBLE);
                        Log.d("PHP", "passage dans PAS OK de login Activity");
                        Toast.makeText(LoginActivity.this, "Attention: " + message, Toast.LENGTH_SHORT).show();
                        return;
                    }

                    @Override
                    public void systemError(String message) {
                        buttonRegister.setVisibility(View.VISIBLE);
                        Toast.makeText(LoginActivity.this, "çamarssepa", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}


