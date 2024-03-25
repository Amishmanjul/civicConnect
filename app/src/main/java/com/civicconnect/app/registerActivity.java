package com.civicconnect.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class registerActivity extends AppCompatActivity {
    EditText edUsername, edPassword, edEmail, edConfirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        edPassword= findViewById(R.id.editTextRegisterPassword);
        edConfirm= findViewById(R.id.editTextRegisterConfPassword);
        edPassword= findViewById(R.id.editTextEmail);

        edUsername= findViewById(R.id.editRegUsername);
        btn= findViewById(R.id.buttonLogin);
        tv=findViewById(R.id.textViewExistingUser);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(registerActivity.this,loginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String Username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                if(Username.length()==0 || email.length()==0|| password.length()==0|| confirm.length()==0){
                    Toast.makeText(getApplicationContext(), "Please Fill all the Credentials!!",Toast.LENGTH_SHORT).show();

                }
                else{
                    if(password.compareTo(confirm)==0){

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password didn't matched",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}