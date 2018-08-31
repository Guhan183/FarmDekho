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

public class searchVENDOR extends AppCompatActivity {


    private RecyclerView mProductRView;
    private LinearLayoutManager mLayoutManager;
    private ProductAdapter mProductAdapter;
    private ArrayList<ProductItem> mProductList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_vendor);
        init();
    }

    private void init() {
        mProductRView=(RecyclerView)findViewById(R.id.product_rview);
        mLayoutManager=new LinearLayoutManager(this);
        mProductRView.setLayoutManager(mLayoutManager);
        mProductAdapter= new ProductAdapter(this,mProductList);
        mProductRView.setAdapter(mProductAdapter);
        fetchData();
    }

    private void fetchData() {

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference my=database.getReference("Vendors");
        my.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot prodsnap:dataSnapshot.getChildren())
                {
                    ProductItem item=prodsnap.getValue(ProductItem.class);
                    mProductList.add(item);
                }
                mProductAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}