package com.example.rubaexpress.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubaexpress.Model.Cart;
import com.example.rubaexpress.R;
import com.example.rubaexpress.Viewholder.CartViewholder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminUserProductsActivity extends AppCompatActivity
{
    private RecyclerView productsLists;
    RecyclerView.LayoutManager layoutManager;
    private DatabaseReference cartListRef;
    private String userID = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_products);
    
        
        userID = getIntent().getStringExtra("uid");
        
        
        productsLists = findViewById(R.id.products_list);
        productsLists.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        productsLists.setLayoutManager(layoutManager);
        
        
        cartListRef= FirebaseDatabase.getInstance().getReference()
                .child("Cart List").child("Admin View").child(userID).child("Products");
    
    }
    
    @Override
    protected void onStart()
    {
        super.onStart();
        
    
        FirebaseRecyclerOptions<Cart> options =
                new FirebaseRecyclerOptions.Builder<Cart >()
                .setQuery(cartListRef,Cart.class)
                .build();
        
        FirebaseRecyclerAdapter<Cart, CartViewholder> adapter = new FirebaseRecyclerAdapter<Cart, CartViewholder>(options)
        {
            @Override
            protected void onBindViewHolder(@NonNull CartViewholder holder, int position, @NonNull Cart model)
            {
                holder.txtProductQuantity.setText("Quantity = " + model.getQuantity());
                holder.txtProductPrice.setText("Price " + model.getPrice()+ "$");
                holder.txtProductName.setText(model.getPname() );
     
            }
    
            @NonNull
            @Override
            public CartViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
            {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items_layout, parent,false);
                CartViewholder holder = new CartViewholder(view);
                return holder;
            }
        };
        
            productsLists.setAdapter(adapter);
            adapter.startListening();
        
        }
    
    }


