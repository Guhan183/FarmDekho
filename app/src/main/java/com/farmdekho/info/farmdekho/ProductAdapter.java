package com.farmdekho.info.farmdekho;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GUHAN on 05-07-2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
   private Context mContext;
   private  ArrayList<ProductItem> mProductList;
   public ProductAdapter(Context con, ArrayList<ProductItem> list)
   {
       this.mContext=con;
       this.mProductList=list;
   }
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_product_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.MyViewHolder holder, int position) {

        holder.nametxt.setText("Name:"+" "+mProductList.get(position).getName());
        holder.addresstxt.setText("Address:"+" "+mProductList.get(position).getAddress());
        holder.phonetxt.setText("Phone No:"+" "+mProductList.get(position).getPhone());
        holder.quantitytxt.setText("Quantity:"+" "+mProductList.get(position).getQuantity());
        holder.datetxt.setText("Date:"+" "+mProductList.get(position).getDate());
        holder.needtxt.setText("Product:"+" "+mProductList.get(position).getNeed());
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        public TextView nametxt,addresstxt,phonetxt,quantitytxt,datetxt,needtxt;
        public MyViewHolder(View itemView) {
            super(itemView);
            nametxt=(TextView)itemView.findViewById(R.id.name_txt);
            addresstxt=(TextView)itemView.findViewById(R.id.address_txt);
            phonetxt=(TextView)itemView.findViewById(R.id.phone_txt);
            quantitytxt=(TextView)itemView.findViewById(R.id.quantity_txt);
            datetxt=(TextView)itemView.findViewById(R.id.date_txt);
            needtxt=(TextView)itemView.findViewById(R.id.need_txt);

        }
    }
}
