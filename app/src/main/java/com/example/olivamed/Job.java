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

public class Job extends AppCompatActivity {
    Dialog dialog;
    EditText namejob;
    EditText teljob;
    EditText emailjob;
    EditText comentjob;

    private OkHttpClient client = new OkHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        dialog = new Dialog(Job.this);

    }

    public void openDialogJob(View v) {
        showCustomDialogJob();
    }
    private void showCustomDialogJob() {
        dialog.setContentView(R.layout.dialog_job);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        Button but_job = dialog.findViewById(R.id.button_job);

        but_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otklik();
            }
        });

        dialog.show();
    }

    private void otklik() {

        namejob = dialog.findViewById(R.id.name_job);
        teljob = dialog.findViewById(R.id.tel_job);
        emailjob = dialog.findViewById(R.id.email_job);
        comentjob = dialog.findViewById(R.id.coment_job);
        String fi = namejob.getText().toString();
        String phone_number = teljob.getText().toString();
        String email = emailjob.getText().toString();
        String text = comentjob.getText().toString();

        JSONObject registrationData = new JSONObject();
        try {
            registrationData.put("fi", fi);
            registrationData.put("phone_number", phone_number);
            registrationData.put("email", email);
            registrationData.put("text", text);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                registrationData.toString()
        );

        Request request = new Request.Builder()
                .url("http://79.174.82.176:8000/api/job/appointment/")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Job.this, "Заявка не отправлена", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(Job.this, "Заявка отправлена успешна", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Job.this, "Заявка не отправлена", Toast.LENGTH_SHORT).show();
                            System.out.println(response.toString());
                        }
                    });
                }
            }
        });
    }


    public void gotoaddlist(View v) {
        Intent intent = new Intent(this, AddList.class);
        startActivity(intent);
    }
    public void goToVoprosOtvet(View v){
        Intent intent = new Intent(this, Vopros_Otvet.class);
        startActivity(intent);
    }
    public void goToUslugi(View v){
        Intent intent = new Intent(this, Uslugi.class);
        startActivity(intent);
    }
    public void goTobase(View v){
        Intent intent = new Intent(this, Base.class);
        startActivity(intent);
    }

}