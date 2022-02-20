package com.blahblah.internal_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class details extends AppCompatActivity
{
    TextView name_view,pass_view;
    Button btn_back;
    FileInputStream fileInputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name_view  = findViewById(R.id.name_view);
        pass_view = findViewById(R.id.pass_view);
        btn_back = findViewById(R.id.btn_back);
        try{
            fileInputStream = openFileInput("user details");
            StringBuffer stringBuffer = new StringBuffer();
            int i;
            while ((i = fileInputStream.read()) != -1){
                stringBuffer.append((char)i);
            }
            fileInputStream.close();
            String detail[] = stringBuffer.toString().split("\n");
            name_view.setText("Name" + detail[0]);
            pass_view.setText("Password" + detail[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(details.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}