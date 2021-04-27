package com.example.gk_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AdapterItem adapterItem;
    private RecyclerView recyclerView;
    private List<Item> itemList=new ArrayList<>();
    private Button btnDanut;
    private Button btnPink;
    private Button btnFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);
        getListItem();
        adapterItem=new AdapterItem(itemList,MainActivity.this);
        recyclerView=findViewById(R.id.rvItemList);
        recyclerView.setAdapter(adapterItem);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        search();


    }

    private void search(){
        btnPink = findViewById(R.id.btnPink);
        btnFloat=findViewById(R.id.btnfloat);
        btnDanut=findViewById(R.id.btnDonut);

        btnDanut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterItem=new AdapterItem(itemList,MainActivity.this);
                recyclerView=findViewById(R.id.rvItemList);
                recyclerView.setAdapter(adapterItem);
                GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,1);
                recyclerView.setLayoutManager(gridLayoutManager);
            }
        });
        btnPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Item> lists=new ArrayList<>();
                lists.add(itemList.get(1));
                adapterItem=new AdapterItem(lists,MainActivity.this);
                recyclerView=findViewById(R.id.rvItemList);
                recyclerView.setAdapter(adapterItem);
                GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,1);
                recyclerView.setLayoutManager(gridLayoutManager);
            }
        });
        btnFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Item> lists=new ArrayList<>();
                lists.add(itemList.get(2));
                adapterItem=new AdapterItem(lists,MainActivity.this);
                recyclerView=findViewById(R.id.rvItemList);
                recyclerView.setAdapter(adapterItem);
                GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,1);
                recyclerView.setLayoutManager(gridLayoutManager);
            }
        });
    }

    private void getListItem(){
        itemList.add(new Item(1,"Tasty Donut","Spicy tasty donut family",10.00,R.drawable.donut_yellow1));
        itemList.add(new Item(2,"Pink Donut","Spicy tasty donut family",20.00,R.drawable.dasty_donut));
        itemList.add(new Item(3,"Floating Donut","Spicy tasty donut family",30.00,R.drawable.green_donut));
        itemList.add(new Item(4,"Tasty Donut","Spicy tasty donut family",35.00,R.drawable.donut_red));
    }
}