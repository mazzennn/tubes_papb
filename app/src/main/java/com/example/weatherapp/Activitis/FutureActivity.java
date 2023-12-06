package com.example.weatherapp.Activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.weatherapp.Adapters.FutureAdapter;
import com.example.weatherapp.Domains.FutureDomain;
import com.example.weatherapp.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v -> startActivity(new Intent(FutureActivity.this,MainActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items=new ArrayList<>();

        items.add(new FutureDomain("Sabtu","storm","Badai",25,10));
        items.add(new FutureDomain("Minggu","cloudy","Berawan",24,16));
        items.add(new FutureDomain("Senin","windy","Berangin",29,15));
        items.add(new FutureDomain("Selasa","cloudy_sunny","Cerah Berawan",22,13));
        items.add(new FutureDomain("Rabu","sunny","Cerah",28,11));
        items.add(new FutureDomain("Kamis","rainy","Hujan",23,12));

        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTomorrow=new FutureAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);

    }
}