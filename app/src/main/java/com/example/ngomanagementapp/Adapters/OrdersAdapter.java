package com.example.ngomanagementapp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ngomanagementapp.DBHelper;
import com.example.ngomanagementapp.DetailActivity;
import com.example.ngomanagementapp.Models.OrdersModel;
import com.example.ngomanagementapp.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder>{
   ArrayList<OrdersModel> list;
   Context context;

    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OrdersAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull OrdersAdapter.viewHolder holder, int position) {
    final OrdersModel model=list.get(position);
    holder.orderImage.setImageResource(model.getOrderImage());
    holder.soldItemName.setText(model.getSoldItemName());
    holder.orderNumber.setText(model.getOrderNumber());
    holder.orderprice1.setText(model.getOrderprice1());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, DetailActivity.class);
            intent.putExtra("id",Integer.parseInt(model.getOrderNumber()));
            intent.putExtra("type",2);

            context.startActivity(intent);
        }
    });
    holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            new AlertDialog.Builder(context)
                    .setTitle("Delete Item")
                    .setMessage("Are you sure you want to delete this item?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DBHelper helper=new DBHelper(context);
                            if(helper.deleteOrder(model.getOrderNumber())>0){
                                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();


            return false;
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
ImageView orderImage;
TextView soldItemName,orderNumber,orderprice1;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage=itemView.findViewById(R.id.orderImage);
            soldItemName=itemView.findViewById(R.id.orderItemName);
            orderNumber=itemView.findViewById(R.id.orderNumber);
            orderprice1=itemView.findViewById(R.id.orderprice1);

        }
    }


}
