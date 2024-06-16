package com.example.olivamed;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    Dialog dialog;
    EditText emailtext;
    EditText emailtext2;
    EditText usnametext;
    EditText passtext;
    EditText passtext2;
    private OkHttpClient client = new OkHttpClient();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new Dialog(MainActivity.this);

    }

    public void goTobase(View v) {
        Intent intent = new Intent(this, Base.class);
        startActivity(intent);
    }

    public void goToAutorization(View v) {
        showCustomDialogAutorization();
    }

    private void showCustomDialogAutorization() {
        dialog.setContentView(R.layout.dialog_autorization);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        Button but_log = dialog.findViewById(R.id.button_login);
        Button but_reg = dialog.findViewById(R.id.button_registration_auto);
        EditText loginE, passE;
        loginE = dialog.findViewById(R.id.login);
        passE = dialog.findViewById(R.id.password);


        but_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auent();
            }
        });

        but_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                showCustomDialogRegistration();
            }
        });

        dialog.show();
    }
    private void register() {

        emailtext = dialog.findViewById(R.id.login);
        usnametext = dialog.findViewById(R.id.usname);
        passtext = dialog.findViewById(R.id.pass);
        String email = emailtext.getText().toString();
        String username = usnametext.getText().toString();
        String password = passtext.getText().toString();

        JSONObject registrationData = new JSONObject();
        try {
            registrationData.put("username", username);
            registrationData.put("email", email);
            registrationData.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                registrationData.toString()
        );

        Request request = new Request.Builder()
                .url("http://79.174.82.176:8000/api/users/create/")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
                        System.out.println(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
                            System.out.println(response.toString());
                        }
                    });
                }
            }
        });
    }

    private void auent() {
        emailtext2 = dialog.findViewById(R.id.loginpol);
        passtext2 = dialog.findViewById(R.id.password);
        String emailpole = emailtext2.getText().toString();
        String passwordpole = passtext2.getText().toString();

        JSONObject loginData = new JSONObject();
        try {
            loginData.put("username", emailpole);
            loginData.put("password", passwordpole);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                loginData.toString()
        );

        Request request = new Request.Builder()
                .url("http://79.174.82.176:8000/api/users/login/")
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Данные неверные или не совпадают", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    // Handle successful login here, e.g., saving tokens, navigating to another activity, etc.
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Вход успешен", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, Base.class);
                                startActivity(intent);

                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Данные неверные или не совпадают", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private void showCustomDialogRegistration() {

        dialog.setContentView(R.layout.dialog_registration);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        Button registration = dialog.findViewById(R.id.button_registration);


        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();

            }
        });
        dialog.show();

    }

    }