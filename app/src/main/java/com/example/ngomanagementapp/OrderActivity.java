package com.example.ngomanagementapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ngomanagementapp.Adapters.OrdersAdapter;
import com.example.ngomanagementapp.Models.OrdersModel;
import com.example.ngomanagementapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper=new DBHelper(this);
        ArrayList<OrdersModel> list=helper.getOrders();
//        list.add(new OrdersModel(R.drawable.lr,"wheat","5","123456"));
//        list.add(new OrdersModel(R.drawable.lr,"wheat","5","123456"));
//        list.add(new OrdersModel(R.drawable.lr,"wheat","5","123456"));
//        list.add(new OrdersModel(R.drawable.lr,"wheat","5","123456"));
//        list.add(new OrdersModel(R.drawable.lr,"wheat","5","123456"));
//        list.add(new OrdersModel(R.drawable.lr,"wheat","5","123456"));
//        list.add(new OrdersModel(R.drawable.lr,"wheat","5","123456"));
//        list.add(new OrdersModel(R.drawable.lr,"wheat","5","123456"));
//        list.add(new OrdersModel(R.drawable.lr,"wheat","5","123456"));
        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}