package com.example.olivamed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;


public class Base extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey("0de46928-dd02-49ad-b9ca-b577a9b9bf5d");
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_base);

        mapView = findViewById(R.id.mapView);
        mapView.getMap().move(
                new CameraPosition(new Point(47.214715, 39.704775), 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 300f), null
        );
    }

    public void gotoaddlist(View v) {
        Intent intent = new Intent(this, AddList.class);
        startActivity(intent);
    }
    public void gotoHistory(View v) {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }


    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
        MapKitFactory.getInstance().onStart();
    }

}