package com.example.ngomanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.ColorSpace;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ngomanagementapp.Models.MainModel;
import com.example.ngomanagementapp.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 4;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders " +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price int," +
                        "quantity int," +
                        "image int," +
                        "description text," +
                        "foodname text)"
        );
        db.execSQL(
                "create table items"+
                "(id integer primary key autoincrement,"+
                "itemname text,"+
                "itemprice int,"+
                "itemdescription text,"+
                "itemimage int)"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists orders" );
        db.execSQL("DROP table if exists items");
        onCreate(db);
    }

    public boolean insertOrder(String name, String phone, int price, int image, String desc, String foodName,int quantity) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodName", foodName);
        values.put("quantity", quantity);
        long id = database.insert("orders", null, values);
        if (id <= 0) {
            return false;
        } else {
            return true;
        }
    }
    public ArrayList<OrdersModel> getOrders(){
        ArrayList<OrdersModel> orders=new ArrayList<>();
        SQLiteDatabase database =this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select id,foodName,image,price from orders",null );
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrdersModel model=new OrdersModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setSoldItemName(cursor.getString(1)+"");
                model.setOrderImage(cursor.getInt(2));
                model.setOrderprice1(cursor.getInt(3)+"");
                orders.add(model);

            }
        }
        cursor.close();
        database.close();
        return orders;
    }
    public Cursor getOrderById(int id){

        SQLiteDatabase database =this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select * from orders where id="+id,null );
        if(cursor!=null)
            cursor.moveToFirst();

        return cursor;

    }
    public boolean insertItem(String itemname,int itemprice, int itemimage, String itemdescription) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("itemname", itemname);

        values.put("itemprice", itemprice);
        values.put("itemimage", itemimage);
        values.put("itemdescription", itemdescription);

        long id = database.insert("items", null, values);
        if (id <= 0) {
            return false;
        } else {
            return true;
        }
    }
    public ArrayList<MainModel> getItems(){
        ArrayList<MainModel> items=new ArrayList<>();
        SQLiteDatabase database =this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select id,itemname,itemimage,itemprice,itemdescription from items",null );
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                MainModel model=new MainModel();
                model.setName(cursor.getInt(1)+"");
                model.setPrice(cursor.getString(2));
                model.setDescription(cursor.getString(4));
                model.setImage(cursor.getInt(3));
                items.add(model);

            }
        }
        cursor.close();
        database.close();
        return items;
    }
    public Cursor getItemById(int id){

        SQLiteDatabase database =this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select * from items where id="+id,null );
        if(cursor!=null)
            cursor.moveToFirst();

        return cursor;

    }

    public boolean updateOrder(String name, String phone, int price, int image, String desc, String foodName,int quantity,int id) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodName", foodName);
        values.put("quantity", quantity);
        long row= database.update("orders",values,"id="+id,null);
        if (row <= 0) {
            return false;
        } else {
            return true;
        }
    }
    public int deleteOrder(String id){
        SQLiteDatabase database =getWritableDatabase();
        return database.delete("orders","id="+id,null);
    }
}
