package com.example.gk_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemMain extends AppCompatActivity {
    private TextView tvName;
    private TextView  tvDescription;
    private TextView tvPrice;
    private ImageView imgItem;
    private ImageButton btnCong;
    private ImageButton btnTru;
    private  Item item;
    private int quantity=1;
    private TextView tvQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemdetail);
        getItemDetail();
        getQuantity();
    }

    private void getQuantity() {
        tvQuantity=findViewById(R.id.tvQuantity);
        btnCong=findViewById(R.id.btnCong);
        btnTru=findViewById(R.id.btnTru);

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity>=1){
                    quantity--;
                    tvQuantity.setText(""+quantity);
                }
            }
        });
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity>=0){
                    quantity++;
                    tvQuantity.setText(""+quantity);
                }
            }
        });
    }

    private void getItemDetail(){
        tvName=findViewById(R.id.tvNameDetail);
        tvDescription=findViewById(R.id.tvDescriptionDetails);
        tvPrice=findViewById(R.id.tvPriceDetail);
        imgItem=findViewById(R.id.imgItemDetail);
        Intent intent=getIntent();
        item=(Item) intent.getSerializableExtra("item");
        tvName.setText(item.getName());
        tvDescription.setText(item.getDescription());
        tvPrice.setText("$"+String.format("%.2f",item.getPrice()));
        imgItem.setImageResource(item.getImgItem());
    }

}