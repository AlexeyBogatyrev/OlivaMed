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

public class MainActivity extends AppCompatActivity {
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new Dialog(MainActivity.this);
    }
    public void goTobase(View v)
    {
        Intent intent = new Intent(this, Base.class);
        startActivity(intent);
    }

    public void goToAutorization(View v)
    {
        showCustomDialog();
    }

    private void showCustomDialog() {
        dialog.setContentView(R.layout.dialog_autorization);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        Button but_log = dialog.findViewById(R.id.button_login);
        EditText loginE, passE;
        loginE = dialog.findViewById(R.id.login);
        passE = dialog.findViewById(R.id.password);

        but_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();

    }


}