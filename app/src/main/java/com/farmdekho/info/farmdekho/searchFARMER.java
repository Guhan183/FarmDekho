package com.farmdekho.info.farmdekho;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class searchFARMER extends AppCompatActivity {


    private RecyclerView mProductRView1;
    private LinearLayoutManager mLayoutManager1;
    private ProductAdapter1 mProductAdapter1;
    private ArrayList<ProductItem1> mProductList1=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_farmer);
        init();
    }

    private void init() {
        mProductRView1=(RecyclerView)findViewById(R.id.product_rview1);
        mLayoutManager1=new LinearLayoutManager(this);
        mProductRView1.setLayoutManager(mLayoutManager1);
        mProductAdapter1= new ProductAdapter1(this,mProductList1);
        mProductRView1.setAdapter(mProductAdapter1);
        fetchData();
    }

    private void fetchData() {

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference my=database.getReference("Farmers");
        my.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot prodsnap:dataSnapshot.getChildren())
                {
                    ProductItem1 item1=prodsnap.getValue(ProductItem1.class);
                    mProductList1.add(item1);
                }
                mProductAdapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}