package com.example.gk_1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ItemViewHolder> {
    private List<Item> listItem=new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public AdapterItem(List<Item> listItem, Context context) {
        this.listItem = listItem;
        this.context = context;
        inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=inflater.inflate(R.layout.item_activity,parent,false);
        ItemViewHolder itemViewHolder=new ItemViewHolder(itemView);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item=listItem.get(position);
        holder.tvName.setText(item.getName());
        holder.tvPrice.setText("$"+String.format("%.2f",item.getPrice()));
        holder.tvDescription.setText(item.getDescription());
        holder.imgItem.setImageResource(item.getImgItem());
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvName;
        private TextView  tvDescription;
        private TextView tvPrice;
        private ImageView imgItem;
        private ImageButton btnAdd;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            imgItem=itemView.findViewById(R.id.imgItem);
            btnAdd=itemView.findViewById(R.id.btnAdd);
            itemView.setOnClickListener(this);
            btnAdd.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Item item=listItem.get(getAdapterPosition());
            Intent intent=new Intent(context,ItemMain.class);
            intent.putExtra("item",item);
            context.startActivity(intent);
        }
    }
}
