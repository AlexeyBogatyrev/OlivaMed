package com.example.olivamed;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class AddList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlist);
    }
    public void gotoBase(View v) {
        Intent intent = new Intent(this, Base.class);
        startActivity(intent);
    }

}

