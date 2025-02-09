package com.snehasis.user_registration;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecyclerViewDisplay extends AppCompatActivity {

    FloatingActionButton add_btn;
    RecyclerView recyclerView;
    LocalDatabase database;
    Intent i1,i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        add_btn = findViewById(R.id.add_btn);

        recyclerView = findViewById(R.id.recycler_view_display);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = new LocalDatabase(this);

        ArrayList<UserModel> data;

        add_btn.setOnClickListener(v -> {

            i1 = new Intent(this, MainActivity.class);
            startActivity(i1);

        });

        i2 = getIntent();

        data = database.getData();

        RecyclerVIewAdapter adapter = new RecyclerVIewAdapter(this, data);
        recyclerView.setAdapter(adapter);

    }
}