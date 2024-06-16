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
import android.widget.TextView;
import android.widget.Toast;

public class AddList extends AppCompatActivity {
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlist);
    }

    public void gotoBase(View v) {
        Intent intent = new Intent(this, Base.class);
        startActivity(intent);
    }


    public void openPoliticText(View v)
    {
        Intent intent = new Intent(this, PoliticText.class);
        startActivity(intent);
    }


}

