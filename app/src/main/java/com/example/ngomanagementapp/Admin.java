package com.example.ngomanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {
EditText aone,atwo,athree;
Button addbutton;
int im;
    String xyz="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        aone=findViewById(R.id.aone);
        atwo=findViewById(R.id.atwo);
        athree=findViewById(R.id.athree);
        addbutton=(Button)findViewById(R.id.addbutton);



        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aone.getText().toString()!=null){
                    xyz=aone.getText().toString();}
                else{
                    xyz="shoes";}
                        if(xyz.equals("shoes")){
        im=R.drawable.shoes;
        }
                        else if(xyz.equals("first-aid")){
                            im=R.drawable.firstaid;
                        }
                Toast.makeText(Admin.this, xyz, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Admin.this ,MainActivity.class);
                intent.putExtra("n",aone.getText().toString());
                intent.putExtra("j",im);
                intent.putExtra("p",atwo.getText().toString());
                intent.putExtra("d",athree.getText().toString());
                startActivity(intent);

            }
        });


    }
}