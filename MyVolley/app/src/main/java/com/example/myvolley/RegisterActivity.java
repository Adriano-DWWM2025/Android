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

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextPseudo, editTextEmail, editTextPassword, editTextConfirmPassword;
    private Button buttonRegister;
    private RequestQueue queue;
    private MyRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_registeractivity);


        editTextPseudo = findViewById(R.id.editTextPseudo);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        queue = MySingleton.getInstance(this).getRequestQueue();
        request = new MyRequest(this, queue);


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String LOGIN = editTextPseudo.getText().toString().trim();
                final String EMAIL = editTextEmail.getText().toString().trim();
                final String PASSWORD = editTextPassword.getText().toString().trim();
                final String PASSWORD2 = editTextConfirmPassword.getText().toString().trim();

                request.register(LOGIN, EMAIL, PASSWORD, PASSWORD2, new MyRequest.RetoursPHP() {
                    @Override
                    public void toutOK(String message) {
                        Log.d("PHP","messagesPHP: " + message);
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        Toast.makeText(RegisterActivity.this, "" + message, Toast.LENGTH_SHORT).show();
                        startActivity(i);
                    }

                    @Override
                    public void pasOK(String message) {
//                        pgbar.setVisibility(View.GONE);
                        buttonRegister.setVisibility(View.VISIBLE);
                        Log.d("PHP","passage dans PAS OK de register Activity");
                        Toast.makeText(RegisterActivity.this, "Attention: " + message, Toast.LENGTH_SHORT).show();
                        return;
                    }

                    @Override
                    public void systemError(String message) {
                        buttonRegister.setVisibility(View.VISIBLE);
                        Toast.makeText(RegisterActivity.this, "Erreur réseau", Toast.LENGTH_SHORT).show();
                    }
                });



//                if (pseudo.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
//                    Toast.makeText(RegisterActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
//                } else if (!password.equals(confirmPassword)) {
//                    Toast.makeText(RegisterActivity.this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(RegisterActivity.this, "Inscription réussie", Toast.LENGTH_SHORT).show();
//                }


            }
        });
    }
}
