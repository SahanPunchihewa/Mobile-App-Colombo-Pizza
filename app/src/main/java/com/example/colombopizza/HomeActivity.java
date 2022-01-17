package com.example.colombopizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    public Button move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //card view

        RecyclerView recyclerView= findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MenuData[] menuData = new MenuData[] {

                new MenuData("Tandoori Chicken Pizza", "Large Pizza=RS.1850",R.drawable.tandoori),
                new MenuData("BBQ Pizza", "Large Pizza=RS.1850",R.drawable.bbq),
                new MenuData("Supersureme Pizza", "Large Pizza=RS.1850",R.drawable.supersureme),


        };

        menuAdapter MenuAdapter = new menuAdapter(menuData,HomeActivity.this);
        recyclerView.setAdapter(MenuAdapter);


    }
}