package com.example.ngomanagementapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ngomanagementapp.Adapters.MainAdapter;
import com.example.ngomanagementapp.Models.MainModel;
import com.example.ngomanagementapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    EditText aone,atwo,athree;
    Button addbutton;
    String a1;
    String b1;
    String c1;
    int e1;

//EditText adminname;
//EditText adminorderPrice;
//EditText admindescription;
    public static int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        adminname=findViewById(R.id.name);
//        adminorderPrice=findViewById(R.id.orderPrice);
//        admindescription=findViewById(R.id.description);
//        aone=findViewById(R.id.aone);
//        atwo=findViewById(R.id.atwo);
//        athree=findViewById(R.id.athree);
//        addbutton=findViewById(R.id.addbutton);

        String a=getIntent().getStringExtra("n");
        String b=getIntent().getStringExtra("p");
        String c=getIntent().getStringExtra("d");
        int e=getIntent().getIntExtra("j",0);




        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<MainModel> list=new ArrayList<>();
//        list.add(new MainModel(R.drawable.lr,adminname.getText().toString(),adminorderPrice.getText().toString(),admindescription.getText().toString()));

        list.add(new MainModel(R.drawable.lr,"wheat","10","grains"));
        list.add(new MainModel(R.drawable.vege1,"vegetables","15","food-items"));
        list.add(new MainModel(R.drawable.stationary,"stationary","30","pens,pencils,highlighters"));
        list.add(new MainModel(R.drawable.mg,"multi-grains","20","grains"));
        list.add(new MainModel(R.drawable.cloth,"clothes","50","tops,bottoms"));
        list.add(new MainModel(R.drawable.dairy,"dairy products","50","cheese,milk,butter"));
        list.add(new MainModel(R.drawable.books,"books","30","readings"));
        //list.add(new MainModel(e,a,b,c));
        list.add(new MainModel(e,a,b,c));
//        if(i==2){
//            list.add(new MainModel(R.drawable.stationary,"adidas","20","ertyui"));
//        }
//        if(i==1){
//            i++;
//             a1=a;
//            b1=b;
//             c1=c;
//             e1=e;
//
//        }

        MainAdapter adapter=new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
            case R.id.MyAdmin:
                startActivity(new Intent(MainActivity.this,Admin.class));
        }

        return super.onOptionsItemSelected(item);
    }

}