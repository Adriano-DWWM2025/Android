package com.example.controledesaisie;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout email, username, password, confirmPassword;
    private Button btnRegister;
    private ProgressBar progressBar;
    private String strLOGIN, strEMAIL, strPASSWORD, strPASSWORD2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_registeractivity);

//        progressBar.setVisibility(View.GONE);

        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        progressBar = findViewById(R.id.progressBar);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validLogin();
                validEmail();
                validPASSWORD1();
                validPASSWORD2();

                if (!validEmail() || !validLogin() || !validPASSWORD1() || !validPASSWORD2()) {
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                btnRegister.setVisibility(View.GONE);
            }
        });

    }
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +                       // Début de la ligne
                    "(?=.*[0-9])" +                     // Au moins 1 chiffre
                    // "(?=.*[a-z])" +                     // Au moins une minuscule
                    // "(?=.*[A-Z])" +                     // Au moins une majuscule
                    // "(?!.*[a-zA-Z])" +               // Aucune lettre possible (OKAOU)
                    // "(?=.*[@#!$%^&+=])" +               // Au moins 1 caractère spécial listé
                    "(?=\\S+$)" +                       // Pas d'espaces vides
                    ".{6,20}" +                         // Minimum 6 caractères et maximum 20 caractères
                    "$"                                 // Fin de la ligne
            );

    private boolean validEmail() {
        strEMAIL = email.getEditText().getText().toString().trim().toLowerCase();

        if (strEMAIL.isEmpty()) {
            email.setError("Email doit être renseigné");
            email.requestFocus();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(strEMAIL).matches()) {
            email.setError(strEMAIL + " n'est pas une adresse Email valide");
            return false;
        } else {
            email.setError(null);

            return true;
        }
    }

    private boolean validLogin() {
        strLOGIN = username.getEditText().getText().toString().trim();

        if (strLOGIN.isEmpty()) {
            username.setError("Login doit être renseigné");
            username.requestFocus();
            return false;
        } else if (strLOGIN.length() > 10) {
            username.setError("Login est trop long");
            return false;
        } else {
            username.setError(null);
            return true;
        }
    }

    private boolean validPASSWORD1() {
        strPASSWORD = password.getEditText().getText().toString().trim();
        strPASSWORD2 = confirmPassword.getEditText().getText().toString().trim();

        if (strPASSWORD.isEmpty() || !PASSWORD_PATTERN.matcher(strPASSWORD).matches()) {
            password.setError("Le mot de passe saisi n'est pas valide");
            Log.d("PHP", "passagepasswd1");
            return false;

        } else if (!strPASSWORD.equals(strPASSWORD2)) {
            password.setError("Les mots de passe ne sont pas identiques");
            confirmPassword.setError("Les mots de passe ne sont pas identiques");
            Log.d("PHP", "passagepasswd not equals");
            return false;

        } else {
            password.setError(null);
            confirmPassword.setError(null);
            return true;
        }
    }

    private boolean validPASSWORD2() {
        strPASSWORD = password.getEditText().getText().toString().trim();
        strPASSWORD2 = confirmPassword.getEditText().getText().toString().trim();

        if (strPASSWORD2.isEmpty() || !PASSWORD_PATTERN.matcher(strPASSWORD).matches()) {
            password.setError("Le mot de passe saisi n'est pas valide");
            Log.d("PHP", "passagepasswd1");
            return false;

        } else if (!strPASSWORD.equals(strPASSWORD2)) {
            password.setError("Les mots de passe ne sont pas identiques");
            confirmPassword.setError("Les mots de passe ne sont pas identiques");
            Log.d("PHP", "passagepasswd not equals");
            return false;

        } else {
            password.setError(null);
            confirmPassword.setError(null);
            return true;
        }
    }

}
