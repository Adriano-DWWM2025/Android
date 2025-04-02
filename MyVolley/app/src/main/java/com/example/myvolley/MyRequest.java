package com.example.myvolley;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyRequest {

    private Context context;
    private RequestQueue queue;

    public MyRequest(Context context, RequestQueue queue) {
        this.context = context;
        this.queue = queue;
    }

    private boolean isJSONValid(String response) {
        try {
            new JSONObject(response);
            return true;
        } catch (JSONException ex) {
            try {
                new org.json.JSONArray(response);
                return true;
            } catch (JSONException ex1) {
                return false;
            }
        }
    }


    public void register(final String LOGIN,
                         final String EMAIL,
                         final String PASSWORD,
                         final String PASSWORD2,
                         final RetoursPHP callback) {
        String url = "http://192.168.1.232/register/register.php";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!isJSONValid(response)) {
                    callback.systemError("Une erreur s'est produite. Veuillez réessayer plus tard.");
                    return;
                }

                try {
                    JSONObject json = new JSONObject(response);
                    boolean error = json.getBoolean("error");

                    if (!error) {
                        callback.toutOK("Félicitations ! Votre compte a été créé.");
                    } else {
                        callback.pasOK(json.getString("message"));
                    }

                } catch (JSONException e) {
                    callback.systemError("Une erreur s'est produite, veuillez réessayer plus tard.");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = getErrorMessage(error);
                callback.systemError(message);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("login", LOGIN);
                map.put("email", EMAIL);
                map.put("password", PASSWORD);
                map.put("password2", PASSWORD2);
                return map;
            }
        };

        queue.add(request);
    }

    public void login(final String LOGIN,
                      final String PASSWORD,
                      final LoginPHP callback) {

        if (LOGIN.isEmpty() || PASSWORD.isEmpty()) {
            callback.pasOK("Tous les champs doivent être remplis.");
            return;
        }

        String url = "http://192.168.1.232/register/login.php";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!isJSONValid(response)) {
                    callback.systemError("Une erreur système s'est produite. Veuillez réessayer plus tard.");
                    return;
                }

                try {
                    JSONObject json = new JSONObject(response);
                    boolean error = json.getBoolean("error");

                    if (!error) {
                        JSONObject user = json.getJSONObject("user");
                        String id = user.getString("id");
                        String pseudo = user.getString("pseudo");
                        String email = user.getString("email");

                        callback.toutOK(id, pseudo, email);
                    } else {
                        callback.pasOK(json.getString("message"));
                    }

                } catch (JSONException e) {
                    callback.systemError("Une erreur s'est produite, veuillez réessayer plus tard.");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = getErrorMessage(error);
                callback.systemError(message);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("login", LOGIN);
                map.put("password", PASSWORD);
                return map;
            }
        };

        queue.add(request);
    }


    private String getErrorMessage(VolleyError error) {
        if (error instanceof TimeoutError) {
            return "Le serveur met trop de temps à répondre.";
        } else if (error instanceof AuthFailureError) {
            return "Erreur d'authentification. Veuillez vérifier vos identifiants.";
        } else if (error instanceof ServerError) {
            return "Erreur côté serveur. Veuillez réessayer plus tard.";
        } else if (error instanceof NetworkError) {
            return "Problème de connexion réseau.";
        } else if (error instanceof ParseError) {
            return "Erreur de traitement des données reçues.";
        } else {
            return "Une erreur inconnue est survenue.";
        }
    }


    public interface RetoursPHP {
        void toutOK(String message);
        void pasOK(String message);
        void systemError(String message);
    }


    public interface LoginPHP {
        void toutOK(String id, String pseudo, String email);
        void pasOK(String message);
        void systemError(String message);
    }
}
