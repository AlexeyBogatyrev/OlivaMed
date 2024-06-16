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
        Toast.makeText(AddList.this, "В разработке!", Toast.LENGTH_SHORT).show();
    }


}

