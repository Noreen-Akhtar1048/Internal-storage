package com.blahblah.internal_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity
{
    TextInputEditText name_text,pass_text;
    Button btn_save;
    FileOutputStream fileOutputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name_text = findViewById(R.id.name_text);
        pass_text = findViewById(R.id.pass_text);
        btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name_text.getEditableText().toString()+"\n";
                String password = pass_text.getEditableText().toString();
                try{
                    fileOutputStream = openFileOutput("user details", Context.MODE_PRIVATE);
                    fileOutputStream.write(username.getBytes());
                    fileOutputStream.write(password.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(),"Details saved succesfully",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,details.class);
                    startActivity(intent);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}