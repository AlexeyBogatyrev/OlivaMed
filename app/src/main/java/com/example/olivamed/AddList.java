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
import android.widget.RadioButton;
import android.widget.TextView;
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

public class AddList extends AppCompatActivity {

    EditText namezap;
    EditText telzap;
    EditText emailzap;
    EditText comentzap;
    RadioButton rad1;

    private OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlist);
    }

    public void goTobase(View v) {
        Intent intent = new Intent(this, Base.class);
        startActivity(intent);
    }


    public void openPoliticText(View v)
    {
        Intent intent = new Intent(this, PoliticText.class);
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
    public void goToJob(View v){
        Intent intent = new Intent(this, Job.class);
        startActivity(intent);
    }
    public void goToZapis(View v){
        zapic();
    }

    private void zapic() {
        rad1 = findViewById(R.id.radioButton2);
        namezap = findViewById(R.id.name_zapic);
        emailzap = findViewById(R.id.email_zapic);
        telzap = findViewById(R.id.telephone_zapic);
        comentzap = findViewById(R.id.coment_zapic);
        String fi = namezap.getText().toString();
        String email = emailzap.getText().toString();
        String phone_number = telzap.getText().toString();
        String comment = comentzap.getText().toString();

        JSONObject zapicData = new JSONObject();
        try {
            zapicData.put("fi", fi);
            zapicData.put("email", email);
            zapicData.put("phone_number", phone_number);
            zapicData.put("comment", comment);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                zapicData.toString()
        );

        Request request = new Request.Builder()
                .url("http://79.174.82.176:8000/api/callback/")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(AddList.this, "Запись провалена", Toast.LENGTH_SHORT).show();
                        System.out.println(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() & rad1.isChecked()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(AddList.this, "Запись успешна", Toast.LENGTH_SHORT).show();

                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(AddList.this, "Запись провалена", Toast.LENGTH_SHORT).show();
                            System.out.println(response.toString());
                        }
                    });
                }
            }
        });
    }
}

