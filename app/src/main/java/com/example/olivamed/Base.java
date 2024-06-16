package com.example.olivamed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Dialog;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;


public class Base extends AppCompatActivity {
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        dialog = new Dialog(Base.this);

    }

    public void gotoaddlist(View v) {
        Intent intent = new Intent(this, AddList.class);
        startActivity(intent);
    }

    public void goToDoctor(View v) {
        Intent intent = new Intent(this, Doctor.class);
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

    public void goToInformathion(View v) {
        showCustomDialogContact();
    }

    private void showCustomDialogContact() {
        dialog.setContentView(R.layout.diaolog_informathion);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);

        dialog.show();
    }

    public void goToSale(View v) {
        showCustomDialogSale();
    }

    private void showCustomDialogSale() {
        dialog.setContentView(R.layout.dialog_sale);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        dialog.show();
    }


}