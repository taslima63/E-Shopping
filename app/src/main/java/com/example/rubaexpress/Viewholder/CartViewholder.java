package com.example.rubaexpress.Viewholder;

import android.nfc.TagLostException;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rubaexpress.Interface.ItemClickListener;
import com.example.rubaexpress.R;

public class CartViewholder<CardViewHolder> extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtProductName, txtProductQuantity, txtProductPrice;
    private ItemClickListener itemClickListener;
    
    public CartViewholder(@NonNull View itemView)
    {
        super(itemView);
        
        txtProductName = itemView.findViewById(R.id.cart_product_name );
        txtProductPrice = itemView.findViewById(R.id.cart_product_price);
        txtProductQuantity = itemView.findViewById(R.id.cart_product_quantity);
    }
    
    @Override
    public void onClick(View view)
    {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
    
    public void setItemClickListener(ItemClickListener itemClickListener)
    
    {
        this.itemClickListener = itemClickListener;
    }
}
