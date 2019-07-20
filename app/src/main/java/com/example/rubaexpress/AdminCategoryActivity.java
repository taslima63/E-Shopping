package com.example.rubaexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminCategoryActivity extends AppCompatActivity
{
    private ImageView Tshirts, Sportsshirts, FemaleDresses, Sweathers;
    private ImageView Purses, Earrings, Womenshoes, sunglasses;
    private ImageView Rings,Makeup,Cosmetics, Menshoes;
    private ImageView Camera, Headphone, Laptop, Phones;
    private ImageView HomeAppliances, Kitchenware,Hat,Watches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);


        Tshirts = (ImageView) findViewById(R.id.t_shirts);
        Sportsshirts = (ImageView) findViewById(R.id.sports_t_shirts);
        FemaleDresses = (ImageView) findViewById(R.id.female_dresses);
        Sweathers= (ImageView) findViewById(R.id.sweather);
        Purses = (ImageView) findViewById(R.id.pink_bag);
        Makeup = (ImageView) findViewById(R.id.makeup);
        Womenshoes = (ImageView) findViewById(R.id.female_shoes);
        Rings =  (ImageView) findViewById(R.id.rings);
        Cosmetics = (ImageView) findViewById(R.id.cosmetics);
        sunglasses = (ImageView) findViewById(R.id.sunglasses);
        Earrings = (ImageView) findViewById(R.id.earring);
        Menshoes= (ImageView) findViewById(R.id.men_shoes);
        Camera= (ImageView) findViewById(R.id.camera);
        Headphone = (ImageView) findViewById(R.id.headphones);
       Laptop = (ImageView) findViewById(R.id.laptop);
        Phones= (ImageView) findViewById(R.id.phone);
        HomeAppliances= (ImageView) findViewById(R.id.homeappliances);
        Kitchenware= (ImageView) findViewById(R.id.kitchen_ware);
        Hat= (ImageView) findViewById(R.id.hat);
       Watches = (ImageView) findViewById(R.id.watch);

        Tshirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Tshirts");
                startActivity(intent);
            }
        });

        Sportsshirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Sportsshirts");
                startActivity(intent);

            }
        });

        FemaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "FemaleDresses");
                startActivity(intent);
            }
        });

        Sweathers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Sweathers");
                startActivity(intent);
            }
        });

        Purses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Purses");
                startActivity(intent);
            }
        });

        Earrings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Earrings");
                startActivity(intent);
            }
        });

        Womenshoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Womenshoes");
                startActivity(intent);
            }
        });

        sunglasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "sunglasses");
                startActivity(intent);
            }
        });
        Rings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Rings");
                startActivity(intent);
            }
        });
        Makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Makeup");
                startActivity(intent);
            }
        });
        Cosmetics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Cosmetics");
                startActivity(intent);
            }
        });
        Menshoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Menshoes");
                startActivity(intent);
            }
        });

         Camera.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {
                 Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                 intent.putExtra("category", "Camera");
                 startActivity(intent);
             }
         });
         Headphone.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {
                 Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                 intent.putExtra("category", "Headphone");
                 startActivity(intent);
             }
         });
         Laptop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {
                 Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                 intent.putExtra("category", "Laptop");
                 startActivity(intent);
             }
         });
         Phones.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {
                 Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                 intent.putExtra("category", "Phones");
                 startActivity(intent);
             }
         });
         HomeAppliances.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {
                 Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                 intent.putExtra("category", "HomeAppliances");
                 startActivity(intent);
             }
         });
         Kitchenware.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {
                 Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                 intent.putExtra("category", "Kitchenware");
                 startActivity(intent);
             }
         });
        Hat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Hat");
                startActivity(intent);
            }
        });
        Watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Watches");
                startActivity(intent);
            }
        });


    }
}
