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

public class Vopros_Otvet extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vopros_otvet);
    }

    public void goTobase(View v) {
        Intent intent = new Intent(this, Base.class);
        startActivity(intent);
    }
    public void gotoaddlist(View v) {
        Intent intent = new Intent(this, AddList.class);
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

}
