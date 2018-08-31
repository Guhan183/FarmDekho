package com.farmdekho.info.farmdekho;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GUHAN on 06-07-2018.
 */

public class ProductAdapter1 extends RecyclerView.Adapter<ProductAdapter1.MyViewHolder>{
    private Context mContext1;
    private  ArrayList<ProductItem1> mProductList1;
    public ProductAdapter1(Context con, ArrayList<ProductItem1> list1)
    {
        this.mContext1=con;
        this.mProductList1=list1;
    }
    @Override
    public ProductAdapter1.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView1= LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_product_item1,parent,false);
        return new ProductAdapter1.MyViewHolder(itemView1);
    }

    @Override
    public void onBindViewHolder(ProductAdapter1.MyViewHolder holder, int position) {

        holder.nametxt1.setText("Name:"+" "+mProductList1.get(position).getName());
        holder.addresstxt1.setText("Address:"+" "+mProductList1.get(position).getAddress());
        holder.phonetxt1.setText("Phone No:"+" "+mProductList1.get(position).getPhone());
        holder.quantitytxt1.setText("Quantity:"+" "+mProductList1.get(position).getQuantity());
        holder.datetxt1.setText("Date:"+" "+mProductList1.get(position).getDate());
        holder.croptxt.setText("CropName:"+" "+mProductList1.get(position).getCrop());
    }

    @Override
    public int getItemCount() {
        return mProductList1.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        public TextView nametxt1,addresstxt1,phonetxt1,quantitytxt1,datetxt1,croptxt;
        public MyViewHolder(View itemView1) {
            super(itemView1);
            nametxt1=(TextView)itemView1.findViewById(R.id.name1_txt);
            addresstxt1=(TextView)itemView1.findViewById(R.id.address1_txt);
            phonetxt1=(TextView)itemView1.findViewById(R.id.phone1_txt);
            quantitytxt1=(TextView)itemView1.findViewById(R.id.quantity1_txt);
            datetxt1=(TextView)itemView1.findViewById(R.id.date1_txt);
            croptxt=(TextView)itemView1.findViewById(R.id.crop_txt);
        }
    }}
