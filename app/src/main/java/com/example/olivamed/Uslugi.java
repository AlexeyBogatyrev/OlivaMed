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

public class Uslugi extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uslugi);
    }

    public void gotoaddlist(View v) {
        Intent intent = new Intent(this, AddList.class);
        startActivity(intent);
    }
    public void goTobase(View v) {
        Intent intent = new Intent(this, AddList.class);
        startActivity(intent);
    }
    public void goToJob(View v){
        Intent intent = new Intent(this, Job.class);
        startActivity(intent);
    }
    public void goToVoprosOtvet(View v){
        Intent intent = new Intent(this, Vopros_Otvet.class);
        startActivity(intent);
    }


}
