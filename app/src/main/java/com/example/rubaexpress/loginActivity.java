package com.example.rubaexpress;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rubaexpress.Admin.AdminCategoryActivity;
import com.example.rubaexpress.Model.Users;
import com.example.rubaexpress.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import io.paperdb.Paper;

public class loginActivity extends AppCompatActivity
{
    private EditText InputPhoneNumber, InputPassword;
    private Button LoginButton;
    private ProgressDialog LoadingBar;
    private  String ParentDBName = "Users";
    private CheckBox checkBoxRememberMe;
    private TextView AdminLink, NotAdminLink, ForgetPasswordLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginButton= (Button) findViewById(R.id.login_btn);
        InputPhoneNumber = (EditText) findViewById(R.id.login_phone_number_input);
        InputPassword = (EditText) findViewById(R.id.login_password_input);
        AdminLink = (TextView) findViewById(R.id.admin_panel_link);
        NotAdminLink = (TextView) findViewById(R.id.not_admin_panel_link);
        ForgetPasswordLink = findViewById(R.id.forget_password_link);
       
        LoadingBar = new ProgressDialog(this);

        checkBoxRememberMe = (CheckBox) findViewById(R.id.remember_me_chkb);
        Paper.init(this);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                loginUser();
            }
        });
    
        ForgetPasswordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(loginActivity.this, ResetPasswordActivity.class);
                intent.putExtra("check", "login");
                startActivity(intent);
            }
        });
    
    
    
        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Login Admin");
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);
                ParentDBName = "Admins";
            }
        });

        NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Login");
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);
                ParentDBName = "Users";
            }
        });
    }

    private void loginUser()
    {
        String phone= InputPhoneNumber.getText().toString();
        String password= InputPassword.getText().toString();

        if (TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Please write your phone number...", Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            LoadingBar.setTitle("Login Account");
            LoadingBar.setMessage("Please wait while we are checking credentials");
            LoadingBar.setCanceledOnTouchOutside(false);
            LoadingBar.show();
            
            AllowAccessToAccount(phone, password);
        }
    }



    private void AllowAccessToAccount(final String phone, final String password)
    {

        if(checkBoxRememberMe.isChecked())
        {
            Paper.book().write(Prevalent.UserPhoneKey, phone);
            Paper.book().write(Prevalent.UserPasswordKey, password);
        }


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();


        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.child(ParentDBName).child(phone).exists())
                {
                    Users usersData= dataSnapshot.child(ParentDBName).child(phone).getValue(Users.class);

                    if (usersData.getPhone().equals(phone))
                    {
                        if (usersData.getPassword().equals(password))
                        {
                           if(ParentDBName.equals("Admins"))
                           {
                               Toast.makeText(loginActivity.this, "Welcome Admin,you are logged in successfully...", Toast.LENGTH_SHORT).show();
                               LoadingBar.dismiss();
 
                               Intent intent = new Intent(loginActivity.this, AdminCategoryActivity.class);
                               startActivity(intent);
                           }
                           else if (ParentDBName.equals("Users"))
                           {
                               Toast.makeText(loginActivity.this, "Logged in successfully...", Toast.LENGTH_SHORT).show();
                               LoadingBar.dismiss();

                               Intent intent = new Intent(loginActivity.this,HomeActivity.class);
                               Prevalent.currentOnlineUsers = usersData;
                               startActivity(intent);
                           }

                        }
                        else
                            {
                                LoadingBar.dismiss();
                                Toast.makeText(loginActivity.this, "Password is incorrect", Toast.LENGTH_SHORT).show();

                            }

                    }
                }
                else
                {
                    Toast.makeText(loginActivity.this, "Account with this" + phone +"number doesn't exists", Toast.LENGTH_SHORT).show();
                    LoadingBar.dismiss();
                    Toast.makeText(loginActivity.this, "You need to create a new account", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private class UserPasswordKey {
    }
}
